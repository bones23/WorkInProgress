package model;
import controller.WelcomeScreenController;
import java.io.Serializable;
import java.util.Random;
import javafx.stage.Stage;
import org.controlsfx.dialog.Dialogs;

/**
 * @author Matthew Taylor
 * @version 21 October 2014
 */
public class RandomEvent implements Serializable {
    //CHECKSTYLE: OFF
    private final Random rand;
    private final Ship myShip;
    private final Game game;
    private final SolarSystem targetSolarSystem;
    private final int EVENT_PERCENT = 5;
    private final int MAX_PERCENT = 100;
    private final int FUEL_MULT = 10;
    private final int ESKILL_MULT = 5;
    private final int MAX_ROB_ATTEMPTS = 6;
    private final int targetLocation;
    private final int ENCOUNTER_PERCENT = 8;
    private final int POLICE_INTENSITY;
    private final int PIRATE_INTENSITY;
    //CHECKSTYLE: ON

    /**
     * Create a RandomEvent and run the events.
     * @param s stage
     */
    public RandomEvent(final Stage s, final int targetLocation) {
        this.targetLocation = targetLocation;
        rand = new Random();
        this.myShip = WelcomeScreenController.game.getShip();
        game = WelcomeScreenController.game;
        targetSolarSystem = game.getUniverse().getSolarSystemAt(targetLocation);
        POLICE_INTENSITY = targetSolarSystem.getPoliceIntensity();
        PIRATE_INTENSITY = targetSolarSystem.getPirateIntensity();
        runRandomEvents(s);
    }

    /**
     * Run through every possible random event and call each with a calculated
     * probability.
     * @param s The Stage to run in
     */
    public final void runRandomEvents(final Stage s) {
        if (rand.nextInt(ENCOUNTER_PERCENT) <
                targetSolarSystem.getPoliceIntensity()) {
            //do police encounter
        } else if (rand.nextInt(ENCOUNTER_PERCENT) <
                targetSolarSystem.getPirateIntensity()) {
            //do pirate encounter
        }
        if (rand.nextInt(MAX_PERCENT) < EVENT_PERCENT) {
            fuelLeak(s);
        }
        if (rand.nextInt(MAX_PERCENT) < EVENT_PERCENT) {
            robbed(s);
        }
        
    }

    /**
     * @param s the Stage
     */
    public final void fuelLeak(final Stage s) {

        int cost = (this.myShip.getFuelTank()
                * FUEL_MULT) - (WelcomeScreenController
                .game.getPlayer().getEngineerSkill() * ESKILL_MULT);

        if (WelcomeScreenController.game.getPlayer().getMoney() - cost >= 0) {
            WelcomeScreenController.game.getPlayer()
                    .setMoney(WelcomeScreenController.game.getPlayer()
                            .getMoney() - cost);
        } else {
            System.exit(1);
        }
        this.myShip.setFuel(0);
        Dialogs.create()
            .owner(s)
            .title("OH NO!")
            .masthead(null)
            .message("There has been a fuel leak!\nBecause of your engineerin"
                + "g skill, you don't"
                + " have to buy a new fuel tank but just some spare parts.\n"
                + " You save " + (WelcomeScreenController.game.getPlayer()
                        .getEngineerSkill() * ESKILL_MULT) + " credits.")
            .showInformation();
    }

    /**
     * Random event: a thief steals from cargo a number of times determined from
     * the player's trader skill.
     * @param s the Stage handling random events
     */
    public final void robbed(final Stage s) {

        // # of attempts a theif tries to steal
        int attempts = MAX_ROB_ATTEMPTS - (WelcomeScreenController
                .game.getPlayer().getTraderSkill() / 2);
        String stolen = "";

        // Thief tries to steal "attempts" times from a random bay. The same
        // bay can be stolen from multiple times but nothing will happen after
        // stealing from it once. This should add some randomness.
        for (int i = 0; i < attempts; i++) {

            int bayToStealFrom = rand.nextInt(this.myShip.getBays());

            if (this.myShip.getCargoManifest()[bayToStealFrom] != null) {
                stolen += "\t" + this.myShip
                        .getCargoManifest()[bayToStealFrom].getName()
                        + " in bay " + bayToStealFrom + "\n";
                TradeItem[] cargo = this.myShip.getCargoManifest();
                cargo[bayToStealFrom] = null;
                this.myShip.setCargoManifest(cargo);
                this.myShip.setOccupiedSlots(this.myShip
                        .getOccupiedSlots() - 1);
            }
        }

        if (stolen.equals("")) {
            stolen = "Nothing! You sure lucked out.";
        }
        Dialogs.create()
                .owner(s)
                .title("You've been robbed!")
                .masthead(null)
                .message("The following have been stolen from cargo:\n"
                        + stolen)
                .showInformation();
    }
}
