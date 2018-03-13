/**
 * Purpose: The Bag class defines the methods used to process the Bag structure.
 *
 * 
 * Constructors: Bag(), Bag(int elements)
 * 
 * Methods: grab, count, removeAll, clear
 * 
 * @author Robert Williams
 * @since 2018-03-12
 */

public class Bag<T> extends ArrayCollection implements BagInterface {

	public Bag() {
		super();
	}

	public Bag(int elements) {
		super(elements);
	}

	@Override
	public Object grab() {
		// If this bag is not empty, removes and returns a random element of the bag;
		// otherwise returns null.
		Object o = new Object();
		int index = 0;
		if (!this.isEmpty()) {
			index = (int) Math.floor(Math.random() * this.numElements);
			o = this.elements[index];
			remove(this.elements[index]);
			return o;
		} else
			return null;
	}

	@Override
	public int count(Object target) {
		// Returns a count of all elements e in this collection such that
		// e.equals(target).
		int count = 0;
		for (int i = 0; i < this.numElements; i++) {
			if (this.elements[i].equals(target)) {
				count++;
			}
		}

		return count;
	}

	@Override
	public int removeAll(Object target) {
		int count = 0;
		// Removes all elements e from this collection such that e.equals(target)
		// and returns the number of elements removed.
		for (int i = 0; i <= this.numElements; i++) {
			if (remove(target)) {
				count++;
			}

		}
		return count;
	}

	@Override
	public void clear() {
		// Empties this bag so that it contains zero elements.
		for (int i = this.numElements; i > 0; i--) {
			this.elements[this.location] = this.elements[this.numElements - 1];
			this.elements[this.numElements - 1] = null;
			this.numElements--;
		}

	}
}
