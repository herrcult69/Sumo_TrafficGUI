package com.sumo.trafficgui.service;

/**
 * Interface for TraCI connection abstraction
 * This allows the application to work without TraaS dependency during initial setup
 */
public interface TraciConnectionInterface {
    
    /**
     * Connect to SUMO
     */
    void connect() throws Exception;
    
    /**
     * Disconnect from SUMO
     */
    void disconnect();
    
    /**
     * Execute a simulation step
     */
    void simulationStep() throws Exception;
    
    /**
     * Get current simulation time
     */
    double getSimulationTime() throws Exception;
    
    /**
     * Check if connected
     */
    boolean isConnected();
}
