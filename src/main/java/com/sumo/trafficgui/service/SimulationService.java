package com.sumo.trafficgui.service;

import com.sumo.trafficgui.model.SimulationState;
import com.sumo.trafficgui.model.Vehicle;
import de.tudresden.sumo.cmd.Vehicle.*;
import de.tudresden.ws.container.SumoStringList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for managing simulation operations
 */
public class SimulationService {
    
    private static final Logger logger = LoggerFactory.getLogger(SimulationService.class);
    
    private SumoConnectionService connectionService;
    private SimulationState simulationState;
    private boolean isRunning;
    
    public SimulationService(SumoConnectionService connectionService) {
        this.connectionService = connectionService;
        this.simulationState = new SimulationState();
        this.isRunning = false;
    }
    
    /**
     * Start the simulation
     */
    public void start() throws Exception {
        logger.info("Starting simulation");
        isRunning = true;
        simulationState.setRunning(true);
    }
    
    /**
     * Stop the simulation
     */
    public void stop() {
        logger.info("Stopping simulation");
        isRunning = false;
        simulationState.setRunning(false);
    }
    
    /**
     * Pause the simulation
     */
    public void pause() {
        logger.info("Pausing simulation");
        simulationState.setPaused(true);
    }
    
    /**
     * Resume the simulation
     */
    public void resume() {
        logger.info("Resuming simulation");
        simulationState.setPaused(false);
    }
    
    /**
     * Execute a single simulation step
     */
    public void step() throws Exception {
        if (connectionService.isConnected() && !simulationState.isPaused()) {
            connectionService.simulationStep();
            updateSimulationState();
        }
    }
    
    /**
     * Update simulation state with current data from SUMO
     */
    private void updateSimulationState() throws Exception {
        // Update simulation time
        double simTime = connectionService.getSimulationTime();
        simulationState.setSimulationTime(simTime);
        simulationState.setCurrentStep(simulationState.getCurrentStep() + 1);
        
        // TODO: Fetch and update vehicle data, traffic light states, etc.
        // This would use TraaS commands to get current vehicle positions, speeds, etc.
    }
    
    /**
     * Get current simulation state
     */
    public SimulationState getSimulationState() {
        return simulationState;
    }
    
    /**
     * Reset simulation to initial state
     */
    public void reset() {
        logger.info("Resetting simulation");
        simulationState.clear();
        isRunning = false;
    }
    
    public boolean isRunning() {
        return isRunning;
    }
}
