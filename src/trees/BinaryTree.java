package trees;

public class BinaryTree {
	
	class Node{
		int key;
		Node right;
		Node left;
		
		Node(int k){
			key = k;
			right = left = null;
		}
	}
	
	Node newNode(int k) {
		return new Node(k);
	}
	
	
	Node root;
	
	BinaryTree(){
		root = null;
	}
	
	BinaryTree(int k){
		root = new Node(k);
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = bt.newNode(8);	
		bt.root.left = bt.newNode(9);
		bt.root.right = bt.newNode(10);
	}
}


