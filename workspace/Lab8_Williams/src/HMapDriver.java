
import java.util.Random;

/**
 * Purpose: The HMapDriver class creates an instance of the HMap class and inserts
 * records into the HMap.
 * 
 * Constructors: None
 * 
 * Methods: main
 * 
 * @author Robert Williams
 * @since 2018-04-23
 * 
 * Total time to insert and remove all elements for Load Ratio 0.5:
 * Insert: 7900222 Remove: 650278
 * 
 * Total time to insert and remove all elements for Load Ratio 0.75:
 * Insert: 7388702 Remove: 747163
 * 
 * Total time to insert and remove all elements for Load Ratio 0.9:
 * Insert: 8068128 Remove: 663416
 * 
 * The total time to insert and remove all elements was optimal at load ratio 0.75. This is likely
 * due to the balance of having to rehash the map and the size of the map at the time it was rehashed.
 * The rehash with load ratio 0.5 would need to happen twice, but would be quicker due to the smaller
 * number of elements. The rehash at load ratio 0.9 would only happen once, but it would have a larger
 * number of elements to rehash. The rehash at load ratio 0.75 was best because it only had to occur
 * once, and had a smaller number of elements than 0.9. The time to remove all elements varied widely. This
 * required searching for all of the keys that were stored. As keys were removed, it could have taken
 * longer to remove elements as it had to sort through elements that were already removed before removing
 * the value at the key.
 */
public class HMapDriver {
	public static void main(String[] args) {
		boolean result;

		HMap<Integer, String> test;

		final int SIZE = 10;
		final int IDRANGE = 10001;
		final int INITIALRANGE = 2;

		int[] keys = new int[SIZE];

		test = new HMap<Integer, String>(SIZE, 0.9);

		int randomID;
		String employeeInitials;
		final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		long t_in, t_out;
		long t_start, t_end;

		Random myRandomID = new Random();
		Random randomIndex = new Random();

		String randomInitials = "";

		t_in = System.nanoTime();
		test.put(100, "IT");
		t_out = System.nanoTime();

		System.out.println("Total time for insertion of: " + 100 + ":" + "IT" + " is:" + (t_out - t_in));

		test.remove(100);

		t_start = System.nanoTime();
		for (int i = 0; i < SIZE; i++) {
			// compute randomID here:
			randomID = myRandomID.nextInt(IDRANGE);
			keys[i] = randomID;

			for (int j = 0; j < INITIALRANGE; j++)
				randomInitials += letters.charAt(randomIndex.nextInt(letters.length()));

			t_in = System.nanoTime();

			test.put(randomID, randomInitials);

			t_out = System.nanoTime();

			System.out.println(
					"Total time for insertion of: " + randomID + ":" + randomInitials + " is: " + (t_out - t_in));
			System.out.println("Load Ratio: " + test.loadRatio());

			System.out.println(test);

			randomInitials = "";
		}
		t_end = System.nanoTime();
		
		System.out.println("Total time to insert all elements: "+ (t_end - t_start));

		System.out.println("Size: " + test.size());

		t_in = System.nanoTime();
		for (int i = 0; i < keys.length; i++) {
			test.remove(keys[i]);
		}
		t_out = System.nanoTime();
		System.out.println("Total time to remove all elements: " + (t_out - t_in));

		System.out.println("Size: " + test.size());
	}
}