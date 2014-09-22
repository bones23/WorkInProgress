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

public class TradeItem {
    private int MTLP;   //Minimum Tech Level to Produce this resource (You can't buy on planets below this level)
    private int MTLU;   //Minimum Tech Level to Use this resource (You can't sell on planets below this level)
    private int TTP;    //Tech Level which produces the most of this item
    private int BP;     //Base Price for this resource
    private int IPL;    //Price increase per tech level
    private int Var;    //variance is the maximum percentage that the price can vary above or below the base
    private int IE;     //Radical price increase event, when this even happens on a planet, the price may increase astronomically
    private int CR;     //When this condition is present, the price of this resource is unusually low
    private int ER;     //When this condition is present, the resource is expensive
    private int MTL;    //Min price offered in space trade with random trader (not on a planet)
    private int MTH;    //Max price offered in space trade with random trader (not on a planet)
    TradeItem(String item){
        switch(item){
            case "Water":
                this.MTLP = 0;
                this.MTLU = 0;
                this.TTP = 2;
                this.BP = 30;
            case "Furs":
                this.MTLP = 0;
                this.MTLU = 0;
        }
    }

    /**
     * @return the MTLP
     */
    public int getMTLP() {
        return this.MTLP;
    }

    /**
     * @return the MTLU
     */
    public int getMTLU() {
        return this.MTLU;
    }

    /**
     * @return the TTP
     */
    public int getTTP() {
        return this.TTP;
    }

    /**
     * @return the BP
     */
    public int getBP() {
        return this.BP;
    }

    /**
     * @return the IPL
     */
    public int getIPL() {
        return this.IPL;
    }

    /**
     * @return the Var
     */
    public int getVar() {
        return this.Var;
    }

    /**
     * @return the IE
     */
    public int getIE() {
        return this.IE;
    }

    /**
     * @return the CR
     */
    public int getCR() {
        return this.CR;
    }

    /**
     * @return the ER
     */
    public int getER() {
        return this.ER;
    }

    /**
     * @return the MTL
     */
    public int getMTL() {
        return this.MTL;
    }

    /**
     * @return the MTH
     */
    public int getMTH() {
        return this.MTH;
    }

    
}
