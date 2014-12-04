/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author frenc_000
 */
public class Mercenary {
    
    private int pilotSkill;
    private int fighterSkill;
    private int traderSkill;
    private int engineerSkill;
    private int amountCharged;
    
    public Mercenary(final String name, final int pSkill, final int fSkill, final int tSkill, final int eSkill, final int charge) {
        this.pilotSkill = pSkill;
        this.fighterSkill = fSkill;
        this.traderSkill = tSkill;
        this.engineerSkill = eSkill;
        this.amountCharged = charge;
    }
    public int getPilotSkill(){
        return pilotSkill;
    }
    public int getFighterSkill(){
        return fighterSkill;
    }
    public int getTraderSkill(){
        return traderSkill;        
    }
    public int getEngineerSkill(){
        return engineerSkill;
    }
    public int getAmountCharged(){
        return amountCharged;
    }
    
    public boolean equals(Mercenary other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Mercenary)) {
            return false;
        }
        Mercenary that = (Mercenary) other;
        
        if (this.amountCharged != that.amountCharged) {
            return false;
        }
            
        return true;
    }
}
