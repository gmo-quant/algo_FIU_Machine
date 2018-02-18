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
		
		// display key of the node
		void display() {
			System.out.println(key);
		}
	}
	
	Node newNode(int k) {
		return new Node(k);
	}
	
	Node root;
	private int[] in;
	private int[] pre;
	
	BinaryTree(){
		root = null;
	}
	
	BinaryTree(int k){
		root = new Node(k);
	}
	
	// construct tree from an array of input
	// 	reference to https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/ 
	//
	//	 construct tree from given Inorder and Preorder traversals
	//	 analysis:
	//	 
	//		 ex. sequence:
	//			 Pre-order : 1, 2, 3, 4, 5, 6
	//			 in-order  : 4, 2, 5, 1, 6, 3
	//	 		in Pre-order sequence, 
	//	 		left most element '1'  is the root of the tree.
	//	 		by searching root '1' in inorder sequence, 
	// 			we can findout all element on left side of '1' are in left subtree
	//			and elements on right are in right subtree
	//			
	// 			we can recursively follow above steps and get the tree from 
	//		so 
	//			we need a helper function to find the index of each root 
	//			of a tree/subtree in the in-order sequence
	//
	//		algorithm:
	// 		1. pick an element from preorder. 
	//		2. increment a preorder index variable(preIdx) to pick next element in next recursive call
	//		3. find the picked element's index in inorder. let the index be inIdx
	//		4. create a new tree tNode with the data as picked element
	//		5. call constructTree for elements before inIdx and make the constructed tree as left subtree of tNode
	//		6. call constructTree for elements after inIdx and make the constructed tree as right subtree of tNode
	// 		7. return tNode
	// 
	// 		use inStart, inEnd to determine left / right subtree in inorder 
	// 
	
	// recursive function to construct binary tree of size n from
		// inorder traversal in[] 
		// and
		// preorder traversal pre[],
		// initial value 
	private static int preIdx = 0;
	private static int inIdx = 0;
	Node constructTree( int inStart, int inEnd) {
		// empty subtree, 
		if (inStart > inEnd) {
			return null;
		}
		// 		1. pick an element from preorder. 
		//		2. increment a preorder index variable(preIdx) to pick next element in next recursive call	
		// 		3. create a new tree tNode with the data as picked element
		Node node = new Node(pre[preIdx++]); 
		// find the picked element's index in inorder. let the index be inIdx
		inIdx = search(inStart, inEnd, node.key); 
		System.out.println("inIdx : " + inIdx);
		constructTree(inStart, inIdx-1);
		constructTree(inIdx+1, inEnd);

		
		return node;
	}
		

	// to save space have a copy of the sequce in  the class, 
	// so when construct the tree recursively 
	void getInPreSequence(int[] in, int[] pre) {
		this.in = new int[in.length];
		this.pre = new int[pre.length];

		for (int i = 0; i < in.length; i++) {
			this.in[i] = in[i];
			this.pre[i] = pre[i];
		}
	}
	
	void displaySequence() {
		System.out.println("In order : ");
		for (int n: in) {
			System.out.print(n + ", ");
		}
		System.out.println();
		System.out.println("post order");
		for (int n : pre) {
			System.out.print(n + ", ");
		}
		System.out.println();
	}
	
	
	// helper function to find the index of a node in inorder traversal
	// find index of value in a[start...end]
	int search( int start, int end, int val ) {
		int i = 0;
		for (i = start; i <=end; i++) {
			if (val == in[i] ) {
				return i;
			}
		}
		return i;
	}
	
	// construct tree from given In-order and level order traversals

	// test suits
	static void testConstrucTree() {
		BinaryTree bt = new BinaryTree();
		int[] in = new int[] {1, 2, 3, 4, 5, 6};
		int[] pre = new int[] {4, 2, 5, 1, 6, 3};
		BinaryTree.Node root;
		bt.getInPreSequence(in, pre);
		bt.displaySequence();
		root = bt.constructTree(0, in.length);
		root.display();
	}
	static void testNewNode() {
		BinaryTree bt = new BinaryTree();
		bt.root = bt.newNode(8);	
		bt.root.left = bt.newNode(9);
		bt.root.right = bt.newNode(10);
		bt.root.display();
		bt.root.left.display();
		bt.root.right.display();
	}
	
	
	public static void main(String[] args) {
//		testNewNode();
		testConstrucTree();

	}
}


