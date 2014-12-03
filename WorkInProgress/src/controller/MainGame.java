package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author lukenewman
 */
public class MainGame extends Application {
    public Stage stage;

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        this.stage.setTitle("Space Trader");

        showMainMenu();
    }

    /**
     * Shows the main menu
     */
    public void showMainMenu() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/WelcomeScreen.fxml"));
            AnchorPane welcomeScreen = (AnchorPane) loader.load();
            
            Scene scene = new Scene(welcomeScreen);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            
            WelcomeScreenController controller = loader.getController();
            controller.setMainGame(this);
        } catch (IOException e) {
            System.out.println("WelcomeScreen.fxml could not be loaded and/or displayed");
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getState() {
        return stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}