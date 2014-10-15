package model;

/**
 *
 * @author CodyMFFries
 */
public class Person {
    private static int pilotSkill;
    private static int fighterSkill;
    private static int traderSkill;
    private static int engineerSkill;
    private String playerName;
    private static int money=10000000;
    private static Ship ship;
    private int x;
    private int y;
    
    public Person(String name, int pSkill, int fSkill, int tSkill, int eSkill){
        this.pilotSkill = pSkill;
        this.fighterSkill = fSkill;
        this.traderSkill = tSkill;
        this.engineerSkill = eSkill;
        this.playerName = name;
        this.ship = new Ship("Flea", name, 14, 10);
    }
    public Person(int pSkill, int fSkill, int tSkill, int eSkill){
        this("Kirk", pSkill, fSkill, tSkill, eSkill);
    }
    public static int getPilotSkill(){
        return pilotSkill;
    }
    public static void setPilotSkill(int newPilot){
        pilotSkill = newPilot;
    }
    public static int getFighterSkill(){
        return fighterSkill;
    }
    public static void setFighterSkill(int newFighter){
        fighterSkill = newFighter;
    }
    public static int getTraderSkill(){
        return traderSkill;
    }
    public static void setTraderSkill(int newTrader){
        traderSkill = newTrader;
    }
    public static int getEngineerSkill(){
        return engineerSkill;
    }
    public static void setEngineerSkill(int newEngineer){
        engineerSkill = newEngineer;
    }
    String getName(){
        return this.playerName;
    }
    void setName(String name){
        this.playerName = name;
    }
    
    public static void setMoney(int cash) {
        money = cash;
    }
    
    public static int getMoney() {
        return money;
    }
    public static Ship getShip(){
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
