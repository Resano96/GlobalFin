package com.globalfin.ui.b2b.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para LoginViewModel.
 * Verifica validaciones, binding de propiedades y manejo de estado.
 */
@DisplayName("LoginViewModel - Tests")
class LoginViewModelTest {

    private LoginViewModel viewModel;

    @BeforeEach
    void setUp() {
        viewModel = new LoginViewModel();
    }

    @Test
    @DisplayName("Debe iniciar con formulario vacío")
    void testInitialState() {
        assertTrue(viewModel.getEmail().isEmpty());
        assertTrue(viewModel.getPassword().isEmpty());
        assertTrue(viewModel.isLoginButtonDisabled());
        assertTrue(viewModel.getErrorMessage().isEmpty());
        assertFalse(viewModel.isLoading());
    }

    @Test
    @DisplayName("Debe habilitar botón cuando email y contraseña están completos")
    void testLoginButtonEnabledWhenFieldsFilled() {
        // Arrange
        viewModel.setEmail("test@example.com");
        viewModel.setPassword("password123");

        // Assert
        assertFalse(viewModel.isLoginButtonDisabled());
    }

    @Test
    @DisplayName("Debe deshabilitar botón si email está vacío")
    void testLoginButtonDisabledWhenEmailEmpty() {
        // Arrange
        viewModel.setEmail("");
        viewModel.setPassword("password123");

        // Assert
        assertTrue(viewModel.isLoginButtonDisabled());
    }

    @Test
    @DisplayName("Debe deshabilitar botón si contraseña está vacía")
    void testLoginButtonDisabledWhenPasswordEmpty() {
        // Arrange
        viewModel.setEmail("test@example.com");
        viewModel.setPassword("");

        // Assert
        assertTrue(viewModel.isLoginButtonDisabled());
    }

    @Test
    @DisplayName("Debe limpiar formulario al resetear")
    void testResetForm() {
        // Arrange
        viewModel.setEmail("test@example.com");
        viewModel.setPassword("password123");
        viewModel.setErrorMessage("Error de prueba");
        viewModel.setLoading(true);

        // Act
        viewModel.resetForm();

        // Assert
        assertTrue(viewModel.getEmail().isEmpty());
        assertTrue(viewModel.getPassword().isEmpty());
        assertTrue(viewModel.getErrorMessage().isEmpty());
        assertFalse(viewModel.isLoading());
    }

    @Test
    @DisplayName("Debe establecer mensaje de error")
    void testSetErrorMessage() {
        // Arrange
        String errorMsg = "Credenciales inválidas";

        // Act
        viewModel.setErrorMessage(errorMsg);

        // Assert
        assertEquals(errorMsg, viewModel.getErrorMessage());
    }

    @Test
    @DisplayName("Debe limpiar mensaje de error")
    void testClearError() {
        // Arrange
        viewModel.setErrorMessage("Error presente");

        // Act
        viewModel.clearError();

        // Assert
        assertTrue(viewModel.getErrorMessage().isEmpty());
    }

    @Test
    @DisplayName("Debe almacenar usuario autenticado")
    void testSetAuthenticatedUser() {
        // Arrange
        LoginViewModel.AuthenticatedUser user = new LoginViewModel.AuthenticatedUser(
                "admin@globalfin.com",
                "token123",
                "ADMIN",
                "admin"
        );

        // Act
        viewModel.setAuthenticatedUser(user);

        // Assert
        assertNotNull(viewModel.getAuthenticatedUser());
        assertEquals("admin@globalfin.com", viewModel.getAuthenticatedUser().getEmail());
        assertEquals("ADMIN", viewModel.getAuthenticatedUser().getRole());
    }

    @Test
    @DisplayName("Debe habilitar loading state")
    void testSetLoading() {
        // Act
        viewModel.setLoading(true);

        // Assert
        assertTrue(viewModel.isLoading());
    }

    @Test
    @DisplayName("Debe validar email con espacios en blanco")
    void testEmailWithWhitespace() {
        // Arrange
        viewModel.setEmail("   ");
        viewModel.setPassword("password123");

        // Assert (debería estar deshabilitado)
        assertTrue(viewModel.isLoginButtonDisabled());
    }

}
