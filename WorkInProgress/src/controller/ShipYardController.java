/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Game;
import model.TradeItem;

/**
 *
 * @author dblake
 */
public class ShipYardController  {
    //CHECKSTYLE: OFF
    Game game = WelcomeScreenController.game;
    @FXML
    private Button buyShip1,buyShip2,leave, fuelUpgrade, cargoUpgrade,
            weaponUpgrade, buyBlackHole;
    @FXML
    private Label currentMoney,currentCargoSpace, fuelTankSize, weaponLabel1
            , weaponLabel2, weaponLabel3, healthLabel, damageLabel, shieldLabel,
            repairCost, shieldRefillCost, holeLabel1, holeLabel2, holeLabel3,
            specialPower;
    private final int STAGE_WIDTH = 960;
    private final int STAGE_HEIGHT = 565;
    private final int blackHoleCost = 10000;
    //CHECKSTYLE: ON

    /**
     * Start the ShipYard.
     */
    @FXML
    private void initialize() {
        healthLabel.setText("" + game.getShip().getHealth());
        damageLabel.setText("" + game.getShip().getAttackDamage());
        shieldLabel.setText("" + game.getShip().getShields());
        currentMoney.setText("" + game.getPlayer().getMoney());
        repairCost.setText("" + game.getShip().repairCost());
        currentCargoSpace.setText("" + game.getShip().getBays());
        fuelTankSize.setText("" + game.getShip().getFuelTank());
        shieldRefillCost.setText("" + game.getShip().refillShieldCost());
        specialPower.setText("Nothing");
        if (game.getCurrentSystem().getTechLevel() < 6) {
            weaponLabel1.setVisible(false);
            weaponLabel2.setVisible(false);
            weaponLabel3.setVisible(false);
            weaponUpgrade.setVisible(false);
            holeLabel3.setVisible(false);
            holeLabel2.setVisible(false);
            holeLabel1.setVisible(false);
            buyBlackHole.setVisible(false);
                  
        }
    }
    /**
     * Changes the current scene from the ShipYard to the GameScreen.
     * @throws IOException A
     */
    @FXML
    private void leave() throws IOException {
         AnchorPane pane = FXMLLoader
                 .load(getClass().getResource("/view/Ship.fxml"));
           Scene scene = new Scene(pane);
           Stage stage;
            stage = WelcomeScreenController.stage;
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setWidth(STAGE_WIDTH);
            stage.setHeight(STAGE_HEIGHT);
            stage.show();
    }

    /**
     * Checks if player has enough money to buy new ship and
     * if so, the cost of ship is subtracted from the player's money.
     * @throws IOException a
     */
    @FXML
    private void buyShip() throws IOException {
       if (game.getPlayer().getMoney() > 5000
               && game.getShip().getBays() < 14) {
           game.getPlayer().setMoney(game.getPlayer().getMoney() - 5000);
           TradeItem[] temp = game.getShip().getCargoManifest();
           int cargoNum = game.getShip().getOccupiedSlots();
           game.setShipUp();
           game.getShip().setCargoManifest(temp);
           game.getShip().setOccupiedSlots(cargoNum);
           game.getShip().setFuelTank(25);
           //game.getShip().
           currentMoney.setText("" + game.getPlayer().getMoney());
           currentCargoSpace.setText("" + game.getShip().getBays());
           //refreshMarketplace();
          // WelcomeScreenController.mc.refreshMarketplace();
          // game.MapController.refreshMarketPlace();
        }
    }

    /**
     * Buy a Ship         2.
     * @throws IOException a
     */
    @FXML
    private void buyShip2() throws IOException {
        if (game.getPlayer().getMoney() > 10000 && game.getShip()
                .getBays() < 20) {
            game.getPlayer().setMoney(game.getPlayer().getMoney() - 10000);
            game.getShip().setFuelTank(25);
            game.getShip().setFuel(game.getShip().getFuelTank());
            game.getShip().setBays(20);
            TradeItem[] temp = new TradeItem[game.getShip().getBays()];
            TradeItem[] current = game.getShip().getCargoManifest();
            for (int i = 0; i < game.getShip().getOccupiedSlots(); i++) {
                temp[i] = current[i];
            }
            game.getShip().setCargoManifest(temp);
            currentMoney.setText("" + game.getPlayer().getMoney());
            fuelTankSize.setText("" + game.getShip().getFuelTank());
            currentCargoSpace.setText("" + game.getShip().getBays());
        }
    }

    /**
     * Buy fuel upgrade.
     * @throws IOException a
     */
    @FXML
    private void buyFuelUpgrade() throws IOException {
        if (game.getPlayer().getMoney() > 500 && game.getShip()
                .getFuelTank() < 20) {
            game.getPlayer().setMoney(game.getPlayer().getMoney() - 200);
            game.getShip().setFuelTank(game.getShip().getFuelTank() + 1);
            currentMoney.setText("" + game.getPlayer().getMoney());
            fuelTankSize.setText("" + game.getShip().getFuelTank());
            game.getShip().setFuel(game.getShip().getFuelTank());
        }
    }

    /**
     * Buy cargo upgrade.
     * @throws IOException a
     */
    @FXML
    private void buyCargoUpgrade() throws IOException {
        if (game.getPlayer().getMoney() > 1000 && game.getShip()
                .getBays() < 19) {
            game.getPlayer().setMoney(game.getPlayer().getMoney() - 1000);
            game.getShip().setBays(game.getShip().getBays() + 2);
            currentMoney.setText("" + game.getPlayer().getMoney());
            currentCargoSpace.setText("" + game.getShip().getBays());
            TradeItem[] temp = new TradeItem[game.getShip().getBays()];
            TradeItem[] current = game.getShip().getCargoManifest();
            for (int i = 0; i < game.getShip().getOccupiedSlots(); i++) {
                temp[i] = current[i];
            }
            game.getShip().setCargoManifest(temp);
        }
    }

    @FXML
    private void buyWeaponUpgrade() throws IOException {
        if (game.getPlayer().getMoney() > 1000) {
            game.getPlayer().setMoney(game.getPlayer().getMoney() - 1000);
            damageLabel.setText("" + game.getShip().addDamage());
            currentMoney.setText("" + game.getPlayer().getMoney());
            damageLabel.setText("" + game.getShip().getAttackDamage());
        }
    }
    
    @FXML
    private void repairShip() throws IOException {
        if (game.getShip().getHealth() < 100
                && game.getPlayer().getMoney() > game.getShip().repairCost()) {
            game.getPlayer().setMoney(game.getPlayer().getMoney()
                    - game.getShip().repairCost());
            game.getShip().setHealth(100);
            currentMoney.setText("" + game.getPlayer().getMoney());
            repairCost.setText("" + game.getShip().repairCost());
            healthLabel.setText("" + game.getShip().getHealth());
        }
    }
    
    @FXML
    private void refillShields() throws IOException {
        if (game.getPlayer().getMoney() > game.getShip().refillShieldCost()) {
            game.getPlayer().setMoney(game.getPlayer().getMoney()
                    - game.getShip().refillShieldCost());
            shieldLabel.setText("" + game.getShip().getMaxShields());
            game.getShip().refillShield();
            currentMoney.setText("" + game.getPlayer().getMoney());
            shieldRefillCost.setText("" + game.getShip().refillShieldCost());
        }
    }
    
    @FXML
    private void buyBlackHole() throws IOException {
        if (game.getPlayer().getMoney() > blackHoleCost
                && !game.getShip().getSpecial().equals("Black Hole")) {
            game.getPlayer().setMoney(game.getPlayer().getMoney()
                    - blackHoleCost);
            currentMoney.setText("" + game.getPlayer().getMoney());
            game.getShip().setSpecial("Black Hole");
            specialPower.setText("Black Hole");
        }
    }
}
