package model;
import java.io.Serializable;

/**
 *
 * @author frenc_000
 */

public class TradeItem implements Serializable {
    //CHECKSTYLE: OFF
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
    private String name;

    private final int WATER_BP = 30;
    private final int WATER_IPL = 3;
    private final int WATER_VAR = 4;
    private final int WATER_MTL = 30;
    private final int WATER_MTH = 50;

    private final int FURS_BP = 250;
    private final int FURS_IPL = 10;
    private final int FURS_VAR = 10;
    private final int FURS_MTL = 230;
    private final int FURS_MTH = 280;

    private final int FOOD_BP = 100;
    private final int FOOD_IPL = 5;
    private final int FOOD_VAR = 5;
    private final int FOOD_MTL = 90;
    private final int FOOD_MTH = 160;

    private final int ORE_TTP = 3;
    private final int ORE_BP = 350;
    private final int ORE_IPL = 20;
    private final int ORE_VAR = 10;
    private final int ORE_MTL = 350;
    private final int ORE_MTH = 420;

    private final int GAMES_MTLP = 3;
    private final int GAMES_TTP = 6;
    private final int GAMES_BP = 250;
    private final int GAMES_IPL = -10;
    private final int GAMES_VAR = 5;
    private final int GAMES_MTL = 160;
    private final int GAMES_MTH = 270;

    private final int FIREARMS_MTLP = 3;
    private final int FIREARMS_TTP = 5;
    private final int FIREARMS_BP = 1250;
    private final int FIREARMS_IPL = -75;
    private final int FIREARMS_VAR = 100;
    private final int FIREARMS_MTL = 600;
    private final int FIREARMS_MTH = 1100;

    private final int MEDICINE_MTLP = 4;
    private final int MEDICINE_TTP = 6;
    private final int MEDICINE_BP = 650;
    private final int MEDICINE_IPL = -20;
    private final int MEDICINE_VAR = 10;
    private final int MEDICINE_MTL = 400;
    private final int MEDICINE_MTH = 700;

    private final int MACHINES_MTLP = 4;
    private final int MACHINES_MTLU = 3;
    private final int MACHINES_TTP = 5;
    private final int MACHINES_BP = 900;
    private final int MACHINES_IPL = -30;
    private final int MACHINES_VAR = 50;
    private final int MACHINES_MTL = 600;
    private final int MACHINES_MTH = 800;

    private final int NARCOTICS_MTLP = 5;
    private final int NARCOTICS_TTP = 5;
    private final int NARCOTICS_BP = 3500;
    private final int NARCOTICS_IPL = -125;
    private final int NARCOTICS_VAR = 150;
    private final int NARCOTICS_MTL = 2000;
    private final int NARCOTICS_MTH = 3000;

    private final int ROBOTS_MTLP = 6;
    private final int ROBOTS_MTLU = 4;
    private final int ROBOTS_TTP = 7;
    private final int ROBOTS_BP = 5000;
    private final int ROBOTS_IPL = -150;
    private final int ROBOTS_VAR = 100;
    private final int ROBOTS_MTL = 3500;
    private final int ROBOTS_MTH = 5000;
    //CHECKSTYLE: ON

    /**
     * Create a TradeItem.
     * @param item the name of the item
     */
    public TradeItem(final String item) {

        this.name = item;
        String never = "never";
        switch(item) {
            case "Water":
                this.MTLP = 0;
                this.MTLU = 0;
                this.TTP = 2;
                this.BP = WATER_BP;
                this.IPL = WATER_IPL;
                this.Var = WATER_VAR;
                this.IE = "DROUGHT";
                this.CR = "LOTSOFWATER";
                this.ER = "DESERT";
                this.MTL = WATER_MTL;
                this.MTH = WATER_MTH;
                this.illegal = false;
                break;
            case "Furs":
                this.MTLP = 0;
                this.MTLU = 0;
                this.TTP = 0;
                this.BP = FURS_BP;
                this.IPL = FURS_IPL;
                this.Var = FURS_VAR;
                this.IE = "COLD";
                this.CR = "RICHFAUNA";
                this.ER = "LIFELESS";
                this.MTL = FURS_MTL;
                this.MTH = FURS_MTH;
                this.illegal = false;
                break;
            case "Food":
                this.MTLP = 1;
                this.MTLU = 0;
                this.TTP = 1;
                this.BP = FOOD_BP;
                this.IPL = FOOD_IPL;
                this.Var = FOOD_VAR;
                this.IE = "CROPFAIL";
                this.CR = "RICHSOIL";
                this.ER = "POORSOIL";
                this.MTL = FOOD_MTL;
                this.MTH = FOOD_MTH;
                this.illegal = false;
                break;
            case "Ore":
                this.MTLP = 2;
                this.MTLU = 2;
                this.TTP = ORE_TTP;
                this.BP = ORE_BP;
                this.IPL = ORE_IPL;
                this.Var = ORE_VAR;
                this.IE = "WAR";
                this.CR = "MINERALRICH";
                this.ER = "MINERALPOOR";
                this.MTL = ORE_MTL;
                this.MTH = ORE_MTH;
                this.illegal = false;
                break;
            case "Games":
                this.MTLP = GAMES_MTLP;
                this.MTLU = 1;
                this.TTP = GAMES_TTP;
                this.BP = GAMES_BP;
                this.IPL = GAMES_IPL;
                this.Var = GAMES_VAR;
                this.IE = "BOREDOM";
                this.CR = "ARTISTIC";
                this.ER = never;
                this.MTL = GAMES_MTL;
                this.MTH = GAMES_MTH;
                this.illegal = false;
                break;
            case "Firearms":
                this.MTLP = FIREARMS_MTLP;
                this.MTLU = 1;
                this.TTP = FIREARMS_TTP;
                this.BP = FIREARMS_BP;
                this.IPL = FIREARMS_IPL;
                this.Var = FIREARMS_VAR;
                this.IE = "WAR";
                this.CR = "WARLIKE";
                this.ER = never;
                this.MTL = FIREARMS_MTL;
                this.MTH = FIREARMS_MTH;
                this.illegal = true;
                break;
            case "Medicine":
                this.MTLP = MEDICINE_MTLP;
                this.MTLU = 1;
                this.TTP = MEDICINE_TTP;
                this.BP = MEDICINE_BP;
                this.IPL = MEDICINE_IPL;
                this.Var = MEDICINE_VAR;
                this.IE = "PLAGUE";
                this.CR = "LOTSOFHERBS";
                this.ER = never;
                this.MTL = MEDICINE_MTL;
                this.MTH = MEDICINE_MTH;
                this.illegal = false;
                break;
            case "Machines":
                this.MTLP = MACHINES_MTLP;
                this.MTLU = MACHINES_MTLU;
                this.TTP = MACHINES_TTP;
                this.BP = MACHINES_BP;
                this.IPL = MACHINES_IPL;
                this.Var = MACHINES_VAR;
                this.IE = "LACKOFWORKERS";
                this.CR = never;
                this.ER = never;
                this.MTL = MACHINES_MTL;
                this.MTH = MACHINES_MTH;
                this.illegal = false;
                break;
            case "Narcotics":
                this.MTLP = NARCOTICS_MTLP;
                this.MTLU = 0;
                this.TTP = NARCOTICS_TTP;
                this.BP = NARCOTICS_BP;
                this.IPL = NARCOTICS_IPL;
                this.Var = NARCOTICS_VAR;
                this.IE = "BOREDOM";
                this.CR = "WEIRDMUSHROOMS";
                this.ER = "Never";
                this.MTL = NARCOTICS_MTL;
                this.MTH = NARCOTICS_MTH;
                this.illegal = true;
                break;
            case "Robots":
                this.MTLP = ROBOTS_MTLP;
                this.MTLU = ROBOTS_MTLU;
                this.TTP = ROBOTS_TTP;
                this.BP = ROBOTS_BP;
                this.IPL = ROBOTS_IPL;
                this.Var = ROBOTS_VAR;
                this.IE = "LACKOFWORKERS";
                this.CR = "Never";
                this.ER = "Never";
                this.MTL = ROBOTS_MTL;
                this.MTH = ROBOTS_MTH;
                this.illegal = false;
                break;
            default:break;
        }
    }

    /**
     * @return the MTLP
     */
    public final int getMTLP() {
        return this.MTLP;
    }

    /**
     * @return the MTLU
     */
    public final int getMTLU() {
        return this.MTLU;
    }

    /**
     * @return the TTP
     */
    public final int getTTP() {
        return this.TTP;
    }

    /**
     * @return the BP
     */
    public final int getBP() {
        return this.BP;
    }

    /**
     * @return the IPL
     */
    public final int getIPL() {
        return this.IPL;
    }

    /**
     * @return the Var
     */
    public final int getVar() {
        return this.Var;
    }

    /**
     * @return the IE
     */
    public final String getIE() {
        return this.IE;
    }

    /**
     * @return the CR
     */
    public final String getCR() {
        return this.CR;
    }

    /**
     * @return the ER
     */
    public final String getER() {
        return this.ER;
    }

    /**
     * @return the MTL
     */
    public final int getMTL() {
        return this.MTL;
    }

    /**
     * @return the MTH
     */
    public final int getMTH() {
        return this.MTH;
    }

    /**
     * @return illegal
     */
    public final boolean getIllegal() {
        return this.illegal;
    }

    /**
     * @return the name
     */
    public final String getName() {
        return this.name;
    }
}
