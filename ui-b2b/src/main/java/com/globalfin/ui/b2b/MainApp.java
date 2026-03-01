package com.globalfin.ui.b2b;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Aplicación principal - Dashboard B2B para GlobalFin.
 * Interfaz de usuario para empleados internos.
 */
public class MainApp extends Application {

    private static final Logger logger = LoggerFactory.getLogger(MainApp.class);

    @Override
    public void start(Stage primaryStage) {
        logger.info("Iniciando GlobalFin Dashboard B2B...");

        try {
            BorderPane root = new BorderPane();
            Label titleLabel = new Label("GlobalFin - Dashboard B2B");
            titleLabel.setStyle("-fx-font-size: 18px; -fx-padding: 20px;");
            root.setTop(titleLabel);

            Scene scene = new Scene(root, 1280, 720);
            primaryStage.setScene(scene);
            primaryStage.setTitle("GlobalFin - Dashboard Interno");
            primaryStage.show();

            logger.info("Dashboard B2B iniciado correctamente");
        } catch (Exception e) {
            logger.error("Error al iniciar la aplicación", e);
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
