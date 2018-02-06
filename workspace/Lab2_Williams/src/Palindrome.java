public class Palindrome {
	
	private StackInterface<String> stack;

	public Palindrome() {
		stack = new LinkedStack<String>();
	}

	public int getPalindromicDate(Integer date) {
		String newDate = new String();

		for (int i = 0; i < date.toString().length(); i++) {
			stack.push(date.toString().substring(i, i + 1));
		}

		for (int i = 0; i < date.toString().length(); i++) {
			if (!stack.isEmpty()) {
				newDate += stack.top();
				stack.pop();
			}else {
				System.out.println("Stack is empty.");
			}
		}
		System.out.println(date.toString());
		System.out.println(newDate);
		if (date.toString().equalsIgnoreCase(newDate)) {
			System.out.println("This date is a palindrome.");
			return Integer.parseInt(newDate);
		} else {
			System.out.println("This date is not a palindrome");
			return (Integer) null;
		}
	}
}
