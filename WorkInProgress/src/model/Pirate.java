/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import controller.WelcomeScreenController;
import java.util.Random;
/**
 *
 * @author Brandon
 */
public class Pirate {
    private int health;
    private int damageLow;
    private int damageHigh;
    private Random rand;
    Game game = WelcomeScreenController.game;
    public Pirate() {
        rand = new Random();
        health = rand.nextInt(50 - 30 + 1) + 30;
        damageLow = 9;
        damageHigh = 18;
    }
    
    public int getHealth() {
        return health;
    }
    
    public int getDamageLow() {
        return damageLow;
    }
    
    public int getDamageHigh() {
        return damageHigh;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
}
