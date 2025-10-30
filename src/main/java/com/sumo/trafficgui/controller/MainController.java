package com.sumo.trafficgui.controller;

import com.sumo.trafficgui.model.SimulationState;
import com.sumo.trafficgui.service.SimulationService;
import com.sumo.trafficgui.service.SumoConnectionService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main controller for the JavaFX application
 */
public class MainController {
    
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    
    @FXML
    private Button connectButton;
    
    @FXML
    private Button startButton;
    
    @FXML
    private Button pauseButton;
    
    @FXML
    private Button stopButton;
    
    @FXML
    private TextField sumoPathField;
    
    @FXML
    private TextField configPathField;
    
    @FXML
    private Label simulationTimeLabel;
    
    @FXML
    private Label vehicleCountLabel;
    
    @FXML
    private ListView<String> vehicleListView;
    
    @FXML
    private Pane simulationCanvas;
    
    private SumoConnectionService connectionService;
    private SimulationService simulationService;
    
    @FXML
    public void initialize() {
        logger.info("Initializing MainController");
        
        // Initialize UI state
        startButton.setDisable(true);
        pauseButton.setDisable(true);
        stopButton.setDisable(true);
    }
    
    @FXML
    private void handleConnect() {
        logger.info("Connect button clicked");
        
        String sumoPath = sumoPathField.getText();
        String configPath = configPathField.getText();
        
        try {
            connectionService = new SumoConnectionService(sumoPath, configPath);
            connectionService.connect();
            
            simulationService = new SimulationService(connectionService);
            
            // Update UI state
            connectButton.setDisable(true);
            startButton.setDisable(false);
            
            logger.info("Connected to SUMO successfully");
        } catch (Exception e) {
            logger.error("Failed to connect to SUMO", e);
            // TODO: Show error dialog
        }
    }
    
    @FXML
    private void handleStart() {
        logger.info("Start button clicked");
        
        try {
            simulationService.start();
            
            // Update UI state
            startButton.setDisable(true);
            pauseButton.setDisable(false);
            stopButton.setDisable(false);
            
            // Start simulation loop
            startSimulationLoop();
        } catch (Exception e) {
            logger.error("Failed to start simulation", e);
        }
    }
    
    @FXML
    private void handlePause() {
        logger.info("Pause button clicked");
        
        if (simulationService.getSimulationState().isPaused()) {
            simulationService.resume();
            pauseButton.setText("Pause");
        } else {
            simulationService.pause();
            pauseButton.setText("Resume");
        }
    }
    
    @FXML
    private void handleStop() {
        logger.info("Stop button clicked");
        
        simulationService.stop();
        
        // Update UI state
        startButton.setDisable(false);
        pauseButton.setDisable(true);
        stopButton.setDisable(true);
        pauseButton.setText("Pause");
    }
    
    private void startSimulationLoop() {
        Thread simulationThread = new Thread(() -> {
            while (simulationService.isRunning()) {
                try {
                    simulationService.step();
                    
                    // Update UI on JavaFX thread
                    Platform.runLater(this::updateUI);
                    
                    Thread.sleep(100); // Control simulation speed
                } catch (Exception e) {
                    logger.error("Error in simulation loop", e);
                    break;
                }
            }
        });
        simulationThread.setDaemon(true);
        simulationThread.start();
    }
    
    private void updateUI() {
        SimulationState state = simulationService.getSimulationState();
        
        // Update labels
        simulationTimeLabel.setText(String.format("%.2f s", state.getSimulationTime()));
        vehicleCountLabel.setText(String.valueOf(state.getVehicles().size()));
        
        // Update vehicle list
        vehicleListView.getItems().clear();
        state.getVehicles().forEach(v -> 
            vehicleListView.getItems().add(v.getId() + " - " + v.getSpeed() + " m/s")
        );
    }
}
