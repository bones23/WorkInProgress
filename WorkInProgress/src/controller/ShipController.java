package controller;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Game;

/**
 *
 * @author frenc_000
 */
public class ShipController {
    Game game = WelcomeScreenController.game;
    @FXML
    private Button marketPlaceButton, mapScreenButton, Shipyard, Mercenaries, save;
    @FXML
    private Label fuelText, cargo, money, playerInfo, currentLocation;
    private final int STAGE_WIDTH = 960;
    private final int STAGE_HEIGHT = 565;
    
    @FXML
    private void initialize() {
        this.money.setText("" + game.getMoney());
        fuelText.setText("" + game.ship.getFuel());
        this.cargo.setText("" + game
                    .getShip().getSpaceLeft());
        playerInfo.setText("" + game.getPlayerString());
        currentLocation.setText("Current Location:\n----------------\n"
                + game.getCurrentSystem());
        if (game.getCurrentSystem().getTechLevel() > 3) {
            Shipyard.setVisible(true);
        } else {
            Shipyard.setVisible(false);
            Mercenaries.setVisible(false);
        }
    }
    
    @FXML
    private void goToMarket(final ActionEvent event) throws IOException {
        Stage stage;
         AnchorPane pane = FXMLLoader.load(getClass()
                 .getResource("/view/MarketplaceScreen.fxml"));
            Scene scene = new Scene(pane);
            stage = WelcomeScreenController.stage;
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setWidth(STAGE_WIDTH);
            stage.setHeight(STAGE_HEIGHT);
            stage.show();
    }
    
    @FXML
    private void goToMap(final ActionEvent event) throws IOException {
        Stage stage;
         AnchorPane pane = FXMLLoader.load(getClass()
                 .getResource("/view/MapController.fxml"));
            Scene scene = new Scene(pane);
            stage = WelcomeScreenController.stage;
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setWidth(STAGE_WIDTH);
            stage.setHeight(STAGE_HEIGHT);
            stage.show();
    }
    
    @FXML
    private void goToShipyard(final ActionEvent event) throws IOException {
         Stage stage;
         AnchorPane pane = FXMLLoader.load(getClass()
                 .getResource("/view/ShipYard.fxml"));
            Scene scene = new Scene(pane);
            stage = WelcomeScreenController.stage;
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setWidth(STAGE_WIDTH);
            stage.setHeight(STAGE_HEIGHT);
            stage.show();
    }
    
    @FXML
    private void save() throws Exception {
        String fileName = "";
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        File file = fileChooser.showSaveDialog(WelcomeScreenController.stage);
        if (file != null) {
           fileName = file.getName();
        } else {
            throw new Exception();
        }
        WelcomeScreenController.game.save(fileName,
                WelcomeScreenController.game);
    }

    @FXML
    private void goToMercenaries(final ActionEvent event) throws IOException{
        Stage stage;
        AnchorPane pane = null;
        if(game.getCurrentSystem().getTechLevel() >= 7)
            pane = FXMLLoader.load(getClass().getResource("/view/Mercenaries4Person.fxml"));
        else if(game.getCurrentSystem().getTechLevel() >= 5)
            pane = FXMLLoader.load(getClass().getResource("/view/Mercenaries3Person.fxml"));
        else
            pane = FXMLLoader.load(getClass().getResource("/view/Mercenaries2Person.fxml"));
        Scene scene = new Scene(pane);
        stage = WelcomeScreenController.stage;
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setWidth(STAGE_WIDTH);
        stage.setHeight(STAGE_HEIGHT);
        stage.show();
    }
}
    
