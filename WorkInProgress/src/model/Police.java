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
public class Police {
    private int health;
    private int damageLow;
    private int damageHigh;
    private Random rand;
    Game game = WelcomeScreenController.game;
    public Police() {
        rand = new Random();
        health = 100;
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
    
    public int takeDamage(int damage) {
        if (health > 0) {
            health = health - damage;
            if (health < 0) {
                health = 0;
            }
        }
        return health;
    }
    
    public int doDamage() {
        return rand.nextInt(damageHigh - damageLow) + damageLow;
    }
}
