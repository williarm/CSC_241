/**
 * Purpose: The StackUnderflowException class is a custom exception class designed to handle
 * StackUnderflowExceptions.
 * 
 * Constructors: StackOverflowException(), StackOverflowException(String message)
 * 
 * Methods: none
 * 
 * @author Nell Dale, Daniel T Joyce, Chip Weems (Object Oriented Data Structures in Java)
 * @since 2018-02-08
 * 
 */
public class StackUnderflowException extends RuntimeException {
	/**
	 * Purpose: The StackUnderflowException() calls the constructor
	 * of the super class RuntimeException
	 * 
	 * @param nothing
	 * @return nothing
	 * 
	 */
	public StackUnderflowException() {
		super();
	}

	/**
	 * Purpose: The StackUnderflowException(String message) calls the constructor
	 * of the super class RuntimeException and passes the message to the constructor
	 * 
	 * @param String message
	 * @return nothing
	 * 
	 */
	public StackUnderflowException(String message) {
		super(message);
	}
}
