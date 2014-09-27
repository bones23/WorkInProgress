/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MT
 */
public class TradeItemTest {
    
    public TradeItemTest() {
    }
    
     @Test
     public void testWater() {
     
         TradeItem water = new TradeItem("Water");
         
         assertEquals(0, water.getMTLP());
         assertEquals(0, water.getMTLU());
         assertEquals(2, water.getTTP());
         assertEquals(30, water.getBP());
         assertEquals(3, water.getIPL());
         assertEquals(4, water.getVar());
         assertEquals("DROUGHT", water.getIE());
         assertEquals("LOTSOFWATER", water.getCR());
         assertEquals("DESERT", water.getER());
         assertEquals(30, water.getMTL());
         assertEquals(50, water.getMTH());
     }
     
     @Test
     public void testFurs() {
     
         TradeItem furs = new TradeItem("Furs");
         
         assertEquals(0, furs.getMTLP());
         assertEquals(0, furs.getMTLU());
         assertEquals(0, furs.getTTP());
         assertEquals(250, furs.getBP());
         assertEquals(10, furs.getIPL());
         assertEquals(10, furs.getVar());
         assertEquals("COLD", furs.getIE());
         assertEquals("RICHFAUNA", furs.getCR());
         assertEquals("LIFELESS", furs.getER());
         assertEquals(230, furs.getMTL());
         assertEquals(280, furs.getMTH());
     }
     
     @Test
     public void testFood() {
     
         TradeItem food = new TradeItem("Food");
         
         assertEquals(1, food.getMTLP());
         assertEquals(0, food.getMTLU());
         assertEquals(1, food.getTTP());
         assertEquals(100, food.getBP());
         assertEquals(5, food.getIPL());
         assertEquals(5, food.getVar());
         assertEquals("CROPFAIL", food.getIE());
         assertEquals("RICHSOIL", food.getCR());
         assertEquals("POORSOIL", food.getER());
         assertEquals(90, food.getMTL());
         assertEquals(160, food.getMTH());
     }
     
     @Test
     public void testOre() {
     
         TradeItem ore = new TradeItem("Ore");
         
         assertEquals(2, ore.getMTLP());
         assertEquals(2, ore.getMTLU());
         assertEquals(3, ore.getTTP());
         assertEquals(350, ore.getBP());
         assertEquals(20, ore.getIPL());
         assertEquals(10, ore.getVar());
         assertEquals("WAR", ore.getIE());
         assertEquals("MINERALRICH", ore.getCR());
         assertEquals("MINERALPOOR", ore.getER());
         assertEquals(350, ore.getMTL());
         assertEquals(420, ore.getMTH());
     }
     
     @Test
     public void testGames() {
     
         TradeItem games = new TradeItem("Games");
         
         assertEquals(3, games.getMTLP());
         assertEquals(1, games.getMTLU());
         assertEquals(6, games.getTTP());
         assertEquals(250, games.getBP());
         assertEquals(-10, games.getIPL());
         assertEquals(5, games.getVar());
         assertEquals("BOREDOM", games.getIE());
         assertEquals("ARTISTIC", games.getCR());
         assertEquals("Never", games.getER());
         assertEquals(160, games.getMTL());
         assertEquals(270, games.getMTH());
     }
     
     @Test
     public void testFirearms() {
     
         TradeItem firearms = new TradeItem("Firearms");
         
         assertEquals(3, firearms.getMTLP());
         assertEquals(1, firearms.getMTLU());
         assertEquals(5, firearms.getTTP());
         assertEquals(1250, firearms.getBP());
         assertEquals(-75, firearms.getIPL());
         assertEquals(100, firearms.getVar());
         assertEquals("WAR", firearms.getIE());
         assertEquals("WARLIKE", firearms.getCR());
         assertEquals("Never", firearms.getER());
         assertEquals(600, firearms.getMTL());
         assertEquals(1100, firearms.getMTH());
     }
     
     @Test
     public void testMedicine() {
     
         TradeItem medicine = new TradeItem("Medicine");
         
         assertEquals(4, medicine.getMTLP());
         assertEquals(1, medicine.getMTLU());
         assertEquals(6, medicine.getTTP());
         assertEquals(650, medicine.getBP());
         assertEquals(-20, medicine.getIPL());
         assertEquals(10, medicine.getVar());
         assertEquals("PLAGUE", medicine.getIE());
         assertEquals("LOTSOFHERBS", medicine.getCR());
         assertEquals("Never", medicine.getER());
         assertEquals(400, medicine.getMTL());
         assertEquals(700, medicine.getMTH());
     }
     
     @Test
     public void testMachines() {
     
         TradeItem machines = new TradeItem("Machines");
         
         assertEquals(4, machines.getMTLP());
         assertEquals(3, machines.getMTLU());
         assertEquals(5, machines.getTTP());
         assertEquals(900, machines.getBP());
         assertEquals(-30, machines.getIPL());
         assertEquals(5, machines.getVar());
         assertEquals("LACKOFWORKERS", machines.getIE());
         assertEquals("Never", machines.getCR());
         assertEquals("Never", machines.getER());
         assertEquals(600, machines.getMTL());
         assertEquals(800, machines.getMTH());
     }
     
     @Test
     public void testNarcotics() {
     
         TradeItem narcotics = new TradeItem("Narcotics");
         
         assertEquals(5, narcotics.getMTLP());
         assertEquals(0, narcotics.getMTLU());
         assertEquals(5, narcotics.getTTP());
         assertEquals(3500, narcotics.getBP());
         assertEquals(-125, narcotics.getIPL());
         assertEquals(150, narcotics.getVar());
         assertEquals("BOREDOM", narcotics.getIE());
         assertEquals("WEIRDMUSHROOMS", narcotics.getCR());
         assertEquals("Never", narcotics.getER());
         assertEquals(2000, narcotics.getMTL());
         assertEquals(3000, narcotics.getMTH());
     }
     
     @Test
     public void testRobots() {
     
         TradeItem robots = new TradeItem("Robots");
         
         assertEquals(6, robots.getMTLP());
         assertEquals(4, robots.getMTLU());
         assertEquals(7, robots.getTTP());
         assertEquals(5000, robots.getBP());
         assertEquals(-150, robots.getIPL());
         assertEquals(100, robots.getVar());
         assertEquals("LACKOFWORKERS", robots.getIE());
         assertEquals("Never", robots.getCR());
         assertEquals("Never", robots.getER());
         assertEquals(3500, robots.getMTL());
         assertEquals(5000, robots.getMTH());
     }
}
