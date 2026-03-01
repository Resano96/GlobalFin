package com.globalfin.exception;

/**
 * Excepción para errores de autenticación.
 * Lanzada cuando las credenciales son inválidas o el usuario no existe.
 */
public class AuthenticationException extends RuntimeException {

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
