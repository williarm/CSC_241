/**
 * Purpose: The BSTExample class creates a Binary Search Tree and adds elements to the
 * Binary Search Tree. It then references the nonRecContains method to determine if an
 * element exists in the Binary Search Tree.
 * 
 * Constructors: None
 * 
 * Methods: main
 * 
 * @author Robert Williams
 * @since 2018-04-09
 */

public class BSTExample {

	public static void main(String[] args) {
		BinarySearchTree<Character> example = new BinarySearchTree<Character>();
		example.add('P');
		example.add('F');
		example.add('S');
		example.add('B');
		example.add('H');
		example.add('R');
		example.add('Y');
		example.add('G');
		example.add('T');
		example.add('Z');
		example.add('W');

		System.out.println(example.nonRecContains('T'));
		System.out.println(example.nonRecContains('E'));

	}

}
