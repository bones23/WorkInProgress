package controller;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Game;
import model.Person;
import model.Pirate;
import model.Ship;

public class Encounters extends Application {
    private Rectangle health1, health2, health3, health4;
    private Canvas canvas;
    private boolean myTurn = true;
    private Button attack, shield, leave;
    private Game game = WelcomeScreenController.game;
    private Ship player = game.getShip();
    private final int rec_width = 100;
    private final int rec_height = 12;
    private Pirate pirate;
    private Label healthLabel1, healthLabel2, playerName, shipName,
            attackDamage, shields, pirateLabel;
    private final int STAGE_WIDTH = 960;
    private final int STAGE_HEIGHT = 565;
    private Person person = game.getPlayer();
    private Image ship, background, layout, pirateShip, explosion, playerShield;
    private GraphicsContext graphicsContext;
    private ImageView ship_1, pirate_Ship;
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 960, 565, Color.WHITE);
        canvas = new Canvas(970, 576);
        graphicsContext = canvas.getGraphicsContext2D();
        background = new Image("/supporting/stars2.jpg");
        ship = new Image("/supporting/Ship.PNG");
        layout = new Image("/supporting/layout.png");
        explosion = new Image("/supporting/explosion.png");
        playerShield = new Image("/supporting/ShipShield.png");
        
        healthLabel1 = new Label();
        healthLabel1.setText("Health: " + player.getHealth() + "/100");
        healthLabel1.setLayoutX(280);
        healthLabel1.setLayoutY(73);
        healthLabel1.setTextFill(Color.WHITE);
        healthLabel2 = new Label("Health: 100/100");
        healthLabel2.setLayoutX(545);
        healthLabel2.setLayoutY(73);
        healthLabel2.setTextFill(Color.WHITE);
        
        pirate = new Pirate();
        playerName = new Label();
        playerName.setLayoutX(245);
        playerName.setLayoutY(43);
        playerName.setText("Name:\n" + person.getName());        
        playerName.setTextFill(Color.WHITE);
        playerName.setFont(Font.font(9));
        
        attackDamage = new Label();
        attackDamage.setLayoutX(345);
        attackDamage.setLayoutY(43);
        attackDamage.setText("Damage:\n" + player.getAttackDamage());
        attackDamage.setTextFill(Color.WHITE);
        attackDamage.setFont(Font.font(9));
        
        shipName = new Label();
        shipName.setLayoutX(285);
        shipName.setLayoutY(43);
        shipName.setText("Ship Name:\n" + player.getShipClass());
        shipName.setTextFill(Color.WHITE);
        shipName.setFont(Font.font(9));
        
        shields = new Label();
        shields.setLayoutX(395);
        shields.setLayoutY(43);
        shields.setText("Shields:\n" + player.getShields());
        shields.setTextFill(Color.WHITE);
        shields.setFont(Font.font(9));
        pirateLabel = new Label("Unknown Pirate");
        pirateLabel.setLayoutX(520);
        pirateLabel.setLayoutY(43);
        pirateLabel.setTextFill(Color.WHITE);
        health1 = new Rectangle(320, 75, rec_width, rec_height);
        health1.setFill(Color.RED);
        health2 = new Rectangle(320, 75, player.getHealth(), rec_height);
        health2.setFill(Color.GREEN);
        health3 = new Rectangle(585, 75, rec_width, rec_height);
        health3.setFill(Color.RED);
        health4 = new Rectangle(585, 75, pirate.getHealth(), rec_height);
        health4.setFill(Color.GREEN);
        
        
        leave = new Button("Leave");
        leave.setLayoutX(427);
        leave.setLayoutY(421);
        leave.setVisible(false);
        leave.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    AnchorPane pane = FXMLLoader
                            .load(getClass().getResource("/view/Ship.fxml"));
                    Scene scene = new Scene(pane);
                    Stage stage;
                    stage = WelcomeScreenController.stage;
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.setWidth(STAGE_WIDTH);
                    stage.setHeight(STAGE_HEIGHT);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(Encounters.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        pirateShip = new Image("/supporting/pirateship.png");
        graphicsContext.drawImage(background, 0, 0);
        graphicsContext.drawImage(layout, 235, 25);
        //graphicsContext.drawImage(ship, 222, 158);
        //graphicsContext.drawImage(pirateShip, 701, 158);
        attack = new Button();
        attack.setLayoutX(287);
        attack.setLayoutY(321);
        attack.setText("Attack");
        attack.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if (myTurn) {    
                    attack(scene);
                }
            }
        });
        shield = new Button();
        shield.setLayoutX(427);
        shield.setLayoutY(321);
        shield.setText("Shield");
        shield.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if (myTurn && player.getShields() > 0) {    
                    pirateMove(scene, 2, true);
                }
            }
        });
        root.getChildren().add(canvas);
        root.getChildren().add(attack);
        root.getChildren().add(shield);
        root.getChildren().add(health1);
        root.getChildren().add(leave);
        root.getChildren().add(health2);
        root.getChildren().add(health3);
        root.getChildren().add(health4);
        root.getChildren().add(healthLabel1);
        root.getChildren().add(healthLabel2);
        root.getChildren().add(playerName);
        root.getChildren().add(shipName);
        root.getChildren().add(attackDamage);
        root.getChildren().add(pirateLabel);
        root.getChildren().add(shields);
        startingAnimation(scene);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    private void attack(final Scene scene) {
        Rectangle rectangle = new Rectangle(264, 206, 15, 3);
        Rectangle rectangle2 = new Rectangle(264, 173, 15,3);
        rectangle.setVisible(true);
        rectangle2.setVisible(true);
        rectangle.setFill(Color.RED);
        rectangle2.setFill(Color.RED);
        final Group root = (Group) scene.getRoot();
        root.getChildren().add(rectangle);
        root.getChildren().add(rectangle2);
        Timeline tl = new Timeline();
        tl.setCycleCount(1);
        tl.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rectangle.setVisible(false);
                rectangle2.setVisible(false);
                health4.setWidth(pirate.takeDamage(player.doDamage()));
                healthLabel2.setText("Health: " + pirate.getHealth() + "/100");
                if (pirate.getHealth() == 0) {    
                    leave.setVisible(true);
                    attack.setVisible(false);
                    shield.setVisible(false);
                    explosion("Pirate");
                    rotate("Ship");
                }
            }
        });
        KeyValue kv = new KeyValue(rectangle.xProperty(), 694);
        KeyFrame kf = new KeyFrame(Duration.millis(750), kv);
        KeyValue kv2 = new KeyValue(rectangle2.xProperty(), 694);
        KeyFrame kf2 = new KeyFrame(Duration.millis(750), kv2);
        tl.getKeyFrames().add(kf);
        tl.getKeyFrames().add(kf2);
        tl.play();
        myTurn = false;
        pirateMove(scene, 1, false);
    }
    
    public void pirateMove(final Scene scene, int cycle, boolean reverse) {
        myTurn = false;
        Rectangle rectangle = new Rectangle(665, 208, 15, 3);
        if (reverse) {
            ship_1.setImage(playerShield);
        }
        rectangle.setVisible(true);
        rectangle.setFill(Color.GREEN);
        final Group root = (Group) scene.getRoot();
        root.getChildren().add(rectangle);
        Timeline tl = new Timeline();
        tl.setCycleCount(cycle);
        tl.setAutoReverse(reverse);
        tl.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rectangle.setVisible(false);
                myTurn = true;
                if (reverse) {
                    health4.setWidth(pirate.takeDamage(player.doDamage()));
                    healthLabel2.setText("Health: " + pirate.getHealth() + "/100");
                    ship_1.setImage(ship);
                    if (pirate.getHealth() == 0) {    
                        leave.setVisible(true);
                        attack.setVisible(false);
                        shield.setVisible(false);
                        explosion("Pirate");
                        rotate("Ship");
                    }
                    shields.setText("Shields:\n" + player.deductShield());
                } else {
                    health2.setWidth(player.takeDamage(pirate.doDamage()));
                    healthLabel1.setText("Health: " + player.getHealth() + "/100");
                    if (player.getHealth() == 0) {    
                        leave.setVisible(true);
                        attack.setVisible(false);
                        shield.setVisible(false);
                        explosion("Player");
                    }
                }
                
            }
        });
        KeyValue kv = new KeyValue(rectangle.xProperty(), 297);
        KeyFrame kf = new KeyFrame(Duration.millis(750), kv);
        tl.getKeyFrames().add(kf);
        tl.play();
    }
    
    public void explosion(String death) {
        if (death.equals("Player")) {
            ship_1.setImage(explosion);
            canvas.toBack();
        } else if (death.equals("Pirate")) {
            pirate_Ship.setImage(explosion);
            canvas.toBack();
        }
        
    }
    
    public void startingAnimation(final Scene scene) {
        ship_1 = new ImageView(ship);
        ship_1.setLayoutX(0);
        ship_1.setLayoutY(158);
        final Group root = (Group) scene.getRoot();
        root.getChildren().add(ship_1);
        Timeline tl = new Timeline();
        tl.setCycleCount(1);
        KeyValue kv = new KeyValue(ship_1.xProperty(), 222);
        KeyFrame kf = new KeyFrame(Duration.millis(1000), kv);
        tl.getKeyFrames().add(kf);
        tl.play();
        
        pirate_Ship = new ImageView(pirateShip);
        pirate_Ship.setLayoutX(960);
        pirate_Ship.setLayoutY(158);
        root.getChildren().add(pirate_Ship);
        Timeline tl1 = new Timeline();
        tl1.setCycleCount(1);
        KeyValue kv2 = new KeyValue(pirate_Ship.xProperty(), -260);
        KeyFrame kf2 = new KeyFrame(Duration.millis(1000), kv2);
        tl1.getKeyFrames().add(kf2);
        tl1.play();
        
        tl.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startSwayShip();
            }
        });
        tl1.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startSwayPirate();
            }
        });
    }
    
    public void startSwayShip() {
        Timeline tl = new Timeline();
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.setAutoReverse(true);
        KeyValue kv = new KeyValue(ship_1.xProperty(), 220);
        KeyValue kv1 = new KeyValue(ship_1.yProperty(), 2);
        KeyFrame kf = new KeyFrame(Duration.millis(1500), kv, kv1);
        tl.getKeyFrames().add(kf);
        tl.play();
        
    }
    public void startSwayPirate() {
        Timeline tl = new Timeline();
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.setAutoReverse(true);
        KeyValue kv = new KeyValue(pirate_Ship.xProperty(), -262);
        KeyValue kv1 = new KeyValue(pirate_Ship.yProperty(), 2);
        KeyFrame kf = new KeyFrame(Duration.millis(1500), kv, kv1);
        tl.getKeyFrames().add(kf);
        tl.play();
    }
    
    public void flyAway(String string) {
        if (string.equals("Ship")) {
            Timeline tl = new Timeline();
            tl.setCycleCount(1);
            KeyValue kv = new KeyValue(ship_1.xProperty(), -150);
            KeyFrame kf = new KeyFrame(Duration.millis(1000), kv);
            tl.getKeyFrames().add(kf);
            tl.play();
            tl.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ship_1.setVisible(false);
            }
        });
        } else if (string.equals("Pirate")) {
            Timeline tl = new Timeline();
            tl.setCycleCount(1);
            KeyValue kv = new KeyValue(pirate_Ship.xProperty(), 960);
            KeyFrame kf = new KeyFrame(Duration.millis(1000), kv);
            tl.getKeyFrames().add(kf);
            tl.play();
            tl.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pirate_Ship.setVisible(false);
            }
        });
        }
    }
    
    public void rotate(String string) {
        if (string.equals("Ship")) {
            RotateTransition rotateTransition = 
            new RotateTransition(Duration.millis(1000), ship_1);
            rotateTransition.setByAngle(180f);
            rotateTransition.setCycleCount(1);
            rotateTransition.play();
            rotateTransition.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    flyAway("Ship");
                }
            });
            
        } else if (string.equals("Pirate")) {
            RotateTransition rotateTransition = 
            new RotateTransition(Duration.millis(1000), pirate_Ship);
            rotateTransition.setByAngle(180f);
            rotateTransition.setCycleCount(1);
            rotateTransition.play();
            rotateTransition.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    flyAway("Pirate");
                }
            });
        }
    }
}