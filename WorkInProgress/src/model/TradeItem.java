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
    private String IE;     //Radical price increase event, when this even happens on a planet, the price may increase astronomically
    private String CR;     //When this condition is present, the price of this resource is unusually low
    private String ER;     //When this condition is present, the resource is expensive
    private int MTL;    //Min price offered in space trade with random trader (not on a planet)
    private int MTH;    //Max price offered in space trade with random trader (not on a planet)
    private boolean illegal; //Whether this resource is illegal
    TradeItem(String item){
        switch(item){
            case "Water":
                this.MTLP = 0;
                this.MTLU = 0;
                this.TTP = 2;
                this.BP = 30;
                this.IPL = 3;
                this.Var = 4;
                this.IE = "DROUGHT";
                this.CR = "LOTSOFWATER";
                this.ER = "DESERT";
                this.MTL = 30;
                this.MTH = 50;
                this.illegal = false;
            case "Furs":
                this.MTLP = 0;
                this.MTLU = 0;
                this.TTP = 0;
                this.BP = 250;
                this.IPL = 10;
                this.Var = 10;
                this.IE = "COLD";
                this.CR = "RICHFAUNA";
                this.ER = "LIFELESS";
                this.MTL = 230;
                this.MTH = 280;
                this.illegal = false;
            case "Food":
                this.MTLP = 1;
                this.MTLU = 0;
                this.TTP = 1;
                this.BP = 100;
                this.IPL = 5;
                this.Var = 5;
                this.IE = "CROPFAIL";
                this.CR = "RICHSOIL";
                this.ER = "POORSOIL";
                this.MTL = 90;
                this.MTH = 160;
                this.illegal = false;
            case "Ore":
                this.MTLP = 2;
                this.MTLU = 2;
                this.TTP = 3;
                this.BP = 350;
                this.IPL = 20;
                this.Var = 10;
                this.IE = "WAR";
                this.CR = "MINERALRICH";
                this.ER = "MINERALPOOR";
                this.MTL = 350;
                this.MTH = 420;
                this.illegal = false;
            case "Games":
                this.MTLP = 3;
                this.MTLU = 1;
                this.TTP = 6;
                this.BP = 250;
                this.IPL = -10;
                this.Var = 5;
                this.IE = "BOREDOM";
                this.CR = "ARTISTIC";
                this.ER = "Never";
                this.MTL = 160;
                this.MTH = 270;
                this.illegal = false;
            case "Firearms":
                this.MTLP = 3;
                this.MTLU = 1;
                this.TTP = 5;
                this.BP = 1250;
                this.IPL = -75;
                this.Var = 100;
                this.IE = "WAR";
                this.CR = "WARLIKE";
                this.ER = "Never";
                this.MTL = 600;
                this.MTH = 1100;
                this.illegal = true;
            case "Medicine":
                this.MTLP = 4;
                this.MTLU = 1;
                this.TTP = 6;
                this.BP = 650;
                this.IPL = -20;
                this.Var = 10;
                this.IE = "PLAGUE";
                this.CR = "LOTSOFHERBS";
                this.ER = "Never";
                this.MTL = 400;
                this.MTH = 700;
                this.illegal = false;
            case "Machines":
                this.MTLP = 4;
                this.MTLU = 3;
                this.TTP = 5;
                this.BP = 900;
                this.IPL = -30;
                this.Var = 5;
                this.IE = "LACKOFWORKERS";
                this.CR = "Never";
                this.ER = "Never";
                this.MTL = 600;
                this.MTH = 800;
                this.illegal = false;
            case "Narcotics":
                this.MTLP = 5;
                this.MTLU = 0;
                this.TTP = 5;
                this.BP = 3500;
                this.IPL = -125;
                this.Var = 150;
                this.IE = "BOREDOM";
                this.CR = "WEIRDMUSHROOMS";
                this.ER = "Never";
                this.MTL = 2000;
                this.MTH = 3000;
                this.illegal = true;
            case "Robots":
                this.MTLP = 6;
                this.MTLU = 4;
                this.TTP = 7;
                this.BP = 5000;
                this.IPL = -150;
                this.Var = 100;
                this.IE = "LACKOFWORKERS";
                this.CR = "Never";
                this.ER = "Never";
                this.MTL = 3500;
                this.MTH = 5000;
                this.illegal = false;
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
    public String getIE() {
        return this.IE;
    }

    /**
     * @return the CR
     */
    public String getCR() {
        return this.CR;
    }

    /**
     * @return the ER
     */
    public String getER() {
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
