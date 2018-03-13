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
 * Linked Stack Empty
 * Iterative Size: 0
 * Iterative Runtime: 101811
 * Recursize Size: 0
 * Recursive Runtime: 35305
 * 
 * Linked Stack Has 5 Elements
 * Iterative Size: 5
 * Iterative Runtime: 36536
 * Recursize Size: 5
 * Recursive Runtime: 62811
 * 
 * Linked Stack Has 1 Element
 * Iterative Size: 1
 * Iterative Runtime: 98527
 * Recursize Size: 1
 * Recursive Runtime: 46801
 * 
 * Linked Stack Empty
 * Iterative Size: 0
 * Iterative Runtime: 45569
 * Recursize Size: 0
 * Recursive Runtime: 53369
 * 
 * How could the LinkedStack data structure be modified so that the size method was constant time?
 * 
 * In order to implement a constant time size method, we would need to keep track of the size of the LinkedStack
 * throughout execution of the program (not through an iterative or recursive approach). For example, initializing a
 * variable to 0 is constant time. If we were to keep track of the size of the Linked Stack after every push and pop in a variable,
 * we could have the size() method return that variable without requiring an iterative or recursive approach. The iterative 
 * and recursive approaches have runtime complexities of O(N) or greater, depending on complexity.
 * 
 * 
 */
public class LinkedStackDriver {

	public static void main(String[] args) {

		LinkedStack<Integer> linkedStack = new LinkedStack<Integer>();
		long timeStart, timeEnd;

		// The LinkedStack is empty. Check the size.
		System.out.println("Linked Stack Empty");
		timeStart = System.nanoTime();
		System.out.println("Iterative Size: " + linkedStack.iterListSize(linkedStack.top));
		timeEnd = System.nanoTime() - timeStart;
		System.out.println("Iterative Runtime: " + timeEnd);
		timeStart = System.nanoTime();
		System.out.println("Recursize Size: " + linkedStack.recListSize(linkedStack.top));
		timeEnd = System.nanoTime() - timeStart;
		System.out.println("Recursive Runtime: " + timeEnd + "\n");

		// The LinkedStack has 5 elements. Check the size.
		for (int i = 1; i <= 5; i++) {
			linkedStack.push(i);
		}

		System.out.println("Linked Stack Has 5 Elements");
		timeStart = System.nanoTime();
		System.out.println("Iterative Size: " + linkedStack.iterListSize(linkedStack.top));
		timeEnd = System.nanoTime() - timeStart;
		System.out.println("Iterative Runtime: " + timeEnd);
		timeStart = System.nanoTime();
		System.out.println("Recursize Size: " + linkedStack.recListSize(linkedStack.top));
		timeEnd = System.nanoTime() - timeStart;
		System.out.println("Recursive Runtime: " + timeEnd + "\n");

		// The LinkedStack has 1 element in it. Check the size. Pop the
		// element and check the size again.
		for (int i = 0; i < 4; i++) {
			linkedStack.pop();
		}

		System.out.println("Linked Stack Has 1 Element");
		timeStart = System.nanoTime();
		System.out.println("Iterative Size: " + linkedStack.iterListSize(linkedStack.top));
		timeEnd = System.nanoTime() - timeStart;
		System.out.println("Iterative Runtime: " + timeEnd);
		timeStart = System.nanoTime();
		System.out.println("Recursize Size: " + linkedStack.recListSize(linkedStack.top));
		timeEnd = System.nanoTime() - timeStart;
		System.out.println("Recursive Runtime: " + timeEnd + "\n");

		linkedStack.pop();

		System.out.println("Linked Stack Empty");
		timeStart = System.nanoTime();
		System.out.println("Iterative Size: " + linkedStack.iterListSize(linkedStack.top));
		timeEnd = System.nanoTime() - timeStart;
		System.out.println("Iterative Runtime: " + timeEnd);
		timeStart = System.nanoTime();
		System.out.println("Recursize Size: " + linkedStack.recListSize(linkedStack.top));
		timeEnd = System.nanoTime() - timeStart;
		System.out.println("Recursive Runtime: " + timeEnd + "\n");

	}

}
