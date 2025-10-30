package com.sumo.trafficgui.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for SimulationState model
 */
public class SimulationStateTest {
    
    private SimulationState state;
    
    @BeforeEach
    public void setUp() {
        state = new SimulationState();
    }
    
    @Test
    public void testInitialState() {
        assertNotNull(state);
        assertEquals(0, state.getCurrentStep());
        assertEquals(0.0, state.getSimulationTime(), 0.001);
        assertFalse(state.isRunning());
        assertFalse(state.isPaused());
        assertNotNull(state.getVehicles());
        assertTrue(state.getVehicles().isEmpty());
    }
    
    @Test
    public void testAddVehicle() {
        Vehicle vehicle = new Vehicle("test_vehicle");
        state.addVehicle(vehicle);
        
        assertEquals(1, state.getVehicles().size());
        assertEquals("test_vehicle", state.getVehicles().get(0).getId());
    }
    
    @Test
    public void testRemoveVehicle() {
        Vehicle vehicle1 = new Vehicle("vehicle_01");
        Vehicle vehicle2 = new Vehicle("vehicle_02");
        
        state.addVehicle(vehicle1);
        state.addVehicle(vehicle2);
        
        assertEquals(2, state.getVehicles().size());
        
        state.removeVehicle("vehicle_01");
        
        assertEquals(1, state.getVehicles().size());
        assertEquals("vehicle_02", state.getVehicles().get(0).getId());
    }
    
    @Test
    public void testClear() {
        state.setCurrentStep(100);
        state.setSimulationTime(50.0);
        state.addVehicle(new Vehicle("test"));
        
        state.clear();
        
        assertEquals(0, state.getCurrentStep());
        assertEquals(0.0, state.getSimulationTime(), 0.001);
        assertTrue(state.getVehicles().isEmpty());
    }
    
    @Test
    public void testSetRunningAndPaused() {
        state.setRunning(true);
        assertTrue(state.isRunning());
        
        state.setPaused(true);
        assertTrue(state.isPaused());
    }
}
