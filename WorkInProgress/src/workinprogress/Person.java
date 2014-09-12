/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package workinprogress;

/**
 *
 * @author frenc_000
 */
public class Person {
    private int pilotSkill;
    private int fighterSkill;
    private int traderSkill;
    private int engineerSkill;
    private String playerName;
    
    public Person(String name, int[] skills){
        this.pilotSkill = skills[0];
        this.fighterSkill = skills[1];
        this.traderSkill = skills[2];
        this.engineerSkill = skills[3];
        this.playerName = name;
    }
    public Person(int[] skills){
        this("Kirk", skills);
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
}
