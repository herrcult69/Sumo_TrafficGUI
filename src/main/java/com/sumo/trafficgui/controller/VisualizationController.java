package com.sumo.trafficgui.controller;

import com.sumo.trafficgui.model.Vehicle;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Controller for handling visualization of the simulation
 */
public class VisualizationController {
    
    private static final Logger logger = LoggerFactory.getLogger(VisualizationController.class);
    
    private Canvas canvas;
    private GraphicsContext gc;
    
    public VisualizationController(Canvas canvas) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
    }
    
    /**
     * Render the current simulation state
     */
    public void render(List<Vehicle> vehicles) {
        // Clear canvas
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        // Draw background
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        // Draw vehicles
        for (Vehicle vehicle : vehicles) {
            drawVehicle(vehicle);
        }
    }
    
    /**
     * Draw a single vehicle
     */
    private void drawVehicle(Vehicle vehicle) {
        gc.setFill(Color.BLUE);
        
        // Convert SUMO coordinates to canvas coordinates
        double x = vehicle.getPosition() % canvas.getWidth();
        double y = canvas.getHeight() / 2;
        
        // Draw vehicle as rectangle
        gc.fillRect(x, y, 20, 10);
    }
    
    /**
     * Clear the visualization canvas
     */
    public void clear() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}
