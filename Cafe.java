public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
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

    public void showOptions() {
        super.showOptions();
        System.out.println(" + sellCoffee() \n + restock()");
    }

    public static void main(String[] args) {
        Cafe c = new Cafe("Compass Cafe", "Some Address", 2);
        c.sellCoffee(12, 2, 3);
        c.showOptions();
    }

}
