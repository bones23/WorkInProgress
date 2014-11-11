package controller;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Game;

/**
 *
 * @author frenc_000
 */
public class ShipController {
    //CHECKSTYLE: OFF
    Game game = WelcomeScreenController.game;
    public Label fuelText;
    public Label spaceLeft;
    //CHECKSTYLE: ON

    /**
     * Purchase fuel.
     * @param event event
     * @throws IOException A
     */
    @FXML
    public final void buyFuel(final ActionEvent event) throws IOException {
        game.ship.buyFuel();
        fuelText.setText("" + game.ship.getFuel());
        //figure out a way to update the maps from this controller
//      //refreshMaps();
    }

    /**
     * Refresh the ship.
     */
    public final void refreshShip() {
        fuelText.setText("" + game.ship.getFuel());
        spaceLeft.setText("" + game.ship.getSpaceLeft());
    }
}
