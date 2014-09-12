/**
 * Creates the universe of the game. The universe consists of 119 SolarSystems.
 * Also creates a 1-D array of the SolarSystem.
 * 
 * @author Brandon Jackson
 * @version 1.0
 */
package model;
import java.util.Random;
public class Universe{
	private String[] names = {
		    "Acamar",
		    "Adahn",		// The alternate personality for The Nameless One in "Planescape: Torment"
		    "Aldea",
		    "Andevian",
		    "Antedi",
		    "Balosnee",
		    "Baratas",
		    "Brax",			// One of the heroes in Master of Magic
		    "Bretel",		// This is a Dutch device for keeping your pants up.
		    "Calondia",
		    "Campor",
		    "Capelle",		// The city I lived in while programming this game
		    "Carzon",
		    "Castor",		// A Greek demi-god
		    "Cestus",
		    "Cheron",		
		    "Courteney",	// After Courteney Cox�
		    "Daled",
		    "Damast",
		    "Davlos",
		    "Deneb",
		    "Deneva",
		    "Devidia",
		    "Draylon",
		    "Drema",
		    "Endor",
		    "Esmee",		// One of the witches in Pratchett's Discworld
		    "Exo",
		    "Ferris",		// Iron
		    "Festen",		// A great Scandinavian movie
		    "Fourmi",		// An ant, in French
		    "Frolix",		// A solar system in one of Philip K. Dick's novels
		    "Gemulon",
		    "Guinifer",		// One way of writing the name of king Arthur's wife
		    "Hades",		// The underworld
		    "Hamlet",		// From Shakespeare
		    "Helena",		// Of Troy
		    "Hulst",		// A Dutch plant
		    "Iodine",		// An element
		    "Iralius",
		    "Janus",		// A seldom encountered Dutch boy's name
		    "Japori",
		    "Jarada",
		    "Jason",		// A Greek hero
		    "Kaylon",
		    "Khefka",
		    "Kira",			// My dog's name
		    "Klaatu",		// From a classic SF movie
		    "Klaestron",
		    "Korma",		// An Indian sauce
		    "Kravat",		// Interesting spelling of the French word for "tie"
		    "Krios",
		    "Laertes",		// A king in a Greek tragedy
		    "Largo",
		    "Lave",			// The starting system in Elite
		    "Ligon",
		    "Lowry",		// The name of the "hero" in Terry Gilliam's "Brazil"
		    "Magrat",		// The second of the witches in Pratchett's Discworld
		    "Malcoria",
		    "Melina",
		    "Mentar",		// The Psilon home system in Master of Orion
		    "Merik",
		    "Mintaka",
		    "Montor",		// A city in Ultima III and Ultima VII part 2
		    "Mordan",
		    "Myrthe",		// The name of my daughter
		    "Nelvana",
		    "Nix",			// An interesting spelling of a word meaning "nothing" in Dutch
		    "Nyle",			// An interesting spelling of the great river
		    "Odet",
		    "Og",			// The last of the witches in Pratchett's Discworld
		    "Omega",		// The end of it all
		    "Omphalos",		// Greek for navel
		    "Orias",
		    "Othello",		// From Shakespeare
		    "Parade",		// This word means the same in Dutch and in English
		    "Penthara",
		    "Picard",		// The enigmatic captain from ST:TNG
		    "Pollux",		// Brother of Castor
		    "Quator",
		    "Rakhar",
		    "Ran",			// A film by Akira Kurosawa
		    "Regulas",
		    "Relva",
		    "Rhymus",
		    "Rochani",
		    "Rubicum",		// The river Ceasar crossed to get into Rome
		    "Rutia",
		    "Sarpeidon",
		    "Sefalla",
		    "Seltrice",
		    "Sigma",
		    "Sol",			// That's our own solar system
		    "Somari",
		    "Stakoron",
		    "Styris",
		    "Talani",
		    "Tamus",
		    "Tantalos",		// A king from a Greek tragedy
		    "Tanuga",
		    "Tarchannen",
		    "Terosa",
		    "Thera",		// A seldom encountered Dutch girl's name
		    "Titan",		// The largest moon of Jupiter
		    "Torin",		// A hero from Master of Magic
		    "Triacus",
		    "Turkana",
		    "Tyrus",
		    "Umberlee",		// A god from AD&D, which has a prominent role in Baldur's Gate
		    "Utopia",		// The ultimate goal
		    "Vadera",
		    "Vagra",
		    "Vandor",
		    "Ventax",
		    "Xenon",
		    "Xerxes",		// A Greek hero
		    "Yew",			// A city which is in almost all of the Ultima games
		    "Yojimbo",		// A film by Akira Kurosawa
		    "Zalkon",
		    "Zuul"			// From the first Ghostbusters movie
		};
	
    private Random rand;
    private SolarSystem[] universe;
    int[][] check;
    int x;
    int y;
    
    /**
     * Constructor for the Universe object. Instantiates 119 SolarSystems in 
     * different, random locations on a 150x100 area.
     * Makes a 1-D array of the SolarSystems.
     */
    public Universe() {
    	universe = new SolarSystem[names.length];
    	rand = new Random();
    	check = new int[150][100];
        for (int i = 0; i < names.length; i++) {
            do {
                x = rand.nextInt(150);
                y = rand.nextInt(100);
            } while(check[x][y] == 1);
            universe[i] = new SolarSystem(names[i], x, y);
            check[x][y] = 1;
        }
    }
    
    /**
     * Prints the universe through the console.
     */
    public void printUniverse() {
    	int count = 0;
    	for (int i = 0; i < universe.length; i++) {
    		System.out.println(universe[i].toString());
    		count ++;
    	}
    }
    
    /**
     * Getter for the universe. Returns a 1-D array of SolarSystems which make 
     * up the universe.
     * 
     * @return universe - collection of SolarSystems
     */
    public SolarSystem[] getUniverse() {
        return universe;
    }

}