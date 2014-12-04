package model;
import java.io.Serializable;
import java.util.Random;

/*
* Creates Solar System object. Each solar system has a name, x/y location, tech
* level, resource level, amount of pirates, amount of police, and government
* type.
*
* @author Brandon Jackson
* @version 1.0
*/
public class SolarSystem implements Serializable {
    //CHECKSTYLE: OFF
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
        "Renaissance", "Early-Industrial", "Industrial", "Post-Industrial",
        "Hi-Tech"}; 
    private String[] resourceNames = {"No Special Resources", "Mineral Rich",
        "Mineral Poor", "Desert", "Lots of Water", "Rich Soil", "Poor Soil",
        "Rich Fauna", "Lifeless", "Weird Mushrooms", "Lots of Herbs",
        "Artistic", "Warlike"};
    private String[] governmentNames = {"Monarchy", "Technocracy", "Democracy", 
        "Corporate State", "Theocracy", "Feudal State", "Socialist State",
        "Anarchy"};

    private final int NUM_RESOURCES = 3;
    //CHECKSTYLE: ON
    //------------------------------------------------------------------------\\

    /**
     * Constructor for SolarSystem Object. The planet's attributes are randomly
     * assigned.
     * @param newName - name of the SolarSystem
     * @param newX - the x coordinate of the SolarSystem
     * @param newY - the y coordinate of the SolarSystem
     */
    public SolarSystem(final String newName, final int newX, final int newY) {
        this.name = newName;
        this.x = newX;
        this.y = newY;

        techLevel = rand.nextInt(techNames.length);
        tech = techNames[techLevel];
        int resourceNum = rand.nextInt(resourceNames.length + NUM_RESOURCES);
//        int noResource = 3;
        if (resourceNum <= NUM_RESOURCES) {
            resource = resourceNames[0];
        } else {
            resource = resourceNames[resourceNum - NUM_RESOURCES];
        }
        if (techLevel <= 2) {
            policeIntensity = 1;
            pirateIntensity = 4;
        } else if (techLevel <= 5) {
            policeIntensity = 3;
            pirateIntensity = 3;
        } else {
            policeIntensity = 4;
            pirateIntensity = 1;
        }
        government = governmentNames[rand.nextInt(governmentNames.length)];
        if (government.equals("Anarchy")) {
            policeIntensity = 0;
            police = "None";
        } else {
            policeIntensity = rand.nextInt(NUM_RESOURCES + 1);
            police = amountNames[policeIntensity];
        }

        if (government.equals("Anarchy")) {
            pirateIntensity = NUM_RESOURCES;
            pirate = "Abundant";
        } else {
            pirateIntensity = rand.nextInt(NUM_RESOURCES + 1);
            pirate = amountNames[pirateIntensity];
        }
        marketplace = new MarketPlace(techLevel);
    }

    /**
     * Getter for the name of the solar system.
     * @return name - name of solar system
     */
    public final String getName() {
        return name;
    }

    /**
     * Getter for the x location of the solar system.
     * @return x - the x coordinate
     */
    public final int getX() {
        return x;
    }

    /**
     * Getter for the tech level of the solar system.
     * @return techLevel - the tech level of the system
     */
    public final int getTechLevel() {
        return techLevel;
    }
    /**
     * Getter for the y location of the solar system.
     * @return y - the y coordinate
     */
    public final int getY() {
        return y;
    }

    /**
     * Getter for the tech level of the solar system.
     * @return tech - the tech level
     */
    public final String getTech() {
        return tech;
    }

    /**
     * Getter for the government type of the solar system.
     * @return government - the government type
     */
    public final String getGovernment() {
        return government;
    }

    /**
     * Getter for the resource type of the solar system.
     * @return resource - the resource type
     */
    public final String getResource() {
        return resource;
    }

    /**
     * Setter for the resource status of the solar system.
     * @param nResource - the resource status
     */
    public final void setResource(final String nResource) {
        this.resource = nResource;
    }

    /**
     * Getter for the pirate status of the solar system.
     * @return pirate - the pirate status
     */
    public final String getPirate() {
        return pirate;
    }

    /**
     * Getter for the police status of the solar system.
     * @return police - the police status
     */
    public final String getPolice() {
        return police;
    }

    /**
     * Getter for the police intensity of the solar system.
     * @return police - the police status
     */
    public final int getPoliceIntensity() {
        return policeIntensity;
    }
    
     /**
     * Getter for the pirate intensity of the solar system.
     * @return police - the police status
     */
    public final int getPirateIntensity() {
        return pirateIntensity;
    }
    /**
     * Getter for marketplace.
     * @return marketplace
     */
    public final MarketPlace getMarketPlace() {
        return marketplace;
    }

    @Override
    public final String toString() {
        return "Name: " + name + "\nTech Level: " + tech + "\nGovernment: "
                + government + "\nResource: " + resource + "\nPolice: "
                + police + "\nPirate: " + pirate + "\nLocation: " + x + ", "
                + y + "\n";
    }
}