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
    private Button buyShip1,buyShip2,leave, fuelUpgrade, cargoUpgrade;
    @FXML
    private Label currentMoney,currentCargoSpace, fuelTankSize;
    @FXML
    private void initialize() {
        currentMoney.setText(""+game.getPlayer().getMoney());
        currentCargoSpace.setText(""+game.getShip().getBays());
        fuelTankSize.setText("" + game.getShip().getFuelTank());
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
           game.getShip().setFuelTank(25);
           //game.getShip().
           currentMoney.setText(""+game.getPlayer().getMoney());
           currentCargoSpace.setText(""+game.getShip().getBays());
           //refreshMarketplace();
          // WelcomeScreenController.mc.refreshMarketplace();
          // game.MapController.refreshMarketPlace();
          
    }
 
    }
    
    @FXML
    private void buyShip2() throws IOException{
        if(game.getPlayer().getMoney()>10000&&game.getShip().getBays()<20){
            game.getPlayer().setMoney(game.getPlayer().getMoney() - 10000);
            game.getShip().setFuelTank(25);
            game.getShip().setFuel(game.getShip().getFuelTank());
            game.getShip().setBays(20);
            TradeItem[] temp = new TradeItem[game.getShip().getBays()];
            TradeItem[] current = game.getShip().getCargoManifest();
            for (int i = 0; i < game.getShip().getOccupiedSlots(); i ++) {
                temp[i] = current[i];
            }
            game.getShip().setCargoManifest(temp);
            currentMoney.setText(""+game.getPlayer().getMoney());           
            fuelTankSize.setText("" + game.getShip().getFuelTank());
            currentCargoSpace.setText(""+game.getShip().getBays());
        }
    }
    @FXML
    private void buyFuelUpgrade() throws IOException{
        if (game.getPlayer().getMoney() > 500 && game.getShip().getFuelTank() < 20) {
            game.getPlayer().setMoney(game.getPlayer().getMoney() - 200);
            game.getShip().setFuelTank(game.getShip().getFuelTank() + 1);
            currentMoney.setText(""+game.getPlayer().getMoney());           
            fuelTankSize.setText("" + game.getShip().getFuelTank());
            game.getShip().setFuel(game.getShip().getFuelTank());
        }
    }
    
    @FXML
    private void buyCargoUpgrade() throws IOException{
        if (game.getPlayer().getMoney() > 1000 && game.getShip().getBays() < 19) {
            game.getPlayer().setMoney(game.getPlayer().getMoney() - 1000);
            game.getShip().setBays(game.getShip().getBays() + 2);
            currentMoney.setText(""+game.getPlayer().getMoney());
            currentCargoSpace.setText(""+game.getShip().getBays());
            TradeItem[] temp = new TradeItem[game.getShip().getBays()];
            TradeItem[] current = game.getShip().getCargoManifest();
            for (int i = 0; i < game.getShip().getOccupiedSlots(); i ++) {
                temp[i] = current[i];
            }
            game.getShip().setCargoManifest(temp);
        }
    }
}
