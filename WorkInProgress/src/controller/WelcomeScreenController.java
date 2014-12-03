package controller;

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
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import model.Game;

import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author dblake, lukenewman
 */
public class WelcomeScreenController implements Initializable {
    //CHECKSTYLE: OFF
    @FXML
    public static Stage stage;
    @FXML
    private Text titleText;
    @FXML
    private Text newGameText;
    @FXML
    private Text loadGameText;
    @FXML
    private Text optionsText;
    @FXML
    private Label pointsRemainingLabel;
    @FXML
    private Button doneButton;
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
    
    private MainGame mainGame;
    public MapController mc = new MapController();
//    private int pointsRemaining = 20;
    public static Game game = new Game();
    //CHECKSTYLE: ON


//    @FXML
//    private void initialize() {
//        Platform.runLater(() -> {
//            System.out.println("this: " + this);
//            System.out.println("pilotSlider: " + this.pilotSlider);
//            this.pilotSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
//                pointAllocationChanged((int)oldValue, (int)newValue);
//            });
//            this.fighterSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
//                pointAllocationChanged((int)oldValue, (int)newValue);
//            });
//            this.traderSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
//                pointAllocationChanged((int)oldValue, (int)newValue);
//            });
//            this.engineerSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
//                pointAllocationChanged((int)oldValue, (int)newValue);
//            });
//
//
//            Font titleTextFont = Font.loadFont(getClass()
//                    .getResource("/supporting/slice.ttf").toExternalForm(), 90);
//            Font textButtonFont = Font.loadFont(getClass()
//                    .getResource("/supporting/CFDots-Regular.ttf").toExternalForm(), 34);
//            Font easterEggFont = Font.loadFont(getClass()
//                    .getResource("/supporting/Alien-Encounters-Regular.ttf").toExternalForm(), 19);
//
//            this.titleText.setFont(titleTextFont);
//            this.newGameText.setFont(textButtonFont);
//            this.loadGameText.setFont(textButtonFont);
//            this.optionsText.setFont(textButtonFont);
//            this.easterEgg.setFont(easterEggFont);
//        });
//        this.stage = mainGame.stage;
//    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // nothin
    }
    
    public void setMainGame(MainGame mainGame) {
        this.mainGame = mainGame;
    }

    @FXML
    private void newGameClicked(final MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass()
                .getResource("/view/CharacterScreen.fxml"));
        this.characterCreationScreen = new Scene(pane);
        System.out.println(this.stage);
        if (this.stage == null) {
            this.stage = new Stage();
            this.stage.setScene(this.characterCreationScreen);
            this.stage.setResizable(false);
            this.stage.show();
            mainGame.stage.close();
        } else {
            this.stage.setScene(this.characterCreationScreen);
        }
    }

    @FXML
    private void loadGameClicked(final MouseEvent event) throws IOException,
            ClassNotFoundException {
        String fileName = "";
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
                .getResource("/view/Ship.fxml"));
        mainGame.stage.close();
            Scene scene = new Scene(pane);
            this.stage = new Stage();
            this.stage.setScene(scene);
            this.stage.setResizable(false);
            this.stage.setWidth(960);
            this.stage.setHeight(565);
            this.stage.show();
    }

//    private void pointAllocationChanged(int oldValue, int newValue) {
//        this.pointsRemaining -= oldValue - newValue;
//        Platform.runLater(() -> {
//            this.pointsRemainingLabel.setText(pointsRemaining + " skill points remaining");
//        });
//    }
    
    /**
     * Sets difficulty to normal if none is selected
     * Displays error dialogue if skill points are not equal to 20
     * if skill points = 20, then character is created and GameScreen
     * is displayed.
     * @param event event
     * @throws IOException A
     */
    @FXML
    private void doneButtonClicked(final MouseEvent event) throws IOException {
        int pilotSliderValue = (int) pilotSlider.getValue();
        int fighterSliderValue = (int) fighterSlider.getValue();
        int traderSliderValue = (int) traderSlider.getValue();
        int engineerSliderValue = (int) engineerSlider.getValue();
        String difficulty = (String) difficultyComboBox.getValue();
        String name = nameTextField.getText();
        if (difficulty == null) {
            difficulty = "Normal";
        }

        // check point allocation
        int totalPoints = pilotSliderValue + fighterSliderValue
                + traderSliderValue + engineerSliderValue;
        if (totalPoints > 20) {
            Dialogs.create()
                    .owner(this.stage)
                    .title("Too Many Points")
                    .masthead(null)
                    .message("Your total points cannot exceed 20.")
                    .showInformation();
        } else if (totalPoints < 20) {
            Dialogs.create()
                    .owner(this.stage)
                    .title("Too Little Points")
                    .masthead(null)
                    .message("Your total points must equal 20.")
                    .showInformation();
        } else if (name.equals("") || name == null) {
            Dialogs.create()
                    .owner(this.stage)
                    .title("No name given")
                    .masthead(null)
                    .message("Must have a name.")
                    .showInformation();
            // create the model
        } else {
            //game = new Game();
            game.createPlayer(name, pilotSliderValue, fighterSliderValue,
                    traderSliderValue, engineerSliderValue);
            stage.close();
            AnchorPane pane = FXMLLoader.load(getClass()
                    .getResource("/view/Ship.fxml"));
            Scene scene = new Scene(pane);
//            System.out.println("this.mainGame.stage: " + this.mainGame.stage);
//            this.mainGame.stage.close();
            this.stage = new Stage();
            this.stage.setScene(scene);
            this.stage.setResizable(false);
            this.stage.setWidth(960);
            this.stage.setHeight(565);
            this.stage.show();
        }
    }

    /**
     * Cancel a click.
     * @param event e
     * @throws IOException a
     */
    @FXML
    private void cancelButtonClicked(final MouseEvent event)
            throws IOException {
        Stage stage;
         AnchorPane pane = FXMLLoader.load(getClass()
                 .getResource("/view/WelcomeScreen.fxml"));
            Scene scene = new Scene(pane);
            stage = WelcomeScreenController.stage;
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
    }

    @FXML
    private Text easterEgg;

    @FXML
    private void easterEggClicked(final MouseEvent event) throws IOException,
            URISyntaxException {
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(new URI("http://www.leekspin.com"));
        }
    }
}
