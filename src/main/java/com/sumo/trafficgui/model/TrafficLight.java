package com.sumo.trafficgui.model;

/**
 * Model class representing a traffic light in the SUMO simulation
 */
public class TrafficLight {
    
    private String id;
    private String state;
    private int phaseDuration;
    private int currentPhase;
    
    public TrafficLight(String id) {
        this.id = id;
    }
    
    // Getters and Setters
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public int getPhaseDuration() {
        return phaseDuration;
    }
    
    public void setPhaseDuration(int phaseDuration) {
        this.phaseDuration = phaseDuration;
    }
    
    public int getCurrentPhase() {
        return currentPhase;
    }
    
    public void setCurrentPhase(int currentPhase) {
        this.currentPhase = currentPhase;
    }
    
    @Override
    public String toString() {
        return "TrafficLight{" +
                "id='" + id + '\'' +
                ", state='" + state + '\'' +
                ", currentPhase=" + currentPhase +
                '}';
    }
}
