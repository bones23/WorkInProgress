package model;

/**
 * @author Matthew Taylor
 * @version 22 September 2014
 */
public class Ship {
    
    private int fuel;
    private int x;
    private int y;
    private String type;
    private String pilot;
    private int numOccupied;
    private TradeItem[] cargo;
    private int bays;
    
    public Ship(String type, String pilot, int fuel, int baysSize) {
        this.type = type;
        this.pilot = pilot;
        this.fuel = fuel;
        this.cargo = new TradeItem[baysSize];
        this.numOccupied = 0;
        this.bays = baysSize;
    }
    
    /**
     * Navigate the ship from its current position to the input (x, y)
     * 
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public void travel(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Adds a TradeItem to the cargo of the ship if it is not full
     * 
     * @param item The TradeItem to add to cargo
     * @return false if cargo is full else true
     */
    public boolean addItem(TradeItem item) {
        
        if(getNumOccupied() == getCargo().length) {
            return false;
        }
        
        for(int i = 0; i < getCargo().length; i++) {
            if(this.getCargo()[i] == null) {
                this.cargo[i] = item;
                this.numOccupied++;
                
                return true;
            }
            
        }
        
        return false;
    }

    /**
     * Removes the first occurring type of the item specified in cargo.
     * 
     * @param item The item to remove
     * @return true if successfully removed else false
     */
    public boolean removeItem(TradeItem item) {
        
        for(int i = 0; i < getCargo().length; i++) {
            if(this.getCargo()[i] != null
               && this.getCargo()[i].getName().equals(item.getName())) {
                
                this.cargo[i] = null;
                this.numOccupied--;
                
                return true;
            }
            
        }
        
        return false;
    }
    
    /**
     * @return the fuel
     */
    public int getFuel() {
        return this.fuel;
    }

    /**
     * @param fuel the new fuel
     */
    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
    
    /**
     * @return the x
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * @return the y
     */
    public int getY() {
        return this.y;
    }
    
    /**
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * @return the pilot
     */
    public String getPilot() {
        return this.pilot;
    }

    /**
     * @return the numOccupied
     */
    public int getNumOccupied() {
        return this.numOccupied;
    }

    /**
     * @return the cargo
     */
    public TradeItem[] getCargo() {
        return this.cargo;
    }
    
}
