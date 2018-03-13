/**
 * Purpose: The LLNode class is designed to allocate space for a Linked List
 * node and allow a node to link to another node.
 * 
 * Constructors: LLNode
 * 
 * Methods: setInfo, getInfo, setLink, getLink
 * 
 * @author Nell Dale, Daniel T Joyce, Chip Weems (Object Oriented Data
 *         Structures in Java)
 * @since 2018-02-08
 * 
 */

public class LLNode<T> {
	protected T info;
	protected LLNode<T> link;

	/**
	 * Purpose: The LLNode constructor accepts an object of class T as an argument
	 * and sets the info variable to that object.
	 * 
	 * @param info
	 *            Object of class T
	 * @return nothing
	 * 
	 */
	public LLNode(T info) {
		this.info = info;
		link = null;
	}

	/**
	 * Purpose: The setInfo method is a setter method for the info variable
	 * 
	 * @param info
	 *            Object of class T
	 * @return nothing
	 * 
	 */
	public void setInfo(T info) {
		this.info = info;
	}

	/**
	 * Purpose: The getInfo method is a getter method for the info variable
	 * 
	 * @param nothing
	 * @return info Object of class T
	 * 
	 */
	public T getInfo() {
		return info;
	}

	/**
	 * Purpose: The setLink method is a setter method for the link variable
	 * 
	 * @param LLNode<T>
	 *            link reference to a node
	 * @return nothing
	 * 
	 */
	public void setLink(LLNode<T> link) {
		this.link = link;
	}

	/**
	 * Purpose: The getLink method is a getter method for the link variable
	 * 
	 * @param nothing
	 * @return link reference to a node
	 * 
	 */
	public LLNode<T> getLink() {
		return link;
	}

}
