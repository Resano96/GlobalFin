package com.globalfin.ui.b2b.service;

import com.globalfin.ui.b2b.model.LoginViewModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.concurrent.CompletableFuture;

/**
 * Servicio HTTP para comunicación con backend.
 * Maneja autenticación y requests REST.
 */
public class HttpAuthService {

    private static final Logger logger = LoggerFactory.getLogger(HttpAuthService.class);

    private static final String API_BASE_URL = "http://localhost:8080/api";
    private static final String LOGIN_ENDPOINT = "/auth/login";

    private final HttpClient httpClient;

    public HttpAuthService() {
        this.httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
    }

    /**
     * Autentica un usuario contra el backend.
     * Retorna resultado de autenticación de forma asincrónica.
     *
     * @param email Email del usuario
     * @param password Contraseña del usuario
     * @return CompletableFuture con usuario autenticado o error
     */
    public CompletableFuture<LoginViewModel.AuthenticatedUser> login(String email, String password) {
        String jsonRequest = buildLoginJson(email, password);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_BASE_URL + LOGIN_ENDPOINT))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .timeout(java.time.Duration.ofSeconds(10))
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    if (response.statusCode() == 200) {
                        logger.info("Login exitoso para: {}", email);
                        return parseLoginResponse(response.body(), email);
                    } else if (response.statusCode() == 401) {
                        logger.warn("Credenciales inválidas para: {}", email);
                        throw new RuntimeException("Credenciales inválidas");
                    } else {
                        logger.error("Error del servidor: {}", response.statusCode());
                        throw new RuntimeException("Error del servidor: " + response.statusCode());
                    }
                })
                .exceptionally(ex -> {
                    logger.error("Error en autenticación", ex);
                    throw new RuntimeException("No se puede conectar al servidor: " + ex.getMessage());
                });
    }

    /**
     * Construye JSON de solicitud de login.
     */
    private String buildLoginJson(String email, String password) {
        return String.format(
                "{\"email\":\"%s\",\"password\":\"%s\"}",
                sanitizeJson(email),
                sanitizeJson(password)
        );
    }

    /**
     * Parsea respuesta de login (simple, en producción usar Jackson/Gson).
     */
    private LoginViewModel.AuthenticatedUser parseLoginResponse(String jsonResponse, String email) {
        try {
            // Extracto simplista (en producción usar JSON parser)
            String token = extractJsonValue(jsonResponse, "token");
            String role = extractJsonValue(jsonResponse, "role");
            String username = extractJsonValue(jsonResponse, "username");

            return new LoginViewModel.AuthenticatedUser(email, token, role, username);
        } catch (Exception e) {
            logger.error("Error al parsear respuesta", e);
            throw new RuntimeException("Error al procesar respuesta del servidor");
        }
    }

    /**
     * Extrae valor de un JSON simple (sin librerías externas).
     */
    private String extractJsonValue(String json, String key) {
        String searchKey = "\"" + key + "\":\"";
        int startIndex = json.indexOf(searchKey);
        if (startIndex == -1) {
            return null;
        }
        startIndex += searchKey.length();
        int endIndex = json.indexOf("\"", startIndex);
        return json.substring(startIndex, endIndex);
    }

    /**
     * Sanitiza valores JSON para evitar inyección.
     */
    private String sanitizeJson(String value) {
        if (value == null) {
            return "";
        }
        return value
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r");
    }

}
