package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author dblake
 */
public class JavaFXApplication5 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Image background = new Image(JavaFXApplication5.class.getResource("/supporting/SpaceTrader1.png").toString());
        ImageView back = new ImageView(background);
        Group rot = new Group(back);
        Parent root = FXMLLoader.load(getClass().getResource("/view/WelcomeScreen.fxml"));
        rot.getChildren().add(root);
        Scene scene = new Scene(rot);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
