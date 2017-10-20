package practice;


public class BST {
	BSTNode root;
	public BST(int rootKey){
		this.root = new BSTNode(rootKey);
	}
	public BST(){};
	public void insert(int key)
	{
		this.InsertUtil(root, key);
	}
	private BSTNode InsertUtil(BSTNode node, int key)
	{
		if (node == null)
			return new BSTNode(key);
		if (node.key == key)
			System.out.println("Key conflict");
		if (node.key > key)
			node.left = InsertUtil(node.left, key);
		if (node.key < key)
			node.right = InsertUtil(node.right, key);
		return node;
	}
	private void PrintInOrderUtil(BSTNode node)
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
		test.insert(500);
		test.insert(100);
		test.PrintInOrder();
	}

}
class BSTNode {
	public int key;
	public BSTNode left;
	public BSTNode right;
	
	public BSTNode(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}
}