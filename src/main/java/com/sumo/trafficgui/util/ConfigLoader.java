package com.sumo.trafficgui.util;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for loading configuration files
 */
public class ConfigLoader {
    
    private static final Logger logger = LoggerFactory.getLogger(ConfigLoader.class);
    private static final Gson gson = new Gson();
    
    /**
     * Load configuration from a JSON file
     */
    public static Map<String, Object> loadConfig(String configPath) {
        logger.info("Loading configuration from: {}", configPath);
        
        try (InputStream is = ConfigLoader.class.getResourceAsStream(configPath)) {
            if (is == null) {
                logger.warn("Configuration file not found: {}", configPath);
                return new HashMap<>();
            }
            
            InputStreamReader reader = new InputStreamReader(is);
            Map<String, Object> config = gson.fromJson(reader, Map.class);
            
            logger.info("Configuration loaded successfully");
            return config;
        } catch (IOException e) {
            logger.error("Error loading configuration", e);
            return new HashMap<>();
        }
    }
    
    /**
     * Load configuration from external file path
     */
    public static Map<String, Object> loadExternalConfig(String filePath) {
        logger.info("Loading external configuration from: {}", filePath);
        
        try (FileReader reader = new FileReader(filePath)) {
            Map<String, Object> config = gson.fromJson(reader, Map.class);
            
            logger.info("External configuration loaded successfully");
            return config;
        } catch (IOException e) {
            logger.error("Error loading external configuration", e);
            return new HashMap<>();
        }
    }
}
