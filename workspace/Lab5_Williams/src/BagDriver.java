/**
 * Purpose: The BagDriver class creates a Bag of FamousPerson objects. It calls
 * methods in the Bag class to add, grab, and remove objects from the Bag.
 * 
 * Constructors: None
 * 
 * Methods: main
 * 
 * @author Robert Williams
 * @since 2018-03-12
 */
public class BagDriver {

	public static void main(String[] args) {
		Bag<FamousPerson> myBag = new Bag(10);
		FamousPerson p1, p2, p3, p4, p5;

		// Create FamousPerson objects
		p1 = new FamousPerson("John", "McEnroe", 1980, "Tennis star.");
		p2 = new FamousPerson("Herman", "Hollerith", 1860, "American scientist.");
		p3 = new FamousPerson("John", "McEnroe", 2017, "Tennis announcer.");
		p4 = new FamousPerson("John", "McEnroe", 1980, "Professor");
		p5 = new FamousPerson("Peyton", "Manning", 1976, "Football player");

		// Print out the size of the bag before adding objects
		System.out.println("Starting Bag Size: " + myBag.size() + "\n");
		
		// Add objects to the bag
		myBag.add(p1);
		myBag.add(p2);
		myBag.add(p3);
		myBag.add(p4);
		myBag.add(p5);
		
		//Print the objects
		System.out.println("Printing the objects:");
		myBag.toString();
		System.out.println("\n");

		System.out.println("Bag Count After Adding Objects: " + myBag.size() + "\n");

		// Grab a random object from the bag
		System.out.println("Grab A Random Object: " + myBag.grab());
		System.out.println("Bag Count After Grabbing Object: " + myBag.size() + "\n");

		// Remove objects matching p1
		System.out.println("Count of Objects Matching P1 Before Remove: " + myBag.count(p1));
		System.out.println("Removed: " + myBag.removeAll(p1));
		System.out.println("Count of Objects Matching P1 After Remove: " + myBag.count(p1) + "\n");

		// Clear the bag
		System.out.println("Bag Count Before Clear: " + myBag.size());
		System.out.println("Clearing the bag... ");
		myBag.clear();
		System.out.println("Bag Count After Clear: " + myBag.size());

	}

}
