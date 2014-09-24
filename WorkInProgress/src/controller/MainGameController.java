/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author lukenewman
 */
public class MainGameController {
    @FXML
    private Stage stage;
    
    @FXML
    private void sellWater(ActionEvent event) throws IOException {
        System.out.println("sell some water");
    }
}
