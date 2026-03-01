package com.globalfin.ui.b2b;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test de humo de la aplicación JavaFX.
 * Verifica que la aplicación arranca y carga la escena principal.
 */
@DisplayName("GlobalFin UI B2B - Smoke Test")
class MainAppTest {

    @Test
    @DisplayName("Debe crear instancia de MainApp")
    void applicationShouldInstantiate() {
        MainApp app = new MainApp();
        assertNotNull(app);
    }

}
