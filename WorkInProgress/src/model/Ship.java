package model;

import org.controlsfx.dialog.Dialogs;
import java.util.Random;
import javafx.stage.Stage;
import controller.*;
/**
 * @author Matthew Taylor
 * @version 22 September 2014
 */
public class Ship {
    
    private int fuel;
    private int x;
    private int y;
    private String shipClass;
    private String pilot;
    public int occupiedSlots;
    private TradeItem[] cargoManifest;
    private int bays;
    private int fuelTank;
    
    /*
    creates a completely customized ship
    */
    public Ship(String shipClass, String pilot, int fuel, int baysSize) {
        this.shipClass = shipClass;
        this.pilot = pilot;
        this.fuel = fuel;
        this.cargoManifest = new TradeItem[baysSize];
        this.occupiedSlots = 0;
        this.bays = baysSize;
        this.fuelTank = fuel;
    }
    /*
    creates a ship with a custom pilot
    */
    public Ship(String pilot){
        this("Flea", pilot, 14, 10);
    }
    /*
    default ship is a flea model with Captain Kirk
    */
    public Ship(){
        this("Flea", "Kirk", 14, 10);
    }
    /**
     * @return the amount of fuel that the ship currently has
     */
    public int getFuel(){
        return this.fuel;
    }
    /**
     * @param fuel the new amount of fuel
     */
    public void setFuel(int fuel){
        this.fuel = fuel;
    }
    public void buyFuel(){
        int toBuy = fuelTank-fuel;
        System.out.println(WelcomeScreenController.game);
        System.out.println(WelcomeScreenController.game.player);
        System.out.println(WelcomeScreenController.game.getPlayer());
        System.out.println(WelcomeScreenController.game.getPlayer().getMoney());
        
        if((WelcomeScreenController.game.getPlayer().getMoney() - toBuy * 5) > 0){
            setFuel(fuelTank);
            WelcomeScreenController.game.getPlayer().setMoney(WelcomeScreenController.game.getPlayer().getMoney() - toBuy * 5);  
        }
    }
    /**
     * @return the x coordinate of the ship's current position
     */
    public int getX() {
        return this.x;
    }
    /**
     * sets the new x coordinate of the ship
     */
    public void setX(int newX){
        this.x = newX;
    }
    /**
     * @return the y coordinate of the ship's current position
     */
    public int getY() {
        return this.y;
    }
    /**
     * sets the new y coordinate of the ship
     */
    public void setY(int newY){
        this.y= newY;
    }
    
    public boolean freeSpace(){
        return (bays - occupiedSlots) > 0;
    }
    public int getSpaceLeft(){
        return bays-occupiedSlots;
    }
    /**
     * Adds a TradeItem to the cargoManifest of the ship if it is not full
     * 
     * @param item The TradeItem to add to cargo
     * @return false if cargo is full else true
     */
    public boolean addItem(TradeItem item) {
        
        if(getOccupiedSlots() == getCargoManifest().length) {
            return false;
        }
        for(int i = 0; i < getCargoManifest().length; i++) {
            if(this.getCargoManifest()[i] == null) {
                this.cargoManifest[i] = item;
                this.occupiedSlots++;
                
                return true;
            }
        }
        return false;
    }

    /**
     * Removes the first occurring type of the item specified in cargoManifest.
     * 
     * @param item The item to remove
     * @return true if successfully removed else false
     */
    public boolean removeItem(TradeItem item) {
        
        for(int i = 0; i < getCargoManifest().length; i++) {
            if(this.getCargoManifest()[i] != null
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
    public int getBays(){
        return this.bays;
    }
    
    /**
     * @return the class of ship that you are flying
     */
    public String getShipClass() {
        return this.shipClass;
    }

    /**
     * @return the pilot of the ship 
     */
    public String getPilot() {
        return this.pilot;
    }
    /**
     * 
     * @param nPilot sets the new pilot of the ship 
     */
    public void setPilot(String nPilot){
        this.pilot = nPilot;
    }
    /**
     * @return the occupiedSlots
     */
    public int getOccupiedSlots() {
        return this.occupiedSlots;
    }

    /**
     * @return the cargo
     */
    public TradeItem[] getCargoManifest() {
        return this.cargoManifest;
    }
    /**
     * @return the number of a specific type of cargo in ship
     */
    public int searchCargo(TradeItem item){
        int output = 0;
        for(TradeItem ti: cargoManifest){
            if(ti != null && ti.getName().equalsIgnoreCase(item.getName()))
                output++;
        }
        return output;
    }
    /**
     * Navigate the ship from its current position to the input (x, y)
     * 
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public int travel(int x, int y, Universe uni, int i, int j) {
        int distance = (int)Math.sqrt(Math.pow((double)Math.abs(getX() - x), 2) + (double)Math.pow(Math.abs(getY() - y), 2));
        if(i != j && distance <= getFuel()){
            i=j;
            setFuel(getFuel() - distance);
            //RandomEvent(s);
        }
        this.x = x;
        this.y = y;
        return j;
    }
    public void RandomEvent(Stage s){
        Random rand = new Random();
        
        if(rand.nextInt(100) < 5){
            fuelLeak(s);
        }
        if(rand.nextInt(100) < 100) {
            robbed(s, rand);
        }
    }
    public void fuelLeak(Stage s){
        int cost = (this.fuelTank * 10) - (WelcomeScreenController.game.getPlayer().getEngineerSkill() * 5);
        if (WelcomeScreenController.game.getPlayer().getMoney() - cost >= 0) {
            WelcomeScreenController.game.getPlayer().setMoney(WelcomeScreenController.game.getPlayer().getMoney() - cost);
        } else {
            //game OVER
        }
        setFuel(0);
        Dialogs.create()
            .owner(s)
            .title("OH NO!")
            .masthead(null)
            .message("There has been a fuel leak!\nBecause of your engineering skill, you don't"
                + " have to buy a new fuel tank but just some spare parts.\n"
                + " You save " + (WelcomeScreenController.game.getPlayer().getEngineerSkill() * 5) + " credits.")
            .showInformation();
    }

    /**
     * Random event: a thief steals from cargo a number of times determined from
     * the player's trader skill.
     * @param s the Stage handling random events
     * @param rand rng
     */
    public void robbed(Stage s, Random rand) {
        
        // # of attempts a theif tries to steal
        int attempts = 6 - (WelcomeScreenController.game.getPlayer().getTraderSkill() / 2);
        String stolen = "";

        // Thief tries to steal "attempts" times from a random bay. The same
        // bay can be stolen from multiple times but nothing will happen after
        // stealing from it once. This should add some randomness.
        for(int i=0; i < attempts; i++) {
            
            int bayToStealFrom = rand.nextInt(this.bays);
            
            if (this.cargoManifest[bayToStealFrom] != null) {
                stolen += "\t" + this.cargoManifest[bayToStealFrom].getName()
                        + " in bay " + bayToStealFrom + "\n";
                this.cargoManifest[bayToStealFrom] = null;
                this.occupiedSlots--;
            }
        }
        
        if (stolen.equals("")) stolen = "Nothing! You sure lucked out.";
        Dialogs.create()
                .owner(s)
                .title("You've been robbed!")
                .masthead(null)
                .message("The following have been stolen from cargo:\n" + stolen)
                .showInformation();
    }
}
