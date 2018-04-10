
//---------------------------------------------------------------------------
// LinkedQueue.java            by Dale/Joyce/Weems                  Chapter 4
//
// Implements QueueInterface using a linked list.
//---------------------------------------------------------------------------

import java.util.*;

public class LinkedQueue<T> implements QueueInterface<T> {
	protected LLNode<T> front; // reference to the front of this queue
	protected LLNode<T> rear; // reference to the rear of this queue
	protected int numElements = 0; // number of elements in this queue

	public LinkedQueue() {
		front = null;
		rear = null;
	}

	public void enqueue(T element)
	// Adds element to the rear of this queue.
	{
		LLNode<T> newNode = new LLNode<T>(element);
		if (rear == null)
			front = newNode;
		else
			rear.setLink(newNode);
		rear = newNode;
		numElements++;
	}

	public T dequeue()
	// Throws QueueUnderflowException if this queue is empty;
	// otherwise, removes front element from this queue and returns it.
	{
		if (isEmpty())
			throw new QueueUnderflowException("Dequeue attempted on empty queue.");
		else {
			T element;
			element = front.getInfo();
			front = front.getLink();
			if (front == null)
				rear = null;
			numElements--;
			return element;
		}
	}

	public boolean isEmpty()
	// Returns true if this queue is empty; otherwise, returns false.
	{
		return (front == null);
	}

	public boolean isFull()
	// Returns false - a linked queue is never full.
	{
		return false;
	}
	
	/**
	 * Purpose: The contains method determines if an element exists in the Binary Search Tree.
	 * 
	 * @param T target
	 * @return boolean
	 * 
	 */

	public boolean contains(T target) {
		T[] elements = (T[]) new Object[size()];
		for (int i = 0; i < elements.length; i++) {
			elements[i] = (T) dequeue();
			System.out.println(elements[i]);
		}

		T item;
		int start = 0;
		int end = elements.length;
		int mid = (end - start) / 2;
		boolean exists = false;

		// compare target with the value at the mid
		// if result is greater than 0, then need to find the mid of
		// the right half of the array
		// if the result is less than 0, then need to find the mid
		// of the left half of the array
		item = elements[mid];
		while (item != null) {
			int compareResult = ((Comparable<? super T>) target).compareTo(item);

			if (start <= end) {

				if (compareResult == 0) {

					exists = true;
					break;

				} else if (compareResult > 0) {

					start = mid + 1;
					mid = start + ((end - start) / 2);
					item = elements[mid];

				} else if (compareResult < 0) {

					end = mid - 1;
					mid = start + ((end - start) / 2);
					item = elements[mid];

				}
			} else {
				item = null;
			}
		}
		return exists;
	}

	public int size()
	// Returns the number of elements in this queue.
	{
		return numElements;
	}

}
