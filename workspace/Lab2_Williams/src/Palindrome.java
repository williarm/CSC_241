public class Palindrome {

	public Palindrome() {

	}

	public void getPalindromicDate(Integer date) {
		String month = date.toString().substring(0,2);
		String day = date.toString().substring(2,4);
		String year = date.toString().substring(4, 8);

		System.out.println("In Month: "+ month);
		System.out.println("In Day: "+ day);
		System.out.println("In Year: " + year);
		StackInterface<String> stack;
		stack = new LinkedStack<String>();
		stack.push(month);
		stack.push(day);
		stack.push(year);
		
		System.out.println("Top: "+ stack.top());
		stack.pop();
		System.out.println("Top: "+ stack.top());
		stack.pop();
		System.out.println("Top: "+ stack.top());
		

	}
}
