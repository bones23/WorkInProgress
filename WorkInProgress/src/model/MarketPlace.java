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
    private final double LOW_PRICE_MULT = .8;
    private final double HIGH_PRICE_MULT = .85;
    private final double LOW_TECH_PRICE_MULT = .25;
    private final double MID_TECH_PRICE_MULT = .5;
    private final int LOW_TECH = 2;
    private final int MID_TECH = 4;
    private final int HIGH_TECH = 6;
    private final int ORE_INDEX = 3;
    private final int GAMES_INDEX = 4;
    private final int FIREARMS_INDEX = 5;
    private final int MEDICINE_INDEX = 6;
    private final int MACHINES_INDEX = 7;
    private final int NARCOTICS_INDEX = 8;
    private final int ROBOTS_INDEX = 9;
    private final int MAX_AMT = 30;
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
        items[ORE_INDEX] = new TradeItem("Ore");
        items[GAMES_INDEX] = new TradeItem("Games");
        items[FIREARMS_INDEX] = new TradeItem("Firearms");
        items[MEDICINE_INDEX] = new TradeItem("Medicine");
        items[MACHINES_INDEX] = new TradeItem("Machines");
        items[NARCOTICS_INDEX] = new TradeItem("Narcotics");
        items[ROBOTS_INDEX] = new TradeItem("Robots");
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
            sellPrice[i] = (int) ((double) totalPrice[i] * HIGH_PRICE_MULT);
            sellPrice[i] = (int) ((double) totalPrice[i] * LOW_PRICE_MULT);
            if (techLevel > LOW_TECH) {
                //int random = nextDouble(1.5 - 1.0 + 1.0) + 1.0;
                totalPrice[i] = (int) (totalPrice[i] * LOW_TECH_PRICE_MULT);
                sellPrice[i] = (int) (sellPrice[i] * LOW_TECH_PRICE_MULT);
            } else if (techLevel > MID_TECH) {
                totalPrice[i] = (int) (totalPrice[i] * MID_TECH_PRICE_MULT);
                sellPrice[i] = (int) (sellPrice[i] * MID_TECH_PRICE_MULT);
            } else if (techLevel > HIGH_TECH) {
                totalPrice[i] = (int) (totalPrice[i] * .75);
                sellPrice[i] = (int) (sellPrice[i] * .75);
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
                        .nextInt(MAX_AMT - NUM_TRADE_ITEMS + 1)
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
                itemNum = ORE_INDEX;
                itemName = "Ore";
                break;
            case "b4":
                itemNum = GAMES_INDEX;
                itemName = "Games";
                break;
            case "b5":
                itemNum = FIREARMS_INDEX;
                itemName = "Firearms";
                break;
            case "b6":
                itemNum = MEDICINE_INDEX;
                itemName = "Medicine";
                break;
            case "b7":
                itemNum = MACHINES_INDEX;
                itemName = "Machines";
                break;
            case "b8":
                itemNum = NARCOTICS_INDEX;
                itemName = "Narcotics";
                break;
            case "b9":
                itemNum = ROBOTS_INDEX;
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
                itemNum = ORE_INDEX;
                itemName = "Ore";
                break;
            case "s4":
                itemNum = GAMES_INDEX;
                itemName = "Games";
                break;
            case "s5":
                itemNum = FIREARMS_INDEX;
                itemName = "Firearms";
                break;
            case "s6":
                itemNum = MEDICINE_INDEX;
                itemName = "Medicine";
                break;
            case "s7":
                itemNum = MACHINES_INDEX;
                itemName = "Machines";
                break;
            case "s8":
                itemNum = NARCOTICS_INDEX;
                itemName = "Narcotics";
                break;
            case "s9":
                itemNum = ROBOTS_INDEX;
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
        int i = 0;
        if (index >= 0 && index < sellPrice.length) {
            i = sellPrice[index];
        }
        return i;
    }

    /**
     * Getter for the buying price of a good.
     * @param index index
     * @return price of a good
     */
    public final int getBuyingPriceAt(final int index) {
        int i = 0;
        if (index >= 0 && index < totalPrice.length) {
            i = totalPrice[index];
        }
        return i;
    }
}
