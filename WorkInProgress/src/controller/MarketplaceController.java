/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.*;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author frenc_000
 */
public class MarketplaceController {
    //I need to call these from the game somehow
    Game game = WelcomeScreenController.game;
    MarketPlace market = game.getMarket();
    int currentLocationIndex = WelcomeScreenController.game.getCurrentLocationIndex();
    Ship ship = WelcomeScreenController.game.getShip();
    //Sell price labels
    @FXML
    private Label sellWaterPrice,sellFurPrice,sellFoodPrice,sellOrePrice,sellGamesPrice,
            sellFirearmsPrice,sellMedicinePrice,sellMachinesPrice,sellNarcoticsPrice,sellRobotsPrice;
    //Buy price labels
    @FXML
    private Label buyWaterPrice,buyFurPrice,buyFoodPrice,buyOrePrice,buyGamesPrice,buyFirearmsPrice
            ,buyMedicinePrice,buyMachinesPrice,buyNarcoticsPrice,buyRobotsPrice;
    //Sell buttons
    @FXML
    private Button s0, s1, s2, s3, s4, s5, s6, s7, s8, s9;
    //Buy buttons
    @FXML
    private Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    //Labels for sellable items
    @FXML
    private Label sellableWater, sellableFurs, sellableFood, sellableOre, sellableGames, sellableFirearms, sellableMedicine,
            sellableMachines, sellableNarcotics, sellableRobots;
    //Labels for buyable items
    @FXML
    private Label buyableWater, buyableFur, buyableFood, buyableOre, buyableGames, buyableFirearms, buyableMedicine,
            buyableMachines, buyableNarcotics, buyableRobots;
    //what the fuck do these even do?
    @FXML
    private Label temp;
    @FXML
    private Label temp2;
    @FXML
    private void buyItem(ActionEvent event) throws IOException {
        String itemName="";
        Object source = event.getSource();
        Button clickedBtn = (Button) source;
        String ite = clickedBtn.getId();
        itemName = market.buyingItem(ite, game.getUniverse(), game.getCurrentLocationIndex(), game.getShip());
        if(itemName != null){
            switch(itemName){
                case "Water":
                    temp=sellableWater;
                    temp2=buyableWater;
                    break;
                case "Furs":
                    temp=sellableFurs;
                    temp2=buyableFur;
                    break;
                case "Food":
                    temp=sellableFood;
                    temp2=buyableFood;
                    break;
                case "Ore":
                    temp=sellableOre;
                    temp2=buyableOre;
                    break;
                case "Games":
                    temp=sellableGames;
                    temp2=buyableGames;
                    break;
                case "Firearms":
                    temp=sellableFirearms;
                    temp2=buyableFirearms;
                    break;
                case "Medicine":
                    temp=sellableMedicine;
                    temp2=buyableMedicine;
                    break;
                case "Machines":
                    temp=sellableMachines;
                    temp2=buyableMachines;
                    break;
                case "Narcotics":
                    temp=sellableNarcotics;
                    temp2=buyableNarcotics;
                    break;
                case "Robots":
                    temp=sellableRobots;
                    temp2=buyableRobots;
                    break;
            }
            temp.setText(""+game.getShip().searchCargo(new TradeItem(itemName)));
            temp2.setText(""+market.getAmountAt(Integer.parseInt(ite.substring(1))));
        }            
            //subtact 1 from buyable
            //add 1 to sellable
            //need set amount in marketplace
    }
    @FXML
    private void sellItem(ActionEvent event) throws IOException {
        String itemName="";
        Object source = event.getSource();
        Button clickedBtn = (Button) source;
        String ite = clickedBtn.getId();
        itemName = market.sellingItem(ite, game.getUniverse(), game.getCurrentLocationIndex(), game.getShip());
        if(itemName != null){
            switch(itemName){
                case "Water":
                    temp=sellableWater;
                    temp2=buyableWater;
                    break;
                case "Furs":
                    temp=sellableFurs;
                    temp2=buyableFur;
                    break;
                case "Food":
                    temp=sellableFood;
                    temp2=buyableFood;
                    break;
                case "Ore":
                    temp=sellableOre;
                    temp2=buyableOre;
                    break;
                case "Games":
                    temp=sellableGames;
                    temp2=buyableGames;
                    break;
                case "Firearms":
                    temp=sellableFirearms;
                    temp2=buyableFirearms;
                    break;
                case "Medicine":
                    temp=sellableMedicine;
                    temp2=buyableMedicine;
                    break;
                case "Machines":
                    temp=sellableMachines;
                    temp2=buyableMachines;
                    break;
                case "Narcotics":
                    temp=sellableNarcotics;
                    temp2=buyableNarcotics;
                    break;
                case "Robots":
                    temp=sellableRobots;
                    temp2=buyableRobots;
                    break;
            }
            temp.setText(""+game.getShip().searchCargo(new TradeItem(itemName)));
            temp2.setText(""+market.getAmountAt(Integer.parseInt(ite.substring(1))));
            //subtract 1 from sellable
            //add 1 to buyable
        }
    }
    @FXML
    private void refreshMarketplace(){
        buyableWater.setText(""+market.getAmountAt(0));
        buyableFur.setText(""+market.getAmountAt(1));
        buyableFood.setText(""+market.getAmountAt(2));
        buyableOre.setText(""+market.getAmountAt(3));
        buyableGames.setText(""+market.getAmountAt(4));
        buyableFirearms.setText(""+market.getAmountAt(5));
        buyableMedicine.setText(""+market.getAmountAt(6));
        buyableMachines.setText(""+market.getAmountAt(7));
        buyableNarcotics.setText(""+market.getAmountAt(8));
        buyableRobots.setText(""+market.getAmountAt(9));
        int cargo =game.getShip().getSpaceLeft();
        //this should be set in ship controller
        //setText(""+game.getShip().getSpaceLeft());
        //should be set in person controller
        //setText("" + Person.getMoney());
        this.sellWaterPrice.setText("" + market.getSellingPriceAt(0));
        this.buyWaterPrice.setText("" + market.getBuyingPriceAt(0));
        this.sellFurPrice.setText("" + market.getSellingPriceAt(1));
        this.buyFurPrice.setText("" + market.getBuyingPriceAt(1));
        this.sellFoodPrice.setText("" + market.getSellingPriceAt(2));
        this.buyFoodPrice.setText("" + market.getBuyingPriceAt(2));
        this.sellOrePrice.setText("" + market.getSellingPriceAt(3));
        this.buyOrePrice.setText("" + market.getBuyingPriceAt(3));
        this.sellGamesPrice.setText("" + market.getSellingPriceAt(4));
        this.buyGamesPrice.setText("" + market.getBuyingPriceAt(4));
        this.sellFirearmsPrice.setText("" + market.getSellingPriceAt(5));
        this.buyFirearmsPrice.setText("" + market.getBuyingPriceAt(5));
        this.sellMedicinePrice.setText("" + market.getSellingPriceAt(6));
        this.buyMedicinePrice.setText("" + market.getBuyingPriceAt(6));
        this.sellMachinesPrice.setText("" + market.getSellingPriceAt(7));
        this.buyMachinesPrice.setText("" + market.getBuyingPriceAt(7));
        this.sellNarcoticsPrice.setText("" + market.getSellingPriceAt(8));
        this.buyNarcoticsPrice.setText("" + market.getBuyingPriceAt(8));
        this.sellRobotsPrice.setText("" + market.getSellingPriceAt(9));
        this.buyRobotsPrice.setText("" + market.getBuyingPriceAt(9));
    }
}
