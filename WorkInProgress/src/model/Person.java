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
    
    public Person(String name, int pSkill, int fSkill, int tSkill, int eSkill){
        this.pilotSkill = pSkill;
        this.fighterSkill = fSkill;
        this.traderSkill = tSkill;
        this.engineerSkill = eSkill;
        this.playerName = name;
    }
    public Person(int pSkill, int fSkill, int tSkill, int eSkill){
        this("Kirk", pSkill, fSkill, tSkill, eSkill);
    }
    int getPilotSkill(){
        return pilotSkill;
    }
    void setPilotSkill(int newPilot){
        this.pilotSkill = newPilot;
    }
    int getFighterSkill(){
        return fighterSkill;
    }
    void setFighterSkill(int newFighter){
        this.fighterSkill = newFighter;
    }
    int getTraderSkill(){
        return traderSkill;
    }
    void setTraderSkill(int newTrader){
        this.traderSkill = newTrader;
    }
    int getEngineerSkill(){
        return engineerSkill;
    }
    void setEngeineerSkill(int newEngineer){
        this.engineerSkill = newEngineer;
    }
    String getName(){
        return this.playerName;
    }
    void setName(String name){
        this.playerName = name;
    }
    @Override
    public String toString(){
        return "Name: " + playerName + "\nPilot Skill: " + pilotSkill + "\nFighter Skill: " + fighterSkill + "\nTrader Skill: " + traderSkill + "\nEngineering Skill: " + engineerSkill;
    }
}
