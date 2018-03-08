/**
 * Purpose: The LinkedStackSize class is designed to check the size of a
 * LinkedList using both a recursize and iterative method.
 * 
 * Constructors: LinkedStackSize
 * 
 * Methods: sizeRec, sizeIter, push
 * 
 * @author Robert Williams
 * @since 2018-03-07
 * 
 */
public class LinkedStackSize {

	private StackInterface<Integer> LinkedStackTest;

	int sizeRec = 0;

	/**
	 * Purpose: The LinkedStackSize constructor initializes the LinkedStackTest variable.
	 * 
	 * @param nothing
	 * @return nothing
	 * 
	 */
	public LinkedStackSize() {
		LinkedStackTest = new LinkedStack<Integer>();
	}

	/**
	 * Purpose: The sizeRec method is a recursive method for determining the size
	 * of a LinkedList
	 * 
	 * @param nothing
	 * @return int sizeRec
	 * 
	 */
	public int sizeRec() {
		if (LinkedStackTest.isEmpty()) {
			return sizeRec;
		} else {
			LinkedStackTest.pop();
			sizeRec++;
			sizeRec();
		}
		return sizeRec;
	}

	/**
	 * Purpose: The sizeIter method is an interative method for determining the size
	 * of a LinkedList
	 * 
	 * @param nothing
	 * @return int sizeIter
	 * 
	 */
	public int sizeIter() {
		int sizeIter = 0;
		while (!LinkedStackTest.isEmpty()) {
			LinkedStackTest.pop();
			sizeIter++;
		}
		return sizeIter;
	}

	/**
	 * Purpose: The push method pushes an element onto the LinkedStack
	 * 
	 * @param int element
	 * @return nothing
	 * 
	 */
	public void push(int element) {
		LinkedStackTest.push(element);
	}
}
