package model;
import java.io.Serializable;
import java.util.Random;

/**
 * Creates the universe of the game. The universe consists of 119 SolarSystems.
 * Also creates a 1-D array of the SolarSystem.
 * @author Brandon Jackson
 * @version 1.0
 */
public class Universe implements Serializable {
    //CHECKSTYLE: OFF
        private final String[] names = {
                    "Acamar",
                    "Adahn",
                    "Aldea",
                    "Andevian",
                    "Antedi",
                    "Balosnee",
                    "Baratas",
                    "Brax",
                    "Bretel",
                    "Calondia",
                    "Campor",
                    "Capelle",
                    "Carzon",
		    "Castor",
		    "Cestus",
		    "Cheron",
		    "Courteney",
		    "Daled",
		    "Damast",
		    "Davlos",
		    "Deneb",
		    "Deneva",
		    "Devidia",
		    "Draylon",
		    "Drema",
		    "Endor",
		    "Esmee",
		    "Exo",
		    "Ferris",
		    "Festen",
		    "Fourmi",
		    "Frolix",
		    "Gemulon",
		    "Guinifer",
		    "Hades",
		    "Hamlet",
		    "Helena",
		    "Hulst",
		    "Iodine",
		    "Iralius",
		    "Janus",
		    "Japori",
		    "Jarada",
		    "Jason",
		    "Kaylon",
		    "Khefka",
		    "Kira",
		    "Klaatu",
		    "Klaestron",
		    "Korma",
		    "Kravat",
		    "Krios",
		    "Laertes",
		    "Largo",
		    "Lave",
		    "Ligon",
		    "Lowry",
		    "Magrat",
		    "Malcoria",
		    "Melina",
		    "Mentar",
		    "Merik",
		    "Mintaka",
		    "Montor",
		    "Mordan",
		    "Myrthe",
		    "Nelvana",
		    "Nix",
		    "Nyle",
		    "Odet",
		    "Og",
		    "Omega",
		    "Omphalos",
		    "Orias",
		    "Othello",
		    "Parade",
		    "Penthara",
		    "Picard",
		    "Pollux",
		    "Quator",
		    "Rakhar",
		    "Ran",
		    "Regulas",
		    "Relva",
		    "Rhymus",
		    "Rochani",
		    "Rubicum",
		    "Rutia",
		    "Sarpeidon",
		    "Sefalla",
		    "Seltrice",
		    "Sigma",
		    "Sol",
		    "Somari",
		    "Stakoron",
		    "Styris",
		    "Talani",
		    "Tamus",
		    "Tantalos",
		    "Tanuga",
		    "Tarchannen",
		    "Terosa",
		    "Thera",
		    "Titan",
		    "Torin",
		    "Triacus",
		    "Turkana",
		    "Tyrus",
		    "Umberlee",
		    "Utopia",
		    "Vadera",
		    "Vagra",
		    "Vandor",
		    "Ventax",
		    "Xenon",
		    "Xerxes",
		    "Yew",
		    "Yojimbo",
		    "Zalkon",
		    "Zuul"
		};
    private Random rand;
    private SolarSystem[] universe;
    int[][] check;
    int x;
    int y;

    private final int SCREEN_X = 154;
    private final int SCREEN_Y = 104;
    private final int X_MAX = 146;
    private final int Y_MAX = 96;
    private final int THREE = 3;
    private final int FOUR = 4;
    //CHECKSTYLE: ON

    /**
     * Constructor for the Universe object. Instantiates 119 SolarSystems in
     * different, random locations on a 150x100 area.
     * Makes a 1-D array of the SolarSystems.
     */
    public Universe() {
    	universe = new SolarSystem[names.length];
    	rand = new Random();
    	check = new int[SCREEN_X][SCREEN_Y];
        for (int i = 0; i < names.length; i++) {
            do {
                x = rand.nextInt(X_MAX) + FOUR;
                y = rand.nextInt(Y_MAX) + FOUR;
            } while(check[x][y] == 1);
            universe[i] = new SolarSystem(names[i], x, y);
            check[x][y] = 1;
            for (int j = x - THREE; j < x + THREE; j++) {
                for (int k = y - THREE; k < y + THREE; k++) {
                    check[j][k] = 1;
                }
            }
        }
    }

    /**
     * Prints the universe through the console.
     * @return  toString - the Universe's information for each SolarSystem in it
     */
    @Override
    public final String toString() {
        String toString = "";
        for (SolarSystem universe1 : this.universe) {
            toString += (universe1.toString() + "\n");
        }
        return toString;
    }

    /**
     * Getter for the universe. Returns a 1-D array of SolarSystems which make
     * up the universe.
     * @return universe - collection of SolarSystems
     */
    public final SolarSystem[] getUniverse() {
        return universe;
    }

    /**
     * getter for a SolarSystem at a specified index.
     *
     * @param index INDINEIXNEINXIDN
     * @return SolarSystem at index
     */
    public final SolarSystem getSolarSystemAt(final int index) {
        return universe[index];
    }
}