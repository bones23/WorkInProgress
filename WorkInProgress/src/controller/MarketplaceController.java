package controller;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import model.Game;
import model.Ship;
import model.MarketPlace;
import model.TradeItem;
import model.Person;

/**
 *
 * @author frenc_000
 */
public class MarketplaceController {
    //CHECKSTYLE: OFF
    //I need to call these from the game somehow
    Game game = WelcomeScreenController.game;
    MarketPlace market = game.getMarket();
    int currentLocationIndex = WelcomeScreenController.game.getCurrentLocationIndex();
    Ship ship = WelcomeScreenController.game.getShip();
    //Sell price labels
    @FXML
    private Label sellWaterPrice,sellFurPrice,sellFoodPrice,sellOrePrice,sellGamesPrice,
            sellFirearmsPrice,sellMedicinePrice,sellMachinesPrice,sellNarcoticsPrice,sellRobotsPrice,fuelText,cargo,money;
    //Buy price labels
    @FXML
    private Label buyWaterPrice,buyFurPrice,buyFoodPrice,buyOrePrice,buyGamesPrice,buyFirearmsPrice
            ,buyMedicinePrice,buyMachinesPrice,buyNarcoticsPrice,buyRobotsPrice;
    //Sell buttons
    @FXML
    private Button s0, s1, s2, s3, s4, s5, s6, s7, s8, s9;
    //Buy buttons
    @FXML
    private Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9,save;
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
    //CHECKSTYLE: ON

    @FXML
    private void initialize() {
        game = WelcomeScreenController.game;
        market = game.currentSystem.getMarketPlace();
        refreshMarketplace();
    }
    
    /**
     * Purchase an item.
     * @param event event
     * @throws IOException A 
     */
    @FXML
    private void buyItem(final ActionEvent event) throws IOException {
        String itemName = "";
        Object source = event.getSource();
        Button clickedBtn = (Button) source;
        String ite = clickedBtn.getId();
        itemName = market.buyingItem(ite, game.getUniverse(),
                game.getCurrentLocationIndex(), game.getShip());
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
            temp2.setText("" + market
                    .getAmountAt(Integer.parseInt(ite.substring(1))));
            this.cargo.setText("" + game.getShip().getSpaceLeft());
            this.money.setText("" + game.getMoney());
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
        itemName = market.sellingItem(ite, game.getUniverse(),
                game.getCurrentLocationIndex(), game.getShip());
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
            temp2.setText("" + market
                    .getAmountAt(Integer.parseInt(ite.substring(1))));
            this.cargo.setText("" + game.getShip().getSpaceLeft());
            this.money.setText("" + game.getMoney());
            //subtract 1 from sellable
            //add 1 to buyable
        }
    }

    /**
     * lol.
     */
    public final void freshPrince() {
        refreshMarketplace();
    }

    /**
     * Refresh the MarketPlace.
     */
    private void refreshMarketplace() {
        market = game.currentSystem.getMarketPlace();
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
        sellableWater.setText("" + game.getShip()
                .searchCargo(new TradeItem("Water")));
        sellableFurs.setText("" + game.getShip()
                .searchCargo(new TradeItem("Furs")));
        sellableFood.setText("" + game.getShip()
                .searchCargo(new TradeItem("Food")));
        sellableOre.setText("" + game.getShip()
                .searchCargo(new TradeItem("Ore")));
        sellableGames.setText("" + game.getShip()
                .searchCargo(new TradeItem("Games")));
        sellableFirearms.setText("" + game.getShip()
                .searchCargo(new TradeItem("Firearms")));
        sellableMedicine.setText("" + game.getShip()
                .searchCargo(new TradeItem("Medicine")));
        sellableMachines.setText("" + game.getShip()
                .searchCargo(new TradeItem("Machines")));
        sellableNarcotics.setText("" + game.getShip()
                .searchCargo(new TradeItem("Narcotics")));
        sellableRobots.setText("" + game.getShip()
                .searchCargo(new TradeItem("Robots")));
        int cargo = game.getShip().getSpaceLeft();
        //this should be set in ship controller
        this.cargo.setText("" + game.getShip().getSpaceLeft());
        //should be set in person controller
        Person player = game.getPlayer();

        int cash = player.getMoney();
        this.money.setText("" + cash);
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
}
