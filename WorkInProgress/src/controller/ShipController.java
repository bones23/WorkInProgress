package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.*;
import controller.*;

/**
 *
 * @author frenc_000
 */
public class ShipController {
    Game game = WelcomeScreenController.game;
    public Label fuelText;
    public Label spaceLeft;
    @FXML
    public void buyFuel(ActionEvent event) throws IOException {
        game.ship.buyFuel();
        fuelText.setText("" + game.ship.getFuel()); 
        //figure out a way to update the maps from this controller
//      //refreshMaps();
    }
    public void refreshShip(){
        fuelText.setText("" + game.ship.getFuel());
        spaceLeft.setText("" + game.ship.getSpaceLeft());
    }
}
