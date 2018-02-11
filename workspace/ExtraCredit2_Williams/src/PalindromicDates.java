import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

/**
 * Purpose: The PalindromicDates program is designed to determine all dates in a
 * given year that are palindromes.
 * 
 * Constructors: PalindromicDates
 * 
 * Methods: printStack, getPalindromicDate, reverseString
 * 
 * @author Robert Williams
 * @since 2018-02-08
 * 
 */

public class PalindromicDates {

	private StackInterface<String> palindromicDates;
	private ArrayList<Integer> dateNumber = new ArrayList<>();
	private ArrayList<String> date = new ArrayList<>();
	private ArrayList<Integer> years = new ArrayList<>();

	/**
	 * Purpose: The Palindrome constructor creates a Palindrome object and
	 * initializes the palindromicDates variable.
	 * 
	 * @param nothing
	 * @return nothing
	 * 
	 */
	public PalindromicDates() {
		palindromicDates = new LinkedStack<String>();
	}
	
	/**
	 * Purpose: The toString method loops through the dateNumber and date
	 * ArrayLists and prints out the elements in each array.
	 * 
	 * @param nothing
	 * @return String
	 * 
	 */

	public String toString() {
		for (Integer dateNum : dateNumber) {
			if (Integer.toString(dateNum).length() < 8) {
				System.out.println("dateNum: 0" + dateNum);
			} else {
				System.out.println("dateNum: " + dateNum);
			}
		}

		for (String dates : date) {
			System.out.println("dateString:" + dates);
		}
		return null;
	}

	/**
	 * Purpose: The isDuplicate method checks to see if the year has already been
	 * searched. If it has, it returns true and does not add the year to the
	 * ArrayList. If it has not been searched, it returns false and adds the year to
	 * the ArrayList.
	 * 
	 * @param int
	 *            year
	 * @return boolean
	 * 
	 */

	public boolean isDuplicate(int year) {
		if (years.contains(year)) {
			System.out.println("Year: " + year + " is a duplicate.");
			return true;
		} else {
			years.add(year);
			return false;
		}
	}

	/**
	 * Purpose: The printStack method empties out the elements of the
	 * palindromicDates LinkedList stack into the dateNumber and dates ArrayLists.
	 * 
	 * @param nothing
	 * @return nothing
	 * 
	 */
	public void emptyStack() {
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

			dateNumber.add(Integer.parseInt(reverseString(month + day + year)));
			date.add(month + "-" + day + "-" + year);
		}
	}

	/**
	 * Purpose: The getPalindromicDates method is designed to determine if the dates
	 * in a year are palindromic. It accepts an int (year) as input and checks to
	 * see if the year has already been searched. If not, it creates a
	 * GregorianCalendar object. It loops through the dates in the Gregorian
	 * Calendar, and reverses the String representation of the date. If the date is
	 * a palindrome, it pushes the date onto the LinkedList stack.
	 * 
	 * @param int
	 *            date
	 * @return StackInterface<String>
	 * 
	 */
	public StackInterface<String> getPalindromicDate(int year) {
		// loop through every day in the year and assign it to the currentDate variable
		if (!isDuplicate(year)) {
			int totalDays = 365;
			String currentDate = new String();
			SimpleDateFormat dateFormatter = new SimpleDateFormat("MMddyyyy");
			GregorianCalendar calendar = new GregorianCalendar();

			// System.out.println("Year: " + year);

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

		}
		return palindromicDates;
	}

	/**
	 * Purpose: The reverseString method is designed to accept a String and reverse
	 * the value of the String.
	 * 
	 * @param String
	 *            date
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
