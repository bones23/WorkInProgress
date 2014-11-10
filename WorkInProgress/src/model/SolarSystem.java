/*
* Creates Solar System object. Each solar system has a name, x/y location, tech
* level, resource level, amount of pirates, amount of police, and government type.
*
* @author Brandon Jackson 
* @version 1.0
*/
package model;
import java.io.Serializable;
import java.util.Random;
public class SolarSystem implements Serializable {
    private Random rand = new Random();
    
    private MarketPlace marketplace;
    
    private String name = "";
    private int x;
    private int y;
    
    private String tech;
    private int techLevel;
    private String resource;
    
    private String government;

    private String police;
    private int policeIntensity;
    
    private String pirate;
    private int pirateIntensity;

    /*List of possible names for the tech, resources, and government types of a 
    SolarSystem */
    private String[] amountNames = {"None", "Minimal", "Moderate", "Abundant"};
    private String[] techNames = {"Pre-Algriculture", "Agriculture", "Medieval",
        "Renaissance", "Early-Industrial", "Industrial", "Post-Industrial", "Hi-Tech"}; 
    private String[] resourceNames = {"No Special Resources", "Mineral Rich", "Mineral Poor",
    "Desert", "Lots of Water", "Rich Soil", "Poor Soil", "Rich Fauna", "Lifeless",
    "Weird Mushrooms", "Lots of Herbs", "Artistic", "Warlike"};
    private String[] governmentNames = {"Monarchy", "Technocracy", "Democracy", 
    "Corporate State", "Theocracy", "Feudal State", "Socialist State", "Anarchy"};
    //--------------------------------------------------------------------------------\\
    
    /**
     * Constructor for SolarSystem Object. The planet's attributes are randomly
     * assigned.
     * 
     * @param name - name of the SolarSystem
     * @param x - the x coordinate of the SolarSystem
     * @param y - the y coordinate of the SolarSystem
     */
    public SolarSystem(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this. y = y;
        
        techLevel = rand.nextInt(techNames.length);
        tech = techNames[techLevel];
        int resourceNum = rand.nextInt(resourceNames.length + 3);
        int noResource = 3;
        if (resourceNum <= noResource) {
            resource = resourceNames[0];
        } else {
            resource = resourceNames[resourceNum - 3];
        }
        
        government = governmentNames[rand.nextInt(governmentNames.length)];
        if (government.equals("Anarchy")) {
            policeIntensity = 0;
            police = "None";
        } else {
            policeIntensity = rand.nextInt(4);
            police = amountNames[policeIntensity];
        }
        
        if (government.equals("Anarchy")) {
            pirateIntensity = 3;
            pirate = "Abundant";
        } else {
            pirateIntensity = rand.nextInt(4);
            pirate = amountNames[pirateIntensity];
        }
        marketplace = new MarketPlace(techLevel);
    }

    /**
     * Getter for the name of the solar system.
     * 
     * @return name - name of solar system
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the x location of the solar system.
     * 
     * @return x - the x coordinate
     */
    public int getX() {
        return x;
    }
    
    /**
     * Getter for the tech level of the solar system
     * @return techLevel - the tech level of the system
     */
    public int getTechLevel() {
        return techLevel;
    }
    /**
     * Getter for the y location of the solar system.
     * 
     * @return y - the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Getter for the tech level of the solar system.
     * 
     * @return tech - the tech level
     */
    public String getTech() {
        return tech;
    }
    
    /**
     * Getter for the government type of the solar system.
     * 
     * @return government - the government type
     */
    public String getGovernment() {
        return government;
    }

    /**
     * Getter for the resource type of the solar system.
     * 
     * @return resource - the resource type
     */
    public String getResource() {
        return resource;
    }
    
    /**
     * Setter for the resource status of the solar system.
     * 
     * @param resource - the resource status
     */
    public void setResource(String resource) {
        this.resource = resource;
    }
    
    /**
     * Getter for the pirate status of the solar system.
     * 
     * @return pirate - the pirate status
     */
    public String getPirate() {
        return pirate;
    }
    
    /**
     * Getter for the police status of the solar system.
     * 
     * @return police - the police status
     */
    public String getPolice() {
        return police;
    }
    
    /**
     * Getter for marketplace
     * @return marketplace 
     */
    public MarketPlace getMarketPlace() {
        return marketplace;
    }
    
    public String toString() {
    	return "Name: " + name + "\nTech Level: " + tech + "\nGovernment: " + government +
    			"\nResource: " + resource + "\nPolice: " + police + "\nPirate: " + pirate + "\nLocation: "
    			+ x + ", " + y + "\n";
    }
}