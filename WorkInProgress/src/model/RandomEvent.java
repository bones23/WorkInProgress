/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.*;
import java.io.Serializable;
import java.util.Random;
import javafx.stage.Stage;
/**
 * @author Matthew Taylor
 * @version 21 October 2014
 */
public class RandomEvent implements Serializable {
    
    Random rand;
    Ship myShip;
    
    public void RandomEvent(Stage s, Ship ship){
        
        rand = new Random();
//        this.myShip = WelcomeScreenController.game.getShip();
    }

    /**
     * Run through every possible random event and call each with a calculated
     * probability
     * 
     * @param s The Stage to run in
     */
    public void runEvents(Stage s) {
        
        if(rand.nextInt(100) < 5){
            fuelLeak(s);
        }
        if(rand.nextInt(100) < 5) {
            robbed(s, rand);
        }
    }
    
    /**
     * Random event: fuel leaks from the ship
     * 
     * @param s The Stage to run in
     * @return The message to display after running the event
     */
    public String fuelLeak(Stage s){
        int cost = (this.myShip.getFuel() * 10) - (WelcomeScreenController.game.getPlayer().getEngineerSkill() * 5);
        
        if (WelcomeScreenController.game.getPlayer().getMoney() - cost >= 0) {
            WelcomeScreenController.game.getPlayer().setMoney(WelcomeScreenController.game.getPlayer().getMoney() - cost);
        } else {
            //game OVER
            System.out.println("Game over");
        }
        
        this.myShip.setFuel(0);
        return "There has been a fuel leak!\nBecause of your engineering skill, you don't"
                + " have to buy a new fuel tank but just some spare parts.\n"
                + " You save " + (WelcomeScreenController.game.getPlayer().getEngineerSkill() * 5) + " credits.";
    }

    /**
     * Random event: a thief steals from cargo a number of times determined from
     * the player's trader skill.
     * 
     * @param s The Stage handling random events
     * @param rand Rng
     * @return What's been taken from the ship
     */
    public String robbed(Stage s, Random rand) {
        
        // # of attempts a theif tries to steal
        int attempts = 6 - (WelcomeScreenController.game.getPlayer().getTraderSkill() / 2);
        String stolen = "The following have been stolen from cargo:\n";

        // Thief tries to steal "attempts" times from a random bay. The same
        // bay can be stolen from multiple times but nothing will happen after
        // stealing from it once. This should add some randomness.
        for(int i=0; i < attempts; i++) {
            
            int bayToStealFrom = rand.nextInt(this.myShip.getBays());
            
            if (this.myShip.getCargoManifest()[bayToStealFrom] != null) {
                stolen += "\t" + this.myShip.getCargoManifest()[bayToStealFrom].getName()
                        + " in bay " + bayToStealFrom + "\n";
                this.myShip.getCargoManifest()[bayToStealFrom] = null;
                this.myShip.occupiedSlots = this.myShip.occupiedSlots - 1;
            }
        }
        
        if (stolen.equals("")) {
            stolen = "Nothing! You sure lucked out.";
        }
        return stolen;
    }
}
