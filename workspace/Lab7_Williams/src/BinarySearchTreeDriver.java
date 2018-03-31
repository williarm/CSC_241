/**
 * Purpose: The BinarySearchTreeDriver class creates objects of
 * the BinarySearchTree class. It creates 10 objects of the BinarySearchTree
 * class, and then adds 1000 nodes for each BinarySearchTree with random values
 * between 1 and 3000.
 * 
 * Constructors: None
 * 
 * Methods: main
 * 
 * @author Robert Williams
 * @since 2018-03-31
 */

import java.util.ArrayList;
import java.util.Random;

public class BinarySearchTreeDriver {

	public static void main(String[] args) {
		ArrayList<BinarySearchTree<Integer>> bstList = new ArrayList<BinarySearchTree<Integer>>();

		for (int i = 0; i < 10; i++) {
			bstList.add(new BinarySearchTree<Integer>());
		}

		Random randomNum = new Random();

		for (BinarySearchTree<Integer> bst : bstList) {
			for (int j = 0; j < 1000; j++) {
				bst.add(randomNum.nextInt(3000) + 1);
			}

			System.out.println("Size: " + bst.size());
			System.out.println("Max Number: " + bst.max());
			System.out.println("Min Number: " + bst.min());
			System.out.println("Height: " + bst.height(bst.root));
			System.out.println("Min Height: " + bst.minHeight(bst.root));
			System.out.println("FRatio: " + bst.fRatio(bst.root) + "\n");
		}

	}

}
