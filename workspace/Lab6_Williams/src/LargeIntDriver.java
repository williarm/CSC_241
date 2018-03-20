/**
 * Purpose: The LargeIntDriver class is a driver for the LargeInt
 * class. It creates objects of the LargeInt class and calls the add
 * and multiply methods.
 * 
 * Constructors: None
 * 
 * Methods: main
 * 
 * @author Robert Williams
 * @since 2018-03-19
 */
public class LargeIntDriver {
	public static void main(String[] args) {
		LargeInt x = new LargeInt("123456789");
		LargeInt y = new LargeInt("123456789");
		LargeInt z = LargeInt.add(x, y);
		LargeInt product = LargeInt.multiply(x, y);
	}
}
