package model;

/**
 *
 * @author CodyMFFries
 */
public class Person {
    private int pilotSkill;
    private int fighterSkill;
    private int traderSkill;
    private int engineerSkill;
    private String playerName;
    private int money=10000000;
    private Ship ship;
    private int x;
    private int y;
    
    public Person(String name, int pSkill, int fSkill, int tSkill, int eSkill){
        this.pilotSkill = pSkill;
        this.fighterSkill = fSkill;
        this.traderSkill = tSkill;
        this.engineerSkill = eSkill;
        this.playerName = name;
        this.ship = new Ship("Flea", name, 14, 10);
        this.money=1000000;
    }
    public Person(int pSkill, int fSkill, int tSkill, int eSkill){
        this("Kirk", pSkill, fSkill, tSkill, eSkill);
    }
    public int getPilotSkill(){
        return pilotSkill;
    }
    public void setPilotSkill(int newPilot){
        pilotSkill = newPilot;
    }
    public int getFighterSkill(){
        return fighterSkill;
    }
    public void setFighterSkill(int newFighter){
        fighterSkill = newFighter;
    }
    public int getTraderSkill(){
        return traderSkill;
    }
    public void setTraderSkill(int newTrader){
        traderSkill = newTrader;
    }
    public  int getEngineerSkill(){
        return engineerSkill;
    }
    public void setEngineerSkill(int newEngineer){
        engineerSkill = newEngineer;
    }
    String getName(){
        return this.playerName;
    }
    void setName(String name){
        this.playerName = name;
    }
    
    public  void setMoney(int cash) {
        money = cash;
    }
    
    public  int getMoney() {
        return money;
    }
    public  Ship getShip(){
        return ship;
    }
    /**
     * @return the x
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * @return the y
     */
    public int getY() {
        return this.y;
    }
    public void setX(int newX){
        this.x = newX;
    }
    public void setY(int newY){
        this.y = newY;
    }
    @Override
    public String toString(){
        return "Name: " + playerName + "\nPilot Skill: " + pilotSkill + "\nFighter Skill: " + fighterSkill + "\nTrader Skill: " + traderSkill + "\nEngineering Skill: " + engineerSkill;
    }
}
