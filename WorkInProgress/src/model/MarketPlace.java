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
    }
    
    public void calculatePrices() {
        for (int i = 0; i < items.length; i++) {
            totalPrice[i] = items[i].getBP() + (items[i].getIPL() * (techLevel - items[i].getMTLP())) + (int)((double)items[i].getBP() * (items[i].getVar())); 
            sellPrice[i] = (int)((double)totalPrice[i] * .15);
        }   
    }
    
    public void calculateAmount() {
        for (int i = 0; i < items.length; i++) {
            if (techLevel > items[i].getMTLP()) {
                amount[i] = 0;
            } else {
                amount[i] = (int)((1.0 - ((double)i / 10)) * (rand.nextInt(30 - 10 + 1) + 10 ));
//                if (techLevel == amount[i].getTTP()) {
//                    
//                }
            }
        }
    }
    
    public void buyingItem(int item, int amountBuying) {
        amount[item] = amount[item] - amountBuying;
        //Player.setMoney(Player.getMoney() - (amountBuying * totalPrice[item]));
    }
    
    public void sellingItem(int item, int amountSelling) {
        amount[item] = amount[item] + amountSelling;
        //Player.setMoney(Player.getMoney() + (amountSelling * sellPrice[item]));
    }
}
