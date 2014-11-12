package model;

/**
 * @author CodyMFFries
 */
public class Person {
    //CHECKSTYLE: OFF
    private int pilotSkill;
    private int fighterSkill;
    private int traderSkill;
    private int engineerSkill;
    private String playerName;
    private int money;
    private Ship ship;
    private int x;
    private int y;

    private final int DEFAULT_SHIP_FUEL = 14;
    private final int DEFAULT_SHIP_BAYS_NUM = 10;
    private final int DEFAULT_PLAYER_CASH = 100000000;
    //CHECKSTYLE: ON

    /**
     * Create a Person to run the Game with.
     * @param name the Person's name
     * @param pSkill pilot skill
     * @param fSkill fighter skill
     * @param tSkill trader skill
     * @param eSkill engineering skill
     * @param cash money to start with
     */
    public Person(final String name, final int pSkill, final int fSkill,
            final int tSkill, final int eSkill, final int cash) {
        this.pilotSkill = pSkill;
        this.fighterSkill = fSkill;
        this.traderSkill = tSkill;
        this.engineerSkill = eSkill;
        this.playerName = name;
        this.ship = new Ship("Flea", name, DEFAULT_SHIP_FUEL,
                DEFAULT_SHIP_BAYS_NUM);
        this.money = cash;
    }

    /**
     * Create a Person with a default amount of cash to run the Game with.
     * @param pSkill pilot skill
     * @param fSkill fighter skill
     * @param tSkill trader skill
     * @param eSkill engineer skill
     */
    public Person(final int pSkill, final int fSkill, final int tSkill,
            final int eSkill) {
        //Checkstyle!
        this.pilotSkill = pSkill;
        this.fighterSkill = fSkill;
        this.traderSkill = tSkill;
        this.engineerSkill = eSkill;
        this.playerName = "Kirk";
        this.ship = new Ship("Flea", "Kirk", DEFAULT_SHIP_FUEL,
                DEFAULT_SHIP_BAYS_NUM);
        this.money = DEFAULT_PLAYER_CASH;
    }

    /**
     * @return the Person's pilot skill
     */
    public final int getPilotSkill() {
        return pilotSkill;
    }

    /**
     * @param newPilot the Person's new pilot skill
     */
    public final void setPilotSkill(final int newPilot) {
        pilotSkill = newPilot;
    }

    /**
     * @return the Person's fighter skill
     */
    public final int getFighterSkill() {
        return fighterSkill;
    }

    /**
     * @param newFighter the Person's new fighter skill
     */
    public final void setFighterSkill(final int newFighter) {
        fighterSkill = newFighter;
    }

    /**
     * @return the Person's trader skill
     */
    public final int getTraderSkill() {
        return traderSkill;
    }

    /**
     * @param newTrader the Person's new trader skill
     */
    public final void setTraderSkill(final int newTrader) {
        traderSkill = newTrader;
    }

    /**
     * @return the Person's engineer skill
     */
    public final int getEngineerSkill() {
        return engineerSkill;
    }

    /**
     * @param newEngineer the Person's new engineer skill
     */
    public final void setEngineerSkill(final int newEngineer) {
        engineerSkill = newEngineer;
    }

    /**
     * @return the Player's name
     */
    public final String getName() {
        return this.playerName;
    }

    /**
     * @param name the Player's new name
     */
    public final void setName(final String name) {
        this.playerName = name;
    }

    /**
     * @return the Player's money
     */
    public final int getMoney() {
        return money;
    }

    /**
     * @param cash the Player's new money
     */
    public final void setMoney(final int cash) {
        money = cash;
    }

    /**
     * @return the Player's ship
     */
    public final Ship getShip() {
        return ship;
    }

    /**
     * @param myShip the Player's new ship
     */
    public final void setShip(final Ship myShip) {
        this.ship = myShip;
    }
    /**
     * @return the Player's x coordinate
     */
    public final int getX() {
        return this.x;
    }

    /**
     * @param newX the Player's new x coordinate
     */
    public final void setX(final int newX) {
        this.x = newX;
    }
    /**
     * @return the Player's y coordinate
     */
    public final int getY() {
        return this.y;
    }

    /**
     * @param newY the Player's new y coordinate
     */
    public final void setY(final int newY) {
        this.y = newY;
    }

    /**
     * @return a String containing the Player's information
     */
    @Override
    public final String toString() {
        return "Name: " + playerName + "\nPilot Skill: " + pilotSkill
                + "\nFighter Skill: " + fighterSkill + "\nTrader Skill: "
                + traderSkill + "\nEngineering Skill: " + engineerSkill;
                
    }
}
