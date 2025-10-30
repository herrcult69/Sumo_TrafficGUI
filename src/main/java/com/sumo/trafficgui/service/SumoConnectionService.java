package com.sumo.trafficgui.service;

// NOTE: TraaS imports are commented out until the library is installed
// See DEPENDENCIES.md for installation instructions
// import de.tudresden.sumo.cmd.Simulation;
// import de.tudresden.ws.container.SumoStringList;
// import it.polito.appeal.traci.SumoTraciConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service class for managing connection to SUMO via TraaS
 * NOTE: This is a stub implementation until TraaS is properly configured.
 * See DEPENDENCIES.md for TraaS setup instructions.
 */
public class SumoConnectionService implements TraciConnectionInterface {
    
    private static final Logger logger = LoggerFactory.getLogger(SumoConnectionService.class);
    
    // Commented out until TraaS is available
    // private SumoTraciConnection connection;
    private String sumoExecutable;
    private String configFile;
    private boolean isConnected;
    private double simulationTime;
    
    public SumoConnectionService(String sumoExecutable, String configFile) {
        this.sumoExecutable = sumoExecutable;
        this.configFile = configFile;
        this.isConnected = false;
        this.simulationTime = 0.0;
    }
    
    /**
     * Establish connection to SUMO
     */
    @Override
    public void connect() throws Exception {
        logger.info("Connecting to SUMO with config: {}", configFile);
        logger.warn("TraaS library not installed. This is a stub implementation.");
        logger.info("See DEPENDENCIES.md for TraaS installation instructions.");
        
        // TODO: Uncomment when TraaS is installed
        /*
        connection = new SumoTraciConnection(sumoExecutable, configFile);
        connection.addOption("--start");
        connection.addOption("--quit-on-end");
        connection.runServer();
        */
        
        isConnected = true;
        logger.info("Stub connection established (not actually connected to SUMO)");
    }
    
    /**
     * Disconnect from SUMO
     */
    @Override
    public void disconnect() {
        if (isConnected) {
            try {
                // TODO: Uncomment when TraaS is installed
                // if (connection != null) {
                //     connection.close();
                // }
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
    @Override
    public void simulationStep() throws Exception {
        if (isConnected) {
            // TODO: Uncomment when TraaS is installed
            // if (connection != null) {
            //     connection.do_timestep();
            // }
            simulationTime += 1.0; // Stub increment
        }
    }
    
    /**
     * Get current simulation time
     */
    @Override
    public double getSimulationTime() throws Exception {
        if (isConnected) {
            // TODO: Uncomment when TraaS is installed
            // if (connection != null) {
            //     return (double) connection.do_job_get(Simulation.getTime());
            // }
            return simulationTime; // Stub time
        }
        return 0.0;
    }
    
    // Uncomment when TraaS is installed
    // public SumoTraciConnection getConnection() {
    //     return connection;
    // }
    
    @Override
    public boolean isConnected() {
        return isConnected;
    }
}
