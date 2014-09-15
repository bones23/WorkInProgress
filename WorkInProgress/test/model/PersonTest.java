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
 * @author Matthew Taylor
 * @version 15 September 2014
 */
public class PersonTest {
    
    Person test;
    Person noName;
    
    public PersonTest() {
    }
    
    @Before
    public void setUp() {
        test = new Person("Me", 3, 4, 5, 8);
        noName = new Person(8, 5, 4, 3);
    }

    /**
     * Test of getPilotSkill method, of class Person.
     */
    @Test
    public void testGetPilotSkill() {
        assertEquals(3, test.getPilotSkill());
        assertEquals(8, noName.getPilotSkill());
    }

    /**
     * Test of setPilotSkill method, of class Person.
     */
    @Test
    public void testSetPilotSkill() {
        test.setPilotSkill(0);
        noName.setPilotSkill(9);
        assertEquals(0, test.getPilotSkill());
        assertEquals(9, noName.getPilotSkill());
    }

    /**
     * Test of getFighterSkill method, of class Person.
     */
    @Test
    public void testGetFighterSkill() {
        assertEquals(4, test.getFighterSkill());
        assertEquals(5, noName.getFighterSkill());
    }

    /**
     * Test of setFighterSkill method, of class Person.
     */
    @Test
    public void testSetFighterSkill() {
        test.setFighterSkill(1);
        noName.setFighterSkill(8);
        assertEquals(1, test.getFighterSkill());
        assertEquals(8, noName.getFighterSkill());
    }

    /**
     * Test of getTraderSkill method, of class Person.
     */
    @Test
    public void testGetTraderSkill() {
        assertEquals(5, test.getTraderSkill());
        assertEquals(4, noName.getTraderSkill());
    }

    /**
     * Test of setTraderSkill method, of class Person.
     */
    @Test
    public void testSetTraderSkill() {
        test.setTraderSkill(9);
        noName.setTraderSkill(0);
        assertEquals(9, test.getTraderSkill());
        assertEquals(0, noName.getTraderSkill());
    }

    /**
     * Test of getEngineerSkill method, of class Person.
     */
    @Test
    public void testGetEngineerSkill() {
        assertEquals(8, test.getEngineerSkill());
        assertEquals(3, noName.getEngineerSkill());
    }

    /**
     * Test of setEngeineerSkill method, of class Person.
     */
    @Test
    public void testSetEngineerSkill() {
        test.setEngineerSkill(7);
        noName.setEngineerSkill(2);
        assertEquals(7, test.getEngineerSkill());
        assertEquals(2, noName.getEngineerSkill());
    }

    /**
     * Test of getName method, of class Person.
     */
    @Test
    public void testGetName() {
        assertEquals("Me", test.getName());
        assertEquals("Kirk", noName.getName());
    }

    /**
     * Test of setName method, of class Person.
     */
    @Test
    public void testSetName() {
        test.setName("9dptn");
        noName.setName("oxpv87");
        assertEquals("9dptn", test.getName());
        assertEquals("oxpv87", noName.getName());
    }

    /**
     * Test of toString method, of class Person.
     */
    @Test
    public void testToString() {
        assertEquals("Name: Me\nPilot Skill: 3\nFighter Skill: 4\nTrader Skill: 5\n"
            + "Engineering Skill: 8", test.toString());
        assertEquals("Name: Kirk\nPilot Skill: 8\nFighter Skill: 5\nTrader Skill: 4\n"
            + "Engineering Skill: 3", noName.toString());
    }
    
}
