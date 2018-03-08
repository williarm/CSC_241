/**
 * Purpose: The LinkedStackSizeDriver class is designed to execute the LinkedStackSize
 * class. It creates 3 instances of the LinkedStackSize class, and adds different numbers
 * of elements to each LinkedStack in order to test the runtimes of the sizeIter and sizeRec
 * methods.
 * 
 * Constructors: None
 * 
 * Methods: main
 * 
 * @author Robert Williams
 * @since 2018-03-07
 * 
 * Answers to Exercise Questions:
 * 
 * What is the runtime of these methods?
 * Empty stack sizeIter runtime: 5995
 * Empty stack sizeRec runtime: 2821
 * 5 Elements in stack sizeIter runtime: 5642
 * 5 Elements in stack sizeRec runtime: 3879
 * 1 Element in stack sizeIter runtime: 706
 * 1 Element in stack sizeRec runtime: 706
 * 
 * How could the LinkedStack data structure be modified so that the size of the method was constant time?
 * 
 * The LinkedStack data structure is not constant time because the size of the collection can grow, and therefore the
 * amount of work required to solve the problem is relative to the size of the problem. We must process all of the elements
 * in the collection to solve the problem. In order to make this a constant time problem, the data structure could be changed
 * to an Array. This would be a constant time algorithm because the size of the Array must be predetermined before elements
 * can be stored in it. Therefore, we would already know the size of the Array without having to process all the elements contained
 * in the Array.
 */
public class LinkedStackSizeDriver {

	public static void main(String[] args) {

		long timeStart;
		long timeEnd;

		// LinkedStack is empty
		LinkedStackSize ls1 = new LinkedStackSize();
		timeStart = System.nanoTime();
		ls1.sizeIter();
		timeEnd = System.nanoTime() - timeStart;
		System.out.println("Empty stack sizeIter runtime: "+ timeEnd);
		
		timeStart = System.nanoTime();
		ls1.sizeRec();
		timeEnd = System.nanoTime() - timeStart;
		System.out.println("Empty stack sizeRec runtime: "+ timeEnd);

		// LinkedStack has 5 elements
		LinkedStackSize ls2 = new LinkedStackSize();
		ls2.push(1);
		ls2.push(2);
		ls2.push(3);
		ls2.push(4);
		ls2.push(5);

		timeStart = System.nanoTime();
		ls2.sizeIter();
		timeEnd = System.nanoTime() - timeStart;
		System.out.println("5 Elements in stack sizeIter runtime: "+ timeEnd);

		ls2.push(1);
		ls2.push(2);
		ls2.push(3);
		ls2.push(4);
		ls2.push(5);

		timeStart = System.nanoTime();
		ls2.sizeRec();
		timeEnd = System.nanoTime() - timeStart;
		System.out.println("5 Elements in stack sizeRec runtime: "+ timeEnd);

		// Linked Stack has 1 element
		LinkedStackSize ls3 = new LinkedStackSize();
		ls3.push(1);

		timeStart = System.nanoTime();
		ls3.sizeIter();
		timeEnd = System.nanoTime() - timeStart;
		System.out.println("1 Element in stack sizeIter runtime: "+ timeEnd);

		ls3.push(1);

		timeStart = System.nanoTime();
		ls3.sizeIter();
		timeEnd = System.nanoTime() - timeStart;
		System.out.println("1 Element in stack sizeRec runtime: "+ timeEnd);
	}

}
