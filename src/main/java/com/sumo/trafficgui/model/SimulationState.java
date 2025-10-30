package com.sumo.trafficgui.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class representing the current state of the simulation
 */
public class SimulationState {
    
    private int currentStep;
    private double simulationTime;
    private boolean isRunning;
    private boolean isPaused;
    private List<Vehicle> vehicles;
    private List<TrafficLight> trafficLights;
    
    public SimulationState() {
        this.vehicles = new ArrayList<>();
        this.trafficLights = new ArrayList<>();
        this.currentStep = 0;
        this.simulationTime = 0.0;
        this.isRunning = false;
        this.isPaused = false;
    }
    
    // Getters and Setters
    
    public int getCurrentStep() {
        return currentStep;
    }
    
    public void setCurrentStep(int currentStep) {
        this.currentStep = currentStep;
    }
    
    public double getSimulationTime() {
        return simulationTime;
    }
    
    public void setSimulationTime(double simulationTime) {
        this.simulationTime = simulationTime;
    }
    
    public boolean isRunning() {
        return isRunning;
    }
    
    public void setRunning(boolean running) {
        isRunning = running;
    }
    
    public boolean isPaused() {
        return isPaused;
    }
    
    public void setPaused(boolean paused) {
        isPaused = paused;
    }
    
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
    
    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
    
    public List<TrafficLight> getTrafficLights() {
        return trafficLights;
    }
    
    public void setTrafficLights(List<TrafficLight> trafficLights) {
        this.trafficLights = trafficLights;
    }
    
    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }
    
    public void removeVehicle(String vehicleId) {
        this.vehicles.removeIf(v -> v.getId().equals(vehicleId));
    }
    
    public void clear() {
        this.vehicles.clear();
        this.trafficLights.clear();
        this.currentStep = 0;
        this.simulationTime = 0.0;
    }
}
