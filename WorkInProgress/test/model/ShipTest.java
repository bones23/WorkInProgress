/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MT
 */
public class ShipTest {
    
    Ship small;
    
    public ShipTest() {
    }
    
    @Before
    public void setUp() {
        small = new Ship("TYPE", "PILOT", 10, 1);
    }
    
     @Test
     public void testTravel() {
     
         small.travel(18, 30);
         
         assertEquals(18, small.getX());
         assertEquals(30, small.getY());
     }
     
     @Test
     public void testAddItem() {
         
         assertTrue(small.addItem(new TradeItem("Water")));
         assertFalse(small.addItem(new TradeItem("Games")));
     }
     
     @Test
     public void testRemoveItem() {
         assertFalse(small.removeItem(new TradeItem("Water")));
         
         small.addItem(new TradeItem("Water"));
         assertTrue(small.removeItem(new TradeItem("Water")));
     }
     
     @Test
     public void testGetFuel() {
         assertEquals(10, small.getFuel());
     }
     
     @Test
     public void testSetFuel() {
         small.setFuel(10101);
         assertEquals(10101, small.getFuel());
     }
     
     @Test
     public void testGetType() {
         assertEquals("TYPE", small.getType());
     }
     
     @Test
     public void testGetPilot() {
         assertEquals("PILOT", small.getPilot());
     }
     
     @Test
     public void testGetNumOccupied() {
         assertEquals(0, small.getNumOccupied());
         
         small.addItem(new TradeItem("Water"));
         assertEquals(1, small.getNumOccupied());
         
         small.removeItem(new TradeItem("Water"));
         assertEquals(0, small.getNumOccupied());
     }
     
     @Test
     public void testGetCargo() {
         assertEquals(1, small.getCargo().length);
     }
}
