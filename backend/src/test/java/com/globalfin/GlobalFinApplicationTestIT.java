package com.globalfin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test de humo del backend GlobalFin.
 * Verifica que la aplicación Spring Boot arranca correctamente.
 */
@SpringBootTest
@DisplayName("GlobalFin Backend - Smoke Test")
class GlobalFinApplicationTestIT {

    @Test
    @DisplayName("Debe cargar el contexto de Spring Boot")
    void applicationContextLoads() {
        // Si llega hasta aquí, el contexto se cargó correctamente
        assertNotNull(true);
    }

}
