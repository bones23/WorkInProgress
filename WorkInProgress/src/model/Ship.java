package model;

import controller.WelcomeScreenController;
import org.controlsfx.dialog.Dialogs;
import java.util.Random;
import javafx.stage.Stage;
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
    private int occupiedSlots;
    private TradeItem[] cargoManifest;
    private int bays;
    private int fuelTank;
    
    public Ship(String shipClass, String pilot, int fuel, int baysSize) {
        this.shipClass = shipClass;
        this.pilot = pilot;
        this.fuel = fuel;
        this.cargoManifest = new TradeItem[baysSize];
        this.occupiedSlots = 0;
        this.bays = baysSize;
        this.fuelTank = fuel;
    }
    
    /**
     * Purchase the maximum amount of fuel that the ship can carry
     */
    public void buyFuel(){
        int toBuy = fuelTank-fuel;
        if((Person.getMoney() - toBuy * 5) > 0){
            setFuel(fuelTank);
            Person.setMoney(Person.getMoney() - toBuy * 5);  
        }
    }
    
    /**
     * Adds a TradeItem to the cargoManifest of the ship if it is not full
     * 
     * @param item The TradeItem to add to cargo
     * @return False if cargo is full else true
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
     * @return True if successfully removed else false
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
     * @return The number of a specific type of cargo in ship
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
     * Navigate the ship from its current position to the location of the destination
     * Solar System index
     * 
     * @param destSSIndex The index in the Universe of the destination SolarSystem
     * @param myStage The Stage to run in
     */
    public void travel(int destSSIndex, Stage myStage) {
        
        int distance = (int)Math.sqrt(Math.pow((double)Math.abs(getX() - x), 2)
                       + (double)Math.pow(Math.abs(getY() - y), 2));
        
        if(WelcomeScreenController.game.currentSystem
                != WelcomeScreenController.game.getUniverse().getSolarSystemAt(destSSIndex)
                && distance <= getFuel())
        {
            WelcomeScreenController.game.setCurrentSystem(destSSIndex);
            setFuel(getFuel() - distance);
            
            RandomEvent events = new RandomEvent();
            events.runEvents(myStage);
        }
        
        this.x = WelcomeScreenController.game.currentSystem.getX();
        this.y = WelcomeScreenController.game.currentSystem.getY();
    }
    
    /**
     * @return The amount of fuel that the ship currently has
     */
    public int getFuel(){
        return this.fuel;
    }
    
    /**
     * @param fuel The new amount of fuel
     */
    public void setFuel(int fuel){
        this.fuel = fuel;
    }
    
    /**
     * @return The x coordinate of the ship's current position
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * @param newX The new x coordinate of the ship
     */
    public void setX(int newX){
        this.x = newX;
    }
    
    /**
     * @return The y coordinate of the ship's current position
     */
    public int getY() {
        return this.y;
    }
    
    /**
     * @param newY The new y coordinate of the ship
     */
    public void setY(int newY){
        this.y= newY;
    }
    
    /**
     * @return The number of bays that the ship has
     */
    public int getBays(){
        return this.bays;
    }
    
    /**
     * @return The class of ship that you are flying
     */
    public String getShipClass() {
        return this.shipClass;
    }

    /**
     * @return The pilot of the ship 
     */
    public String getPilot() {
        return this.pilot;
    }
    
    /**
     * @param nPilot The new pilot of the ship 
     */
    public void setPilot(String nPilot){
        this.pilot = nPilot;
    }
    
    /**
     * @return The occupied slots
     */
    public int getOccupiedSlots() {
        return this.occupiedSlots;
    }
    
    /**
     * @param os The new number of occupied slots
     */
    public void setOccupiedSlots(int os) {
        this.occupiedSlots = os;
    }

    /**
     * @return The cargo
     */
    public TradeItem[] getCargoManifest() {
        return this.cargoManifest;
    }
    
    /**
     * @return True if at least 1 bay is open, else false
     */
    public boolean freeSpace(){
        return (bays - occupiedSlots) > 0;
    }
    
    /**
     * @return The # of cargo bays left 
     */
    public int getSpaceLeft(){
        return bays-occupiedSlots;
    }
}
