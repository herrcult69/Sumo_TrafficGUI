package com.sumo.trafficgui.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Vehicle model
 */
public class VehicleTest {
    
    private Vehicle vehicle;
    
    @BeforeEach
    public void setUp() {
        vehicle = new Vehicle("vehicle_01");
    }
    
    @Test
    public void testVehicleCreation() {
        assertNotNull(vehicle);
        assertEquals("vehicle_01", vehicle.getId());
    }
    
    @Test
    public void testSetAndGetSpeed() {
        vehicle.setSpeed(25.5);
        assertEquals(25.5, vehicle.getSpeed(), 0.001);
    }
    
    @Test
    public void testSetAndGetPosition() {
        vehicle.setPosition(100.0);
        assertEquals(100.0, vehicle.getPosition(), 0.001);
    }
    
    @Test
    public void testSetAndGetType() {
        vehicle.setType("passenger");
        assertEquals("passenger", vehicle.getType());
    }
    
    @Test
    public void testSetAndGetEdgeId() {
        vehicle.setEdgeId("edge_01");
        assertEquals("edge_01", vehicle.getEdgeId());
    }
    
    @Test
    public void testToString() {
        vehicle.setSpeed(30.0);
        vehicle.setPosition(50.0);
        
        String result = vehicle.toString();
        
        assertTrue(result.contains("vehicle_01"));
        assertTrue(result.contains("30.0"));
        assertTrue(result.contains("50.0"));
    }
}
