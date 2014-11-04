package model;

import java.io.Serializable;

/**
 *
 * @author CodyMFFries
 */
public class Person implements Serializable{
    private int pilotSkill;
    private int fighterSkill;
    private int traderSkill;
    private int engineerSkill;
    private String playerName;
    private int money;
    private Ship ship;
    private int x;
    private int y;
    
    public Person(String name, int pSkill, int fSkill, int tSkill, int eSkill, int cash){
        this.pilotSkill = pSkill;
        this.fighterSkill = fSkill;
        this.traderSkill = tSkill;
        this.engineerSkill = eSkill;
        this.playerName = name;
        this.ship = new Ship("Flea", name, 14, 10);
        this.money = cash;
    }
    public Person(int pSkill, int fSkill, int tSkill, int eSkill){
        this("Kirk", pSkill, fSkill, tSkill, eSkill, 100000000);
    }
    
    /**
     * @return the Person's pilot skill 
     */
    public int getPilotSkill(){
        return pilotSkill;
    }
    
    /**
     * @param newPilot the Person's new pilot skill
     */
    public void setPilotSkill(int newPilot){
        pilotSkill = newPilot;
    }
    
    /**
     * @return the Person's fighter skill 
     */
    public int getFighterSkill(){
        return fighterSkill;
    }
    
    /**
     * @param newFighter the Person's new fighter skill
     */
    public void setFighterSkill(int newFighter){
        fighterSkill = newFighter;
    }
    
    /**
     * @return the Person's trader skill 
     */
    public int getTraderSkill(){
        return traderSkill;
    }
    
    /**
     * @param newTrader the Person's new trader skill 
     */
    public void setTraderSkill(int newTrader){
        traderSkill = newTrader;
    }
    
    /**
     * @return the Person's engineer skill
     */
    public  int getEngineerSkill(){
        return engineerSkill;
    }
    
    /**
     * @param newEngineer the Person's new engineer skill
     */
    public void setEngineerSkill(int newEngineer){
        engineerSkill = newEngineer;
    }
    
    /**
     * @return the Player's name
     */
    String getName(){
        return this.playerName;
    }
    
    /**
     * @param name the Player's new name
     */
    void setName(String name){
        this.playerName = name;
    }
    
    /**
     * @return the Player's money
     */
    public  int getMoney() {
        return money;
    }
    
    /**
     * @param cash the Player's new money
     */
    public  void setMoney(int cash) {
        money = cash;
    }
    
    /**
     * @return the Player's ship
     */
    public  Ship getShip(){
        return ship;
    }
    
    /**
     * @param ship the Player's new ship
     */
    public void setShip(Ship ship){
        this.ship = ship;
    }
    /**
     * @return the Player's x coordinate
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * @param newX the Player's new x coordinate
     */
    public void setX(int newX){
        this.x = newX;
    }
    /**
     * @return the Player's y coordinate
     */
    public int getY() {
        return this.y;
    }
    
    /**
     * @param newY the Player's new y coordinate
     */
    public void setY(int newY){
        this.y = newY;
    }
    
    /**
     * @return a String containing the Player's information
     */
    @Override
    public String toString(){
        return "Name: " + playerName + "\nPilot Skill: " + pilotSkill
                + "\nFighter Skill: " + fighterSkill + "\nTrader Skill: "
                + traderSkill + "\nEngineering Skill: " + engineerSkill
                + "\nMoney: " + money;
    }
}
