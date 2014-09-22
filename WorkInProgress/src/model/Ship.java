package model;

/**
 *
 * @author MT
 */
public class Ship {
    
    private int fuel;
    private int x;
    private int y;
    private String type;
    private String pilot;
    private int numOccupied;
    private TradeItem[] cargo;
    
    public Ship(String type, String pilot, int fuel, int baysSize, int x, int y) {
        this.type = type;
        this.fuel = fuel;
        this.x = x;
        this.y = y;
        this.cargo = new TradeItem[baysSize];
        
        this.numOccupied = 0;
    }
    
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
        if(numOccupied == cargo.length) {
            return false;
        }
        
        for(int i = 0; i < cargo.length; i++) {
            if(this.cargo[i] == null) {
                this.cargo[i] = item;
                this.numOccupied++;
                
                return true;
            }
            
        }
        
        return false;
    }
    
    
}
