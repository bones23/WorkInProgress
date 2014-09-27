/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Person;
import model.Universe;
import org.controlsfx.dialog.Dialogs;
import java.util.*;

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
    @FXML
    private Label sellWaterPrice;
    @FXML
    private Label buyWaterPrice;
    @FXML
    private Button waterInCargo;
    @FXML
    private Label waterOnPlanet;
    Universe universe = new Universe();
    
     @FXML
    private void initialize() {
        // Initialize the values in GameScreen.fxml after it is loaded
       String money =(""+Person.getMoney());// isn't 0 if you assign person an initial amount of money
       this.money.setText(money);
       String sellWaterPrice = ("20");// did not know how to get this.
       this.sellWaterPrice.setText(sellWaterPrice);
       String waterInCargo = "Sell: " + "45";// did not know how to get this.
       this.waterInCargo.setText(waterInCargo);
       
    }
    
    @FXML
    private void sellWater(ActionEvent event) throws IOException {
        if(0 <= universe.getUniverse()[0].getTechLevel()){
            Person.getShip().
            System.out.println("sell some water");
        }
        
    }
}
