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
            sellPrice[i] = (int)((double)totalPrice[i] * .80);
            if (techLevel > 2) {
                //int random = nextDouble(1.5 - 1.0 + 1.0) + 1.0;
                totalPrice[i] = (int)(totalPrice[i] * 1.5);
                sellPrice[i] = (int)(sellPrice[i] * 1.5);
            } else if (techLevel > 4) {
                totalPrice[i] = (int)(totalPrice[i] * 1.75);
                sellPrice[i] = (int)(sellPrice[i] * 1.75);
            } else if(techLevel > 6) {
                totalPrice[i] = (int)(totalPrice[i] * 2);
                sellPrice[i] = (int)(sellPrice[i] * 2);
            }
            if (techLevel < items[i].getMTLU()) {
                sellPrice[i] = 0;
            }
            if (techLevel < items[i].getMTLP()) {
                totalPrice[i] = 0;
            }
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
    public String buyingItem(String buttonPushed, Universe uni, int i, Ship s) {
        int itemNum = -1;
        String itemName = null;
        switch(buttonPushed){
            case "b0":
                itemNum=0;
                itemName="Water";
                break;
            case "b1":
                itemNum=1;
                itemName="Furs";
                break;
            case "b2":
                itemNum=2;
                itemName="Food";
                break;
            case "b3":
                itemNum=3;
                itemName="Ore";
                break;
            case "b4":
                itemNum=4;
                itemName="Games";
                break;
            case "b5":
                itemNum=5;
                itemName="Firearms";
                break;
            case "b6":
                itemNum=6;
                itemName="Medicine";
                break;
            case "b7":
                itemNum=7;
                itemName="Machines";
                break;
            case "b8":
                itemNum=8;
                itemName="Narcotics";
                break;
            case "b9":
                itemNum=9;
                itemName="Robots";
                break;
            }
        if(Person.getMoney() >= uni.getSolarSystemAt(i).getMarketPlace().getBuyingPriceAt(itemNum)
                && uni.getSolarSystemAt(i).getMarketPlace().getAmountAt(itemNum) > 0
                && s.addItem(new TradeItem(itemName)) == true
                && uni.getSolarSystemAt(i).getMarketPlace().getBuyingPriceAt(itemNum) > 0){
            amount[itemNum] = amount[itemNum] - 1;
            Person.setMoney(Person.getMoney() - totalPrice[itemNum]);
        }
        return itemName;
    }
    
    /**
     * Sells an item to the marketplace. The market place gains an item and the
     * player gains money.
     * @param item item being sold
     * @param amountSelling the amount of items being sold
     */
    public String sellingItem(String buttonPushed, Universe uni, int i, Ship s) {
        int itemNum = -1;
        String itemName = null;
        switch(buttonPushed){
            case "s0":
                itemNum=0;
                itemName="Water";
                break;
            case "s1":
                itemNum=1;
                itemName="Furs";
                break;
            case "s2":
                itemNum=2;
                itemName="Food";
                break;
            case "s3":
                itemNum=3;
                itemName="Ore";
                break;
            case "s4":
                itemNum=4;
                itemName="Games";
                break;
            case "s5":
                itemNum=5;
                itemName="Firearms";
                break;
            case "s6":
                itemNum=6;
                itemName="Medicine";
                break;
            case "s7":
                itemNum=7;
                itemName="Machines";
                break;
            case "s8":
                itemNum=8;
                itemName="Narcotics";
                break;
            case "s9":
                itemNum=9;
                itemName="Robots";
                break;
        }
        System.out.println(itemNum);
        if(uni.getSolarSystemAt(i).getMarketPlace().getSellingPriceAt(itemNum)> 0
                && s.removeItem(new TradeItem(itemName)) == true){
            amount[itemNum] = amount[itemNum] + 1;
            Person.setMoney(Person.getMoney() + sellPrice[itemNum]);
        }
        return itemName;
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
     * @return selling price for an item
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
