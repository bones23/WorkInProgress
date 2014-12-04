/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Game;
import model.Mercenary;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author dblake, cody, brandon, luke
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
        if (game.ship.addMerc(merc2object) == false){
            //display error message that ship is full
            Dialogs.create()
            .owner(WelcomeScreenController.stage)
            .title("Barracks Full")
            .masthead(null)
            .message("Your barracks are full! You can't hire anymore mercenaries.")
            .showInformation();
        } else {
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
        if (game.ship.addMerc(merc3object) == false){
            //display error message that ship is full
            Dialogs.create()
            .owner(WelcomeScreenController.stage)
            .title("Barracks Full")
            .masthead(null)
            .message("Your barracks are full! You can't hire anymore mercenaries.")
            .showInformation();
        } else {
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
        if (game.ship.addMerc(merc4object) == false){
            //display error message that ship is full
            Dialogs.create()
            .owner(WelcomeScreenController.stage)
            .title("Barracks Full")
            .masthead(null)
            .message("Your barracks are full! You can't hire anymore mercenaries.")
            .showInformation();
        } else {
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
        while (game.ship.getMercs().size() != 0){
            Mercenary m = game.ship.getMercs().remove(i);
            game.player.removeMercPoints(m);
            game.ship.removeMerc(m);
            i--;
        }
        HireMerc1.setDisable(false);
        FireMerc1.setDisable(true);
        HireMerc2.setDisable(false);
        FireMerc2.setDisable(true);
        if (HireMerc3 != null) {
            HireMerc3.setDisable(false);
            FireMerc3.setDisable(true);
        }
        if (HireMerc4 != null) {
            HireMerc4.setDisable(false);
            FireMerc4.setDisable(true);
        }
        FireAllMercs.setDisable(true);
        attackAmount.setText("" + game.getShip().getAttackDamage());
    }
    @FXML
    private void fireMerc1(){
        if (game.ship.getMercs().size() > 0) {
            int price = Integer.parseInt(merc1price.getText());
            
            for (Mercenary m : game.ship.getMercs()) {
                if (m.getAmountCharged() == price) {
                    game.ship.getMercs().remove(m);
                    game.ship.removeMerc(m);
                }
            }

            HireMerc1.setDisable(false);
            FireMerc1.setDisable(true);
            attackAmount.setText("" + game.getShip().getAttackDamage());
            
            System.out.println("FIRING A MERC: SIZE NOW " + game.ship.getMercs().size());
            if (game.ship.getMercs().size() == 0) {
                FireAllMercs.setDisable(true);
            }
        }
    }
    @FXML
    private void fireMerc2(){
        if (game.ship.getMercs().size() > 0) {     
            int price = Integer.parseInt(merc2price.getText());
            
            for (Mercenary m : game.ship.getMercs()) {
                if (m.getAmountCharged() == price) {
                    game.ship.getMercs().remove(m);
                    game.ship.removeMerc(m);
                }
            }

            HireMerc2.setDisable(false);
            FireMerc2.setDisable(true);
            attackAmount.setText("" + game.getShip().getAttackDamage());
            
            System.out.println("FIRING A MERC: SIZE NOW " + game.ship.getMercs().size());
            if (game.ship.getMercs().size() == 0) {
                FireAllMercs.setDisable(true);
            }
        }
    }
    @FXML
    private void fireMerc3(){
        if (game.ship.getMercs().size() > 0) {     
            int price = Integer.parseInt(merc3price.getText());
            
            for (Mercenary m : game.ship.getMercs()) {
                if (m.getAmountCharged() == price) {
                    game.ship.getMercs().remove(m);
                    game.ship.removeMerc(m);
                }
            }

            HireMerc3.setDisable(false);
            FireMerc3.setDisable(true);
            attackAmount.setText("" + game.getShip().getAttackDamage());
            
            System.out.println("FIRING A MERC: SIZE NOW " + game.ship.getMercs().size());
            if (game.ship.getMercs().size() == 0) {
                FireAllMercs.setDisable(true);
            }
        }
    }
    @FXML
    private void fireMerc4(){
        if (game.ship.getMercs().size() > 0) {     
            int price = Integer.parseInt(merc4price.getText());
            
            for (Mercenary m : game.ship.getMercs()) {
                if (m.getAmountCharged() == price) {
                    game.ship.getMercs().remove(m);
                    game.ship.removeMerc(m);
                }
            }

            HireMerc4.setDisable(false);
            FireMerc4.setDisable(true);
            attackAmount.setText("" + game.getShip().getAttackDamage());
            
            System.out.println("FIRING A MERC: SIZE NOW " + game.ship.getMercs().size());
            if (game.ship.getMercs().size() == 0) {
                FireAllMercs.setDisable(true);
            }
        }
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
}