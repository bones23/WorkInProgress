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
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.Person;
import model.Ship;
import model.SolarSystem;
import model.TradeItem;
import model.Universe;
/**
 *
 * @author lukenewman
 */
public class MainGameController {
    @FXML
    private Stage stage;
    
    @FXML
    private Label money;
    @FXML
    private Label cargo;
    @FXML
    private Label sellWaterPrice;
    @FXML
    private Label buyWaterPrice;
    @FXML
    private Label sellFurPrice;
    @FXML
    private Label buyFurPrice;
    @FXML
    private Label sellFoodPrice;
    @FXML
    private Label buyFoodPrice;
    @FXML
    private Label sellOrePrice;
    @FXML
    private Label buyOrePrice;
    @FXML
    private Label sellGamesPrice;
    @FXML
    private Label buyGamesPrice;
     @FXML
    private Label sellFirearmsPrice;
    @FXML
    private Label buyFirearmsPrice;
    @FXML
    private Label sellMedicinePrice;
    @FXML
    private Label buyMedicinePrice;
    @FXML
    private Label sellMachinesPrice;
    @FXML
    private Label buyMachinesPrice;
    @FXML
    private Label sellNarcoticsPrice;
    @FXML
    private Label buyNarcoticsPrice;
    @FXML
    private Label sellRobotsPrice;
    @FXML
    private Label buyRobotsPrice;
    @FXML
    private TextField sellWaterQuantity;
    @FXML
    private Button s0;
    @FXML
    private Button s1;
    @FXML
    private Button s2;
    @FXML
    private Button s3;
    @FXML
    private Button s4;
    @FXML
    private Button s5;
    @FXML
    private Button s6;
    @FXML
    private Button s7;
    @FXML
    private Button s8;
    @FXML
    private Button s9;
     @FXML
    private Button b0;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button b5;
    @FXML
    private Button b6;
    @FXML
    private Button b7;
    @FXML
    private Button b8;
    @FXML
    private Button b9;
    @FXML
    private Label sellableWater;
    @FXML
    private Label sellableFurs;
    @FXML
    private Label sellableFood;
    @FXML
    private Label sellableOre;
    @FXML
    private Label sellableGames;
    @FXML
    private Label sellableFirearms;
    @FXML
    private Label sellableMedicine;
    @FXML
    private Label sellableMachines;
    @FXML
    private Label sellableNarcotics;
    @FXML
    private Label sellableRobots;
    @FXML
    private Label buyableWater;
    @FXML
    private Label buyableFur;
    @FXML
    private Label buyableFood;
    @FXML
    private Label buyableOre;
    @FXML
    private Label buyableGames;
    @FXML
    private Label buyableFirearms;
    @FXML
    private Label buyableMedicine;
    @FXML
    private Label buyableMachines;
    @FXML
    private Label buyableNarcotics;
    @FXML
    private Label temp;
    @FXML
    private Label temp2;
    @FXML
    private Label buyableRobots;
    private Universe universe;
    private Ship s;
    private Random rand = new Random();
    int i = rand.nextInt(120);
    int tempp=0;
    @FXML
    private Label currentLocation;
    @FXML
    private Canvas universeMap;
    
    @FXML
    private Label selectedLocation;
    @FXML
    private Canvas miniMap;
    int qq=0;
    @FXML
    private Button TravelHere;
    @FXML
    private void initialize() {
        universe = new Universe();
        s = Person.getShip();
        currentLocation.setText("Current Location:\n----------------\n"+universe.getSolarSystemAt(i));
        
        buyableWater.setText(""+universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(0));
        buyableFur.setText(""+universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(1));
        buyableFood.setText(""+universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(2));
        buyableOre.setText(""+universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(3));
        buyableGames.setText(""+universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(4));
        buyableFirearms.setText(""+universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(5));
        buyableMedicine.setText(""+universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(6));
        buyableMachines.setText(""+universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(7));
        buyableNarcotics.setText(""+universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(8));
        buyableRobots.setText(""+universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(9));
       int cargo =s.getBays()-s.getNumOccupied();
       this.cargo.setText(""+cargo);
       this.money.setText("" + Person.getMoney());
       this.sellWaterPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getSellingPriceAt(0));
       this.buyWaterPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getBuyingPriceAt(0));
       this.sellFurPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getSellingPriceAt(1));
       this.buyFurPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getBuyingPriceAt(1));
       this.sellFoodPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getSellingPriceAt(2));
       this.buyFoodPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getBuyingPriceAt(2));
       this.sellOrePrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getSellingPriceAt(3));
       this.buyOrePrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getBuyingPriceAt(3));
       this.sellGamesPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getSellingPriceAt(4));
       this.buyGamesPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getBuyingPriceAt(4));
       this.sellFirearmsPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getSellingPriceAt(5));
       this.buyFirearmsPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getBuyingPriceAt(5));
       this.sellMedicinePrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getSellingPriceAt(6));
       this.buyMedicinePrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getBuyingPriceAt(6));
       this.sellMachinesPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getSellingPriceAt(7));
       this.buyMachinesPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getBuyingPriceAt(7));
       this.sellNarcoticsPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getSellingPriceAt(8));
       this.buyNarcoticsPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getBuyingPriceAt(8));
       this.sellRobotsPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getSellingPriceAt(9));
       this.buyRobotsPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getBuyingPriceAt(9));
       drawUniverse();
       drawMini();
       System.out.println("number "+qq);
      // universeMap.co
    }
    
    
    @FXML
    private void buyItem(ActionEvent event) throws IOException {
        int itemNum = -1;
        String itemName="Water";
        Object source = event.getSource();Button clickedBtn = (Button) source;
        String ite = clickedBtn.getId();
            if(ite.equals("b0")){itemNum=0;itemName="Water";temp=sellableWater;temp2=buyableWater;}
            else if(ite.equals("b1")){itemNum=1;itemName="Furs";temp=sellableFurs;temp2=buyableFur;}
            else if(ite.equals("b2")){itemNum=2;itemName="Food";temp=sellableFood;temp2=buyableFood;}
            else if(ite.equals("b3")){itemNum=3;itemName="Ore";temp=sellableOre;temp2=buyableOre;}
            else if(ite.equals("b4")){itemNum=4;itemName="Games";temp=sellableGames;temp2=buyableGames;}
            else if(ite.equals("b5")){itemNum=5;itemName="Firearms";temp=sellableFirearms;temp2=buyableFirearms;}
            else if(ite.equals("b6")){itemNum=6;itemName="Medicine";temp=sellableMedicine;temp2=buyableMedicine;}
            else if(ite.equals("b7")){itemNum=7;itemName="Machines";temp=sellableMachines;temp2=buyableMachines;}
            else if(ite.equals("b8")){itemNum=8;itemName="Narcotics";temp=sellableNarcotics;temp2=buyableNarcotics;}
            else if(ite.equals("b9")){itemNum=9;itemName="Robots";temp=sellableRobots;temp2=buyableRobots;}
        int cost =universe.getSolarSystemAt(0).getMarketPlace().getBuyingPriceAt(itemNum);
        if (Person.getMoney() >= cost && s.getBays()-s.getNumOccupied()>0 && universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(itemNum)>0 &&s.addItem(new TradeItem(itemName))==true) 
        {
            universe.getSolarSystemAt(i).getMarketPlace().buyingItem(itemNum, 1);
            this.money.setText("" + Person.getMoney());
            int cargo =s.getBays()-s.getNumOccupied();
            this.cargo.setText(""+cargo);
            int x=s.searchCargo(new TradeItem(itemName));
            temp.setText(""+x);
            temp2.setText(""+universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(itemNum));
            //subtact 1 from buyable
            //add 1 to sellable
            //need set amount in marketplace
        }
    }
    
    @FXML
    private void sellItem(ActionEvent event) throws IOException {
        //int amountWater = 5;
        int itemNum = -1;
        String itemName="";
        Object source = event.getSource();
        Button clickedBtn = (Button) source;
        String ite = clickedBtn.getId();
          if(ite.equals("s0")){itemNum=0;itemName="Water";temp=sellableWater;temp2=buyableWater;}
            else if(ite.equals("s1")){itemNum=1;itemName="Furs";temp=sellableFurs;temp2=buyableFur;}
            else if(ite.equals("s2")){itemNum=2;itemName="Food";temp=sellableFood;temp2=buyableFood;}
            else if(ite.equals("s3")){itemNum=3;itemName="Ore";temp=sellableOre;temp2=buyableOre;}
            else if(ite.equals("s4")){itemNum=4;itemName="Games";temp=sellableGames;temp2=buyableGames;}
            else if(ite.equals("s5")){itemNum=5;itemName="Firearms";temp=sellableFirearms;temp2=buyableFirearms;}
            else if(ite.equals("s6")){itemNum=6;itemName="Medicine";temp=sellableMedicine;temp2=buyableMedicine;}
            else if(ite.equals("s7")){itemNum=7;itemName="Machines";temp=sellableMachines;temp2=buyableMachines;}
            else if(ite.equals("s8")){itemNum=8;itemName="Narcotics";temp=sellableNarcotics;temp2=buyableNarcotics;}
            else if(ite.equals("s9")){itemNum=9;itemName="Robots";temp=sellableRobots;temp2=buyableRobots;}
        int cost = 1*universe.getSolarSystemAt(i).getMarketPlace().getSellingPriceAt(itemNum);
        if(s.removeItem(new TradeItem(itemName))==true)
        {
            universe.getSolarSystemAt(i).getMarketPlace().sellingItem(itemNum, 1);
            this.money.setText("" + Person.getMoney());
            int cargo =s.getBays()-s.getNumOccupied();
            this.cargo.setText(""+cargo);
            int x=s.searchCargo(new TradeItem(itemName));
            //temp.setText(""+x);
            temp.setText(""+x);
            temp2.setText(""+universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(itemNum));
            //subtract 1 from sellable
            //add 1 to buyable
        }
    }
    
    
    private void drawUniverse() {
        GraphicsContext g2d = universeMap.getGraphicsContext2D();
        g2d.setFill(Color.WHITE);
        g2d.fillRect(0, 0, universeMap.getWidth(), universeMap.getHeight());
        Color d = Color.web("#FFFFFF",0.9);
        g2d.setFill(d);
        g2d.fillRect(0, 0, universeMap.getWidth(), universeMap.getHeight());
            Color c = Color.web("#008000",0.5);
                g2d.setFill(c);
                g2d.fillOval((2*universe.getSolarSystemAt(i).getX())-50,(2*universe.getSolarSystemAt(i).getY())-50,100,100);//x-range5/8, y-range5/8
                g2d.setFill(Color.RED);
                g2d.fillOval(2 *universe.getSolarSystemAt(i).getX(),2 * universe.getSolarSystemAt(i).getY(), 4, 4);
                g2d.setFill(Color.BLACK);
        for (int k = 0; k < 120; k++) {
            if(universe.getSolarSystemAt(i)!=universe.getSolarSystemAt(k)){
                g2d.fillOval(2 *universe.getSolarSystemAt(k).getX(),2 * universe.getSolarSystemAt(k).getY(), 2, 2);
            }
            g2d.setFill(Color.BLACK);
        
       
        }
    }
    private LinkedList<SolarSystem> miniSystems;
    private SolarSystem solar;
    private void drawMini() {
        
        GraphicsContext g2d = miniMap.getGraphicsContext2D();
        g2d.setFill(Color.WHITE);
        g2d.fillRect(0, 0, miniMap.getWidth(), miniMap.getHeight());
        Color d = Color.web("#FFFF00",0.5);
        g2d.setFill(d);
        g2d.fillRect(0, 0, miniMap.getWidth(), miniMap.getHeight());
        g2d.setFill(Color.RED);
        g2d.fillOval(140, 90, 10, 10);
        g2d.setFill(Color.BLACK);
        miniSystems = new LinkedList();
        for (int k = 0; k < 120; k++) {
            if(universe.getSolarSystemAt(i)!=universe.getSolarSystemAt(k)){
                
            if (Math.abs(2*universe.getSolarSystemAt(i).getX() - 2*universe.getSolarSystemAt(k).getX()) < 50
                    && Math.abs(2*universe.getSolarSystemAt(i).getY() - 2*universe.getSolarSystemAt(k).getY()) < 50) {
                miniSystems.add(universe.getSolarSystemAt(k));
                System.out.println("planet location "+ universe.getSolarSystemAt(k).getX());
                int x = 4*universe.getSolarSystemAt(i).getX() - 4*universe.getSolarSystemAt(k).getX();
                int y = 4*universe.getSolarSystemAt(i).getY() - 4*universe.getSolarSystemAt(k).getY();
                g2d.fillOval((140-x),(90-y),5,5);
                qq++;
            }
            }
        }
                
    }
    int j=i;
    @FXML
    private void handleMouseClick(MouseEvent event) {
        System.out.println((140-event.getX()-universe.getSolarSystemAt(i).getX())/4);
        int x = (int) event.getX();
        int y = (int) event.getY();
        for(SolarSystem name:miniSystems){
            int x2 = name.getX();
            int y2 = name.getY();
            x2 = 4*universe.getSolarSystemAt(i).getX() - 4*x2;
            y2 = 4*universe.getSolarSystemAt(i).getY() - 4*y2;
            x2= 140- x2;
            y2= 90-y2;
            if((x>=x2&&x<=x2+5)&&(y>=y2&&y<=y2+5)){
                selectedLocation.setText(name.toString());
                for (int i = 0; i < 120; i++) {
                    if (universe.getSolarSystemAt(i).getName().equals(name.getName())) {
                        j = i;
                    }
                }
            }
        }
        
        
    }
    @FXML
    private void Travel(ActionEvent event) throws IOException {
        
        if(Person.getMoney()>=50&&i!=j){
            i=j;
        Person.setMoney(Person.getMoney()-50);
        buyableWater.setText(""+universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(0));
        buyableFur.setText(""+universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(1));
        buyableFood.setText(""+universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(2));
        buyableOre.setText(""+universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(3));
        buyableGames.setText(""+universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(4));
        buyableFirearms.setText(""+universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(5));
        buyableMedicine.setText(""+universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(6));
        buyableMachines.setText(""+universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(7));
        buyableNarcotics.setText(""+universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(8));
        buyableRobots.setText(""+universe.getSolarSystemAt(i).getMarketPlace().getAmountAt(9));
       int cargo =s.getBays()-s.getNumOccupied();
       this.cargo.setText(""+cargo);
       this.money.setText("" + Person.getMoney());
       this.sellWaterPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getSellingPriceAt(0));
       this.buyWaterPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getBuyingPriceAt(0));
       this.sellFurPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getSellingPriceAt(1));
       this.buyFurPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getBuyingPriceAt(1));
       this.sellFoodPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getSellingPriceAt(2));
       this.buyFoodPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getBuyingPriceAt(2));
       this.sellOrePrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getSellingPriceAt(3));
       this.buyOrePrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getBuyingPriceAt(3));
       this.sellGamesPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getSellingPriceAt(4));
       this.buyGamesPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getBuyingPriceAt(4));
       this.sellFirearmsPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getSellingPriceAt(5));
       this.buyFirearmsPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getBuyingPriceAt(5));
       this.sellMedicinePrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getSellingPriceAt(6));
       this.buyMedicinePrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getBuyingPriceAt(6));
       this.sellMachinesPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getSellingPriceAt(7));
       this.buyMachinesPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getBuyingPriceAt(7));
       this.sellNarcoticsPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getSellingPriceAt(8));
       this.buyNarcoticsPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getBuyingPriceAt(8));
       this.sellRobotsPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getSellingPriceAt(9));
       this.buyRobotsPrice.setText("" + universe.getSolarSystemAt(i).getMarketPlace().getBuyingPriceAt(9));
       selectedLocation.setText("");
        drawUniverse();
       drawMini();
        }
    }
 
}