package controller;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.*;

/**
 * @author lukenewman
 * @author pretty much everyone
 */
public class MainGameController {
    //CHECKSTYLE: OFF
    //Main stage variable
    @FXML
    private Stage stage;
    //Status labels
    //money should go to personal info
    //fueltext and cargo should go to ship
    @FXML
    private Label money, fuelText, cargo;
    //instance of the player's ship
    private Ship s;
    //Sell price labels
    @FXML
    private Label sellWaterPrice,sellFurPrice,sellFoodPrice,sellOrePrice,sellGamesPrice,
            sellFirearmsPrice,sellMedicinePrice,sellMachinesPrice,sellNarcoticsPrice,sellRobotsPrice;
    //Buy price labels
    @FXML
    private Label buyWaterPrice,buyFurPrice,buyFoodPrice,buyOrePrice,buyGamesPrice,buyFirearmsPrice
            ,buyMedicinePrice,buyMachinesPrice,buyNarcoticsPrice,buyRobotsPrice;
    //Sell buttons
    @FXML
    private Button s0, s1, s2, s3, s4, s5, s6, s7, s8, s9;
    //Buy buttons
    @FXML
    private Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
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
    //universe initialization
    private Universe universe;
    private MarketPlace market;
    private final Random rand = new Random();
    int i = rand.nextInt(120);
    @FXML
    private Label currentLocation;
    @FXML
    private Canvas universeMap;
    @FXML
    private Label fuelCost;
    @FXML
    private Label selectedLocation;
    @FXML
    private Canvas miniMap;
    @FXML
    private Button TravelHere;
    private int fuelMax;
    @FXML
    private Button buyFuel;
    public Game game;
    //review this for code that should be elsewhere
    //CHECKSTYLE: ON

    @FXML
    private void initialize() {
        game = WelcomeScreenController.game;
        universe = game.getUniverse();
        s = game.getShip();
        market = game.currentSystem.getMarketPlace();
        fuelMax = game.getShip().getFuel();
        currentLocation.setText("Current Location:\n----------------\n"
                + game.currentSystem.toString());
        refreshMarketplace();
        drawUniverse();
        drawMini();
        fuelText.setText("" + game.getShip().getFuel());
    }

    @FXML
    private void buyItem(final ActionEvent event) throws IOException {
        String itemName = "";
        Object source = event.getSource();
        Button clickedBtn = (Button) source;
        String ite = clickedBtn.getId();
        itemName = market.buyingItem(ite, universe, i, s);
        if (itemName != null) {
            switch(itemName) {
                case "Water":
                    temp = sellableWater;
                    temp2 = buyableWater;
                    break;
                case "Furs":
                    temp = sellableFurs;
                    temp2 = buyableFur;
                    break;
                case "Food":
                    temp = sellableFood;
                    temp2 = buyableFood;
                    break;
                case "Ore":
                    temp = sellableOre;
                    temp2 = buyableOre;
                    break;
                case "Games":
                    temp = sellableGames;
                    temp2 = buyableGames;
                    break;
                case "Firearms":
                    temp = sellableFirearms;
                    temp2 = buyableFirearms;
                    break;
                case "Medicine":
                    temp = sellableMedicine;
                    temp2 = buyableMedicine;
                    break;
                case "Machines":
                    temp = sellableMachines;
                    temp2 = buyableMachines;
                    break;
                case "Narcotics":
                    temp = sellableNarcotics;
                    temp2 = buyableNarcotics;
                    break;
                case "Robots":
                    temp = sellableRobots;
                    temp2 = buyableRobots;
                    break;
                default:break;
            }
            temp.setText("" + game.getShip()
                    .searchCargo(new TradeItem(itemName)));
            temp2.setText("" + market.getAmountAt(Integer
                    .parseInt(ite.substring(1))));
            System.out.println(game.getPlayer());
            this.money.setText("" + game.getPlayer().getMoney());
            this.cargo.setText("" + game.getShip().getSpaceLeft());
        }
            //subtact 1 from buyable
            //add 1 to sellable
            //need set amount in marketplace
    }

    @FXML
    private void sellItem(final ActionEvent event) throws IOException {
        String itemName = "";
        Object source = event.getSource();
        Button clickedBtn = (Button) source;
        String ite = clickedBtn.getId();
        itemName = market.sellingItem(ite, universe, i, s);
        if (itemName != null) {
            switch(itemName) {
                case "Water":
                    temp = sellableWater;
                    temp2 = buyableWater;
                    break;
                case "Furs":
                    temp = sellableFurs;
                    temp2 = buyableFur;
                    break;
                case "Food":
                    temp = sellableFood;
                    temp2 = buyableFood;
                    break;
                case "Ore":
                    temp = sellableOre;
                    temp2 = buyableOre;
                    break;
                case "Games":
                    temp = sellableGames;
                    temp2 = buyableGames;
                    break;
                case "Firearms":
                    temp = sellableFirearms;
                    temp2 = buyableFirearms;
                    break;
                case "Medicine":
                    temp = sellableMedicine;
                    temp2 = buyableMedicine;
                    break;
                case "Machines":
                    temp = sellableMachines;
                    temp2 = buyableMachines;
                    break;
                case "Narcotics":
                    temp = sellableNarcotics;
                    temp2 = buyableNarcotics;
                    break;
                case "Robots":
                    temp = sellableRobots;
                    temp2 = buyableRobots;
                    break;
                default:break;
            }
            temp.setText("" + s.searchCargo(new TradeItem(itemName)));
            temp2.setText("" + market.getAmountAt(Integer
                    .parseInt(ite.substring(1))));
            this.money.setText("" + game.getPlayer().getMoney());
            this.cargo.setText("" + game.getShip().getSpaceLeft());
            //subtract 1 from sellable
            //add 1 to buyable
        }
    }

    /**
     * Draw the Universe as a map.
     */
    private void drawUniverse() {
        GraphicsContext g2d = universeMap.getGraphicsContext2D();
        g2d.setFill(Color.WHITE);
        g2d.fillRect(0, 0, universeMap.getWidth(), universeMap.getHeight());
        Color d = Color.web("#FFFFFF", 0.9);
        g2d.setFill(d);
        g2d.fillRect(0, 0, universeMap.getWidth(), universeMap.getHeight());
        Color c = Color.web("#008000", 0.5);
        int r = 2 * s.getFuel();
        g2d.setFill(c);
        g2d.fillOval((2 * universe.getSolarSystemAt(i).getX()) - r + 2,
                (2 * universe.getSolarSystemAt(i).getY())
                - r + 2, 4 * s.getFuel() + 1, 4 * s.getFuel() + 1);
                //x-range5/8, y-range5/8
        g2d.setFill(Color.RED);
        g2d.fillOval(2 * universe.getSolarSystemAt(i).getX(),
                2 * universe.getSolarSystemAt(i).getY(), 4, 4);
        g2d.setFill(Color.BLACK);
        for (int k = 0; k < 120; k++) {
            if (universe.getSolarSystemAt(i) != universe.getSolarSystemAt(k)) {
                g2d.fillOval(2 * universe.getSolarSystemAt(k).getX(),
                        2 * universe.getSolarSystemAt(k).getY(), 2, 2);
            }
            g2d.setFill(Color.BLACK);
        }
    }

    private LinkedList<SolarSystem> miniSystems;
    /**
     * Draw the MiniMap.
     */
    private void drawMini() {
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
            if (universe.getSolarSystemAt(i) != universe.getSolarSystemAt(k)) {
            int currentX = universe.getSolarSystemAt(i).getX();
            int currentY = universe.getSolarSystemAt(i).getY();
            int selectedX = universe.getSolarSystemAt(k).getX();
            int selectedY = universe.getSolarSystemAt(k).getY();
            int distance = (int) Math.sqrt(Math.pow((double) Math
                    .abs(currentX - selectedX), 2) + (double) Math
                            .pow(Math.abs(currentY - selectedY), 2));
            if (distance <= s.getFuel()) {
                miniSystems.add(universe.getSolarSystemAt(k));
               // System.out.println("planet location "+ universe
               // .getSolarSystemAt(k).getX());
                int x = 4 * universe.getSolarSystemAt(i).getX()
                        - 4 * universe.getSolarSystemAt(k).getX();
                int y = 4 * universe.getSolarSystemAt(i).getY()
                        - 4 * universe.getSolarSystemAt(k).getY();
                g2d.fillOval((140 - x), (90 - y), 5, 5);
            }
            }
        }
    }
    int j = i;
    //mouse click event on minimap for travel
    @FXML
    private void handleMouseClick(final MouseEvent event) {
      //  System.out.println((140-event.getX()-universe.getSolarSystemAt(i)
      //  .getX())/4);
        int x = (int) event.getX();
        int y = (int) event.getY();
        for (SolarSystem name : miniSystems) {
            int x2 = name.getX();
            int y2 = name.getY();
            x2 = 4 * universe.getSolarSystemAt(i).getX() - 4 * x2;
            y2 = 4 * universe.getSolarSystemAt(i).getY() - 4 * y2;
            x2 = 140 - x2;
            y2 = 90 - y2;

            if((x >= x2 && x <= x2 + 5) && (y >= y2 &&y <= y2 + 5)) {
                selectedLocation.setText("Selected Location:"
                        + "\n----------------\n" + name.toString());
                for (int i = 0; i < 120; i++) {
                    if (universe.getSolarSystemAt(i).getName()
                            .equals(name.getName())) {
                        j = i;
                    }
                }
            }
            int currentX = universe.getSolarSystemAt(i).getX();
            int currentY = universe.getSolarSystemAt(i).getY();
            int selectedX = universe.getSolarSystemAt(j).getX();
            int selectedY = universe.getSolarSystemAt(j).getY();
            int distance = (int) Math.sqrt(Math.pow((double) Math
                    .abs(currentX - selectedX), 2)
                    + (double) Math.pow(Math.abs(currentY - selectedY), 2));
            if (distance != 0) {
                fuelCost.setText("Fuel Cost:\n" + distance);
            }
        }
    }

    //needs to go to MapController
    @FXML
    private void travel(final ActionEvent event) throws IOException {
        if (i != j) {
            i = game.getShip().travel(game.uni.getSolarSystemAt(j).getX(),
                    game.uni.getSolarSystemAt(j).getY(), game.getUniverse(),
                    game.getCurrentLocationIndex(), j,
                    WelcomeScreenController.stage);
        }
        refreshMarketplace();
        selectedLocation.setText("Choose Location");
        currentLocation.setText("Current Location:\n----------------\n"
                + game.getCurrentSystem());
        fuelCost.setText("Fuel Cost:\n");
        fuelText.setText("" + game.getShip().getFuel());
        drawUniverse();
        drawMini();
    }
    //needs to go to marketplacecontroller
    //refresh marketplace
    @FXML
    private void refreshMarketplace() {
        market = universe.getSolarSystemAt(i).getMarketPlace();
        buyableWater.setText("" + market.getAmountAt(0));
        buyableFur.setText("" + market.getAmountAt(1));
        buyableFood.setText("" + market.getAmountAt(2));
        buyableOre.setText("" + market.getAmountAt(3));
        buyableGames.setText("" + market.getAmountAt(4));
        buyableFirearms.setText("" + market.getAmountAt(5));
        buyableMedicine.setText("" + market.getAmountAt(6));
        buyableMachines.setText("" + market.getAmountAt(7));
        buyableNarcotics.setText("" + market.getAmountAt(8));
        buyableRobots.setText("" + market.getAmountAt(9));
        int cargo = s.getBays() - s.getOccupiedSlots();
        this.cargo.setText("" + s.getSpaceLeft());
        //this.money.setText("" + Person.getMoney());
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
    //should go to ShipController
    @FXML
    private void buyFuel(final ActionEvent event) throws IOException {
        game.ship.buyFuel();
        fuelText.setText("" + s.getFuel());
        money.setText("" + WelcomeScreenController.game.getPlayer().getMoney());
        drawUniverse();
        drawMini();
    }
}