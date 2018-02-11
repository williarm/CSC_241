
/**
 * Purpose: The PalindromeDriver class is designed to execute the code in
 * the Palindrome.java class. It accepts user input and creates an instance
 * of the Palindrome Class. It calls the getPalindromicDate method and
 * printStack methods.
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
		int startYear = Integer.parseInt(JOptionPane.showInputDialog("Please enter a starting year greater than 0: "));
		int endYear = Integer.parseInt(JOptionPane.showInputDialog("Please enter an ending year greater than 0: "));

		if (startYear >= 0 && endYear >= 0) {
			PalindromicDates p = new PalindromicDates();
			for (int i = startYear; i < endYear + 1; i++) {
				p.getPalindromicDate(i);
				p.printStack();
			}

		} else {
			JOptionPane.showMessageDialog(null, "One of the years entered is less than 0. Please try again.");
		}
	}
}
