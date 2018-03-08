/**
 * Purpose: The StackOverflowException class is a custom exception class designed to handle
 * StackOverflowExceptions.
 * 
 * Constructors: StackOverflowException(), StackOverflowException(String message)
 * 
 * Methods: none
 * 
 * @author Nell Dale, Daniel T Joyce, Chip Weems (Object Oriented Data Structures in Java)
 * @since 2018-02-08
 * 
 */
public class StackOverflowException extends RuntimeException {
	/**
	 * Purpose: The StackOverflowException() calls the constructor
	 * of the super class RuntimeException
	 * 
	 * @param nothing
	 * @return nothing
	 * 
	 */
	public StackOverflowException() {
		super();
	}

	/**
	 * Purpose: The StackOverflowException(String message) calls the constructor
	 * of the super class RuntimeException and passes the message to the constructor
	 * 
	 * @param String message
	 * @return nothing
	 * 
	 */
	public StackOverflowException(String message) {
		super(message);
	}
}
