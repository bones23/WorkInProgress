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
    private Button marketPlaceButton, mapScreenButton, Shipyard, save;
    @FXML
    private Label fuelText, cargo, money, playerInfo;
    private final int STAGE_WIDTH = 960;
    private final int STAGE_HEIGHT = 565;
    
    @FXML
    private void initialize() {
        this.money.setText("" + game.getMoney());
        fuelText.setText("" + game.ship.getFuel());
        this.cargo.setText("" + game
                    .getShip().getSpaceLeft());
        playerInfo.setText("" + game.getPlayerString());
        if (game.getCurrentSystem().getTechLevel() > 3) {
            Shipyard.setVisible(true);
        } //WHAT IS THIS CHECKSTYLE?!?
        else {
            Shipyard.setVisible(false);
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
    private void encounter(final ActionEvent event) throws IOException {
        
        Stage stage = WelcomeScreenController.stage;;
        /*
         AnchorPane pane = FXMLLoader.load(getClass()
                 .getResource("/view/Encounter.fxml"));
            Scene scene = new Scene(pane);
            stage = WelcomeScreenController.stage;
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setWidth(STAGE_WIDTH);
            stage.setHeight(STAGE_HEIGHT);
            stage.show();
                */
        Encounters start = new Encounters();
        start.start(stage);
        
    }
}
    
