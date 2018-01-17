//This program will test the queue iterators of the BST.
//Ivan Temesvari
//10/24/2016

package ch08.trees;
import java.io.*;

import ch05.queues.QueueUnderflowException;

public class TestBSTIterator{
	public static void main(String[] args){
		BinarySearchTree<String> myTree = new BinarySearchTree();
		
		myTree.add("C");
		myTree.add("G");
		myTree.add("F");
		myTree.add("B");
		myTree.add("D");
		myTree.add("A");
	
		
		myTree.reset(BinarySearchTree.INORDER);
		System.out.print("tree: ");
		for(int i = 0; i < myTree.size(); i++)
			System.out.print(myTree.getNext(BinarySearchTree.INORDER));
		
		/*
		String e = myTree.getNext(BinarySearchTree.INORDER);
		while(e != null){
			System.out.print(e);
			try{
				e = myTree.getNext(BinarySearchTree.INORDER);
			}
			catch(QueueUnderflowException c){
				break;
			}
		}
		*/
		
	}
}








