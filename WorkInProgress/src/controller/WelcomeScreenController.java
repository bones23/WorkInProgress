package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
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
import javafx.stage.Stage;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.scene.text.Text;

import model.Person;
import model.Universe;

import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author dblake
 */
public class WelcomeScreenController extends Application implements Initializable {
    @FXML
    private static Stage stage;
    
    @FXML
    private Text newGameText;
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
    private static Scene welcomeScreen;
    @FXML
    private Scene characterCreationScreen;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/WelcomeScreen.fxml"));
        this.welcomeScreen = new Scene(pane);
        
        this.stage = new Stage();
        System.out.println("start: " + this.stage);
        this.stage.setScene(this.welcomeScreen);
        this.stage.setResizable(false);
        this.stage.show();
    }
    
    @FXML
    private void newGameClicked(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/CharacterScreen.fxml"));
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
    private void loadGameClicked(MouseEvent event) throws IOException {
        System.out.println("Load game");
        System.out.println("load stage: " + this.stage);
    }
    
    @FXML
    private void okButtonClicked(MouseEvent event) throws IOException {
        int pilotSliderValue = (int) pilotSlider.getValue();
        int fighterSliderValue = (int) fighterSlider.getValue();
        int traderSliderValue = (int) traderSlider.getValue();
        int engineerSliderValue = (int) engineerSlider.getValue();
        String difficulty = (String)difficultyComboBox.getValue();
        String name = nameTextField.getText();
        if (difficulty == null) {
            difficulty = "Normal";
        }
        
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
            Universe universe = new Universe();
            System.out.println(universe.toString());
            Person player = new Person(name, pilotSliderValue, fighterSliderValue, traderSliderValue, engineerSliderValue);
            System.out.println(player);
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/GameScreen.fxml"));
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
        this.stage.setScene(this.welcomeScreen);
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
