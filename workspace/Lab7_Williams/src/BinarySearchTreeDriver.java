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
				bst.add(randomNum.nextInt(3000));
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
