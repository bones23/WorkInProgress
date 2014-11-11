package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Matthew Taylor
 * @version 2 October 2014
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
     
         //small.travel(18, 30);
         
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
         //Tests to see if you can remove an item when nothing is in the ship.
         assertEquals(0, small.getOccupiedSlots());
         assertFalse(small.removeItem(new TradeItem("Water")));
         assertEquals(0, small.getOccupiedSlots());
         
         //Changes bays to 10 to test if multiple items can be removed
         small.setBays(10);
         TradeItem[] current = small.getCargoManifest();
         TradeItem[] temp = new TradeItem[small.getBays()];
         for (int i = 0; i < current.length; i++) {
               if (current[i] != null)
                temp[i] = current[i];
         }
         small.setCargoManifest(temp);
         //-----------------------------------------------------------
         
         //Tests to see if one item is removed successfully from the cargo
         small.addItem(new TradeItem("Water"));
         assertEquals(1, small.getOccupiedSlots());
         assertEquals(small.getCargoManifest()[0].getName(), "Water");
         assertTrue(small.removeItem(new TradeItem("Water")));
         assertEquals(0, small.getOccupiedSlots());
         assertNull(small.getCargoManifest()[0]);
         
         //Tests to see if items are removed successfully after the Cargo size
        // has been increased.
         small.addItem(new TradeItem("Water"));
         assertEquals(1, small.getOccupiedSlots());
         assertEquals(small.getCargoManifest()[0].getName(), "Water");
         small.addItem(new TradeItem("Ore"));
         assertEquals(2, small.getOccupiedSlots());
         assertEquals(small.getCargoManifest()[1].getName(), "Ore");
         
         current = small.getCargoManifest();
         assertEquals(small.getCargoManifest()[0], current[0]);
         assertEquals(small.getCargoManifest()[1], current[1]);
         small.setBays(20);
         temp = new TradeItem[small.getBays()];
         for (int i = 0; i < current.length; i++) {
               if (current[i] != null)
                temp[i] = current[i];
         }
         small.setCargoManifest(temp);
         assertEquals(20, small.getBays());
         assertEquals(2, small.getOccupiedSlots());
         assertEquals(small.getCargoManifest()[0], current[0]);
         assertEquals(small.getCargoManifest()[1], current[1]);
         
         assertTrue(small.removeItem(new TradeItem("Water")));
         assertEquals(1, small.getOccupiedSlots());
         assertNull(small.getCargoManifest()[0]);
         
         assertTrue(small.removeItem(new TradeItem("Ore")));
         assertEquals(0, small.getOccupiedSlots());
         assertNull(small.getCargoManifest()[1]);

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
         assertEquals("TYPE", small.getShipClass());
     }
     
     @Test
     public void testGetPilot() {
         assertEquals("PILOT", small.getPilot());
     }
     
     @Test
     public void testGetNumOccupied() {
         assertEquals(0, small.getOccupiedSlots());
         
         small.addItem(new TradeItem("Water"));
         assertEquals(1, small.getOccupiedSlots());
         
         small.removeItem(new TradeItem("Water"));
         assertEquals(0, small.getOccupiedSlots());
     }
     
     @Test
     public void testGetCargoManifest() {
         assertEquals(1, small.getCargoManifest().length);
     }
}
