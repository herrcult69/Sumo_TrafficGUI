package com.sumo.trafficgui.model;

/**
 * Model class representing a vehicle in the SUMO simulation
 */
public class Vehicle {
    
    private String id;
    private String type;
    private double speed;
    private double position;
    private String routeId;
    private String edgeId;
    private double angle;
    
    public Vehicle(String id) {
        this.id = id;
    }
    
    // Getters and Setters
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public double getSpeed() {
        return speed;
    }
    
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    public double getPosition() {
        return position;
    }
    
    public void setPosition(double position) {
        this.position = position;
    }
    
    public String getRouteId() {
        return routeId;
    }
    
    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }
    
    public String getEdgeId() {
        return edgeId;
    }
    
    public void setEdgeId(String edgeId) {
        this.edgeId = edgeId;
    }
    
    public double getAngle() {
        return angle;
    }
    
    public void setAngle(double angle) {
        this.angle = angle;
    }
    
    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", speed=" + speed +
                ", position=" + position +
                ", edgeId='" + edgeId + '\'' +
                '}';
    }
}
