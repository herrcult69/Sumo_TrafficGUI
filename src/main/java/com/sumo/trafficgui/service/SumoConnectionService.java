package com.sumo.trafficgui.service;

import de.tudresden.sumo.cmd.Simulation;
import de.tudresden.ws.container.SumoStringList;
import it.polito.appeal.traci.SumoTraciConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service class for managing connection to SUMO via TraaS
 */
public class SumoConnectionService {
    
    private static final Logger logger = LoggerFactory.getLogger(SumoConnectionService.class);
    
    private SumoTraciConnection connection;
    private String sumoExecutable;
    private String configFile;
    private boolean isConnected;
    
    public SumoConnectionService(String sumoExecutable, String configFile) {
        this.sumoExecutable = sumoExecutable;
        this.configFile = configFile;
        this.isConnected = false;
    }
    
    /**
     * Establish connection to SUMO
     */
    public void connect() throws Exception {
        logger.info("Connecting to SUMO with config: {}", configFile);
        
        connection = new SumoTraciConnection(sumoExecutable, configFile);
        connection.addOption("--start");
        connection.addOption("--quit-on-end");
        
        connection.runServer();
        isConnected = true;
        
        logger.info("Successfully connected to SUMO");
    }
    
    /**
     * Disconnect from SUMO
     */
    public void disconnect() {
        if (connection != null && isConnected) {
            try {
                connection.close();
                isConnected = false;
                logger.info("Disconnected from SUMO");
            } catch (Exception e) {
                logger.error("Error disconnecting from SUMO", e);
            }
        }
    }
    
    /**
     * Execute a single simulation step
     */
    public void simulationStep() throws Exception {
        if (connection != null && isConnected) {
            connection.do_timestep();
        }
    }
    
    /**
     * Get current simulation time
     */
    public double getSimulationTime() throws Exception {
        if (connection != null && isConnected) {
            return (double) connection.do_job_get(Simulation.getTime());
        }
        return 0.0;
    }
    
    public SumoTraciConnection getConnection() {
        return connection;
    }
    
    public boolean isConnected() {
        return isConnected;
    }
}
