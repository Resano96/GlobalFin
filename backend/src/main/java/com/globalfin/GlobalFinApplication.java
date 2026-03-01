package com.globalfin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Aplicación principal de GlobalFin Backend.
 * Inicia los servicios REST para las transacciones bancarias.
 */
@SpringBootApplication
public class GlobalFinApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlobalFinApplication.class, args);
    }

}
