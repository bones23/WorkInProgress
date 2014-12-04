/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.util.Random;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Game;
import model.TradeItem;
import model.Mercenary;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author dblake
 */
public class MercenariesController  {
    //CHECKSTYLE: OFF
    Game game = WelcomeScreenController.game;
    @FXML
    private Button buyShip1,buyShip2,leave, fuelUpgrade, cargoUpgrade,
            weaponUpgrade, buyBlackHole, HireMerc1, HireMerc2, HireMerc3, HireMerc4,
            FireMerc1, FireMerc2, FireMerc3, FireMerc4, FireAllMercs;
    @FXML
    private Label healthAmount, attackAmount, moneyAmount, cargoAmount, 
            tankSizeAmount, shieldAmount, 
            merc1, merc2, merc3, merc4, 
            merc4price, merc3price, merc2price, merc1price,
            merc1fighterSkill, merc2fighterSkill, merc3fighterSkill, merc4fighterSkill,
            merc1engineerSkill, merc2engineerSkill, merc3engineerSkill, merc4engineerSkill,
            merc1pilotSkill, merc2pilotSkill, merc3pilotSkill, merc4pilotSkill,
            merc1traderSkill, merc2traderSkill, merc3traderSkill, merc4traderSkill;
    private final int STAGE_WIDTH = 960;
    private final int STAGE_HEIGHT = 565;
    private final int MERC_MAX_ADDED_POINTS = 5;
    private final int MERC_MAX_PRICE = 300;
    
    private String[] firstNames = {"Otelia", "Dennis", "Jaimee", "Lynelle", 
        "Peter", "Van", "Odell", "Karmen", "Yoshie", "Tanna", "Lela", "Edra", 
        "Rosetta","Errol", "Otto", "Rosalva", "Yuriko", "Cyrus", "Kena", "Bern"};
    private String[] lastNames = {"Ater", "Wolff", "Alers", "Padillo", "Naples",
        "Colter", "Stone", "Sin", "Lobue", "Draves", "Starner", "Lunt", "Wilkin",
        "Dandridge", "Flury", "Rupert", "Cornelison", "Tarr", "Yokley"};
//CHECKSTYLE: ON

    /**
     * Start the ShipYard.
     */
    @FXML
    private void initialize() {
        healthAmount.setText("" + game.getShip().getHealth());
        attackAmount.setText("" + game.getShip().getAttackDamage());
        shieldAmount.setText("" + game.getShip().getShields());
        moneyAmount.setText("" + game.getPlayer().getMoney());
        cargoAmount.setText("" + game.getShip().getBays());
        tankSizeAmount.setText("" + game.getShip().getFuelTank());
        
        if (game.getCurrentSystem().getTechLevel()+1 > 7) {
            merc1.setText("" + randomizeName());
            merc2.setText("" + randomizeName());
            merc3.setText("" + randomizeName());
            merc4.setText("" + randomizeName());
            
            FireMerc1.setDisable(true);
            FireMerc2.setDisable(true);
            FireMerc3.setDisable(true);
            FireMerc4.setDisable(true);
            
            merc1price.setText("" + randomizeValue(MERC_MAX_PRICE));
            merc2price.setText("" + randomizeValue(MERC_MAX_PRICE));
            merc3price.setText("" + randomizeValue(MERC_MAX_PRICE));
            merc4price.setText("" + randomizeValue(MERC_MAX_PRICE));
            
            merc1fighterSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc2fighterSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc3fighterSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc4fighterSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            
            merc1engineerSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc2engineerSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc3engineerSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc4engineerSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            
            merc1pilotSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc2pilotSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc3pilotSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc4pilotSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            
            merc1traderSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc2traderSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc3traderSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc4traderSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
        }else if (game.getCurrentSystem().getTechLevel() >= 5){
            merc1.setText("" + randomizeName());
            merc2.setText("" + randomizeName());
            merc3.setText("" + randomizeName());
            
            FireMerc1.setDisable(true);
            FireMerc2.setDisable(true);
            FireMerc3.setDisable(true);
            
            merc1price.setText("" + randomizeValue(MERC_MAX_PRICE));
            merc2price.setText("" + randomizeValue(MERC_MAX_PRICE));
            merc3price.setText("" + randomizeValue(MERC_MAX_PRICE));
            
            merc1fighterSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc2fighterSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc3fighterSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            
            merc1engineerSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc2engineerSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc3engineerSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            
            merc1pilotSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc2pilotSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc3pilotSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            
            merc1traderSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc2traderSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc3traderSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
        }else{
            merc1.setText("" + randomizeName());
            merc2.setText("" + randomizeName());
            
            FireMerc1.setDisable(true);
            FireMerc2.setDisable(true);
            
            merc1price.setText("" + randomizeValue(MERC_MAX_PRICE));
            merc2price.setText("" + randomizeValue(MERC_MAX_PRICE));
            
            merc1fighterSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc2fighterSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            
            merc1engineerSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc2engineerSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            
            merc1pilotSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc2pilotSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            
            merc1traderSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
            merc2traderSkill.setText("" + randomizeValue(MERC_MAX_ADDED_POINTS));
        }
        if(game.ship.getMercs().size() <= 0)
            FireAllMercs.setDisable(true);
    }
    @FXML
    private String randomizeName(){
        Random rand = new Random();
        return firstNames[rand.nextInt(firstNames.length)] 
                + " " + lastNames[rand.nextInt(lastNames.length)];
    }
    @FXML
    private int randomizeValue(int value){
        Random rand = new Random();
        return rand.nextInt(value);
    }
    @FXML
    private void hireMerc1(){
        //create mercenary object
        int merc1fSkill, merc1pSkill, merc1tSkill, merc1eSkill, merc1charge;
        merc1fSkill = Integer.parseInt(merc1fighterSkill.getText());
        merc1pSkill = Integer.parseInt(merc1pilotSkill.getText());
        merc1tSkill = Integer.parseInt(merc1traderSkill.getText());
        merc1eSkill = Integer.parseInt(merc1engineerSkill.getText());
        merc1charge = Integer.parseInt(merc1price.getText());
        Mercenary merc1object = new Mercenary(merc1.getText(), merc1pSkill, 
                merc1fSkill, merc1tSkill, 
                merc1eSkill, merc1charge);
        //add object to player's list of people within their ship
        if(game.ship.addMerc(merc1object) == false){
            //display error message that ship is full
            Dialogs.create()
            .owner(WelcomeScreenController.stage)
            .title("Barracks Full")
            .masthead(null)
            .message("Your barracks are full! You can't hire anymore mercenaries.")
            .showInformation();
        }else{
            //if merc is added do these things:
            //add merc's skill points to player's points
            game.player.addMercPoints(merc1object);
            attackAmount.setText("" + game.getShip().getAttackDamage());
            HireMerc1.setDisable(true);
            FireMerc1.setDisable(false);
            FireAllMercs.setDisable(false);
        }
    }
    @FXML
    private void hireMerc2(){
        //create mercenary object
        int merc2fSkill, merc2pSkill, merc2tSkill, merc2eSkill, merc2charge;
        merc2fSkill = Integer.parseInt(merc2fighterSkill.getText());
        merc2pSkill = Integer.parseInt(merc2pilotSkill.getText());
        merc2tSkill = Integer.parseInt(merc2traderSkill.getText());
        merc2eSkill = Integer.parseInt(merc2engineerSkill.getText());
        merc2charge = Integer.parseInt(merc2price.getText());
        Mercenary merc2object = new Mercenary(merc2.getText(), merc2pSkill, 
                merc2fSkill, merc2tSkill, 
                merc2eSkill, merc2charge);
        //add object to player's list of people within their ship
        if(game.ship.addMerc(merc2object) == false){
            //display error message that ship is full
            Dialogs.create()
            .owner(WelcomeScreenController.stage)
            .title("Barracks Full")
            .masthead(null)
            .message("Your barracks are full! You can't hire anymore mercenaries.")
            .showInformation();
        }else{
            //if merc is added do these things:
            //add merc's skill points to player's points
            game.player.addMercPoints(merc2object);
            attackAmount.setText("" + game.getShip().getAttackDamage());
            HireMerc2.setDisable(true);
            FireMerc2.setDisable(false);
            FireAllMercs.setDisable(false);
        }
    }
    @FXML
    private void hireMerc3(){
        //create mercenary object
        int merc3fSkill, merc3pSkill, merc3tSkill, merc3eSkill, merc3charge;
        merc3fSkill = Integer.parseInt(merc3fighterSkill.getText());
        merc3pSkill = Integer.parseInt(merc3pilotSkill.getText());
        merc3tSkill = Integer.parseInt(merc3traderSkill.getText());
        merc3eSkill = Integer.parseInt(merc3engineerSkill.getText());
        merc3charge = Integer.parseInt(merc3price.getText());
        Mercenary merc3object = new Mercenary(merc3.getText(), merc3pSkill, 
                merc3fSkill, merc3tSkill, 
                merc3eSkill, merc3charge);
        //add object to player's list of people within their ship
        if(game.ship.addMerc(merc3object) == false){
            //display error message that ship is full
            Dialogs.create()
            .owner(WelcomeScreenController.stage)
            .title("Barracks Full")
            .masthead(null)
            .message("Your barracks are full! You can't hire anymore mercenaries.")
            .showInformation();
        }else{
            //if merc is added do these things:
            //add merc's skill points to player's points
            game.player.addMercPoints(merc3object);
            attackAmount.setText("" + game.getShip().getAttackDamage());
            HireMerc3.setDisable(true);
            FireMerc3.setDisable(false);
            FireAllMercs.setDisable(false);
        }
    }
    @FXML
    private void hireMerc4(){
        //create mercenary object
        int merc4fSkill, merc4pSkill, merc4tSkill, merc4eSkill, merc4charge;
        merc4fSkill = Integer.parseInt(merc4fighterSkill.getText());
        merc4pSkill = Integer.parseInt(merc4pilotSkill.getText());
        merc4tSkill = Integer.parseInt(merc4traderSkill.getText());
        merc4eSkill = Integer.parseInt(merc4engineerSkill.getText());
        merc4charge = Integer.parseInt(merc4price.getText());
        Mercenary merc4object = new Mercenary(merc4.getText(), merc4pSkill, 
                merc4fSkill, merc4tSkill, 
                merc4eSkill, merc4charge);
        //add object to player's list of people within their ship
        if(game.ship.addMerc(merc4object) == false){
            //display error message that ship is full
            Dialogs.create()
            .owner(WelcomeScreenController.stage)
            .title("Barracks Full")
            .masthead(null)
            .message("Your barracks are full! You can't hire anymore mercenaries.")
            .showInformation();
        }else{
            //if merc is added do these things:
            //add merc's skill points to player's points
            attackAmount.setText("" + game.getShip().getAttackDamage());
            game.player.addMercPoints(merc4object);
            HireMerc4.setDisable(true);
            FireMerc4.setDisable(false);
            FireAllMercs.setDisable(false);
        }
    }
    /**
     * Changes the current scene from the ShipYard to the GameScreen.
     * @throws IOException A
     */
    @FXML
    private void fireAllMercs(){
        int i = game.ship.getMercs().size() - 1;
        while(game.ship.getMercs().size() != 0){
            Mercenary m = game.ship.getMercs().remove(i);
            game.player.removeMercPoints(m);
            game.ship.removeMerc(m);
            i--;
        }
        FireAllMercs.setDisable(true);
        attackAmount.setText("" + game.getShip().getAttackDamage());
    }
    @FXML
    private void fireMerc1(){
        int merc1fSkill, merc1pSkill, merc1tSkill, merc1eSkill, merc1charge;
        merc1fSkill = Integer.parseInt(merc1fighterSkill.getText());
        merc1pSkill = Integer.parseInt(merc1pilotSkill.getText());
        merc1tSkill = Integer.parseInt(merc1traderSkill.getText());
        merc1eSkill = Integer.parseInt(merc1engineerSkill.getText());
        merc1charge = Integer.parseInt(merc1price.getText());
        Mercenary merc1object = new Mercenary(merc1.getText(), merc1pSkill, 
                merc1fSkill, merc1tSkill, 
                merc1eSkill, merc1charge);
        game.ship.removeMerc(merc1object);
        game.player.removeMercPoints(merc1object);
        
        HireMerc1.setDisable(false);
        FireMerc1.setDisable(true);
        attackAmount.setText("" + game.getShip().getAttackDamage());
    }
    @FXML
    private void fireMerc2(){
        int merc2fSkill, merc2pSkill, merc2tSkill, merc2eSkill, merc2charge;
        merc2fSkill = Integer.parseInt(merc2fighterSkill.getText());
        merc2pSkill = Integer.parseInt(merc2pilotSkill.getText());
        merc2tSkill = Integer.parseInt(merc2traderSkill.getText());
        merc2eSkill = Integer.parseInt(merc2engineerSkill.getText());
        merc2charge = Integer.parseInt(merc2price.getText());
        Mercenary merc2object = new Mercenary(merc2.getText(), merc2pSkill, 
                merc2fSkill, merc2tSkill, 
                merc2eSkill, merc2charge);
        game.ship.removeMerc(merc2object);
        game.player.removeMercPoints(merc2object);
        
        HireMerc1.setDisable(false);
        FireMerc1.setDisable(true);
        attackAmount.setText("" + game.getShip().getAttackDamage());
    }
    @FXML
    private void fireMerc3(){
        int merc3fSkill, merc3pSkill, merc3tSkill, merc3eSkill, merc3charge;
        merc3fSkill = Integer.parseInt(merc3fighterSkill.getText());
        merc3pSkill = Integer.parseInt(merc3pilotSkill.getText());
        merc3tSkill = Integer.parseInt(merc3traderSkill.getText());
        merc3eSkill = Integer.parseInt(merc3engineerSkill.getText());
        merc3charge = Integer.parseInt(merc3price.getText());
        Mercenary merc3object = new Mercenary(merc3.getText(), merc3pSkill, 
                merc3fSkill, merc3tSkill, 
                merc3eSkill, merc3charge);
        game.ship.removeMerc(merc3object);
        game.player.removeMercPoints(merc3object);
        
        HireMerc1.setDisable(false);
        FireMerc1.setDisable(true);
        attackAmount.setText("" + game.getShip().getAttackDamage());
    }
    @FXML
    private void fireMerc4(){
        int merc4fSkill, merc4pSkill, merc4tSkill, merc4eSkill, merc4charge;
        merc4fSkill = Integer.parseInt(merc4fighterSkill.getText());
        merc4pSkill = Integer.parseInt(merc4pilotSkill.getText());
        merc4tSkill = Integer.parseInt(merc4traderSkill.getText());
        merc4eSkill = Integer.parseInt(merc4engineerSkill.getText());
        merc4charge = Integer.parseInt(merc4price.getText());
        Mercenary merc4object = new Mercenary(merc4.getText(), merc4pSkill, 
                merc4fSkill, merc4tSkill, 
                merc4eSkill, merc4charge);
        game.ship.removeMerc(merc4object);
        game.player.removeMercPoints(merc4object);
        
        HireMerc1.setDisable(false);
        FireMerc1.setDisable(true);
        attackAmount.setText("" + game.getShip().getAttackDamage());
    }
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
//    @FXML
//    private void buyShip() throws IOException {
//       if (game.getPlayer().getMoney() > 5000
//               && game.getShip().getBays() < 14) {
//           game.getPlayer().setMoney(game.getPlayer().getMoney() - 5000);
//           TradeItem[] temp = game.getShip().getCargoManifest();
//           int cargoNum = game.getShip().getOccupiedSlots();
//           game.setShipUp();
//           game.getShip().setCargoManifest(temp);
//           game.getShip().setOccupiedSlots(cargoNum);
//           game.getShip().setFuelTank(25);
//           //game.getShip().
//           moneyAmount.setText("" + game.getPlayer().getMoney());
//           cargoAmount.setText("" + game.getShip().getBays());
//           //refreshMarketplace();
//          // WelcomeScreenController.mc.refreshMarketplace();
//          // game.MapController.refreshMarketPlace();
//        }
//    }

    /**
     * Buy a Ship         2.
     * @throws IOException a
     */
//    @FXML
//    private void buyShip2() throws IOException {
//        if (game.getPlayer().getMoney() > 10000 && game.getShip()
//                .getBays() < 20) {
//            game.getPlayer().setMoney(game.getPlayer().getMoney() - 10000);
//            game.getShip().setFuelTank(25);
//            game.getShip().setFuel(game.getShip().getFuelTank());
//            game.getShip().setBays(20);
//            TradeItem[] temp = new TradeItem[game.getShip().getBays()];
//            TradeItem[] current = game.getShip().getCargoManifest();
//            for (int i = 0; i < game.getShip().getOccupiedSlots(); i++) {
//                temp[i] = current[i];
//            }
//            game.getShip().setCargoManifest(temp);
//            moneyAmount.setText("" + game.getPlayer().getMoney());
//            tankSizeAmount.setText("" + game.getShip().getFuelTank());
//            cargoAmount.setText("" + game.getShip().getBays());
//        }
//    }

    /**
     * Buy fuel upgrade.
     * @throws IOException a
     */
//    @FXML
//    private void buyFuelUpgrade() throws IOException {
//        if (game.getPlayer().getMoney() > 500 && game.getShip()
//                .getFuelTank() < 20) {
//            game.getPlayer().setMoney(game.getPlayer().getMoney() - 200);
//            game.getShip().setFuelTank(game.getShip().getFuelTank() + 1);
//            moneyAmount.setText("" + game.getPlayer().getMoney());
//            tankSizeAmount.setText("" + game.getShip().getFuelTank());
//            game.getShip().setFuel(game.getShip().getFuelTank());
//        }
//    }

    /**
     * Buy cargo upgrade.
     * @throws IOException a
     */
//    @FXML
//    private void buyCargoUpgrade() throws IOException {
//        if (game.getPlayer().getMoney() > 1000 && game.getShip()
//                .getBays() < 19) {
//            game.getPlayer().setMoney(game.getPlayer().getMoney() - 1000);
//            game.getShip().setBays(game.getShip().getBays() + 2);
//            moneyAmount.setText("" + game.getPlayer().getMoney());
//            cargoAmount.setText("" + game.getShip().getBays());
//            TradeItem[] temp = new TradeItem[game.getShip().getBays()];
//            TradeItem[] current = game.getShip().getCargoManifest();
//            for (int i = 0; i < game.getShip().getOccupiedSlots(); i++) {
//                temp[i] = current[i];
//            }
//            game.getShip().setCargoManifest(temp);
//        }
//    }

//    @FXML
//    private void buyWeaponUpgrade() throws IOException {
//        if (game.getPlayer().getMoney() > 1000) {
//            game.getPlayer().setMoney(game.getPlayer().getMoney() - 1000);
//            //damageLabel.setText("" + game.getShip().addDamage());
//            moneyAmount.setText("" + game.getPlayer().getMoney());
//            attackAmount.setText("" + game.getShip().getAttackDamage());
//        }
//    }
//    
//    @FXML
//    private void repairShip() throws IOException {
//        if (game.getShip().getHealth() < 100
//                && game.getPlayer().getMoney() > game.getShip().repairCost()) {
//            game.getPlayer().setMoney(game.getPlayer().getMoney()
//                    - game.getShip().repairCost());
//            game.getShip().setHealth(100);
//            moneyAmount.setText("" + game.getPlayer().getMoney());
//            //repairCost.setText("" + game.getShip().repairCost());
//            healthAmount.setText("" + game.getShip().getHealth());
//        }
//    }
    
//    @FXML
//    private void refillShields() throws IOException {
//        if (game.getPlayer().getMoney() > game.getShip().refillShieldCost()) {
//            game.getPlayer().setMoney(game.getPlayer().getMoney()
//                    - game.getShip().refillShieldCost());
//            shieldAmount.setText("" + game.getShip().getMaxShields());
//            game.getShip().refillShield();
//            moneyAmount.setText("" + game.getPlayer().getMoney());
//            shieldAmount.setText("" + game.getShip().refillShieldCost());
//        }
//    }
    
//    @FXML
//    private void buyBlackHole() throws IOException {
//        if (game.getPlayer().getMoney() > blackHoleCost
//                && !game.getShip().getSpecial().equals("Black Hole")) {
//            game.getPlayer().setMoney(game.getPlayer().getMoney()
//                    - blackHoleCost);
//            moneyAmount.setText("" + game.getPlayer().getMoney());
//            game.getShip().setSpecial("Black Hole");
//            //specialPower.setText("Black Hole");
//        }
//    }
}
