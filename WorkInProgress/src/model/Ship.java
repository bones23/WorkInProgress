package model;
import org.controlsfx.dialog.Dialogs;
import java.util.Random;
import javafx.stage.Stage;
import controller.WelcomeScreenController;
import java.io.Serializable;
/**
 * @author Matthew Taylor
 * @version 22 September 2014
 */
public class Ship implements Serializable  {

    //CHECKSTYLE: OFF
    private int fuel;
    private int x;
    private int y;
    private String shipClass;
    private String pilot;
    public int occupiedSlots;
    private TradeItem[] cargoManifest;
    private int bays;
    private int fuelTank;
    private int health = 100;
    private int attackDamage = 18;
    private Random rand = new Random();
    private int shields = 3, maxShields = 3;
    private final int DEFAULT_FUEL = 14;
    private final int DEFAULT_BAYS = 10;
    private String special = "";
    private final int FUEL_PRICE = 5;
    private final int EVENT_PERCENT = 5;
    private final int MAX_PERCENT = 100;
    private final int FUEL_MULT = 10;
    private final int ESKILL_MULT = 5;
    private final int MAX_ROB_ATTEMPTS = 6;
    //CHECKSTYLE: OFF

    /**
     * Create a Ship.
     * @param myShipClass class of the Ship
     * @param myPilot the pilot name
     * @param myFuel fuel tank size
     * @param baysSize number of bays
     */
    public Ship(final String myShipClass, final String myPilot,
            final int myFuel, final int baysSize) {
        this.shipClass = myShipClass;
        this.pilot = myPilot;
        this.fuel = myFuel;
        this.cargoManifest = new TradeItem[baysSize];
        this.occupiedSlots = 0;
        this.bays = baysSize;
        this.fuelTank = DEFAULT_FUEL;
    }

    /**
     * Create a defaulted Ship with a pilot name.
     * @param myPilot the pilot name
     */
    public Ship(final String myPilot) {
        this.shipClass = "Flea";
        this.pilot = myPilot;
        this.fuel = DEFAULT_FUEL;
        this.cargoManifest = new TradeItem[DEFAULT_BAYS];
        this.occupiedSlots = 0;
        this.bays = DEFAULT_BAYS;
        this.fuelTank = DEFAULT_FUEL;
    }

   /**
    * Default ship is a flea model with Captain Kirk.
    */
    public Ship() {
        this.shipClass = "Flea";
        this.pilot = "Kirk";
        this.fuel = DEFAULT_FUEL;
        this.cargoManifest = new TradeItem[DEFAULT_BAYS];
        this.occupiedSlots = 0;
        this.bays = DEFAULT_BAYS;
        this.fuelTank = DEFAULT_FUEL;
    }

    /**
     * "Upgrade" Ship.
     * @param name name
     * @param cargo cargo
     * @param myFuel fuel
     */
    public Ship(final String name, final int cargo, final int myFuel) {
        this.shipClass = "Upgrade";
        this.pilot = "Kirk";
        this.fuel = DEFAULT_FUEL;
        this.cargoManifest = new TradeItem[DEFAULT_FUEL];
        this.occupiedSlots = 0;
        this.bays = DEFAULT_FUEL;
        this.fuelTank = DEFAULT_FUEL;
        //NOTE: DEFAULT_FUEL is being used for cargo size
    }

    /**
     * @return the amount of fuel that the ship currently has
     */
    public final int getFuel() {
        return this.fuel;
    }

    /**
     * @param myFuel the new amount of fuel
     */
    public final void setFuel(final int myFuel) {
        this.fuel = myFuel;
    }

    /**
     * Purchase fuel.
     */
    public final void buyFuel() {
        int toBuy = fuelTank - fuel;
        System.out.println(WelcomeScreenController.game);
        System.out.println(WelcomeScreenController.game.player);
        System.out.println(WelcomeScreenController.game.getPlayer());
        System.out.println(WelcomeScreenController.game.getPlayer().getMoney());

        if ((WelcomeScreenController.game.getPlayer()
                .getMoney() - toBuy * FUEL_PRICE) > 0) {
            setFuel(fuelTank);
            WelcomeScreenController.game.getPlayer()
                    .setMoney(WelcomeScreenController
                            .game.getPlayer().getMoney() - toBuy * FUEL_PRICE);
        }
    }

    /**
     * @return the x coordinate of the ship's current position
     */
    public final int getX() {
        return this.x;
    }

    /**
     * Sets the new x coordinate of the ship.
     * @param newX new X
     */
    public final void setX(final int newX) {
        this.x = newX;
    }

    /**
     * @return the y coordinate of the ship's current position
     */
    public final int getY() {
        return this.y;
    }

    /**
     * Sets the new y coordinate of the ship.
     * @param newY new Y
     */
    public final void setY(final int newY) {
        this.y = newY;
    }

    /**
     * @return true iff bays are available else false
     */
    public final boolean freeSpace() {
        return (bays - occupiedSlots) > 0;
    }

    /**
     * @return the # of bays available
     */
    public final int getSpaceLeft() {
        return bays - occupiedSlots;
    }

    /**
     * Adds a TradeItem to the cargoManifest of the ship if it is not full.
     * @param item The TradeItem to add to cargo
     * @return false if cargo is full else true
     */
    public final boolean addItem(final TradeItem item) {

        if (getOccupiedSlots() == getCargoManifest().length) {
            return false;
        }
        for (int i = 0; i < getCargoManifest().length; i++) {
            if (this.getCargoManifest()[i] == null) {
                this.cargoManifest[i] = item;
                this.occupiedSlots++;

                return true;
            }
        }
        return false;
    }

    /**
     * Removes the first occurring type of the item specified in cargoManifest.
     * @param item The item to remove
     * @return true if successfully removed else false
     */
    public final boolean removeItem(final TradeItem item) {

        for (int i = 0; i < getCargoManifest().length; i++) {
            if (this.getCargoManifest()[i] != null
               && this.getCargoManifest()[i].getName().equals(item.getName())) {
                this.cargoManifest[i] = null;
                this.occupiedSlots--;
                return true;
            }
        }
        return false;
    }

    /**
     * @return bays: the number of bays that the ship has
     */
    public final int getBays() {
        return this.bays;
    }

    /**
     * @return the class of ship that you are flying
     */
    public final String getShipClass() {
        return this.shipClass;
    }

    /**
     * @return the pilot of the ship
     */
    public final String getPilot() {
        return this.pilot;
    }
    /**
     * @param nPilot sets the new pilot of the ship
     */
    public final void setPilot(final String nPilot) {
        this.pilot = nPilot;
    }

    /**
     * @return the occupiedSlots
     */
    public final int getOccupiedSlots() {
        return this.occupiedSlots;
    }

    /**
     * @param temp new # of occupied slots
     */
    public final void setOccupiedSlots(final int temp) {
        this.occupiedSlots = temp;
    }

    /**
     * @param j the array of cargo
     */
    public final void setCargoManifest(final TradeItem[] j) {
        this.cargoManifest = j;
    }

    /**
     * @return the cargo
     */
    public final TradeItem[] getCargoManifest() {
        return this.cargoManifest;
    }

    /**
     * @param item the TradeItem to search for
     * @return the number of a specific type of cargo in ship
     */
    public final int searchCargo(final TradeItem item) {
        int output = 0;
        for (TradeItem ti: cargoManifest) {
            if (ti != null && ti.getName().equalsIgnoreCase(item.getName())) {
                output++;
            }
        }
        return output;
    }

    /**
     * Navigate the ship from its current position to the input (x, y).
     * @param newX x-coordinate
     * @param newY y-coordinate
     * @param uni Universe
     * @param i i
     * @param j j
     * @param s s
     * @return j
     */
    public final int travel(final int newX, final int newY, final Universe uni,
            final int i, final int j, final Stage s) {

        int distance = (int) Math.sqrt(Math
                .pow((double) Math.abs(getX() - newX), 2)
                + (double) Math.pow(Math.abs(getY() - newY), 2));

        if (i != j && distance <= getFuel()) {
//            i = j;
            System.out.println(distance);
            setFuel(getFuel() - distance);
            RandomEvent randomEvent = new RandomEvent(s, j);
        }

        this.x = newX;
        this.y = newY;
        return j;
    }

    /**
     * @param myBays new # bays
     */
    public final void setBays(final int myBays) {
        this.bays = myBays;
    }

    /**
     * @param nFuelTank new fuel size
     */
    public final void setFuelTank(final int nFuelTank) {
        this.fuelTank = nFuelTank;
    }

    /**
     * @return fuel tank
     */
    public final int getFuelTank() {
        return this.fuelTank;
    }
    
    /**
     * 
     * @return health - health of the ship
     */
    public final int getHealth() {
        return health;
    }
    
    /**
     * 
     * @param health - health of the ship
     */
    public final void setHealth(int health) {
        this.health = health;
    }
    
    public final int takeDamage(int damage) {
        health = health - damage;
        if (health <= 0) {
            health = 0;
        }
        return health;
    }
    
    public final int getAttackDamage() {
        return attackDamage;
    }
    public final int getShields() {
        return shields;
    }
    public final int getMaxShields() {
        return maxShields;
    }
    public final void setMaxShields(int maxShields) {
        this.maxShields = maxShields;
    }
    public final void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
    public final void setShields(int shields) {
        this.shields = shields;
    }
    
    public final int doDamage() {
        return rand.nextInt(attackDamage + 2 - (attackDamage - 2))
                + (attackDamage - 2);
    }
    
    public final int deductShield() {
        shields -= 1;
        return shields;
    }

    public final int addDamage() {
        attackDamage += 1;
        return attackDamage;
    }
    
    public final int repairCost() {
        return (100 - health) * 5;
    }
    
    public final int refillShieldCost() {
        return (maxShields - shields) * 500;
    }
    
    public final void refillShield() {
        shields = maxShields;
    }
    
    public final String getSpecial() {
        return special;
    }
    public final void setSpecial(String special) {
        this.special = special;
    }
}
