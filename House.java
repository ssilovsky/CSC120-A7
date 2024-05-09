
/**
* This is the House class.
* @author  Sophia Silovsky
* @version 1.0
* @since   2024-04-03
*/
import java.util.ArrayList;
import java.util.Hashtable;

public class House extends Building {

  private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;

  /**
   * House constructor
   * 
   * @param name          String
   * @param address       String
   * @param nFloors       int
   * @param hasDiningRoom boolean
   * @param hasElevator   boolean
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors, hasElevator);
    this.hasDiningRoom = hasDiningRoom;
    this.residents = new ArrayList<String>();
  }

  /**
   * Default House Constructor
   */
  public House() {
    this("House Name", "Some Address", 1, false, false);
    this.residents = new ArrayList<String>();
  }

  /**
   * Returns whether the house has a dining room
   * 
   * @return boolean getter for hasDiningRoom
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Returns number of residents in the house
   * 
   * @return int number of residents in array 'residents'
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * Returns string stating whether the house has a dining room and or an elevator
   * 
   * @return String description of house attributes
   */
  public String toString() {
    String desc = super.toString();

    if (this.hasDiningRoom) {
      desc += "It has a dining room. ";
    }
    if (this.hasElevator) {
      desc += "It has an elevator. ";
    }
    return desc;
  }

  /**
   * Move to floor depending on whether a house has an elevator
   * 
   * @param floorNum int, what floor user wants to go to
   */
  public void goToFloor(int floorNum) {
    if (hasElevator) {
      super.goToFloor(floorNum);
    } else {
      System.out.println("Sorry this house does not have an elevator. Use goUp() or goDown() instead.");
    }
  }

  /**
   * Adds student to the residents of a house
   * 
   * @param name String name of student moving in
   */
  public void moveIn(String name) {
    if (this.isResident(name)) {
      System.out.println(name + " is already moved in.");
    } else {
      this.residents.add(name);
      System.out.println(name + " has successfully moved in!");
    }
  }

  /**
   * Removes student from the residents of a house
   * 
   * @param name String name of student moving out
   * @return String name of student
   */
  public String moveOut(String name) {
    if (this.isResident(name)) {
      this.residents.remove(name);
      System.out.println(name + " has moved out.");
    } else {
      System.out.println(name + " is not a resident here.");
    }
    return name;
  }

  /**
   * Checks whether a student is a resident of a house
   * 
   * @param person name of the student
   * @return boolean if student is resident
   */
  public boolean isResident(String person) {
    return this.residents.contains(person);
  }

  /**
   * Check if an ArrayList of people are members of a house / Overload method.
   * 
   * @param persons ArrayList<String> People you want to check are residents
   * @return Hashtable, key = person's name, value = whether they are a resident
   */
  public Hashtable<String, Boolean> isResident(ArrayList<String> persons) {
    Hashtable<String, Boolean> isResidentHash = new Hashtable<>();
    for (int i = 0; i < persons.size(); i++) {
      if (this.residents.contains(persons.get(i))) {
        isResidentHash.put(persons.get(i), true);
      } else {
        isResidentHash.put(persons.get(i), false);
      }
    }
    return isResidentHash;
  }

  /**
   * Print the options available
   */
  public void showOptions() {
    super.showOptions();
    System.out.println(" + hasDiningRoom() \n + nResidents() \n + moveIn() \n + moveOut() \n + isResident()");
  }

  /**
   * House overload with if the room is a bedroom
   * 
   * @param roomType  String
   * @param isBedroom boolean
   */
  public void enterNewRoom(String roomType, boolean isBedroom) {
    if (isBedroom) {
      System.out.println("Hmm, don't enter this room unless it is your bedroom.");
    } else {
      super.enterNewRoom(roomType);
    }
  }

  /**
   * Example of house class
   */
  public static void main(String[] args) {
    House h = new House("Lamont", "100 Green Street", 2, true, false);
    System.out.println(h);
    h.moveIn("Jason");
    h.isResident("Jason");
    h.moveOut("Sam");
    h.showOptions();
    h.enter();
    h.goToFloor(1);
    h.goToFloor(2);
    ArrayList<String> listR = new ArrayList<String>();
    listR.add("Jason");
    listR.add("Jess");
    listR.add("Sam");
    System.out.println(h.isResident(listR));

  }

}