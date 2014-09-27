/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Person;
import model.Universe;

/**
 *
 * @author lukenewman
 */
public class MainGameController {
    @FXML
    private Stage stage;
    
    @FXML
    private Label money;
    @FXML
    private Label cargo;
    //same for all goods:
    @FXML
    private Label sellWaterPrice;
    @FXML
    private Label buyWaterPrice;
    @FXML
    private TextField sellWaterQuantity;
    @FXML
    private Button sellWaterButton;
    @FXML
    private TextField buyWaterQuantity;
    @FXML
    private Button buyWaterButton;
    //same for all goods
    private Universe universe;
    
    @FXML
    private void initialize() {
       // create the universe
       // create dummy player
       universe = new Universe();
       
       // Initialize the values in GameScreen.fxml after it is loaded
        
       String money = "" + Person.getMoney();// isn't 0 if you assign person an initial amount of money
       this.money.setText(money);
       String sellWaterPrice = "" + universe.getSolarSystemAt(0).getMarketPlace().getSellingPriceAt(0);
       this.sellWaterPrice.setText(sellWaterPrice);
       String waterInCargo = "Sell: " + "45";// did not know how to get this.
       String buyWaterPrice = "" + universe.getSolarSystemAt(0).getMarketPlace().getBuyingPriceAt(0);
       this.buyWaterPrice.setText(buyWaterPrice);
    }
    
    @FXML
    private void sellWater(ActionEvent event) throws IOException {
        int amountBuying = Integer.parseInt(buyWaterQuantity.getText());
        int amountWater = universe.getSolarSystemAt(0).getMarketPlace().getAmountAt(0);
        int cost = amountBuying * universe.getSolarSystemAt(0).getMarketPlace().getBuyingPriceAt(0);
        if (amountWater >= amountBuying && Person.getMoney() >= cost) {
            
        }
    }
    
    @FXML
    private void buyWater(ActionEvent event) throws IOException {
        System.out.println("buy some water");
    }
}
