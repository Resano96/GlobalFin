package com.globalfin.service;

import com.globalfin.dto.LoginRequest;
import com.globalfin.dto.LoginResponse;
import com.globalfin.exception.AuthenticationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para AuthenticationService.
 * Verifica el flujo de login, validaciones y generación de tokens.
 */
@DisplayName("AuthenticationService - Tests")
class AuthenticationServiceTest {

    private AuthenticationService authenticationService;

    @BeforeEach
    void setUp() {
        authenticationService = new AuthenticationService();
    }

    @Test
    @DisplayName("Debe autenticar usuario con credenciales válidas")
    void testLoginSuccess() {
        // Arrange
        LoginRequest request = new LoginRequest("admin@globalfin.com", "admin123");

        // Act
        LoginResponse response = authenticationService.authenticate(request);

        // Assert
        assertNotNull(response);
        assertNotNull(response.getToken());
        assertNotNull(response.getRefreshToken());
        assertEquals("admin@globalfin.com", response.getEmail());
        assertEquals("ADMIN", response.getRole());
        assertEquals("admin", response.getUsername());
    }

    @Test
    @DisplayName("Debe lanzar excepción con email inválido")
    void testLoginWithInvalidEmail() {
        // Arrange
        LoginRequest request = new LoginRequest("noexiste@globalfin.com", "password123");

        // Act & Assert
        assertThrows(AuthenticationException.class, () -> {
            authenticationService.authenticate(request);
        });
    }

    @Test
    @DisplayName("Debe lanzar excepción con contraseña incorrecta")
    void testLoginWithWrongPassword() {
        // Arrange
        LoginRequest request = new LoginRequest("admin@globalfin.com", "passwordIncorrecto");

        // Act & Assert
        assertThrows(AuthenticationException.class, () -> {
            authenticationService.authenticate(request);
        });
    }

    @Test
    @DisplayName("Debe lanzar excepción con request nulo")
    void testLoginWithNullRequest() {
        // Act & Assert
        assertThrows(AuthenticationException.class, () -> {
            authenticationService.authenticate(null);
        });
    }

    @Test
    @DisplayName("Debe lanzar excepción con email nulo")
    void testLoginWithNullEmail() {
        // Arrange
        LoginRequest request = new LoginRequest(null, "password123");

        // Act & Assert
        assertThrows(AuthenticationException.class, () -> {
            authenticationService.authenticate(request);
        });
    }

    @Test
    @DisplayName("Debe lanzar excepción con contraseña nula")
    void testLoginWithNullPassword() {
        // Arrange
        LoginRequest request = new LoginRequest("admin@globalfin.com", null);

        // Act & Assert
        assertThrows(AuthenticationException.class, () -> {
            authenticationService.authenticate(request);
        });
    }

    @Test
    @DisplayName("Debe autenticar usuario empleado con rol correcto")
    void testLoginEmployeeRole() {
        // Arrange
        LoginRequest request = new LoginRequest("empleado@globalfin.com", "emp123");

        // Act
        LoginResponse response = authenticationService.authenticate(request);

        // Assert
        assertEquals("EMPLOYEE", response.getRole());
    }

    @Test
    @DisplayName("Debe autenticar usuario cliente con rol USER")
    void testLoginUserRole() {
        // Arrange
        LoginRequest request = new LoginRequest("cliente@globalfin.com", "cli123");

        // Act
        LoginResponse response = authenticationService.authenticate(request);

        // Assert
        assertEquals("USER", response.getRole());
    }

}
