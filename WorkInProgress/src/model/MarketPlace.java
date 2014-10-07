package model;
import java.util.Random;
/**
 * Market place class.
 * @author Brandon Jackson
 */
public class MarketPlace {
    private int techLevel;
    private TradeItem[] items;
    private int[] totalPrice;
    private int[] amount;
    private int[] sellPrice;
    private Random rand;
    
    public MarketPlace() {
        this(0);
    }
    public MarketPlace(int techLevel) {
        rand = new Random();
        this.techLevel = techLevel;
        items = new TradeItem[10];
        items[0] = new TradeItem("Water");
        items[1] = new TradeItem("Furs");
        items[2] = new TradeItem("Food");
        items[3] = new TradeItem("Ore");
        items[4] = new TradeItem("Games");
        items[5] = new TradeItem("Firearms");
        items[6] = new TradeItem("Medicine");
        items[7] = new TradeItem("Machines");
        items[8] = new TradeItem("Narcotics");
        items[9] = new TradeItem("Robots");
        amount = new int[10];
        totalPrice = new int[10];
        sellPrice = new int[10];
        calculateAmount();
        calculatePrices();
    }
    
    /**
     * Calculates the price of a good being sold to the marketplace and bought 
     * from the market place.
     */
    public void calculatePrices() {
        for (int i = 0; i < items.length; i++) {
            totalPrice[i] = items[i].getBP() + (items[i].getIPL() * (techLevel - items[i].getMTLP())) + (int)((double)items[i].getBP() * (items[i].getVar())); 
            sellPrice[i] = (int)((double)totalPrice[i] * .85);
        }   
    }
    /**
     * Calculates the amount of items there are on each SolarSystem. Considers
     * the minimum tech level to produce.
     */
    public void calculateAmount() {
        for (int i = 0; i < items.length; i++) {
            if (techLevel < items[i].getMTLP()) {
                amount[i] = 0;
            } else {
                amount[i] = (int)Math.round((1.0 - ((double)i / 10)) * (rand.nextInt(30 - 10 + 1) + 10 ));
                if (techLevel == items[i].getTTP()) {
                    amount[i] = amount[i] * 2;  
                }
            }
        }
    }
    
    /**
     * Buys an item from marketplace
     * Subtracts the amount of items from market place and the amount being paid
     * from the players money.
     * @param item the item that is being bought
     * @param amountBuying the amount being bought
     */
    public void buyingItem(int item, int amountBuying) {
        amount[item] = amount[item] - amountBuying;
        Person.setMoney(Person.getMoney() - (amountBuying * totalPrice[item]));
    }
    
    /**
     * Sells an item to the marketplace. The market place gains an item and the
     * player gains money.
     * @param item item being sold
     * @param amountSelling the amount of items being sold
     */
    public void sellingItem(int item, int amountSelling) {
        amount[item] = amount[item] + amountSelling;
        Person.setMoney(Person.getMoney() + (amountSelling * sellPrice[item]));
    }
    
    /**
     * getter for the amount
     * @return amount
     */
    public int[] getAmount() {
        return amount;
    }
    
    /**
     * getter for the amount at a certain index
     * @param index
     * @return amount of a good
     */
    public int getAmountAt(int index) {
        return amount[index];
    }
    
    /**
     * Getter for the selling price
     * @param index
     * @return sellprice for an item
     */
    public int getSellingPriceAt(int index) {
        return sellPrice[index];
    }
    
    /**
     * getter for the buying price of a good
     * @param index
     * @return price of a good 
     */
    public int getBuyingPriceAt(int index) {
        return totalPrice[index];
    }
}
