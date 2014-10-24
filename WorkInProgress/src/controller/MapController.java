/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
/**
 *
 * @author frenc_000
 */
public class MapController  {
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
    private Label fuelText,carge,money;
    private Random rand = new Random();
    int i = game.getCurrentLocationIndex();
    int destinationIndex = i;
     @FXML
    private void initialize() {
        drawUniverse();
        drawMini();
    }
    @FXML
    public void drawUniverse() {
        Universe universe = game.getUniverse();
        GraphicsContext g2d = universeMap.getGraphicsContext2D();
        g2d.setFill(Color.WHITE);
        g2d.fillRect(0, 0, universeMap.getWidth(), universeMap.getHeight());
        Color d = Color.web("#FFFFFF",0.9);
        g2d.setFill(d);
        g2d.fillRect(0, 0, universeMap.getWidth(), universeMap.getHeight());
        Color c = Color.web("#008000",0.5);
        int r = 2 * game.getShip().getFuel();
        g2d.setFill(c);
        g2d.fillOval((2*game.currentSystem.getX())-r + 2,(2*game.currentSystem.getY()) 
                - r + 2,4 * game.getShip().getFuel() + 1,4 * game.getShip().getFuel() + 1);//x-range5/8, y-range5/8
        g2d.setFill(Color.RED);
        g2d.fillOval(2 *game.currentSystem.getX(),2 * game.currentSystem.getY(), 4, 4);
        g2d.setFill(Color.BLACK);
        for (int k = 0; k < 120; k++) {
            if(game.currentSystem != game.getUniverse().getSolarSystemAt(k)){
                g2d.fillOval(2 *universe.getSolarSystemAt(k).getX(),2 * universe.getSolarSystemAt(k).getY(), 2, 2);
            }
            g2d.setFill(Color.BLACK);
        }
    }
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
            if(game.currentSystem!=game.uni.getSolarSystemAt(k)){
            int currentX = game.currentSystem.getX();
            int currentY = game.currentSystem.getY();
            int selectedX = game.uni.getSolarSystemAt(k).getX();
            int selectedY = game.uni.getSolarSystemAt(k).getY();
            int distance = (int)Math.sqrt(Math.pow((double)Math.abs(currentX - selectedX), 2) + (double)Math.pow(Math.abs(currentY - selectedY), 2));
            if (distance <= game.ship.getFuel()) {
                miniSystems.add(game.uni.getSolarSystemAt(k));
               // System.out.println("planet location "+ universe.getSolarSystemAt(k).getX());
                int x = 4*game.currentSystem.getX() - 4*game.uni.getSolarSystemAt(k).getX();
                int y = 4*game.currentSystem.getY() - 4*game.uni.getSolarSystemAt(k).getY();
                g2d.fillOval((140-x),(90-y),5,5);
            }
            }
        }     
    }
    @FXML
    private Label selectedLocation,fuelCost;
    @FXML
    private void handleMouseClick(MouseEvent event) {
      //  System.out.println((140-event.getX()-universe.getSolarSystemAt(i).getX())/4);
        int x = (int) event.getX();
        int y = (int) event.getY();
        for(SolarSystem name:miniSystems){
            int x2 = name.getX();
            int y2 = name.getY();
            x2 = 4*game.getCurrentSystem().getX() - 4*x2;
            y2 = 4*game.getCurrentSystem().getY() - 4*y2;
            x2= 140- x2;
            y2= 90-y2;
            
            if((x>=x2&&x<=x2+5)&&(y>=y2&&y<=y2+5)){
                selectedLocation.setText("Selected Location:\n----------------\n" + name.toString());
                for (int i = 0; i < 120; i++) {
                    if (game.uni.getSolarSystemAt(i).getName().equals(name.getName())) {
                        destinationIndex = i;
                    }
                }
            }
            int currentX = game.getCurrentSystem().getX();
            int currentY = game.getCurrentSystem().getY();
            int selectedX = game.uni.getSolarSystemAt(destinationIndex).getX();
            int selectedY = game.uni.getSolarSystemAt(destinationIndex).getY();
            int distance = (int)Math.sqrt(Math.pow((double)Math.abs(currentX - selectedX), 2) + (double)Math.pow(Math.abs(currentY - selectedY), 2));
            //if (distance != 0)
                fuelCost.setText("Fuel Cost:\n" + distance);
        }
    }
    @FXML
    public void refreshMaps(){
        drawMini();
        drawUniverse();
    }
    @FXML
    public void buyFuel(ActionEvent event) throws IOException {
        game.ship.buyFuel();
        fuelText.setText("" + game.ship.getFuel()); 
        //figure out a way to update the maps from this controller
        refreshMaps();
    }
    public void refreshShip(){
        fuelText.setText("" + game.ship.getFuel());
        spaceLeft.setText("" + game.ship.getSpaceLeft());
    }
    @FXML
    private void Travel(ActionEvent event) throws IOException {
        if(i!=destinationIndex){
            i = game.getShip().travel(game.uni.getSolarSystemAt(destinationIndex).getX(), game.uni.getSolarSystemAt(destinationIndex).getY(), game.getUniverse(), game.getCurrentLocationIndex(), destinationIndex,WelcomeScreenController.stage);
            game.setCurrentSystem(i);
        }
        //refreshMarketplace();
        
        selectedLocation.setText("Choose Location");
        currentLocation.setText("Current Location:\n----------------\n"+game.getCurrentSystem());
        fuelCost.setText("Fuel Cost:\n");
        fuelText.setText("" + game.getShip().getFuel());
        drawUniverse();
        drawMini();
        new MarketplaceController().freshPrince();
    }
}
