/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
/**
 *
 * @author frenc_000
 */
public class Game{
    public Ship ship;
    public Universe uni;
    public Person player;
    public int currentLocationIndex;
    public SolarSystem currentSystem;
    public Random rand;
    public MarketPlace market;
    
    public Game(){
        uni = new Universe();
        rand = new Random();
        market = new MarketPlace();
        currentLocationIndex = rand.nextInt(120);
        currentSystem = uni.getSolarSystemAt(currentLocationIndex);
        //ship = new Ship();
        ship.setX(currentSystem.getX());
        ship.setY(currentSystem.getY());
    }
    /*
    creates a player object
    */
    public void createPlayer(String name, int pilot, int fighter, int trader, int engineer){
        player = new Person(name, pilot, fighter, trader, engineer);
    }
    /*
    * @return a string representation of a Player
    */
    public String getPlayerString(){
        return player.toString();
    }
    /*
    *@return a string representation of the Universe
    */
    public String getUniverseString(){
        return uni.toString();
    }
    /*
    returns the player object
    */
    public Person getPlayer(){
        return player;
    }
    /*
    returns the universe object
    */
    public Universe getUniverse(){
        return uni;
    }
    /*
    returns the ship object
    */
    public Ship getShip(){
        return ship;
    }
    public MarketPlace getMarket(){
        return market;
    }
    /*
    creates a serialized ObjectOutputStream to save the game's current state
    */
    public void save(Ship s, Universe u, Person p)throws IOException{
        //saves a game
    }
    /*
    loads a game state through an ObjectInputStream
    */
    public void load(String input) throws IOException{
        //loads a game
    }
}
