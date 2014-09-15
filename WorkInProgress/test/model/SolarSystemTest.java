package model;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Matthew Taylor
 * @version 15 September 2014
 */
public class SolarSystemTest {
    
    SolarSystem test;
    
    public SolarSystemTest() {
    }
    
    @Before
    public void setUp() {
        test = new SolarSystem("Test", 17, 29);
    }
    
    /**
     * Test of getName method, of class SolarSystem.
     */
    @Test
    public void testGetName() {
        assertEquals("Test", test.getName());
    }

    /**
     * Test of getX method, of class SolarSystem.
     */
    @Test
    public void testGetX() {
        assertEquals(17, test.getX());
    }

    /**
     * Test of getY method, of class SolarSystem.
     */
    @Test
    public void testGetY() {
        assertEquals(29, test.getY());
    }

    /**
     * Test of getTech method, of class SolarSystem.
     */
    @Test
    public void testGetTech() {
        String[] techNames = {"Pre-Algriculture", "Agriculture", "Medieval",
            "Renaissance", "Early-Industrial", "Industrial", "Post-Industrial", "Hi-Tech"};
        assertTrue(Arrays.asList(techNames).contains(test.getTech()));
    }

    /**
     * Test of getGovernment method, of class SolarSystem.
     */
    @Test
    public void testGetGovernment() {
        String[] governmentNames = {"Monarchy", "Technocracy", "Democracy", 
            "Corporate State", "Theocracy", "Feudal State", "Socialist State", "Anarchy"};
        assertTrue(Arrays.asList(governmentNames).contains(test.getGovernment()));
    }

    /**
     * Test of getResource method, of class SolarSystem.
     */
    @Test
    public void testGetResource() {
        String[] resourceNames = {"No Special Resources","No Special Resources",
            "No Special Resources", "No Special Resources", "Mineral Rich", "Mineral Poor",
            "Desert", "Lots of Water", "Rich Soil", "Poor Soil", "Rich Fauna", "Lifeless",
            "Weird Mushrooms", "Lots of Herbs", "Artistic", "Warlike"};
        assertTrue(Arrays.asList(resourceNames).contains(test.getResource()));
    }

    /**
     * Test of setResource method, of class SolarSystem.
     */
    @Test
    public void testSetResource() {
        test.setResource("Something");
        assertEquals("Something", test.getResource());
    }

    /**
     * Test of getPirate method, of class SolarSystem.
     */
    @Test
    public void testGetPirate() {
        String[] amountNames = {"None", "Minimal", "Moderate", "Abundant"};
        assertTrue(Arrays.asList(amountNames).contains(test.getPirate()));
    }

    /**
     * Test of getPolice method, of class SolarSystem.
     */
    @Test
    public void testGetPolice() {
        String[] amountNames = {"None", "Minimal", "Moderate", "Abundant"};
        assertTrue(Arrays.asList(amountNames).contains(test.getPolice()));
    }

    /**
     * Test of toString method, of class SolarSystem.
     */
    @Test
    public void testToString() {
        assertEquals("Name: Test\nTech Level: " + test.getTech() + "\nGovernment: "
            + test.getGovernment() + "\nResource: " + test.getResource() + "\nPolice: "
            + test.getPolice() + "\nPirate: " + test.getPirate() + "\nLocation: 17"
            + ", 29\n", test.toString());
        System.out.println(test.toString());
    }
    
}
