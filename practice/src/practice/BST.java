package practice;

import java.util.Stack;

public class BST {
	public BST(){};
	
	
	public void PrintInOrder(TreeNode root)
	{
		
		if (root == null)
			return;
		PrintInOrder(root.left);
		System.out.print(root.key);
		System.out.print(" ");
		PrintInOrder(root.right);
	}
	public void PrintPreOrder(TreeNode root)
	{
		
		if (root == null)
			return;
		
		System.out.print(root.key);
		System.out.print(" ");
		PrintPreOrder(root.left);
		PrintPreOrder(root.right);
	}
	public void PrintPostOrder(TreeNode root)
	{
		
		if (root == null)
			return;
		PrintPostOrder(root.left);
		PrintPostOrder(root.right);
		System.out.print(root.key);
		System.out.print(" ");
		
	}
	private int inorderSuccessor(TreeNode root, int key)
	{
		return key;
	}
	private int inorderPredessor(TreeNode root, int key)
	{
		return key;
	}
	private int preorderSuccessor(TreeNode root, int key)
	{
		return key;
	}
	private int preorderPredessor(TreeNode root, int key)
	{
		return key;
	}
	private int postorderSuccessor(TreeNode root, int key)
	{
		return key;
	}
	private int postorderPredessor(TreeNode root, int key)
	{
		return key;
	}
	public static void test()
	{
		

		BST bst = new BST();
		/*
		TreeNode bt = bst.CreateBinaryTree();
		System.out.println(bst.isBST(bt));
		TreeNode st = bst.createBST();
		System.out.println(bst.isBST(bt));
		TreeNode pbt = bst.createPerfectBinaryTree();
		System.out.println(bst.heightBST(bt));
		System.out.println(bst.heightBST(st));
		System.out.println(bst.heightBST(pbt));
		System.out.println(bst.isPerfect(bt));
		System.out.println(bst.isPerfect(st));
		System.out.println(bst.isPerfect(pbt));
		*/
		TreeNode root = bst.CreateBinaryTree();
		bst.PrintPreOrder(root);
		bst.preOrderIterative(root);
	}
	private TreeNode flattenHelper(TreeNode root)
	{
		if (root == null || (root.left == null && root.right == null))
			return root;
		TreeNode lbt = flattenHelper(root.left);
		TreeNode rbt = flattenHelper(root.right);
        if (lbt !=null) lbt.right = root.right;
        if (root.left != null)
        	root.right = root.left; 
        root.left = null;
        
        if (rbt != null) 
        	return rbt; 
		return lbt;
			
	}
	public void flatten_test()
	{
		TreeNode root = this.CreateBinaryTree();
		flattenHelper(root);
		TreeNode p = root;
		while(p!=null)
		{
			System.out.println(p.key);
			p = p.right;
		}
	}
	/*
	 * 			  1
	 * 		2			5
	 *	3		4	6		7
	 */
	public TreeNode CreateBinaryTree()
	{
		TreeNode node2 = new TreeNode(2, 3, 4);
		TreeNode node3 = new TreeNode(5, 6, 7);
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
		TreeNode node5 = new TreeNode(5, node10, node11);
		TreeNode node6 = new TreeNode(6, node12, node13);
		TreeNode node7 = new TreeNode(7, node14, node15);
		
		TreeNode node2 = new TreeNode(2, node4, node5);
		TreeNode node3 = new TreeNode(3, node6, node7);
		return new TreeNode(1, node2, node3);
	}
	public boolean isBST(TreeNode root)
	{
		if (root == null)
			return true;
		TreeNode left = root.left;
		TreeNode right = root.right;
		if (left == null && right !=null && root.key > right.key)
			return false;
		if (left != null && right ==null && root.key < left.key)
			return false;
		if(left !=null & right!=null)
		{
			if (root.key > right.key || root.key < left.key)
				return false;
		}
		return isBST(left) && isBST(right);
	}
	public boolean isPerfect(TreeNode root)
	{
		if(root == null)
			return true;
		int lh = heightBST(root.left);
		int rh = heightBST(root.right);
		return lh == rh && isPerfect(root.left) && isPerfect(root.right);
	}
	public int heightBST(TreeNode root)
	{
		if (root == null)
			return 0;
		int lh = 1 + heightBST(root.left);
		int rh = heightBST(root.right);
		return Math.max(lh, rh);
	}
	public void inOrderIterative(TreeNode root)
	{
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode cur = root;
		while(cur != null)
		{
			st.push(cur);
			cur = cur.left;
		}
		while(st.size() > 0)
		{
			cur = st.pop();
			System.out.println(cur.key);
			if (cur.right != null)
			{
				cur = cur.right;
				while(cur != null)
				{
					st.push(cur);
					cur = cur.left;
				}
			}
			
		}
	}
	public void postOrderTraversal(TreeNode root)
	{
		if (root == null)
			return;
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode cur = root;
		TreeNode temp;
		while (cur != null || st.size() > 0)
		{
			if (cur != null)
			{
				st.push(cur);
				cur = cur.left;
			}
			else
			{
				temp = st.peek().right;
				if (temp == null)
				{
					temp = st.pop();
					System.out.println(temp.key);
					while( st.size() > 0 && temp == st.peek().right)
					{
						temp = st.pop();
						System.out.println(temp.key);
						
					}
				}
				else
				{
					cur = temp;
				}
			}
		}
	}
	public void preOrderIterative(TreeNode root)
	{
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode cur = root;
		st.push(cur);
		while(st.size() > 0)
		{
			cur = st.pop();
			System.out.println(cur.key);
			if (cur.right != null)
			{
				st.push(cur.right);
			}
			if (cur.left != null)
			{
				st.push(cur.left);
			}
			
			
		}
	}
	public void morris_traversal(TreeNode root)
	{
		if(root == null)
			return;
		TreeNode current = root;
		while(current != null)
		{
			if(current.left == null)
			{
				System.out.println(current.key);
				current = current.right;
			}
			else
			{
				TreeNode pre = current.left;
				while(pre.right !=null && pre.right != current)
					pre = pre.right;
				if (pre.right == null)
				{
					pre.right = current;
					current =  current.left;
				}
				else
				{
					pre.right = null;
					System.out.println(current.key);
					current = current.right;
				}
			}
		}
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