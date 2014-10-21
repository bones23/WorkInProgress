package model;

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
        if((Person.getMoney() - toBuy * 5) > 0){
            setFuel(fuelTank);
            Person.setMoney(Person.getMoney() - toBuy * 5);  
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
     * 
     * @return 
     */
    public void setOccupiedSlots(int os) {
        this.occupiedSlots = os;
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
    public int travel(int x, int y, Universe uni, int i, int j, Stage s) {
        int distance = (int)Math.sqrt(Math.pow((double)Math.abs(getX() - x), 2) + (double)Math.pow(Math.abs(getY() - y), 2));
        if(i != j && distance <= getFuel()){
            i=j;
            setFuel(getFuel() - distance);
//            RandomEvent(s);
        }
        this.x = x;
        this.y = y;
        return j;
    }
}
