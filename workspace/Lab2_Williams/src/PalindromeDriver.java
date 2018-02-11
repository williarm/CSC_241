
/**
 * Purpose: The PalindromeDriver class is designed to execute the code in
 * the Palindrome.java class. It accepts user input and creates an instance
 * of the Palindrome Class. It calls the getPalindromicDate method, emptyStack,
 * and toString methods.
 * 
 * Constructors: None
 * 
 * Methods: main
 * 
 * @author Robert Williams
 * @since 2018-02-08
 * 
 */
import javax.swing.JOptionPane;

public class PalindromeDriver {

	public static void main(String[] args) {

		String year;

		PalindromicDates p = new PalindromicDates();
		while (true) {

			year = JOptionPane.showInputDialog("Please enter a year greater than 0. Press cancel to finish entering dates.");

			if (year == null) {
				p.toString();
				System.exit(0);
			} else {
				try {
					if (Integer.parseInt(year) >= 0) {
						p.getPalindromicDate(Integer.parseInt(year));
						p.emptyStack();

					} else {
						System.out.println("Please enter a year greater than 0.");
					}
				} catch (NumberFormatException e) {
					System.out.println("Value entered is not a valid year.");
				}
			}

		}

	}

}
