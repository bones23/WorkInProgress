package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Person;
import model.Universe;
import org.controlsfx.dialog.Dialogs;



/**
 *
 * @author Dustin Blake
 * @author Luke Newman
 */
public class CharacterCreationController {
    // stages
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
        // create the model
        } else if (totalPoints < 20){
            Dialogs.create()
                    .owner(this.stage)
                    .title("Too Little Points")
                    .masthead(null)
                    .message("Your total points must equal 20.")
                    .showInformation();
        } else {
            Universe universe = new Universe();
            System.out.println(universe.toString());
            Person player = new Person(name, pilot, fighter, trader, engineer);
            System.out.println(player);
            ((Node)event.getSource()).getScene().getWindow().hide(); 
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
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
}
