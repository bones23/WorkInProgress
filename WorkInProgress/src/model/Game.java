/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import controller.WelcomeScreenController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;
/**
 *
 * @author frenc_000
 */
public class Game implements Serializable{
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
        ship = new Ship();
        ship.setX(currentSystem.getX());
        ship.setY(currentSystem.getY());
    }
    public Game(Game game){
        this.uni = game.uni;
        this.rand = game.rand;
        this.market = game.market;
        this.currentLocationIndex = game.currentLocationIndex;
        this.currentSystem = game.currentSystem;
        this.ship = game.ship;
    }
    /*
    creates a player object
    */
    public void createPlayer(String name, int pilot, int fighter, int trader, int engineer){
        player = new Person(name, pilot, fighter, trader, engineer,100000);
    }
    public int getCurrentLocationIndex(){
        return currentLocationIndex;
    }
    public SolarSystem getCurrentSystem(){
        return currentSystem;
    }
    public int getMoney(){
        return player.getMoney();
    }
    public void setCurrentSystem(int index){
        this.currentSystem = uni.getSolarSystemAt(index);
    }
    public void setCurrentSystem(SolarSystem system){
        this.currentSystem = system;
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
    public void setShipUp(){
        Ship up = new Ship("upgrade",14,14);
        this.ship=up;
    }
    public MarketPlace getMarket(){
        return market;
    }
    

    /**
     * creates a serialized ObjectOutputStream to save the game's current state
     * @param fileName, the fileName we are trying to save
     * @param game , the object that we are saving
     * @throws IOException 
     */
    public void save(String fileName, Game game)throws IOException{
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
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
            output.writeObject(game);
            output.writeObject(game.player);
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     * loads a game state through an ObjectInputStream
     * @param fileName, name of the file we are trying to load
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public void load(String fileName) throws IOException, ClassNotFoundException{
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
           

  
            //
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName));
            WelcomeScreenController.game  = (Game) input.readObject();
            //WelcomeScreenController.game = newgame;
            //THIS IS THE NEW GAME INSTANCE. 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();;
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
