package practice;


public class BST {
	TreeNode root;
	public BST(int rootKey){
		this.root = new TreeNode(rootKey);
	}
	public BST(TreeNode node){
		this.root = node;
	}
	public BST(){};
	
	private void PrintInOrderUtil(TreeNode node)
	{
		if (node == null)
			return;
		PrintInOrderUtil(node.left);
		System.out.print(node.key);
		System.out.print(" ");
		PrintInOrderUtil(node.right);
	}
	public void PrintInOrder()
	{
		
		this.PrintInOrderUtil(root);
	}
	public static void test()
	{
		BST test = new BST(150);
		test.PrintInOrder();
	}
	/*
	 * 			  1
	 * 		2			3
	 *	3		4	5		6
	 */
	public TreeNode CreateBinaryTree()
	{
		TreeNode node2 = new TreeNode(2, 3, 4);
		TreeNode node3 = new TreeNode(2, 5, 6);
		return new TreeNode(1, node2, node3);
	}
	/*
	 * 			8
	 * 
	 * 3 				10
	 * 
	 * 		6					14
	 * 
	 * 4		 7			13
	 */
	public TreeNode createBST()
	{
		TreeNode node6 = new TreeNode(6, 4, 7);
		TreeNode node3 = new TreeNode(3, null, node6);
		TreeNode node14 = new TreeNode(14, new TreeNode(13), null);
		TreeNode node10 = new TreeNode(10, null, node14);
		return new TreeNode(8, node3, node10);
	}
	/*
	 * 									1
	 * 
	 * 					2										3
	 * 
	 * 			4				5 						6							7
	 * 
	 * 		8		 9 		 10		11			12				13				14			15
	 * 
	 *	16	  17  18  19  20   21 22  23	24	    25		26		27	     28		29	 30		31
	 */
	public TreeNode createPerfectBinaryTree()
	{
		TreeNode node8 = new TreeNode(8, 16, 17);
		TreeNode node9 = new TreeNode(9, 18, 19);
		TreeNode node10 = new TreeNode(10, 20, 21);
		TreeNode node11 = new TreeNode(11, 22, 23);
		TreeNode node12 = new TreeNode(12, 24, 25);
		TreeNode node13 = new TreeNode(13, 26, 27);
		TreeNode node14 = new TreeNode(14, 28, 29);
		TreeNode node15 = new TreeNode(15, 30, 31);
		
		TreeNode node4 = new TreeNode(4, node8, node9);
		TreeNode node5 = new TreeNode(4, node10, node11);
		TreeNode node6 = new TreeNode(4, node12, node13);
		TreeNode node7 = new TreeNode(4, node14, node15);
		
		TreeNode node2 = new TreeNode(4, node4, node5);
		TreeNode node3 = new TreeNode(4, node6, node7);
		return new TreeNode(1, node2, node3);
	}

}
class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}
	public TreeNode(int key, TreeNode left, TreeNode right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}
	public TreeNode(int key, int left, int right) {
		this.key = key;
		this.left = new TreeNode(left);
		this.right = new TreeNode(right);
	}

	public TreeNode InsertBST(TreeNode node, int key)
	{
		if (node == null)
			return new TreeNode(key);
		if (node.key == key)
			System.out.println("Key conflict");
		if (node.key > key)
			node.left = InsertBST(node.left, key);
		if (node.key < key)
			node.right = InsertBST(node.right, key);
		return node;
	}
}