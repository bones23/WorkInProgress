package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.Window;

import model.Person;
import model.Universe;

import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author dblake
 */
public class WelcomeScreenController extends Application implements Initializable {
    @FXML
    private Stage stage;
    
    // components
    @FXML
    private Label label;
    @FXML
    private Button but;
    @FXML
    private Button OK;
    @FXML
    private Button cancel;
    @FXML
    private TextField Name;
    @FXML
    private ComboBox Difficulty;
    @FXML
    private Slider Pilot;
    @FXML
    private Slider Fighter;
    @FXML
    private Slider Trader;
    @FXML
    private Slider Engineer;
    
    // screens/windows
    @FXML
    private Window welcomeScreen;
    @FXML
    private Window characterCreationScreen;
    
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
        Image background = new Image(WelcomeScreenController.class.getResource("/supporting/SpaceTrader1.png").toString());
        ImageView back = new ImageView(background);
        Group rot = new Group(back);
        Parent root = FXMLLoader.load(getClass().getResource("/view/WelcomeScreen.fxml"));
        rot.getChildren().add(root);
        Scene scene = new Scene(rot);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/CharacterScreen.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
        this.welcomeScreen = ((Node) event.getSource()).getScene().getWindow();
        this.welcomeScreen.hide();
    }
    
    @FXML
    private void okOnCharacterScreen(ActionEvent event) throws IOException {
        int pilot = (int) Pilot.getValue();
        int fighter = (int) Fighter.getValue();
        int trader = (int) Trader.getValue();
        int engineer = (int) Engineer.getValue();
        String difficulty = (String)Difficulty.getValue();
        String name = Name.getText();
        if (difficulty == null) {
            difficulty = "Normal";
        }
        
        // check point allocation
        int totalPoints = pilot + fighter + trader + engineer;
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
            Person player = new Person(name, pilot, fighter, trader, engineer);
            System.out.println(player);
            this.characterCreationScreen = ((Node)event.getSource()).getScene().getWindow();
            this.characterCreationScreen.hide();
            Parent root = FXMLLoader.load(getClass().getResource("/view/GameScreen.fxml"));
            Group rot = new Group();
            rot.getChildren().add(root);
            Scene scene = new Scene(rot);
            stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setWidth(975);
            stage.setHeight(800);
            stage.show();
        }
    }
    
    @FXML
    private void cancelOnCharacterScreen(ActionEvent event) throws IOException {
        this.characterCreationScreen.hide();
        // show welcome screen
    }
}
