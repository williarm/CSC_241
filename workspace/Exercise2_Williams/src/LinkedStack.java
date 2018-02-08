
public class LinkedStack<T> implements StackInterface<T> {

	// TODO Auto-generated method stub
	protected LLNode<T> top;

	public LinkedStack() {
		top = null;
	}

	@Override
	public void push(T element) {
		// TODO Auto-generated method stub
		LLNode<T> newNode = new LLNode<T>(element);
		newNode.setLink(top);
		top = newNode;

	}

	@Override
	public void pop() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new StackUnderflowException("Pop attempted on an empty stack.");
		} else {
			top = top.getLink();

		}

	}

	@Override
	public T top() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new StackUnderflowException("Top attempted on an empty stack.");
		} else {
			return top.getInfo();
		}
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (top == null);
	}

}
