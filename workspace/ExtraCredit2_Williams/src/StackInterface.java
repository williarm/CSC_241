
public interface StackInterface<T> {
	void push(T element);

	void pop();

	T top();

	boolean isFull();

	boolean isEmpty();
}
