//package ch04.threads;

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
