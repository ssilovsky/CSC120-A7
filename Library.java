import java.util.Hashtable;

public class Library extends Building {

  private Hashtable<String, Boolean> collection;

  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
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
    if (this.collection.containsKey(title)) {
      if (this.collection.get(title)) {
        System.out.println(title + " is available.");
      } else {
        System.out.println(title + " is not available.");
      }

    } else {
      System.out.println(title + " is not in the library.");
    }
    return this.collection.get(title);
  }

  /**
   * Prints collection keys and values
   */
  public void printCollection() {
    System.out.println(this.collection.keySet() + "=" + this.collection.values());

  }

  public void showOptions() {
    super.showOptions();
    System.out.println(
        " + addTitle() \n + removeTitle() \n + checkOut() \n + returnBook() \n + containsTitle() \n + isAvailable() \n + printCollection()");
  }

  public static void main(String[] args) {
    Library l = new Library("Neilson", "Some Address", 4);
    l.addTitle("Othello by Shakespeare");
    l.addTitle("Jason Derulo by Jason D");
    l.printCollection();
    l.containsTitle("Othello by Shakespeare");
    // l.isAvailable("Othello by Shakepeare");
    l.showOptions();
  }

}