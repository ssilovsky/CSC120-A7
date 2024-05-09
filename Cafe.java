/**
 * This is the Cafe class.
 * 
 * @author Sophia Silovsky
 * @version 1.0
 * @since 2024-04-03
 */
public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Cafe constructor
     * 
     * @param name    String
     * @param address String
     * @param nFloors int
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 2;
        this.nSugarPackets = 3;
        this.nCreams = 4;
        this.nCups = 1;
    }

    /**
     * Default Cafe Constructor
     */
    public Cafe() {
        this("Cafe Name", "Some Address", 1);
        this.nCoffeeOunces = 2;
        this.nSugarPackets = 3;
        this.nCreams = 4;
        this.nCups = 1;
    }

    /**
     * Sells coffee and removes the coffee, sugar, cream, and cup used
     * 
     * @param size          int size of drink ordered / ounces of coffee used
     * @param nSugarPackets int number of sugar packets used
     * @param nCreams       int number of creams used
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (size > this.nCoffeeOunces || nSugarPackets > this.nSugarPackets || nCreams > this.nCreams
                || this.nCups == 0) {
            this.restock(size, nSugarPackets, nCreams, 1);
        }
        this.nCoffeeOunces = this.nCoffeeOunces - size;
        this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        this.nCreams = this.nCreams - nCreams;
        this.nCups = this.nCups - 1;
        System.out.println("Enjoy your coffee!");
    }

    /**
     * Restocks the cafe with the direct amount used from sellCoffee
     * 
     * @param size          int size of drink ordered / ounces of coffee to restock
     * @param nSugarPackets int number of sugar packets to restock
     * @param nCreams       int number of creams to restock
     * @param nCups         int number of cups to restock
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = this.nCoffeeOunces + nCoffeeOunces;
        this.nSugarPackets = this.nSugarPackets + nSugarPackets;
        this.nCreams = this.nCreams + nCreams;
        this.nCups = this.nCups + nCups;
        System.out.println("Successfully restocked.");
    }

    /**
     * Restocks with set default amount of 20 items each / Overload method
     */
    private void restock() {
        this.nCoffeeOunces = this.nCoffeeOunces + 20;
        this.nSugarPackets = this.nSugarPackets + 20;
        this.nCreams = this.nCreams + 20;
        this.nCups = this.nCups + 20;
        System.out.println("Successfully restocked.");
    }

    /**
     * Overload from goToFloor since patrons can't go past first floor
     */
    public void goToFloor(int floorNum) {
        if (floorNum == 1) {
            System.out.println("You're already on the first floor!");
        } else {
            System.out.println("Patrons can only access the first floor.");
        }
    }

    /**
     * Overload since there is only one room in a cafe
     */
    public void enterNewRoom() {
        throw new RuntimeException("Whoopsie you can only stay in the main cafe!");
    }

    /**
     * Print the options available
     */
    public void showOptions() {
        super.showOptions();
        System.out.println(" + sellCoffee()");
    }

    public static void main(String[] args) {
        Cafe c = new Cafe("Compass Cafe", "Some Address", 2);
        c.sellCoffee(12, 2, 3);
        c.goToFloor(2);
        c.showOptions();
        c.enterNewRoom();
        c.restock();
    }

}
