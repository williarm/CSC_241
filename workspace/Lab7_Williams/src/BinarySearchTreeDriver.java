
public class BinarySearchTreeDriver {

	public static void main(String[] args) {
		BinarySearchTree<String> tree1 = new BinarySearchTree<String>();
		tree1.add("B");
		tree1.add("A");
		tree1.add("D");
		tree1.add("C");
		tree1.add("G");
		tree1.add("F");
		tree1.add("E");
		System.out.println(tree1.height(tree1.root));
		System.out.println(tree1.size());

	}

}
