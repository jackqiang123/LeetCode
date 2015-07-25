package problem110;

import TreeNode.TreeNode;
//Given a binary tree, determine if it is height-balanced.
//
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
public class Solution {
	private static boolean isBalancedorNot = true;

	public static boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		int heightleft = treeheight(root.left);

		int heightright = treeheight(root.right);

		if (isBalancedorNot == false)
			return false;

		//System.out.println("left tree is with height" + heightleft
		//		+ " and the right is " + heightright);
		
		if (Math.abs(heightleft - heightright) <= 1)
			return true;
		else
			return false;

	}

	private static int treeheight(TreeNode node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		int hl = 0, hr = 0;
		
			hl = treeheight(node.left) + 1;
		
			hr = treeheight(node.right) + 1;
	//	System.out.println("at node"+node.val+"we get in and hl =="+hl+";hr=="+hr);
		if (Math.abs(hl-hr)>1) {
			//System.out.println("we get in and hl =="+hl+";hr=="+hr);
			isBalancedorNot = false;}
		if (hl >= hr)
			return hl;
		else
			return hr;

	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
	//	TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		n0.left = n1;
		n0.right = n2;
		
		n1.left = n3;
		n1.right = n4;
		n3.left = n5;
		
		n2.right = n7;
	
		System.out.println("whether it is balanced ?" + isBalanced(n0));
	}
}
