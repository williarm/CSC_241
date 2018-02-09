import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

/**
 * Purpose: The Palindrome program is designed to determine all dates in a given
 * year that are palindromes.
 * 
 * Constructors: Palindrome
 * 
 * Methods: printStack, getPalindromicDate, reverseString
 * 
 * @author Robert Williams
 * @since 2018-02-08
 * 
 */

public class Palindrome {

	private StackInterface<String> palindromicDates;

	/**
	 * Purpose: The Palindrome constructor creates a Palindrome object
	 * and initializes the palindromicDates variable.
	 * 
	 * @param nothing
	 * @return nothing
	 * 
	 */
	public Palindrome() {
		palindromicDates = new LinkedStack<String>();
	}

	/**
	 * Purpose: The printStack method prints out the elements
	 * of the palindromicDates LinkedList stack. 
	 * 
	 * @param nothing
	 * @return nothing
	 * 
	 */
	public void printStack() {
		String month = new String();
		String day = new String();
		String year = new String();

		while (!palindromicDates.isEmpty()) {
			month = palindromicDates.top();
			palindromicDates.pop();
			day = palindromicDates.top();
			palindromicDates.pop();
			year = palindromicDates.top();
			palindromicDates.pop();

			System.out.println("Palindromic Date is: " + reverseString(month + day + year));
			System.out.println("Formatted Date is: " + month + "-" + day + "-" + year + "\n");

		}
	}

	/**
	 * Purpose: The getPalindromicDates method is designed to determine if the dates in a
	 * year are palindromic. It accepts an int (year) as input, and created a GregorianCalendar
	 * object. It loops through the dates in the Gregorian Calendar, and reverses the String representation
	 * of the date. If the date is a palindrome, it pushes the date onto the LinkedList stack.
	 * 
	 * @param int date
	 * @return StackInterface<String>
	 * 
	 */
	public StackInterface<String> getPalindromicDate(int date) {
		// loop through every day in the year and assign it to the currentDate variable
		int year = date;
		int totalDays = 365;
		String currentDate = new String();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MMddyyyy");
		GregorianCalendar calendar = new GregorianCalendar();

		System.out.println("Year: " + year);

		calendar.set(Calendar.YEAR, year);
		if (calendar.isLeapYear(year)) {
			totalDays = 366;
		}

		for (int i = 1; i <= totalDays; i++) {
			calendar.set(Calendar.DAY_OF_YEAR, i);
			currentDate = dateFormatter.format(calendar.getTime());

			if (currentDate.equalsIgnoreCase(reverseString(currentDate))) {
				palindromicDates.push(currentDate.substring(4, 8));
				palindromicDates.push(currentDate.substring(2, 4));
				palindromicDates.push(currentDate.substring(0, 2));
			}
		}

		return palindromicDates;

	}

	/**
	 * Purpose: The reverseString method is designed to accept a String
	 * and reverse the value of the String.
	 * 
	 * @param String date
	 * @return String newDate
	 * 
	 */
	public String reverseString(String date) {
		String newDate = new String();

		for (int i = date.length() - 1; i >= 0; i--) {
			newDate += date.substring(i, i + 1);
		}
		return newDate;
	}
}
