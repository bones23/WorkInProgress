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
    int MTLP;   //Minimum Tech Level to Produce this resource (You can't buy on planets below this level)
    int MTLU;   //Minimum Tech Level to Use this resource (You can't sell on planets below this level)
    int TTP;    //Tech Level which produces the most of this item
    int BP;     //Base Price for this resource
    int IPL;    //Price increase per tech level
    int Var;    //variance is the maximum percentage that the price can vary above or below the base
    int IE;     //Radical price increase event, when this even happens on a planet, the price may increase astronomically
    int CR;     //When this condition is present, the price of this resource is unusually low
    int ER;     //When this condition is present, the resource is expensive
    int MTL;    //Min price offered in space trade with random trader (not on a planet)
    int MTH;    //Max price offered in space trade with random trader (not on a planet)
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
}
