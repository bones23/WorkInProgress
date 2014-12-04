package model;
import controller.WelcomeScreenController;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

/**
 *
 * @author frenc_000
 */
public class Game {
    //CHECKSTYLE: OFF
    //Public
    public Ship ship;
    public Universe uni;
    public Person player;
    public int currentLocationIndex;
    public SolarSystem currentSystem;
    public Random rand;
    public MarketPlace market;

    private final int MAX_LOCATION_INDEX = 120;
    private final int DEFAULT_PLAYER_CASH = 100000;
    private final int DEFAULT_SHIP_FUEL = 14;
    private final int DEFAULT_SHIP_BAYS_NUM = 14;
    //CHECKSTYLE: ON

    /**
     * Create a new Game with a populated Universe, MarketPlace, and Ship.
     */
    public Game() {
        uni = new Universe();
        rand = new Random();
        market = new MarketPlace();
        currentLocationIndex = rand.nextInt(MAX_LOCATION_INDEX);
        currentSystem = uni.getSolarSystemAt(currentLocationIndex);
        ship = new Ship();
        ship.setX(currentSystem.getX());
        ship.setY(currentSystem.getY());
    }

    /**
     * Create a Game from an existing Game's information.
     * @param game the old Game
     */
    public Game(final Game game) {
        this.uni = game.uni;
        this.rand = game.rand;
        this.market = game.market;
        this.currentLocationIndex = game.currentLocationIndex;
        this.currentSystem = game.currentSystem;
        this.ship = game.ship;
    }
    /**
     * Create a new Player.
     * @param name Player's name
     * @param pilot pilot skill
     * @param fighter fighter skill
     * @param trader trader skill
     * @param engineer engineer skill
     */
    public final void createPlayer(final String name, final int pilot,
            final int fighter, final int trader, final int engineer) {
        //Seems unnecessary
        player = new Person(name, pilot, fighter, trader, engineer,
                DEFAULT_PLAYER_CASH);
        ship.setAttackDamage(ship.getAttackDamage() + fighter);
    }

    /**
     * @return the index of the current location (SolarSystem)
     */
    public final int getCurrentLocationIndex() {
        return currentLocationIndex;
    }

    /**
     * @return the currently visited SolarSystem
     */
    public final SolarSystem getCurrentSystem() {
        return currentSystem;
    }

    /**
     * @return the Player's money
     */
    public final int getMoney() {
        return player.getMoney();
    }

    /**
     * @param index the index of the new SolarSystem
     */
    public final void setCurrentSystem(final int index) {
        this.currentSystem = uni.getSolarSystemAt(index);
    }

    /**
     * @param system the new SolarSystem
     */
    public final void setCurrentSystem(final SolarSystem system) {
        this.currentSystem = system;
    }

    /**
     * @return a string representation of a Player
     */
    public final String getPlayerString() {
        return player.toString();
    }

    /**
     *@return a string representation of the Universe
     */
    public final String getUniverseString() {
        return uni.toString();
    }

    /**
     *@return the player object
     */
    public final Person getPlayer() {
        return player;
    }

    /**
     *@return the universe object
     */
    public final Universe getUniverse() {
        return uni;
    }

    /**
     *@return the ship object
     */
    public final Ship getShip() {
        return ship;
    }

    /**
     * Create a Ship for upgrades (temp).
     */
    public final void setShipUp() {
        Ship up = new Ship("upgrade", DEFAULT_SHIP_FUEL, DEFAULT_SHIP_BAYS_NUM);
        this.ship = up;
    }

    /**
     * @return the current MarketPlace
     */
    public final MarketPlace getMarket() {
        return market;
    }

    /**
     * Creates a serialized ObjectOutputStream to save the game's current state.
     * @param fileName the fileName we are trying to save
     * @param game the object that we are saving
     * @throws IOException CHECKSTYLE RULES
     */
    public final void save(final String fileName, final Game game)
            throws IOException {

        /** THIS PORTION OF CODE GOES IN THE UI
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            fileName = file.getName();
        } else {
            throw new Exception();
        }
        WelcomeScreenController.game.save(fileName, game);
        */

        try {
            ObjectOutputStream output =
                    new ObjectOutputStream(new FileOutputStream(fileName));
            output.writeObject(game);
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads a game state through an ObjectInputStream.
     * @param fileName name of the file we are trying to load
     * @throws IOException problynot an IOException
     * @throws ClassNotFoundException defnot a ClassNotFoundException
     */
    public final void load(final String fileName)
            throws IOException, ClassNotFoundException {
        //Game newgame=WelcomeScreenController.game;
        /** INSERT THIS CODE INTO THE UI
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            fileName = file.getName();
        }
        WelcomeScreenController.game.load(fileName);
        */
        try {
            ObjectInputStream input =
                    new ObjectInputStream(new FileInputStream(fileName));
            WelcomeScreenController.game  = (Game) input.readObject();
            //WelcomeScreenController.game = newgame;
            //THIS IS THE NEW GAME INSTANCE.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Game newgame = (Game) input.readObject();
           // WelcomeScreenController.game = newgame;

        /*
        THE REST OF THIS METHOD SHOULD START A UNIVERSE USING THE "game" OBJECT.
        game has all the information needed to make a new game.
        */

       // WelcomeScreenController.game = newgame;

        /*
        initialize a new game using this object
        */
    }
}