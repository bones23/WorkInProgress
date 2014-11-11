package model;
import controller.WelcomeScreenController;
import java.io.Serializable;
import java.util.Random;
/**
 * Market place class.
 * @author Brandon Jackson
 */
public class MarketPlace implements Serializable {
    //CHECKSTYLE: OFF
    private int techLevel;
    private TradeItem[] items;
    private int[] totalPrice;
    private int[] amount;
    private int[] sellPrice;
    private Random rand;

    private final int NUM_TRADE_ITEMS = 10;
    private final double PT8 = .8;
    private final double PT85 = .85;
    private final double ONEPT5 = 1.5;
    private final double ONEPT75 = 1.75;
    private final int LOW_TECH = 2;
    private final int MID_TECH = 4;
    private final int HIGH_TECH = 6;
    private final int THREE = 3;
    private final int FOUR = 4;
    private final int FIVE = 5;
    private final int SIX = 6;
    private final int SEVEN = 7;
    private final int EIGHT = 8;
    private final int NINE = 9;
    private final int THIRTY = 30;
    //CHECKSTYLE: ON

    /**
     * Create a MarketPlace with a tech level of 0.
     */
    public MarketPlace() {
        this(0);
    }

    /**
     * Create a MarketPlace.
     * @param myTechLevel tech level
     */
    public MarketPlace(final int myTechLevel) {
        rand = new Random();
        this.techLevel = myTechLevel;
        items = new TradeItem[NUM_TRADE_ITEMS];
        items[0] = new TradeItem("Water");
        items[1] = new TradeItem("Furs");
        items[2] = new TradeItem("Food");
        items[THREE] = new TradeItem("Ore");
        items[FOUR] = new TradeItem("Games");
        items[FIVE] = new TradeItem("Firearms");
        items[SIX] = new TradeItem("Medicine");
        items[SEVEN] = new TradeItem("Machines");
        items[EIGHT] = new TradeItem("Narcotics");
        items[NINE] = new TradeItem("Robots");
        amount = new int[NUM_TRADE_ITEMS];
        totalPrice = new int[NUM_TRADE_ITEMS];
        sellPrice = new int[NUM_TRADE_ITEMS];
        calcAmtAndPrices();
    }

    /**
     * Private helper method for the constructor.
     */
    private void calcAmtAndPrices() {
        calculateAmount();
        calculatePrices();
    }

    /**
     * Calculates the price of a good being sold to the marketplace and bought
     * from the MarketPlace.
     */
    public final void calculatePrices() {
        for (int i = 0; i < items.length; i++) {
            totalPrice[i] = items[i].getBP() + (items[i].getIPL()
                    * (techLevel - items[i].getMTLP()))
                    + (int) ((double) items[i].getBP() * (items[i].getVar()));
            sellPrice[i] = (int) ((double) totalPrice[i] * PT85);
            sellPrice[i] = (int) ((double) totalPrice[i] * PT8);
            if (techLevel > LOW_TECH) {
                //int random = nextDouble(1.5 - 1.0 + 1.0) + 1.0;
                totalPrice[i] = (int) (totalPrice[i] * ONEPT5);
                sellPrice[i] = (int) (sellPrice[i] * ONEPT5);
            } else if (techLevel > MID_TECH) {
                totalPrice[i] = (int) (totalPrice[i] * ONEPT75);
                sellPrice[i] = (int) (sellPrice[i] * ONEPT75);
            } else if (techLevel > HIGH_TECH) {
                totalPrice[i] = (int) (totalPrice[i] * 2);
                sellPrice[i] = (int) (sellPrice[i] * 2);
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
    public final void calculateAmount() {
        for (int i = 0; i < items.length; i++) {
            if (techLevel < items[i].getMTLP()) {
                amount[i] = 0;
            } else {
                amount[i] = (int) Math.round((1.0
                        - ((double) i / NUM_TRADE_ITEMS)) * (rand
                        .nextInt(THIRTY - NUM_TRADE_ITEMS + 1)
                                + NUM_TRADE_ITEMS));
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
     * @param buttonPushed the button that was clicked
     * @param uni the Universe the the game is running on
     * @param i SolarSystem index in the Universe
     * @param s the ship to store the bought items on
     * @return the name of the item purchased
     */
    public final String buyingItem(final String buttonPushed,
            final Universe uni, final int i, final Ship s) {
        int itemNum = -1;
        String itemName = null;
        switch(buttonPushed) {
            case "b0":
                itemNum = 0;
                itemName = "Water";
                break;
            case "b1":
                itemNum = 1;
                itemName = "Furs";
                break;
            case "b2":
                itemNum = 2;
                itemName = "Food";
                break;
            case "b3":
                itemNum = THREE;
                itemName = "Ore";
                break;
            case "b4":
                itemNum = FOUR;
                itemName = "Games";
                break;
            case "b5":
                itemNum = FIVE;
                itemName = "Firearms";
                break;
            case "b6":
                itemNum = SIX;
                itemName = "Medicine";
                break;
            case "b7":
                itemNum = SEVEN;
                itemName = "Machines";
                break;
            case "b8":
                itemNum = EIGHT;
                itemName = "Narcotics";
                break;
            case "b9":
                itemNum = NINE;
                itemName = "Robots";
                break;
            default:
            }
        if (uni != null && s != null && WelcomeScreenController.game.getPlayer()
                .getMoney()
                >= uni.getSolarSystemAt(i).getMarketPlace()
                            .getBuyingPriceAt(itemNum)
                && uni.getSolarSystemAt(i).getMarketPlace()
                        .getAmountAt(itemNum) > 0
                && s.addItem(new TradeItem(itemName))
                && uni.getSolarSystemAt(i).getMarketPlace()
                        .getBuyingPriceAt(itemNum) > 0) {
            amount[itemNum] = amount[itemNum] - 1;
            WelcomeScreenController.game.getPlayer()
                    .setMoney(WelcomeScreenController.game.getPlayer()
                            .getMoney() - totalPrice[itemNum]);
        }
        return itemName;
    }

    /**
     * Sells an item to the marketplace. The market place gains an item and the
     * player gains money.
     * @param buttonPushed the button that was clicked
     * @param uni the Universe the the game is running on
     * @param i SolarSystem index in the Universe
     * @param s the ship to store the bought items on
     * @return the name of the item sold
     */
    public final String sellingItem(final String buttonPushed,
            final Universe uni, final int i, final Ship s) {
        int itemNum = -1;
        String itemName = null;
        switch(buttonPushed) {
            case "s0":
                itemNum = 0;
                itemName = "Water";
                break;
            case "s1":
                itemNum = 1;
                itemName = "Furs";
                break;
            case "s2":
                itemNum = 2;
                itemName = "Food";
                break;
            case "s3":
                itemNum = THREE;
                itemName = "Ore";
                break;
            case "s4":
                itemNum = FOUR;
                itemName = "Games";
                break;
            case "s5":
                itemNum = FIVE;
                itemName = "Firearms";
                break;
            case "s6":
                itemNum = SIX;
                itemName = "Medicine";
                break;
            case "s7":
                itemNum = SEVEN;
                itemName = "Machines";
                break;
            case "s8":
                itemNum = EIGHT;
                itemName = "Narcotics";
                break;
            case "s9":
                itemNum = NINE;
                itemName = "Robots";
                break;
            default:

        }
        if (uni != null && s != null && uni.getSolarSystemAt(i).getMarketPlace()
                .getSellingPriceAt(itemNum) > 0
                && s.removeItem(new TradeItem(itemName))) {
            amount[itemNum] = amount[itemNum] + 1;
            WelcomeScreenController.game.getPlayer()
                    .setMoney(WelcomeScreenController.game.getPlayer()
                            .getMoney() + sellPrice[itemNum]);
        }
        return itemName;
    }

    /**
     * getter for the amount.
     * @return amount
     */
    public final int[] getAmount() {
        return amount;
    }

    /**
     * getter for the amount at a certain index.
     * @param index index
     * @return amount of a good
     */
    public final int getAmountAt(final int index) {
        return amount[index];
    }

    /**
     * Getter for the selling price.
     * @param index index
     * @return selling price for an item
     */
    public final int getSellingPriceAt(final int index) {
        return sellPrice[index];
    }

    /**
     * Getter for the buying price of a good.
     * @param index index
     * @return price of a good
     */
    public final int getBuyingPriceAt(final int index) {
        return totalPrice[index];
    }
}
