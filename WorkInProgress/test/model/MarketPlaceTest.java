package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Matthew Taylor
 * @version 6 October 2014
 */
public class MarketPlaceTest {
    
    MarketPlace mkt;
    
    public MarketPlaceTest() {
    }
    
    @Before
    public void setUp() {
        mkt = new MarketPlace(10);
    }
    
     @Test
     public void testCalculatePrices() {
         for(int i=0; i<10; i++) {
             System.out.print(mkt.getSellingPriceAt(i) + " ");
             System.out.print(mkt.getBuyingPriceAt(i) + "\n");
         }
         
         assertEquals((int)(mkt.getBuyingPriceAt(0)*.85), mkt.getSellingPriceAt(0));
         assertEquals((int)(mkt.getBuyingPriceAt(1)*.85), mkt.getSellingPriceAt(1));
         assertEquals((int)(mkt.getBuyingPriceAt(2)*.85), mkt.getSellingPriceAt(2));
         assertEquals((int)(mkt.getBuyingPriceAt(3)*.85), mkt.getSellingPriceAt(3));
         assertEquals((int)(mkt.getBuyingPriceAt(4)*.85), mkt.getSellingPriceAt(4));
         assertEquals((int)(mkt.getBuyingPriceAt(5)*.85), mkt.getSellingPriceAt(5));
         assertEquals((int)(mkt.getBuyingPriceAt(6)*.85), mkt.getSellingPriceAt(6));
         assertEquals((int)(mkt.getBuyingPriceAt(7)*.85), mkt.getSellingPriceAt(7));
         assertEquals((int)(mkt.getBuyingPriceAt(8)*.85), mkt.getSellingPriceAt(8));
         assertEquals((int)(mkt.getBuyingPriceAt(9)*.85), mkt.getSellingPriceAt(9));
     }
     
     @Test
     public void testCalculateAmount() {
  
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
         int waterAmt = mkt.getAmount()[0] - 5;
         mkt.buyingItem(0, 5);
         
         assertEquals(waterAmt, mkt.getAmount()[0]);
     }
     
     @Test
     public void testSellingItem() {
         int waterAmt = mkt.getAmount()[0] + 5;
         mkt.sellingItem(0, 5);
         
         assertEquals(waterAmt, mkt.getAmount()[0]);
     }
     
     @Test
     public void testGetAmount() {
         assertEquals(10, mkt.getAmount().length);
     }
}
