/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javafx.application.Platform;
import javax.swing.Timer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import model.Pirate;

/**
 *
 * @author Brandon
 */
public class EncounterController {
    @FXML
    private Canvas canvas;
    @FXML
    private Button attack, surrender, dodge, flee;
    private Image ship, pirateShip, bullet, refresh, pirateShipHit, shipHit;
    private final int bulletVelocity = 10;
    private final int bulletx1 = 47;
    private final int bullety1 = 123;
    private final int bullety2 = 90;
    private final int bulletx3 = 425;
    private final int bullety3 = 125;
    private int x = bulletx1;
    private int x2 = bulletx3;
    private Timer attackTimer;
    private Pirate pirate;
    @FXML
    private void initialize() {
        ship = new Image("/supporting/Ship.png");
        shipHit = new Image("/supporting/ShipHit.png");
        pirateShip = new Image("/supporting/pirateship.png");
        pirateShipHit = new Image("/supporting/pirateshiphit.png");
        bullet = new Image("/supporting/bullet.png");
        refresh = new Image("/supporting/refresh.PNG");
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.drawImage(refresh, 0, 0);
        graphicsContext.drawImage(ship, 5, 75);
        graphicsContext.drawImage(pirateShip, 430, 75);
        //graphicsContext.drawImage(bullet, 425, 125);
        //graphicsContext.drawImage(bullet, 47, 123);
        //graphicsContext.drawImage(bullet, 47, 90);
        //pirate bullet at 425, 125
        //ship bullet at 47, 123 and 47, 90
        attackTimer = new Timer(9, new AttackTimer());
    }
    
    @FXML
    private void attack() throws IOException {
        
        attackTimer.start();
      
    }
    
    private void shoot() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        if (x < 420) {
            graphicsContext.drawImage(refresh, 0, 0);
            graphicsContext.drawImage(ship, 5, 75);
            graphicsContext.drawImage(pirateShip, 430, 75);
            graphicsContext.drawImage(bullet, x, bullety1);
            graphicsContext.drawImage(bullet, x, bullety2);
           
        }
        if (x < 1000) {
            x += 5 ;
        }
        //collision to pirate
        if (x >= 420) {
            graphicsContext.drawImage(refresh, 0, 0);
            graphicsContext.drawImage(ship, 5, 75);
            graphicsContext.drawImage(pirateShipHit, 430, 75);
            if (x > 500) {
                graphicsContext.drawImage(refresh, 0, 0);
                graphicsContext.drawImage(ship, 5, 75);
                graphicsContext.drawImage(pirateShip, 430, 75);
            }
        }
        if (x >= 650) {
            graphicsContext.drawImage(refresh, 0, 0);
            graphicsContext.drawImage(ship, 5, 75);
            graphicsContext.drawImage(pirateShip, 430, 75);
        }
        if (x >= 1000) {
            graphicsContext.drawImage(refresh, 0, 0);
            graphicsContext.drawImage(ship, 5, 75);
            graphicsContext.drawImage(pirateShip, 430, 75);
            graphicsContext.drawImage(bullet, x2, bullety3);
            x2 -= 5;
            if (x2 <= 75) {
                graphicsContext.drawImage(refresh, 0, 0);
                graphicsContext.drawImage(shipHit, 5, 75);
                graphicsContext.drawImage(pirateShip, 430, 75);
                if (x2 <= -5) {
                    graphicsContext.drawImage(refresh, 0, 0);
                    graphicsContext.drawImage(ship, 5, 75);
                    graphicsContext.drawImage(pirateShip, 430, 75);
                    x = bulletx1;
                    x2 = bulletx3;
                    attackTimer.stop();
                }
            }
        }
    }
    @FXML
    private void surrender() throws IOException {
        
    }
    
    @FXML
    private void flee() throws IOException {
        
    }
    
    @FXML
    private void dodge() throws IOException {
        
    }
    private void reset() {
        
    }
    
    private class AttackTimer implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Platform.runLater(new Runnable() {
            @Override
            public void run() {
                shoot();
            }   
            });
        }
    }
}
