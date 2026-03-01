package com.globalfin.service;

import com.globalfin.dto.LoginRequest;
import com.globalfin.dto.LoginResponse;
import com.globalfin.exception.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Servicio de autenticación para GlobalFin.
 * Responsable de validar credenciales y generar tokens.
 *
 * ⚠️ SPRINT 1: Usuarios en memoria para demostración.
 * PRODUCCIÓN: Integrar con base de datos + JWT real + refresh tokens.
 */
@Service
public class AuthenticationService {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

    // Usuarios de prueba (SOLO DESARROLLO)
    private static final Map<String, String> TEST_USERS = new HashMap<>();

    static {
        // email -> password (hasheada en producción)
        TEST_USERS.put("admin@globalfin.com", "admin123");
        TEST_USERS.put("empleado@globalfin.com", "emp123");
        TEST_USERS.put("cliente@globalfin.com", "cli123");
    }

    /**
     * Autentica un usuario con email y contraseña.
     *
     * @param request DTO con email y contraseña
     * @return DTO con token y datos del usuario
     * @throws AuthenticationException si las credenciales son inválidas
     */
    public LoginResponse authenticate(LoginRequest request) {
        // 1. Validar entrada
        if (request == null || request.getEmail() == null || request.getPassword() == null) {
            logger.warn("Intento de login con datos nulos");
            throw new AuthenticationException("Credenciales inválidas");
        }

        String email = request.getEmail().trim().toLowerCase();
        String password = request.getPassword();

        // 2. Buscar usuario (en base de datos en producción)
        if (!TEST_USERS.containsKey(email)) {
            logger.warn("Intento de login con email inexistente: {}", email);
            throw new AuthenticationException("Credenciales inválidas");
        }

        // 3. Validar contraseña (comparar con hash en producción)
        String storedPassword = TEST_USERS.get(email);
        if (!password.equals(storedPassword)) {
            logger.warn("Intento de login con contraseña incorrecta para: {}", email);
            throw new AuthenticationException("Credenciales inválidas");
        }

        // 4. Generar token (JWT en producción)
        String token = generateToken(email);
        String refreshToken = generateRefreshToken(email);

        // 5. Determinar rol (de base de datos en producción)
        String role = determineRole(email);
        String username = extractUsername(email);

        logger.info("Login exitoso para: {}", email);

        return new LoginResponse(token, refreshToken, email, role, username);
    }

    /**
     * Genera un token de autenticación (mock para desarrollo).
     * En producción, usar JWT con firma y expiración.
     */
    private String generateToken(String email) {
        String payload = email + ":" + System.currentTimeMillis();
        return Base64.getEncoder().encodeToString(payload.getBytes());
    }

    /**
     * Genera un refresh token (mock para desarrollo).
     */
    private String generateRefreshToken(String email) {
        return UUID.randomUUID().toString();
    }

    /**
     * Determina el rol del usuario (mock para desarrollo).
     */
    private String determineRole(String email) {
        if (email.contains("admin")) {
            return "ADMIN";
        } else if (email.contains("empleado")) {
            return "EMPLOYEE";
        }
        return "USER";
    }

    /**
     * Extrae el nombre del usuario del email.
     */
    private String extractUsername(String email) {
        return email.split("@")[0];
    }

}
