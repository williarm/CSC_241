public class Palindrome {
	
	public Palindrome() {
		
	}
	
	public void getPalindromicDate(Integer date) {

		StackInterface<Integer> myStack;
		myStack = new LinkedStack<Integer>();
		myStack.push(date);
		System.out.println(myStack.top());
		
	}
}
