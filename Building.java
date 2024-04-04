public class Building {

    protected String name;
    protected String address;
    protected int nFloors;
    protected int activeFloor = -1; // Default value indicating we are not inside this building
    protected boolean hasElevator;

    /* Default constructor */
    public Building() {
        this("<Name Unknown>", "<Address Unknown>", 1);
    }

    /* Overloaded constructor with address only */
    public Building(String address) {
        this(); // Call default constructor
        this.address = address; // Override address
    }

    /* Overloaded constructor with name, address */
    public Building(String name, String address) {
        this(name, address, 1); // Call full constructor with hard-coded # floors
    }

    public Building(String name, String address, int nFloors) {
        if (name != null) {
            this.name = name;
        }
        if (address != null) {
            this.address = address;
        }
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /* Full constructor */
    public Building(String name, String address, int nFloors, boolean hasElevator) {
        if (name != null) {
            this.name = name;
        }
        if (address != null) {
            this.address = address;
        }
        this.nFloors = nFloors;
        this.hasElevator = hasElevator;

    }

    /* Accessors */
    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public int getFloors() {
        return this.nFloors;
    }

    /* Navigation methods */
    public Building enter() {
        if (activeFloor != -1) {
            throw new RuntimeException("You are already inside this Building.");
        }
        this.activeFloor = 1;
        System.out.println("You are now inside " + this.name + " on the ground floor.");
        return this; // Return a pointer to the current building
    }

    public Building exit() {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
        }
        if (this.activeFloor > 1) {
            throw new RuntimeException("You have fallen out a window from floor #" + this.activeFloor + "!");
        }
        System.out.println("You have left " + this.name + ".");
        this.activeFloor = -1; // We're leaving the building, so we no longer have a valid active floor
        return null; // We're outside now, so the building is null
    }

      /**
   * Moves to floor that us +- than 1
   * 
   * @param floorNum int, what floor user wants to go to
   */
    public void goToFloor(int floorNum) {
        if (this.hasElevator) {
            if (this.activeFloor == -1) {
                throw new RuntimeException(
                        "You are not inside this Building. Must call enter() before navigating between floors.");
            }
            if (floorNum < 1 || floorNum > this.nFloors) {
                throw new RuntimeException(
                        "Invalid floor number. Valid range for this Building is 1-" + this.nFloors + ".");
            }
            System.out.println("You are now on floor #" + floorNum + " of " + this.name);
            this.activeFloor = floorNum;
        } else {
            System.out.println("You cannot go up multiple floors. Use goUp() or goDown() instead.");
        }
    }

    /* Floor navigation */
    public void goUp() {
        this.goToFloor(this.activeFloor + 1);
    }

    public void goDown() {
        this.goToFloor(this.activeFloor - 1);
    }

      /**
   * Allows user to enter a room
   * 
   * @param roomType String, type of room, i.e. classroom, kitchen, etc.
   */
    public void enterNewRoom(String roomType) {
        System.out.println("You have entered the " + roomType);
    }

    /* Prints what the user can accoplish within the class */
    public void showOptions() {
        System.out.println("Available options at " + this.name
                + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + enterRoom(str)");
    }

    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address + ".";
    }

    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println("Test of Building constructor/methods");
        System.out.println("------------------------------------");

        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
        fordHall.showOptions();

        System.out.println("-----------------------------------");
        System.out.println("Demonstrating enter/exit/navigation");
        System.out.println("-----------------------------------");
        fordHall.enter();
        fordHall.goUp();
        fordHall.goDown();
        fordHall.enterNewRoom("classroom");
        fordHall.exit();
    }

}
