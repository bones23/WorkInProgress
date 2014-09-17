/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MT
 */
public class UniverseTest {
    
    Universe test;
    
    public UniverseTest() {
    }
    
    @Before
    public void setUp() {
        test = new Universe();
    }

    /**
     * Test of printUniverse method, of class Universe.
     */
    @Test
    public void testPrintUniverse() {
        
        // Counts # times "Name: " appears in toString()
        String toMatch = "Name: ";
        Pattern pattern = Pattern.compile(toMatch);
        Matcher matcher = pattern.matcher(test.toString());
        int count = 0;
        while(matcher.find()) {
            count++;
        }
        
        assertEquals(120, count);
        System.out.println(test.toString());
    }

     /**
     * Test of getUniverse method, of class Universe.
     */
    @Test
    public void testGetUniverse() {
        assertEquals(120, test.getUniverse().length);
    }
    
}
