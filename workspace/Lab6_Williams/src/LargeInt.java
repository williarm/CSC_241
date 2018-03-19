
//---------------------------------------------------------------------------
// LargeInt.java            by Dale/Joyce/Weems                     Chapter 6
// 
// Provides a Large Integer ADT. Large integers can consist of any number
// of digits, plus a sign. Supports an add and a subtract operation.
//---------------------------------------------------------------------------

import java.util.Iterator;

public class LargeInt {
	protected LargeIntList numbers; // Holds digits

	// Constants for sign variable
	protected static final boolean PLUS = true;
	protected static final boolean MINUS = false;

	protected boolean sign;

	public LargeInt()
	// Instantiates an "empty" large integer.
	{
		numbers = new LargeIntList();
		sign = PLUS;
	}

	public LargeInt(String intString)
	// Precondition: intString contains a well-formatted integer
	//
	// Instantiates a large integer as indicated by intString
	{
		numbers = new LargeIntList();
		sign = PLUS;

		int firstDigitPosition; // Position of first digit in intString
		int lastDigitPosition; // Position of last digit in intString

		// Used to translate character to byte
		char digitChar;
		int digitInt;
		byte digitByte;

		firstDigitPosition = 0;
		if (intString.charAt(0) == '+') // Skip leading plus sign
			firstDigitPosition = 1;
		else if (intString.charAt(0) == '-') // Handle leading minus sign
		{
			firstDigitPosition = 1;
			sign = MINUS;
		}

		lastDigitPosition = intString.length() - 1;

		for (int count = firstDigitPosition; count <= lastDigitPosition; count++) {
			digitChar = intString.charAt(count);
			digitInt = Character.digit(digitChar, 10);
			digitByte = (byte) digitInt;
			numbers.addEnd(digitByte);
		}
	}

	public void setNegative() {
		sign = MINUS;
	}

	public String toString() {
		Byte element;

		String largeIntString;
		if (sign == PLUS)
			largeIntString = "+";
		else
			largeIntString = "-";

		int count = numbers.size();
		Iterator<Byte> forward = numbers.forward();
		while (forward.hasNext()) {
			element = forward.next();
			largeIntString = largeIntString + element;
			if ((((count - 1) % 3) == 0) && (count != 1))
				largeIntString = largeIntString + ",";
			count--;
		}
		return (largeIntString);
	}

	protected static boolean greaterList(LargeIntList first, LargeIntList second)
	// Precondition: first and second have no leading zeros
	//
	// Returns true if first represents a larger number than second;
	// otherwise, returns false

	{
		boolean greater = false;
		if (first.size() > second.size())
			greater = true;
		else if (first.size() < second.size())
			greater = false;
		else {
			byte digitFirst;
			byte digitSecond;
			Iterator<Byte> firstForward = first.forward();
			Iterator<Byte> secondForward = second.forward();

			// Set up loop
			int length = first.size();
			boolean keepChecking = true;
			int count = 1;

			while ((count <= length) && (keepChecking)) {
				digitFirst = firstForward.next();
				digitSecond = secondForward.next();
				if (digitFirst > digitSecond) {
					greater = true;
					keepChecking = false;
				} else if (digitFirst < digitSecond) {
					greater = false;
					keepChecking = false;
				}
				count++;
			}
		}
		return greater;
	}

	protected static LargeIntList addLists(LargeIntList larger, LargeIntList smaller)
	// Precondition: larger > smaller
	//
	// Returns a specialized list that is a byte-by-byte sum of the two
	// argument lists
	{
		byte digit1;
		byte digit2;
		byte temp;
		byte carry = 0;

		int largerLength = larger.size();
		int smallerLength = smaller.size();
		int lengthDiff;

		LargeIntList result = new LargeIntList();

		Iterator<Byte> largerReverse = larger.reverse();
		Iterator<Byte> smallerReverse = smaller.reverse();
		// Process both lists while both have digits
		for (int count = 1; count <= smallerLength; count++) {
			digit1 = largerReverse.next();
			digit2 = smallerReverse.next();
			temp = (byte) (digit1 + digit2 + carry);
			carry = (byte) (temp / 10);
			result.addFront((byte) (temp % 10));
		}

		// Finish processing of leftover digits
		lengthDiff = (largerLength - smallerLength);
		for (int count = 1; count <= lengthDiff; count++) {
			digit1 = largerReverse.next();
			temp = (byte) (digit1 + carry);
			carry = (byte) (temp / 10);
			result.addFront((byte) (temp % 10));
		}
		if (carry != 0)
			result.addFront((byte) carry);

		return result;
	}

	protected static LargeIntList subtractLists(LargeIntList larger, LargeIntList smaller)
	// Precondition: larger >= smaller
	//
	// Returns a specialized list that is the difference of the two argument lists
	{
		byte digit1;
		byte digit2;
		byte temp;
		boolean borrow = false;

		int largerLength = larger.size();
		int smallerLength = smaller.size();
		int lengthDiff;

		LargeIntList result = new LargeIntList();

		Iterator<Byte> largerReverse = larger.reverse();
		Iterator<Byte> smallerReverse = smaller.reverse();

		// Process both lists while both have digits.
		for (int count = 1; count <= smallerLength; count++) {
			digit1 = largerReverse.next();
			if (borrow) {
				if (digit1 != 0) {
					digit1 = (byte) (digit1 - 1);
					borrow = false;
				} else {
					digit1 = 9;
					borrow = true;
				}
			}

			digit2 = smallerReverse.next();

			if (digit2 <= digit1)
				result.addFront((byte) (digit1 - digit2));
			else {
				borrow = true;
				result.addFront((byte) (digit1 + 10 - digit2));
			}
		}

		// Finish processing of leftover digits
		lengthDiff = (largerLength - smallerLength);
		for (int count = 1; count <= lengthDiff; count++) {
			digit1 = largerReverse.next();
			if (borrow) {
				if (digit1 != 0) {
					digit1 = (byte) (digit1 - 1);
					borrow = false;
				} else {
					digit1 = 9;
					borrow = true;
				}
			}
			result.addFront(digit1);
		}

		return result;
	}

	public static LargeInt add(LargeInt first, LargeInt second)
	// Returns a LargeInt that is the sum of the two argument LargeInts
	{
		LargeInt sum = new LargeInt();

		if (first.sign == second.sign) {
			if (greaterList(first.numbers, second.numbers))
				sum.numbers = addLists(first.numbers, second.numbers);
			else
				sum.numbers = addLists(second.numbers, first.numbers);
			sum.sign = first.sign;
		} else // Signs are different
		{
			if (greaterList(first.numbers, second.numbers)) {
				sum.numbers = subtractLists(first.numbers, second.numbers);
				sum.sign = first.sign;
			} else {
				sum.numbers = subtractLists(second.numbers, first.numbers);
				sum.sign = second.sign;
			}
		}

		return sum;
	}

	public static LargeInt subtract(LargeInt first, LargeInt second)
	// Returns a LargeInt that is the difference of the two argument LargeInts
	{
		LargeInt diff = new LargeInt();

		// Create an inverse of second
		LargeInt negSecond = new LargeInt();
		negSecond.sign = !second.sign;
		Iterator<Byte> secondForward = second.numbers.forward();
		int length = second.numbers.size();
		for (int count = 1; count <= length; count++)
			negSecond.numbers.addEnd(secondForward.next());

		// Add first to inverse of second
		diff = add(first, negSecond);

		return diff;
	}

	public static LargeInt multiply(LargeInt first, LargeInt second) {

		/*i already have both numbers as is. multiplication requires me to multiply the top number (first number)
		by the first digit of the bottom number (second number)
		to make this step happen, i need to do the following:
			- get the last digit of the second number (this is what i multiply the first number by. in this case, I'm adding
			the first number to itself this many times - 1). how do I do this? Create an Iterator, then use .next() to get the 
			next value in the List. If I use reverse, then next will give me the ones place. If I use forward, then next will give me
			the first number in the List. I can iterate through the list using hasNext to get the next value in the list.
		
		questions: how do i store the result set of each step in multiplication? 
			- for the ones place, i need to add the number to itself multiple times. this can be stored in the product.numbers List
			- but, how do I handle it for multiple length numbers?
			- if the current multiple is not in the ones place, then i need to call addLast
			to put a 0 at the end of the list
			
			public int recListSize(LLNode<T> listRef) {
		if (listRef == null)
			return 0;
		else
			return 1 + recListSize(listRef.getLink());
	}
		*/
		LargeInt product = first;
		int loopCounter = 0;
		Iterator<Byte> multiple = second.numbers.reverse();
		byte currentMultiple = multiple.next();
		/*while(multiple.hasNext()) {
			currentMultiple = multiple.next();
			for (int i=0; i< currentMultiple; i++) {
				System.out.println(currentMultiple);
				product = add(product, first);
			}
		}*/
		for (int i=0; i< currentMultiple-1; i++) {
			System.out.println(currentMultiple);
			product = add(product, first);
			loopCounter++;
		}
		System.out.println(product.toString());
		currentMultiple = multiple.next();
		for (int i=0; i< currentMultiple; i++) {
			System.out.println(currentMultiple);
			product = add(product, first);
			loopCounter++;
		}
		System.out.println(product.toString());
		currentMultiple = multiple.next();
		for (int i=0; i< currentMultiple; i++) {
			System.out.println(currentMultiple);
			product = add(product, first);
			loopCounter++;
		}
		if (!multiple.hasNext()) {
			System.out.println("No more multiples.");
		} else {
			System.out.println("Has more multiples.");
		}
		System.out.println(product.toString());
		System.out.println("Loop Counter: "+ loopCounter);
		return product;
	}

}