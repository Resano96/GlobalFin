package com.globalfin.ui.b2b.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.ObjectProperty;

/**
 * ViewModel para la pantalla de Login (B2B).
 * Gestiona el estado y validaciones de la vista de login.
 *
 * Patrón MVVM: Separa la lógica de presentación de la UI.
 */
public class LoginViewModel {

    // Propiedades vinculables (binding para JavaFX)
    private final SimpleStringProperty email = new SimpleStringProperty("");
    private final SimpleStringProperty password = new SimpleStringProperty("");
    private final SimpleBooleanProperty isLoading = new SimpleBooleanProperty(false);
    private final SimpleStringProperty errorMessage = new SimpleStringProperty("");
    private final SimpleBooleanProperty loginButtonDisabled = new SimpleBooleanProperty(true);

    // Estado de usuario autenticado
    private final ObjectProperty<AuthenticatedUser> authenticatedUser = new SimpleObjectProperty<>();

    public LoginViewModel() {
        // Observar cambios en email/password para habilitar/deshabilitar botón
        email.addListener((obs, oldVal, newVal) -> validateForm());
        password.addListener((obs, oldVal, newVal) -> validateForm());
    }

    /**
     * Valida que los campos estén completos.
     */
    private void validateForm() {
        String emailVal = email.get();
        String passVal = password.get();
        boolean isValid = emailVal != null && !emailVal.trim().isEmpty() &&
                         passVal != null && !passVal.trim().isEmpty();
        loginButtonDisabled.set(!isValid);
    }

    /**
     * Resetea la vista después de login exitoso o cancelación.
     */
    public void resetForm() {
        email.set("");
        password.set("");
        errorMessage.set("");
        isLoading.set(false);
        authenticatedUser.set(null);
    }

    /**
     * Limpia el mensaje de error.
     */
    public void clearError() {
        errorMessage.set("");
    }

    // ==================== Getters/Setters ====================

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String value) {
        email.set(value);
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String value) {
        password.set(value);
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public boolean isLoading() {
        return isLoading.get();
    }

    public void setLoading(boolean value) {
        isLoading.set(value);
    }

    public SimpleBooleanProperty isLoadingProperty() {
        return isLoading;
    }

    public String getErrorMessage() {
        return errorMessage.get();
    }

    public void setErrorMessage(String value) {
        errorMessage.set(value);
    }

    public SimpleStringProperty errorMessageProperty() {
        return errorMessage;
    }

    public boolean isLoginButtonDisabled() {
        return loginButtonDisabled.get();
    }

    public SimpleBooleanProperty loginButtonDisabledProperty() {
        return loginButtonDisabled;
    }

    public AuthenticatedUser getAuthenticatedUser() {
        return authenticatedUser.get();
    }

    public void setAuthenticatedUser(AuthenticatedUser user) {
        authenticatedUser.set(user);
    }

    public ObjectProperty<AuthenticatedUser> authenticatedUserProperty() {
        return authenticatedUser;
    }

    // ==================== Inner class ====================

    /**
     * Representa un usuario autenticado.
     */
    public static class AuthenticatedUser {
        private final String email;
        private final String token;
        private final String role;
        private final String username;

        public AuthenticatedUser(String email, String token, String role, String username) {
            this.email = email;
            this.token = token;
            this.role = role;
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public String getToken() {
            return token;
        }

        public String getRole() {
            return role;
        }

        public String getUsername() {
            return username;
        }

        @Override
        public String toString() {
            return "AuthenticatedUser{" +
                    "email='" + email + '\'' +
                    ", role='" + role + '\'' +
                    ", username='" + username + '\'' +
                    '}';
        }
    }

}
