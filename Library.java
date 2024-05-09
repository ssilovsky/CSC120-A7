import java.util.ArrayList;
import java.util.Hashtable;

public class Library extends Building {

  private Hashtable<String, Boolean> collection;

  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors, hasElevator);
    this.collection = new Hashtable<String, Boolean>();
  }

  public Library(){
    this("Some Library", "Some Address", 2, true);
    this.collection = new Hashtable<String, Boolean>();
  }

  /**
   * Adds book to collection, default makes book available for checkout
   * 
   * @param title String of book title
   */
  public void addTitle(String title) {
    this.collection.put(title, true);
  }

  /**
   * Removes book title from collection Hashtable
   * 
   * @param title String of book title
   * @return String title of book removed
   */
  public String removeTitle(String title) {
    if (this.collection.containsKey(title)) {
      this.collection.remove(title);
      System.out.println(title + "has been removed.");
    } else {
      System.out.println("We do not have " + title);
    }
    return title;
  }

  /**
   * Checks out book, sets book as unavailble in Hastable
   * 
   * @param title String of book title
   */
  public void checkOut(String title) {
    if (this.collection.containsKey(title)) {
      this.collection.replace(title, false);
      System.out.println(title + " has been checked out by you.");
    } else {
      System.out.println("Sorry, someone else already checked out " + title);
    }

  }

  /**
   * Returns book to collection Hashtable
   * 
   * @param title String of book title
   */
  public void returnBook(String title) {
    if (this.collection.containsKey(title)) {
      System.out.println(title + " is already in the library.");
    } else {
      this.collection.replace(title, true);
      System.out.println("You've returned" + title);
    }
  }

  /**
   * Checks if book title is in collection
   * 
   * @param title String of book title
   * @return boolean if title exists in collection
   */
  public boolean containsTitle(String title) {
    if (this.collection.containsKey(title)) {
      System.out.println("We do have " + title);
    } else {
      System.out.println("We do not have " + title);
    }
    return this.collection.containsKey(title);

  }

  /**
   * Checks if title is available to be checked out
   * 
   * @param title String of book title
   * @return boolean if title is available to check out
   */
  public boolean isAvailable(String title) {
    if (this.collection.containsKey(title) && this.collection.get(title)) {
      System.out.println(title + " is available.");
      return true;
    } else {
      System.out.println(title + " is not available.");
      return false;
    }
  }

  /**
   * Check if an ArrayList of books are available / Overload method.
   * @param books
   * @return Hashtable, key = book title, value = whether the book is available
   */
  public Hashtable<String, Boolean> isAvailable(ArrayList<String> books){
    Hashtable<String, Boolean> isAvailableHash = new Hashtable<>();
    for (int i = 0; i < books.size(); i++){
      if (this.collection.containsKey(books.get(i)) && this.collection.get(books.get(i))) {
        isAvailableHash.put(books.get(i), true);
      } else {
        isAvailableHash.put(books.get(i), false);
      }
    }
    return isAvailableHash;
  }


  /**
   * Prints collection keys and values
   */
  public void printCollection() {
    System.out.println(this.collection.keySet() + "=" + this.collection.values());

  }

  public void enterNewRoom(String roomType, boolean isQuietRoom){
    if (isQuietRoom) {
      System.out.println("Shhhh. Be quiet.");
      super.enterNewRoom(roomType);
    } else{
      super.enterNewRoom(roomType);
    }
  }


  public void showOptions() {
    super.showOptions();
    System.out.println(
        " + addTitle() \n + removeTitle() \n + checkOut() \n + returnBook() \n + containsTitle() \n + isAvailable() \n + printCollection()");
  }

  public static void main(String[] args) {
    Library l = new Library("Neilson", "Some Address", 4, true);
    l.addTitle("Othello by Shakespeare");
    l.addTitle("Jason Derulo by Jason D");
    l.printCollection();
    l.containsTitle("Othello by Shakespeare");
    l.showOptions();
    l.enterNewRoom("Quiet Room", true);
    ArrayList<String> listA = new ArrayList<String>();
    listA.add("Othello by Shakespeare");
    listA.add("Jason Derulo by Jason D");
    listA.add("Sharks and Stuff by Davey Jones");
    System.out.println(l.isAvailable(listA));
  }

}