package com.sumo.trafficgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Main application entry point for SUMO Traffic GUI
 * Initializes JavaFX application and loads the main view
 */
public class MainApplication extends Application {
    
    private static final Logger logger = LoggerFactory.getLogger(MainApplication.class);
    
    @Override
    public void start(Stage stage) throws IOException {
        logger.info("Starting SUMO Traffic GUI Application");
        
        FXMLLoader fxmlLoader = new FXMLLoader(
            MainApplication.class.getResource("/fxml/main-view.fxml")
        );
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        
        // Load CSS stylesheet
        scene.getStylesheets().add(
            MainApplication.class.getResource("/css/styles.css").toExternalForm()
        );
        
        stage.setTitle("SUMO Traffic Simulation GUI");
        stage.setScene(scene);
        stage.show();
        
        logger.info("Application started successfully");
    }
    
    @Override
    public void stop() {
        logger.info("Shutting down SUMO Traffic GUI Application");
        // Clean up resources, close SUMO connections, etc.
    }

    public static void main(String[] args) {
        launch();
    }
}
