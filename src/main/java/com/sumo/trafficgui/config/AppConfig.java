package com.sumo.trafficgui.config;

/**
 * Application configuration class
 */
public class AppConfig {
    
    private static AppConfig instance;
    
    private String sumoExecutablePath;
    private String defaultConfigFile;
    private int simulationStepDelay;
    private boolean enableLogging;
    
    private AppConfig() {
        // Default values
        this.sumoExecutablePath = "sumo";
        this.defaultConfigFile = "";
        this.simulationStepDelay = 100;
        this.enableLogging = true;
    }
    
    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }
    
    // Getters and Setters
    
    public String getSumoExecutablePath() {
        return sumoExecutablePath;
    }
    
    public void setSumoExecutablePath(String sumoExecutablePath) {
        this.sumoExecutablePath = sumoExecutablePath;
    }
    
    public String getDefaultConfigFile() {
        return defaultConfigFile;
    }
    
    public void setDefaultConfigFile(String defaultConfigFile) {
        this.defaultConfigFile = defaultConfigFile;
    }
    
    public int getSimulationStepDelay() {
        return simulationStepDelay;
    }
    
    public void setSimulationStepDelay(int simulationStepDelay) {
        this.simulationStepDelay = simulationStepDelay;
    }
    
    public boolean isEnableLogging() {
        return enableLogging;
    }
    
    public void setEnableLogging(boolean enableLogging) {
        this.enableLogging = enableLogging;
    }
}
