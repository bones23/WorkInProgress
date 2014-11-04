package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Matthew Taylor
<<<<<<< HEAD
 * @version 2 October 2014
=======
 * @version 6 October 2014
>>>>>>> origin/gui7
 */
public class MarketPlaceTest {
    
    MarketPlace mktT6;
    MarketPlace mktT10;
    
    public MarketPlaceTest() {
    }
    
    @Before
    public void setUp() {
        mktT6 = new MarketPlace(6);
        mktT10 = new MarketPlace(10);
    }
    
     @Test
     public void testCalculatePrices() {
         
         //Print selling and buying prices for each item
//         for(int i=0; i<10; i++) {
//             System.out.print(mktT10.getSellingPriceAt(i) + " ");
//             System.out.print(mktT10.getBuyingPriceAt(i) + "\n");
//         }
         
         assertEquals(Math.round(mktT10.getBuyingPriceAt(0)*.8), mktT10.getSellingPriceAt(0));
         assertEquals(Math.round(mktT10.getBuyingPriceAt(1)*.8), mktT10.getSellingPriceAt(1));
         assertEquals(Math.round(mktT10.getBuyingPriceAt(2)*.8), mktT10.getSellingPriceAt(2));
         assertEquals(Math.round(mktT10.getBuyingPriceAt(3)*.8), mktT10.getSellingPriceAt(3));
         assertEquals(Math.round(mktT10.getBuyingPriceAt(4)*.8), mktT10.getSellingPriceAt(4));
         assertEquals(Math.round(mktT10.getBuyingPriceAt(5)*.8), mktT10.getSellingPriceAt(5));
         assertEquals(Math.round(mktT10.getBuyingPriceAt(6)*.8), mktT10.getSellingPriceAt(6));
         assertEquals(Math.round(mktT10.getBuyingPriceAt(7)*.8), mktT10.getSellingPriceAt(7));
         assertEquals(Math.round(mktT10.getBuyingPriceAt(8)*.8), mktT10.getSellingPriceAt(8));
         assertEquals(Math.round(mktT10.getBuyingPriceAt(9)*.8), mktT10.getSellingPriceAt(9));
     }

     @Test
     public void testCalculateAmount() {
  
         //Print amount range for each item (ex. "10 to 30")
//         for(int i=0; i<10; i++) System.out.print((int)Math.round((1.0 - ((double)i / 10)) * 10)
//                                    + " to " + (int)Math.round((1.0 - ((double)i/10)) * 30) + "\n");
         
         for(int i=0; i<10; i++) System.out.println(mktT6.getAmount()[i]);
         
         // Bounds determined by the formula:
         // (int)Math.round((1.0 - ((double)i / 10)) * (rand.nextInt(30 - 10 + 1) + 10 ))
         assertTrue(mktT10.getAmount()[0] >= 10 && mktT10.getAmount()[0] <= 30);
         assertTrue(mktT10.getAmount()[1] >= 9 && mktT10.getAmount()[1] <= 27);
         assertTrue(mktT10.getAmount()[2] >= 8 && mktT10.getAmount()[2] <= 24);
         assertTrue(mktT10.getAmount()[3] >= 7 && mktT10.getAmount()[3] <= 21);
         assertTrue(mktT10.getAmount()[4] >= 6 && mktT10.getAmount()[4] <= 18);
         assertTrue(mktT10.getAmount()[5] >= 5 && mktT10.getAmount()[5] <= 15);
         assertTrue(mktT10.getAmount()[6] >= 4 && mktT10.getAmount()[6] <= 12);
         assertTrue(mktT10.getAmount()[7] >= 3 && mktT10.getAmount()[7] <= 9);
         assertTrue(mktT10.getAmount()[8] >= 2 && mktT10.getAmount()[8] <= 6);
         assertTrue(mktT10.getAmount()[9] >= 1 && mktT10.getAmount()[9] <= 3);
         
         assertTrue(mktT6.getAmount()[0] >= 10 && mktT6.getAmount()[0] <= 30);
         assertTrue(mktT6.getAmount()[1] >= 9 && mktT6.getAmount()[1] <= 27);
         assertTrue(mktT6.getAmount()[2] >= 8 && mktT6.getAmount()[2] <= 24);
         assertTrue(mktT6.getAmount()[3] >= 7 && mktT6.getAmount()[3] <= 21);
         assertTrue(mktT6.getAmount()[4] >= 12 && mktT6.getAmount()[4] <= 36);
         assertTrue(mktT6.getAmount()[5] >= 5 && mktT6.getAmount()[5] <= 15);
         assertTrue(mktT6.getAmount()[6] >= 8 && mktT6.getAmount()[6] <= 24);
         assertTrue(mktT6.getAmount()[7] >= 3 && mktT6.getAmount()[7] <= 9);
         assertTrue(mktT6.getAmount()[8] >= 2 && mktT6.getAmount()[8] <= 6);
         assertTrue(mktT6.getAmount()[9] >= 1 && mktT6.getAmount()[9] <= 3);
     }
     
     @Test
     public void testBuyingItem() {
         assertEquals("Water", mktT10.buyingItem("b0", null, 0, null));
         assertEquals("Furs", mktT10.buyingItem("b1", null, 0, null));
         assertEquals("Food", mktT10.buyingItem("b2", null, 0, null));
         assertEquals("Ore", mktT10.buyingItem("b3", null, 0, null));
         assertEquals("Games", mktT10.buyingItem("b4", null, 0, null));
         assertEquals("Firearms", mktT10.buyingItem("b5", null, 0, null));
         assertEquals("Medicine", mktT10.buyingItem("b6", null, 0, null));
         assertEquals("Machines", mktT10.buyingItem("b7", null, 0, null));
         assertEquals("Narcotics", mktT10.buyingItem("b8", null, 0, null));
         assertEquals("Robots", mktT10.buyingItem("b9", null, 0, null));
     }
     
     @Test
     public void testSellingItem() {
         assertEquals("Water", mktT10.sellingItem("s0", null, 0, null));
         assertEquals("Furs", mktT10.sellingItem("s1", null, 0, null));
         assertEquals("Food", mktT10.sellingItem("s2", null, 0, null));
         assertEquals("Ore", mktT10.sellingItem("s3", null, 0, null));
         assertEquals("Games", mktT10.sellingItem("s4", null, 0, null));
         assertEquals("Firearms", mktT10.sellingItem("s5", null, 0, null));
         assertEquals("Medicine", mktT10.sellingItem("s6", null, 0, null));
         assertEquals("Machines", mktT10.sellingItem("s7", null, 0, null));
         assertEquals("Narcotics", mktT10.sellingItem("s8", null, 0, null));
         assertEquals("Robots", mktT10.sellingItem("s9", null, 0, null));
     }
     
     @Test
     public void testGetAmount() {
         assertEquals(10, mktT10.getAmount().length);
     }
}
