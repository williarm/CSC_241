public class PalindromeDriver {

	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		for (int i = 1100; i < 2031; i++) {
			p.getPalindromicDate(i);
			p.printStack();
		}

	}
}
