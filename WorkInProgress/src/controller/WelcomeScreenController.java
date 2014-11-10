package controller;

import model.Game;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
//import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author dblake
 */
public class WelcomeScreenController extends MainDisplayController implements Initializable{
    @FXML
    public static Stage stage;
    
    @FXML
    private Text titleText;
    @FXML
    private Text newGameText;
    @FXML
    private Text loadGameText;
    @FXML
    private Button okButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField nameTextField;
    @FXML
    private ComboBox difficultyComboBox;
    @FXML
    private Slider pilotSlider;
    @FXML
    private Slider fighterSlider;
    @FXML
    private Slider traderSlider;
    @FXML
    private Slider engineerSlider;
    
    @FXML
    private WelcomeScreenController welcomeScreen = MainDisplayController.welcomeScreen;
    @FXML
    private Scene characterCreationScreen;
    public static Game game=new Game();
    public Stage main = MainDisplayController.stage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Font.loadFont(WelcomeScreenController.class
                .getResource("slice.ttf").toExternalForm(), 10);
        Font.loadFont(WelcomeScreenController.class
                .getResource("CFDots-Regular.ttf").toExternalForm(), 10);
        Font.loadFont(WelcomeScreenController.class
                .getResource("Alien-Encounters-Regular.ttf").toExternalForm(), 10);
        
        this.titleText.getStyleClass().add("titleText");
        this.newGameText.getStyleClass().add("textButton");
        this.loadGameText.getStyleClass().add("textButton");
        this.easterEgg.getStyleClass().add("easterEgg");
    }
    
    @FXML
    @SuppressWarnings("static-access")
    private void newGameClicked(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass()
                .getResource("/view/CharacterScreen.fxml"));
        this.characterCreationScreen = new Scene(pane);
        System.out.println(this.stage);
        if (this.stage == null) {
            this.stage = new Stage();
            this.stage.setScene(this.characterCreationScreen);
            this.stage.setResizable(false);
            this.stage.show();
        } else {
            this.stage.setScene(this.characterCreationScreen);
        }
    }
    
    @FXML
    private void loadGameClicked(MouseEvent event) throws IOException, 
            ClassNotFoundException {
        String fileName="";
        System.out.println("Load game");
        System.out.println("load stage: " + this.stage);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            fileName = file.getName();
        }
        game.load(fileName);
        AnchorPane pane = FXMLLoader.load(getClass()
                .getResource("/view/MapController.fxml"));
            AnchorPane pane2 = FXMLLoader.load(getClass()
                .getResource("/view/MarketplaceScreen.fxml"));
            pane.getChildren().add(pane2);
            Scene scene = new Scene(pane);
            this.stage = new Stage();
            this.stage.setScene(scene);
            this.stage.setResizable(false);
            this.stage.setWidth(975);
            this.stage.setHeight(800);
            this.stage.show();
    }
    
    @FXML
    private void okButtonClicked(MouseEvent event) throws IOException {
        int pilotSliderValue = (int) pilotSlider.getValue();
        int fighterSliderValue = (int) fighterSlider.getValue();
        int traderSliderValue = (int) traderSlider.getValue();
        int engineerSliderValue = (int) engineerSlider.getValue();
        String difficulty = (String)difficultyComboBox.getValue() == null ? 
                (String)difficultyComboBox.getValue() : "Normal";
        String name = nameTextField.getText();
        
        // check point allocation
        int totalPoints = pilotSliderValue + fighterSliderValue + traderSliderValue + engineerSliderValue;
        if (totalPoints > 20) {
            Dialogs.create()
                    .owner(this.stage)
                    .title("Too Many Points")
                    .masthead(null)
                    .message("Your total points cannot exceed 20.")
                    .showInformation();
        } else if (totalPoints < 20){
            Dialogs.create()
                    .owner(this.stage)
                    .title("Too Little Points")
                    .masthead(null)
                    .message("Your total points must equal 20.")
                    .showInformation();
        // create the model
        } else {
            //game = new Game();
            System.out.println(game.getUniverse().toString());
            game.createPlayer(name, pilotSliderValue, fighterSliderValue, traderSliderValue, engineerSliderValue);
            System.out.println(game.getPlayer().toString());
            System.out.println(game.getPlayer().getMoney());
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/MapController.fxml"));
            AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/view/MarketplaceScreen.fxml"));
            pane.getChildren().add(pane2);
            Scene scene = new Scene(pane);
            this.stage = new Stage();
            this.stage.setScene(scene);
            this.stage.setResizable(false);
            this.stage.setWidth(975);
            this.stage.setHeight(800);
            this.stage.show();
        }
    }
    
    @FXML
    private void cancelButtonClicked(MouseEvent event) throws IOException {
        //this.stage.setScene(this.welcomeScreen);
    }
    
    @FXML
    private Text easterEgg;
    
    @FXML
    private void easterEggClicked(MouseEvent event) throws IOException, URISyntaxException {
        if(Desktop.isDesktopSupported())
        {
            Desktop.getDesktop().browse(new URI("http://www.leekspin.com"));
        }
    }
}
