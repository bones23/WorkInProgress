/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import controller.*;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Game;
import model.Ship;
import model.TradeItem;

/**
 *
 * @author dblake
 */
public class ShipYardController  {
    Game game = WelcomeScreenController.game;
    @FXML
    private Button buyShip1,buyShip2,leave;
    @FXML
    private Label currentMoney,currentCargoSpace;
    @FXML
    private void initialize() {
        currentMoney.setText(""+game.getPlayer().getMoney());
        currentCargoSpace.setText(""+game.getShip().getBays());
    }
    /**
     * Changes the current scene from the ShipYard to the GameScreen
     * @throws IOException 
     */
    @FXML
    private void leave() throws IOException{
         AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/GameScreen.fxml"));
           Scene scene = new Scene(pane);
           Stage stage;
            stage = WelcomeScreenController.stage;
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setWidth(975);
            stage.setHeight(800);
            stage.show();
    }/**
     * Checks if player has enough money to buy new ship
     * if so, the cost of ship is subtacted from the player's money
     * @throws IOException 
     */
    @FXML
    private void buyShip() throws IOException{
       if(game.getPlayer().getMoney()>5000&&game.getShip().getBays()<14){
           game.getPlayer().setMoney(game.getPlayer().getMoney()-5000);
           TradeItem[] temp=game.getShip().getCargoManifest();
           int cargoNum=game.getShip().getOccupiedSlots();
           game.setShipUp();
           game.getShip().setCargoManifest(temp);
           game.getShip().setOccupiedSlots(cargoNum);
           //game.getShip().
           currentMoney.setText(""+game.getPlayer().getMoney());
        currentCargoSpace.setText(""+game.getShip().getBays());
           //refreshMarketplace();
          // WelcomeScreenController.mc.refreshMarketplace();
          // game.MapController.refreshMarketPlace();
          
    }
    }
}
