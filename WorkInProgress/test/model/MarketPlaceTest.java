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
    
    MarketPlace mkt;
    
    public MarketPlaceTest() {
    }
    
    @Before
    public void setUp() {
        mkt = new MarketPlace();
        mkt = new MarketPlace(10);
    }
    
     @Test
     public void testCalculatePrices() {
         
         //Print selling and buying prices for each item
//         for(int i=0; i<10; i++) {
//             System.out.print(mkt.getSellingPriceAt(i) + " ");
//             System.out.print(mkt.getBuyingPriceAt(i) + "\n");
//         }
         
         assertEquals(Math.round(mkt.getBuyingPriceAt(0)*.8), mkt.getSellingPriceAt(0));
         assertEquals(Math.round(mkt.getBuyingPriceAt(1)*.8), mkt.getSellingPriceAt(1));
         assertEquals(Math.round(mkt.getBuyingPriceAt(2)*.8), mkt.getSellingPriceAt(2));
         assertEquals(Math.round(mkt.getBuyingPriceAt(3)*.8), mkt.getSellingPriceAt(3));
         assertEquals(Math.round(mkt.getBuyingPriceAt(4)*.8), mkt.getSellingPriceAt(4));
         assertEquals(Math.round(mkt.getBuyingPriceAt(5)*.8), mkt.getSellingPriceAt(5));
         assertEquals(Math.round(mkt.getBuyingPriceAt(6)*.8), mkt.getSellingPriceAt(6));
         assertEquals(Math.round(mkt.getBuyingPriceAt(7)*.8), mkt.getSellingPriceAt(7));
         assertEquals(Math.round(mkt.getBuyingPriceAt(8)*.8), mkt.getSellingPriceAt(8));
         assertEquals(Math.round(mkt.getBuyingPriceAt(9)*.8), mkt.getSellingPriceAt(9));
     }

     @Test
     public void testCalculateAmount() {
  
         //Print amount range for each item (ex. "10 to 30")
//         for(int i=0; i<10; i++) System.out.print((int)Math.round((1.0 - ((double)i / 10)) * 10)
//                                    + " to " + (int)Math.round((1.0 - ((double)i/10)) * 30) + "\n");
         
//         for(int i=0; i<10; i++) System.out.println(mkt.getAmount()[i]);
         
         // Bounds determined by the formula:
         // (int)Math.round((1.0 - ((double)i / 10)) * (rand.nextInt(30 - 10 + 1) + 10 ))
         assertTrue(mkt.getAmount()[0] >= 10 && mkt.getAmount()[0] <= 30);
         assertTrue(mkt.getAmount()[1] >= 9 && mkt.getAmount()[1] <= 27);
         assertTrue(mkt.getAmount()[2] >= 8 && mkt.getAmount()[2] <= 24);
         assertTrue(mkt.getAmount()[3] >= 7 && mkt.getAmount()[3] <= 21);
         assertTrue(mkt.getAmount()[4] >= 6 && mkt.getAmount()[4] <= 18);
         assertTrue(mkt.getAmount()[5] >= 5 && mkt.getAmount()[5] <= 15);
         assertTrue(mkt.getAmount()[6] >= 4 && mkt.getAmount()[6] <= 12);
         assertTrue(mkt.getAmount()[7] >= 3 && mkt.getAmount()[7] <= 9);
         assertTrue(mkt.getAmount()[8] >= 2 && mkt.getAmount()[8] <= 6);
         assertTrue(mkt.getAmount()[9] >= 1 && mkt.getAmount()[9] <= 3);
     }
     
     @Test
     public void testBuyingItem() {
         assertEquals("Water", mkt.buyingItem("b0", null, 0, null));
         assertEquals("Furs", mkt.buyingItem("b1", null, 0, null));
         assertEquals("Food", mkt.buyingItem("b2", null, 0, null));
         assertEquals("Ore", mkt.buyingItem("b3", null, 0, null));
         assertEquals("Games", mkt.buyingItem("b4", null, 0, null));
         assertEquals("Firearms", mkt.buyingItem("b5", null, 0, null));
         assertEquals("Medicine", mkt.buyingItem("b6", null, 0, null));
         assertEquals("Machines", mkt.buyingItem("b7", null, 0, null));
         assertEquals("Narcotics", mkt.buyingItem("b8", null, 0, null));
         assertEquals("Robots", mkt.buyingItem("b9", null, 0, null));
     }
     
     @Test
     public void testSellingItem() {
         assertEquals("Water", mkt.sellingItem("s0", null, 0, null));
         assertEquals("Furs", mkt.sellingItem("s1", null, 0, null));
         assertEquals("Food", mkt.sellingItem("s2", null, 0, null));
         assertEquals("Ore", mkt.sellingItem("s3", null, 0, null));
         assertEquals("Games", mkt.sellingItem("s4", null, 0, null));
         assertEquals("Firearms", mkt.sellingItem("s5", null, 0, null));
         assertEquals("Medicine", mkt.sellingItem("s6", null, 0, null));
         assertEquals("Machines", mkt.sellingItem("s7", null, 0, null));
         assertEquals("Narcotics", mkt.sellingItem("s8", null, 0, null));
         assertEquals("Robots", mkt.sellingItem("s9", null, 0, null));
     }
     
     @Test
     public void testGetAmount() {
         assertEquals(10, mkt.getAmount().length);
     }
}
