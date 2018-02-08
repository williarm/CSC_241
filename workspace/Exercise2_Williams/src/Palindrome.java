import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Palindrome {

	private StackInterface<String> palindromicDates;

	public Palindrome() {
		palindromicDates = new LinkedStack<String>();
	}

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

	public String reverseString(String date) {
		String newDate = new String();

		for (int i = date.length() - 1; i >= 0; i--) {
			newDate += date.substring(i, i + 1);
		}
		return newDate;
	}
}
