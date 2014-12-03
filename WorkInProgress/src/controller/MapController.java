package controller;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.Game;
import model.MarketPlace;
import model.SolarSystem;
import model.Ship;
import model.Universe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
/**
 *
 * @author frenc_000
 */
public class MapController  {
    //CHECKSTYLE: OFF
    //MarketplaceController mpc = new MarketplaceController();
    @FXML
    private Canvas universeMap;
    
    @FXML
    public Label spaceLeft,currentLocation;
    @FXML
    private Canvas miniMap;
    private LinkedList<SolarSystem> miniSystems;
    Game game = WelcomeScreenController.game;
    @FXML
    private Label fuelText,cargo,money;
    int i = game.getCurrentLocationIndex();
    int destinationIndex = i;
   // Game game = WelcomeScreenController.game;
    MarketPlace market = game.getMarket();
    int currentLocationIndex = WelcomeScreenController.game.getCurrentLocationIndex();
    Ship ship = WelcomeScreenController.game.getShip();
    private final int STAGE_WIDTH = 960;
    private final int STAGE_HEIGHT = 565;

    //Buy buttons
    @FXML
    private Button save,Shipyard, goBackFromMap;
    //Labels for sellable items
   

    //CHECKSTYLE: ON
    
     @FXML
    private void initialize() {
        game = WelcomeScreenController.game;
        market = game.currentSystem.getMarketPlace();
        drawMini();
        drawUniverse();
        this.money.setText("" + game.getMoney());
        fuelText.setText("" + game.ship.getFuel());
        currentLocation.setText("Current Location:\n----------------\n"
                + game.getCurrentSystem());
    }

    /**
     * Draws the universe map based on the current position.
     */
    @FXML
    public void drawUniverse() {
        universeMap.toFront();
        Universe universe = game.getUniverse();
        GraphicsContext g2d = universeMap.getGraphicsContext2D();
        g2d.setFill(Color.WHITE);
        g2d.fillRect(0, 0, universeMap.getWidth(), universeMap.getHeight());
        g2d.setFill(Color.WHITE);
        g2d.fillRect(0, 0, universeMap.getWidth(), universeMap.getHeight());
        Color c = Color.web("#008000", 0.5);
        int r = 2 * game.getShip().getFuel();
        g2d.setFill(c);
        g2d.fillOval((2 * game.currentSystem.getX()) - r + 2,
                (2 * game.currentSystem.getY())
                - r + 2, 4 * game.getShip().getFuel() + 1,
                4 * game.getShip().getFuel() + 1); //x-range5/8, y-range5/8
        g2d.setFill(Color.RED);
        g2d.fillOval(2 * game.currentSystem.getX(),
                2 * game.currentSystem.getY(), 4, 4);
        g2d.setFill(Color.BLACK);
        for (int k = 0; k < 120; k++) {
            if (game.currentSystem != game.getUniverse().getSolarSystemAt(k)) {
                g2d.fillOval(2 * universe.getSolarSystemAt(k).getX(),
                        2 * universe.getSolarSystemAt(k).getY(), 2, 2);
            }
            g2d.setFill(Color.BLACK);
        }
    }

    /**
     * Draws the mini map, displaying only planets that are in range.
     */
    @FXML
    public void drawMini() {
        GraphicsContext g2d = miniMap.getGraphicsContext2D();
        g2d.setFill(Color.WHITE);
        g2d.fillRect(0, 0, miniMap.getWidth(), miniMap.getHeight());
        //Color d = Color.web("#FFFF00",0.5);
        //g2d.setFill(d);
        g2d.setFill(Color.WHITE);
        g2d.fillRect(0, 0, miniMap.getWidth(), miniMap.getHeight());
        g2d.setFill(Color.RED);
        g2d.fillOval(140, 90, 10, 10);
        g2d.setFill(Color.BLACK);
        miniSystems = new LinkedList();
        for (int k = 0; k < 120; k++) {
            if (game.currentSystem != game.uni.getSolarSystemAt(k)) {
            int currentX = game.currentSystem.getX();
            int currentY = game.currentSystem.getY();
            int selectedX = game.uni.getSolarSystemAt(k).getX();
            int selectedY = game.uni.getSolarSystemAt(k).getY();
            int distance = (int) Math.sqrt(Math.pow((double) Math
                    .abs(currentX - selectedX), 2)
                    + (double) Math.pow(Math.abs(currentY - selectedY), 2));
            if (distance <= game.ship.getFuel()) {
                miniSystems.add(game.uni.getSolarSystemAt(k));
               // System.out.println("planet location "
               // + universe.getSolarSystemAt(k).getX());
                int x = 4 * game.currentSystem.getX()
                        - 4 * game.uni.getSolarSystemAt(k).getX();
                int y = 4 * game.currentSystem.getY()
                        - 4 * game.uni.getSolarSystemAt(k).getY();
                g2d.fillOval((140 - x), (90 - y), 5 , 5);
            }
            }
        }
    }

    @FXML
    private Label selectedLocation, fuelCost;
    /*
    calculates whether or not what the user clicked was a planet
    If it is a planet, then planet data and the fuel cost to get there are
    displayed.
    */
    @FXML
    private void handleMouseClick(final MouseEvent event) {
        Ship ship = WelcomeScreenController.game.getShip();
      //  System.out.println((140-event.getX()
      //  - universe.getSolarSystemAt(i).getX())/4);
        int x = (int) event.getX();
        int y = (int) event.getY();
        for(SolarSystem name : miniSystems){
            int x2 = name.getX();
            int y2 = name.getY();
            x2 = 4 * game.getCurrentSystem().getX() - 4 * x2;
            y2 = 4 * game.getCurrentSystem().getY() - 4 * y2;
            x2 = 140 - x2;
            y2 = 90 - y2;
            
            if ((x >= x2 && x <= x2 + 5) && (y >= y2 && y <= y2 + 5)) {
                selectedLocation.setText("Selected Location:\n----------------"
                        + "\n" + name.toString());
                for (int i = 0; i < 120; i++) {
                    if (game.uni.getSolarSystemAt(i).getName()
                            .equals(name.getName())) {
                        destinationIndex = i;
                    }
                }
            }
            int currentX = game.getCurrentSystem().getX();
            int currentY = game.getCurrentSystem().getY();
            int selectedX = game.uni.getSolarSystemAt(destinationIndex).getX();
            int selectedY = game.uni.getSolarSystemAt(destinationIndex).getY();
            int distance = (int) Math.sqrt(Math.pow((double) Math
                    .abs(currentX - selectedX), 2)
                    + (double) Math.pow(Math.abs(currentY - selectedY), 2));
            if (distance != 0) {
                fuelCost.setText("Fuel Cost:\n" + distance);
            }
        }
    }

    /**
     * Helper method which refreshes the maps.
     */
    @FXML
    public final void refreshMaps() {
        drawMini();
        drawUniverse();
    }
    /*
    buys fuel to fill the player's fueltank if player has enough money.
    updates the fuel displayed on UI.
    updates the amount of money displayed on UI.
    */
    @FXML
    public final void buyFuel(final ActionEvent event) throws IOException {
        game.ship.buyFuel();
        fuelText.setText("" + game.ship.getFuel());
        this.money.setText("" + game.getMoney());
        refreshMaps();
    }
    /**
     * Updates the ships labels.
     */
    public final void refreshShip() {
        fuelText.setText("" + game.ship.getFuel());
        spaceLeft.setText("" + game.ship.getSpaceLeft());
    }
    /**
     * Travel method which calls the ship's travel method.
     * Will only travel if the targeted solarSysten isnt the solarSystem you
     * currently are on.
     * @param event event
     * @throws IOException A
     */
    @FXML
    private void Travel(final ActionEvent event) throws IOException {
        if (i != destinationIndex) {
            i = game.getShip().travel(game.uni
                    .getSolarSystemAt(destinationIndex).getX(),
                    game.uni.getSolarSystemAt(destinationIndex).getY(),
                    game.getUniverse(), game.getCurrentLocationIndex(),
                    destinationIndex, WelcomeScreenController.stage);
            game.setCurrentSystem(i);
        }
        //refreshMarketplace();

        selectedLocation.setText("Choose Location");
        currentLocation.setText("Current Location:\n----------------"
                + "\n" + game.getCurrentSystem());
        fuelCost.setText("Fuel Cost:\n");
        fuelText.setText("" + game.getShip().getFuel());
        drawUniverse();
        drawMini();
       
    }

    @FXML
    private void save() throws Exception {
        String fileName = "";
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        File file = fileChooser.showSaveDialog(WelcomeScreenController.stage);
        if (file != null) {
           fileName = file.getName();
        } else {
            throw new Exception();
        }
        WelcomeScreenController.game.save(fileName,
                WelcomeScreenController.game);
    }

    @FXML
    private void leave() throws IOException {
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
    }
}
