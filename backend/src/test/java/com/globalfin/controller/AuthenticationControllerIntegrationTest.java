package com.globalfin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globalfin.dto.LoginRequest;
import com.globalfin.service.AuthenticationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Tests de integración para AuthenticationController.
 * Verifica los endpoints REST de autenticación.
 */
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("AuthenticationController - Integration Tests")
class AuthenticationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("POST /api/auth/login debe retornar 200 con credenciales válidas")
    void testLoginEndpointSuccess() throws Exception {
        // Arrange
        LoginRequest request = new LoginRequest("admin@globalfin.com", "admin123");
        String jsonRequest = objectMapper.writeValueAsString(request);

        // Act & Assert
        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists())
                .andExpect(jsonPath("$.refreshToken").exists())
                .andExpect(jsonPath("$.email").value("admin@globalfin.com"))
                .andExpect(jsonPath("$.role").value("ADMIN"));
    }

    @Test
    @DisplayName("POST /api/auth/login debe retornar 401 con credenciales inválidas")
    void testLoginEndpointFailure() throws Exception {
        // Arrange
        LoginRequest request = new LoginRequest("admin@globalfin.com", "wrongPassword");
        String jsonRequest = objectMapper.writeValueAsString(request);

        // Act & Assert
        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.message").exists());
    }

    @Test
    @DisplayName("POST /api/auth/login debe validar email inválido")
    void testLoginEndpointInvalidEmail() throws Exception {
        // Arrange
        LoginRequest request = new LoginRequest("invalid-email", "password123");
        String jsonRequest = objectMapper.writeValueAsString(request);

        // Act & Assert
        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("POST /api/auth/login debe rechazar email vacío")
    void testLoginEndpointEmptyEmail() throws Exception {
        // Arrange
        LoginRequest request = new LoginRequest("", "password123");
        String jsonRequest = objectMapper.writeValueAsString(request);

        // Act & Assert
        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("POST /api/auth/login debe rechazar contraseña vacía")
    void testLoginEndpointEmptyPassword() throws Exception {
        // Arrange
        LoginRequest request = new LoginRequest("admin@globalfin.com", "");
        String jsonRequest = objectMapper.writeValueAsString(request);

        // Act & Assert
        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isBadRequest());
    }

}
