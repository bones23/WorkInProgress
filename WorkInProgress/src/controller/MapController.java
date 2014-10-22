/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.LinkedList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.*;
import javafx.fxml.FXML;
/**
 *
 * @author frenc_000
 */
public class MapController {
    private Canvas universeMap;
    private Canvas miniMap;
    private LinkedList<SolarSystem> miniSystems;
    Game game = WelcomeScreenController.game;
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
    public void refreshMaps(){
        drawMini();
        drawUniverse();
    }
}
