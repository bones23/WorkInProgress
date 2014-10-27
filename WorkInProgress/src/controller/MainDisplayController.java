/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Bones
 */
public class MainDisplayController extends Application implements Initializable{
    @FXML
    public static Stage stage;
    @FXML
    public static WelcomeScreenController welcomeScreen;
    @FXML
    public static MarketplaceController marketScreen;
    @FXML
    public static MapController mapScreenController;
    @FXML
    public static ShipController shipScreenController;
    @FXML
    public static CharacterCreationController charCreatiionScreenController;
    @FXML
    public Scene charCreationScene;
    @FXML
    public Scene mapScene;
    @FXML
    public Scene marketScene;
    @FXML
    public Scene shipScene;
    @FXML
    public Scene personalInfoScene;
    
    
    
    @FXML
    public Scene welcomeScreenScene;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/WelcomeScreen.fxml"));
        this.welcomeScreenScene = new Scene(pane);
        this.stage = new Stage();
        System.out.println("start: " + this.stage);
        System.out.println();
        this.stage.setScene(this.welcomeScreenScene);
        this.stage.setResizable(false);
        this.stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
