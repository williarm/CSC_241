/**
 * Purpose: The LinkedStack class is designed to process operations relating to the stack. It
 * implements the StackInterface interface.
 * 
 * Constructors: LinkedStack
 * 
 * Methods: push, pop, top, isFull, isEmpty
 * 
 * @author Nell Dale, Daniel T Joyce, Chip Weems (Object Oriented Data Structures in Java)
 * @since 2018-02-08
 * 
 */
public class LinkedStack<T> implements StackInterface<T> {

	// TODO Auto-generated method stub
	protected LLNode<T> top;

	/**
	 * Purpose: The LinkedStack constructor creates an empty stack
	 * by setting the value of top to null. 
	 * 
	 * @param nothing
	 * @return nothing
	 * 
	 */
	public LinkedStack() {
		top = null;
	}

	/**
	 * Purpose: The push method creates a new node and links it to the current
	 * chain of nodes.
	 * 
	 * @param T element
	 * @return nothing
	 * 
	 */
	@Override
	public void push(T element) {
		// TODO Auto-generated method stub
		LLNode<T> newNode = new LLNode<T>(element);
		newNode.setLink(top);
		top = newNode;
	}

	/**
	 * Purpose: The pop method deletes the first node of a Linked List.
	 * 
	 * @param nothing
	 * @return nothing
	 * 
	 */
	@Override
	public void pop() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new StackUnderflowException("Pop attempted on an empty stack.");
		} else {
			top = top.getLink();

		}

	}

	/**
	 * Purpose: The top method returns the value of the top node of a Linked List.
	 * 
	 * @param nothing
	 * @return T value of the top node of a Linked List
	 * 
	 */
	@Override
	public T top() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new StackUnderflowException("Top attempted on an empty stack.");
		} else {
			return top.getInfo();
		}
	}

	/**
	 * Purpose: The isFull method returns a boolean indicating if the stack is full.
	 * 
	 * @param nothing
	 * @return boolean false
	 * 
	 */
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Purpose: The isEmpty method returns a boolean indicating if the stack is empty.
	 * 
	 * @param nothing
	 * @return boolean
	 * 
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (top == null);
	}

}
