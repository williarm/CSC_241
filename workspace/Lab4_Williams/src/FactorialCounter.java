/**
 * Purpose: The FactorialCounter class is designed to increment
 * a counter.
 * 
 * Constructors: FactorialCounter
 * 
 * Methods: increment, multipleIncrement, getCount
 * 
 * @author Dale/Joyce/Weems
 * @since 2018-02-26
 * 
 */

public class FactorialCounter {
	private float count;

	public FactorialCounter() {
		count = 1;
	}

	public synchronized void increment() {
		count++;
	}

	public synchronized void multipleIncrement(int times) {
		// complete this code
		int originalCount = (int) count;
		for (int i = 0; i < originalCount; i++) {
			for (int j = 0; j < times - 1; j++) {
				increment();
			}
		}
	}

	public synchronized float getCount() {
		return count;
	}
}
