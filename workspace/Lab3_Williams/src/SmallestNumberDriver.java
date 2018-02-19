import java.util.ArrayList;

/**
 * Purpose: The SmallestNumberDriver class executes the smallestNumber method.
 * It returns the smallest number in an ArrayList of integers.
 * 
 * Constructors: None
 * 
 * Methods: main, smallestNumber
 * 
 * @author Robert Williams
 * @since 2018-02-18
 * 
 */
public class SmallestNumberDriver {

	static int[] intArray = { -3, 5, 1, -9, 8, 16, 10, -4, 5, 2, -1 };
	static ArrayList<Integer> values = new ArrayList<Integer>();

	public static void main(String[] args) {
		for (int i : intArray) {
			values.add(i);
		}

		System.out.println(smallestNumber(0));

	}

	/**
	 * Purpose: The smallestNumber method returns the smallest number from 
	 * a set of ArrayList elements.
	 * 
	 * @param int index
	 * @return int smallest number
	 * 
	 */
	public static int smallestNumber(int index) {
		// base case, return the value at the index
		if (index == values.size() - 1) {
			return values.get(index);
		} else {
			/*
			 * general case, check to see if the current value at the index is less than the
			 * value at the next index. If it is, then return the value at the current
			 * index. Otherwise, return the value at the next index.
			 */
			if (values.get(index) < smallestNumber(index + 1)) {
				return values.get(index);
			} else
				return smallestNumber(index + 1);
		}
	}
}