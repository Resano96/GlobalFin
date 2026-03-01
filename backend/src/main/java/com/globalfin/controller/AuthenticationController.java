package com.globalfin.controller;

import com.globalfin.dto.LoginRequest;
import com.globalfin.dto.LoginResponse;
import com.globalfin.exception.AuthenticationException;
import com.globalfin.service.AuthenticationService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para autenticación.
 * Endpoint: POST /api/auth/login
 */
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    /**
     * Autentica un usuario y retorna un token.
     *
     * @param request DTO con email y contraseña (validado)
     * @return Token y datos del usuario si es exitoso
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        try {
            logger.debug("Solicitud de login para: {}", request.getEmail());
            LoginResponse response = authenticationService.authenticate(request);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            logger.warn("Autenticación fallida: {}", e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse("Credenciales inválidas"));
        } catch (Exception e) {
            logger.error("Error inesperado en login", e);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Error interno del servidor"));
        }
    }

    /**
     * DTO simple para errores.
     */
    public static class ErrorResponse {
        private String message;

        public ErrorResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}
