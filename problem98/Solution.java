package problem98;

import TreeNode.TreeNode;

//Given a binary tree, determine if it is a valid binary search tree (BST).
//
//Assume a BST is defined as follows:
//
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.
public class Solution {
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		if (root.left == null && root.right == null) return true;
		int leftmax = 0;
		int rightmax = 0;
		if (root.left != null)
			leftmax = findmax(root.left);
		if (root.right != null)
			rightmax = findmin(root.right);
		
		if (root.left != null && root.right != null)
		{	
		if (leftmax < root.val && root.val < rightmax)
			return (isValidBST(root.left) && isValidBST(root.right));
		else
			return false;
		}
		else if (root.left != null && root.right == null)
		{
			if (leftmax < root.val )
				return (isValidBST(root.left));
			else
				return false;
			
		}
		else {
			if (root.val < rightmax)
				return ( isValidBST(root.right));
			else
				return false;
			
			
		}
	}

	private int findmin(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}

		return root.val;
	}

	private int findmax(TreeNode root) {

		while (root.right != null) {
			root = root.right;
		}

		return root.val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
