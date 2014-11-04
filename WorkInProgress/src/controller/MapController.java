/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.*;
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
   // Game game = WelcomeScreenController.game;
    MarketPlace market = game.getMarket();
    int currentLocationIndex = WelcomeScreenController.game.getCurrentLocationIndex();
    Ship ship = WelcomeScreenController.game.getShip();
    //Sell price labels
    @FXML
    private Label sellWaterPrice,sellFurPrice,sellFoodPrice,sellOrePrice,sellGamesPrice,sellFirearmsPrice,sellMedicinePrice,sellMachinesPrice,sellNarcoticsPrice,sellRobotsPrice,cargo;
    //Buy price labels
    @FXML
    private Label buyWaterPrice,buyFurPrice,buyFoodPrice,buyOrePrice,buyGamesPrice,buyFirearmsPrice
            ,buyMedicinePrice,buyMachinesPrice,buyNarcoticsPrice,buyRobotsPrice;
    //Sell buttons
    @FXML
    private Button s0, s1, s2, s3, s4, s5, s6, s7, s8, s9;
    //Buy buttons
    @FXML
    private Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9,save,Shipyard;
    //Labels for sellable items
    @FXML
    private Label sellableWater, sellableFurs, sellableFood, sellableOre, sellableGames, sellableFirearms, sellableMedicine,
            sellableMachines, sellableNarcotics, sellableRobots;
    //Labels for buyable items
    @FXML
    private Label buyableWater, buyableFur, buyableFood, buyableOre, buyableGames, buyableFirearms, buyableMedicine,
            buyableMachines, buyableNarcotics, buyableRobots;
    //what the fuck do these even do?
    @FXML
    private Label temp;
    @FXML
    private Label temp2;
    
     @FXML
    private void initialize() {
        game = WelcomeScreenController.game;
        market = game.currentSystem.getMarketPlace();
        refreshMarketplace();
        drawUniverse();
        drawMini();
         this.money.setText(""+game.getMoney());
        fuelText.setText("" + game.ship.getFuel());
         currentLocation.setText("Current Location:\n----------------\n"+game.getCurrentSystem());
        if (game.getCurrentSystem().getTechLevel()>3) {
            Shipyard.setVisible(true);
            
        }
        else{
            Shipyard.setVisible(false);
        }
    }
    
    
    
    @FXML
    private void showShipyard() throws IOException{
        Stage stage;
         AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ShipYard.fxml"));
          
            Scene scene = new Scene(pane);
            stage = WelcomeScreenController.stage;
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setWidth(600);
            stage.setHeight(425);
            stage.show();
    }
    /**
     * Draws the universe map based on the current position
     */
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
    /*
    calculates whether or not what the user clicked was a planet
    If it is a planet, then planet data and the fuel cost to get there are displayed.
    */
    @FXML
    private void handleMouseClick(MouseEvent event) {
        Ship ship = WelcomeScreenController.game.getShip();
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
    
    /**
     * Helper method which refreshes the maps
     */
    @FXML
    public void refreshMaps(){
        drawMini();
        drawUniverse();
    }
    /*
    buys fuel to fill the player's fueltank if player has enough money.
    updates the fuel displayed on UI.
    updates the amount of money displayed on UI.
    */
    @FXML
    public void buyFuel(ActionEvent event) throws IOException {
        game.ship.buyFuel();
        fuelText.setText("" + game.ship.getFuel()); 
        this.money.setText(""+game.getMoney());
        //figure out a way to update the maps from this controller
        refreshMaps();
    }
    /**
     * Updates the ships labels
     */
    public void refreshShip(){
        fuelText.setText("" + game.ship.getFuel());
        spaceLeft.setText("" + game.ship.getSpaceLeft());
    }
    /**
     * Travel method which calls the ship's travel method.
     * Will only travel if the targeted solarSysten isnt the solarSystem you
     * currently are on.
     * @param event
     * @throws IOException 
     */
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
        refreshMarketplace();
        if (game.getCurrentSystem().getTechLevel()>3) {
            Shipyard.setVisible(true);
            
        }
        else{
            Shipyard.setVisible(false);
        }
    }
    
    /**
     * Buys an item from a marketplace and updates the associated labels. 
     * @param event
     * @throws IOException 
     */
     @FXML
    private void buyItem(ActionEvent event) throws IOException {
        String itemName="";
        Object source = event.getSource();
        Button clickedBtn = (Button) source;
        String ite = clickedBtn.getId();
        itemName = market.buyingItem(ite, game.getUniverse(), game.getCurrentLocationIndex(), game.getShip());
        if(itemName != null){
            switch(itemName){
                case "Water":
                    temp=sellableWater;
                    temp2=buyableWater;
                    break;
                case "Furs":
                    temp=sellableFurs;
                    temp2=buyableFur;
                    break;
                case "Food":
                    temp=sellableFood;
                    temp2=buyableFood;
                    break;
                case "Ore":
                    temp=sellableOre;
                    temp2=buyableOre;
                    break;
                case "Games":
                    temp=sellableGames;
                    temp2=buyableGames;
                    break;
                case "Firearms":
                    temp=sellableFirearms;
                    temp2=buyableFirearms;
                    break;
                case "Medicine":
                    temp=sellableMedicine;
                    temp2=buyableMedicine;
                    break;
                case "Machines":
                    temp=sellableMachines;
                    temp2=buyableMachines;
                    break;
                case "Narcotics":
                    temp=sellableNarcotics;
                    temp2=buyableNarcotics;
                    break;
                case "Robots":
                    temp=sellableRobots;
                    temp2=buyableRobots;
                    break;
            }
            temp.setText(""+game.getShip().searchCargo(new TradeItem(itemName)));
            temp2.setText(""+market.getAmountAt(Integer.parseInt(ite.substring(1))));
            this.cargo.setText(""+game.getShip().getSpaceLeft());
            this.money.setText(""+game.getMoney());
        }            
            //subtact 1 from buyable
            //add 1 to sellable
            //need set amount in marketplace
    }
    /**
     * Sells an item. item is taken out of inventory and player receives money.
     * @param event
     * @throws IOException 
     */
    @FXML
    private void sellItem(ActionEvent event) throws IOException {
        String itemName="";
        Object source = event.getSource();
        Button clickedBtn = (Button) source;
        String ite = clickedBtn.getId();
        itemName = market.sellingItem(ite, game.getUniverse(), game.getCurrentLocationIndex(), game.getShip());
        if(itemName != null){
            switch(itemName){
                case "Water":
                    temp=sellableWater;
                    temp2=buyableWater;
                    break;
                case "Furs":
                    temp=sellableFurs;
                    temp2=buyableFur;
                    break;
                case "Food":
                    temp=sellableFood;
                    temp2=buyableFood;
                    break;
                case "Ore":
                    temp=sellableOre;
                    temp2=buyableOre;
                    break;
                case "Games":
                    temp=sellableGames;
                    temp2=buyableGames;
                    break;
                case "Firearms":
                    temp=sellableFirearms;
                    temp2=buyableFirearms;
                    break;
                case "Medicine":
                    temp=sellableMedicine;
                    temp2=buyableMedicine;
                    break;
                case "Machines":
                    temp=sellableMachines;
                    temp2=buyableMachines;
                    break;
                case "Narcotics":
                    temp=sellableNarcotics;
                    temp2=buyableNarcotics;
                    break;
                case "Robots":
                    temp=sellableRobots;
                    temp2=buyableRobots;
                    break;
            }
            temp.setText(""+game.getShip().searchCargo(new TradeItem(itemName)));
            temp2.setText(""+market.getAmountAt(Integer.parseInt(ite.substring(1))));
            this.cargo.setText(""+game.getShip().getSpaceLeft());
            this.money.setText(""+game.getMoney());
            //subtract 1 from sellable
            //add 1 to buyable
        }
    }
    
    /**
    Updates the market place UI
    as well as the player's cargo and money
    */
    public  void refreshMarketplace(){
         market = game.currentSystem.getMarketPlace();
        buyableWater.setText(""+market.getAmountAt(0));
        buyableFur.setText(""+market.getAmountAt(1));
        buyableFood.setText(""+market.getAmountAt(2));
        buyableOre.setText(""+market.getAmountAt(3));
        buyableGames.setText(""+market.getAmountAt(4));
        buyableFirearms.setText(""+market.getAmountAt(5));
        buyableMedicine.setText(""+market.getAmountAt(6));
        buyableMachines.setText(""+market.getAmountAt(7));
        buyableNarcotics.setText(""+market.getAmountAt(8));
        buyableRobots.setText(""+market.getAmountAt(9));
        sellableWater.setText(""+game.getShip().searchCargo(new TradeItem("Water")));
        sellableFurs.setText(""+game.getShip().searchCargo(new TradeItem("Furs")));
        sellableFood.setText(""+game.getShip().searchCargo(new TradeItem("Food")));
        sellableOre.setText(""+game.getShip().searchCargo(new TradeItem("Ore")));
        sellableGames.setText(""+game.getShip().searchCargo(new TradeItem("Games")));
        sellableFirearms.setText(""+game.getShip().searchCargo(new TradeItem("Firearms")));
        sellableMedicine.setText(""+game.getShip().searchCargo(new TradeItem("Medicine")));
        sellableMachines.setText(""+game.getShip().searchCargo(new TradeItem("Machines")));
        sellableNarcotics.setText(""+game.getShip().searchCargo(new TradeItem("Narcotics")));
        sellableRobots.setText(""+game.getShip().searchCargo(new TradeItem("Robots")));
        int cargo =game.getShip().getSpaceLeft();
        //this should be set in ship controller
        this.cargo.setText(""+game.getShip().getSpaceLeft());
        //should be set in person controller
        Person player = game.getPlayer();
        
        int cash = player.getMoney();
        this.money.setText(""+cash);
        this.sellWaterPrice.setText("" + market.getSellingPriceAt(0));
        this.buyWaterPrice.setText("" + market.getBuyingPriceAt(0));
        this.sellFurPrice.setText("" + market.getSellingPriceAt(1));
        this.buyFurPrice.setText("" + market.getBuyingPriceAt(1));
        this.sellFoodPrice.setText("" + market.getSellingPriceAt(2));
        this.buyFoodPrice.setText("" + market.getBuyingPriceAt(2));
        this.sellOrePrice.setText("" + market.getSellingPriceAt(3));
        this.buyOrePrice.setText("" + market.getBuyingPriceAt(3));
        this.sellGamesPrice.setText("" + market.getSellingPriceAt(4));
        this.buyGamesPrice.setText("" + market.getBuyingPriceAt(4));
        this.sellFirearmsPrice.setText("" + market.getSellingPriceAt(5));
        this.buyFirearmsPrice.setText("" + market.getBuyingPriceAt(5));
        this.sellMedicinePrice.setText("" + market.getSellingPriceAt(6));
        this.buyMedicinePrice.setText("" + market.getBuyingPriceAt(6));
        this.sellMachinesPrice.setText("" + market.getSellingPriceAt(7));
        this.buyMachinesPrice.setText("" + market.getBuyingPriceAt(7));
        this.sellNarcoticsPrice.setText("" + market.getSellingPriceAt(8));
        this.buyNarcoticsPrice.setText("" + market.getBuyingPriceAt(8));
        this.sellRobotsPrice.setText("" + market.getSellingPriceAt(9));
        this.buyRobotsPrice.setText("" + market.getBuyingPriceAt(9));
    }
    /**
     * Saves the game using serialization.
     * @throws IOException
     * @throws Exception 
     */
    @FXML
    private void save() throws IOException, Exception{
        String fileName="";
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        File file = fileChooser.showSaveDialog(WelcomeScreenController.stage);
        if (file != null) {
           fileName = file.getName();
        } else {
            throw new Exception();
        }
        WelcomeScreenController.game.save(fileName, WelcomeScreenController.game);
        //
        
    }

}
