package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.dialog.Dialogs;
import model.Person;
import model.Universe; //added to print out universe
import model.SolarSystem; //added to print out universe

/**
 *
 * @author dblake
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Stage stage;
    @FXML
    private Stage stage2;
    
    @FXML
    private Label label;
    @FXML
    private Button but;
    @FXML
    private Button OK;
    @FXML
    private Button cancel;
    //@FXML
    //Parent root;
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
    private void handleButtonAction(ActionEvent event) throws IOException {
        //this.stage.close();
       // System.out.println("You clicked me!");
        //but.setVisible(false);
        Parent root = FXMLLoader.load(getClass().getResource("CharacterScreen.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
        
        
        
        //label.setText("Hello World!");
        //st.setVisible(false);
        //button.setVisible(false);
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
        if (pilot + fighter + trader + engineer > 20) {
            Dialogs.create()
                    .owner(this.stage)
                    .title("Too Many Points")
                    .masthead(null)
                    .message("Your total points cannot exceed 20.")
                    .showInformation();
        // create the model
        } else {
            Universe universe = new Universe();
            universe.printUniverse();
            Person player = new Person(name, pilot, fighter, trader, engineer);
            System.out.println(player);
            ((Node)event.getSource()).getScene().getWindow().hide(); 
        }
    }
    
    @FXML
    private void cancelOnCharacterScreen(ActionEvent event) throws IOException {
        // close the screen
        //((Node))(event.getSource())).getScene().getWindow().hide();
        ((Node)event.getSource()).getScene().getWindow().hide(); 
        //stage.hide();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    // welcome screen
    //public void start(Stage stage) throws Exception {
      //  Parent root = FXMLLoader.load(getClass().getResource("WelcomeScreen.fxml"));
       // Scene scene = new Scene(root);
        
       // this.stage = stage;
        
        //this.stage.setScene(scene);
        //this.stage.show();
    //}

    /**
     * @param args the command line arguments
     */
    //public static void main(String[] args) {
      //  launch(args);
    //}
    
}
