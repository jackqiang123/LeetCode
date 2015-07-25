package problem124;

import TreeNode.TreeNode;

//Given a binary tree, find the maximum path sum.
//
//The path may start and end at any node in the tree.
//
//For example:
//Given the below binary tree,
//
//       1
//      / \
//     2   3
//Return 6.
public class Solution {
	private int currentmax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
   // int maxvalue = 0;
//    int left = maxPathHelper(root.left);
//    int right = maxPathHelper(root.right);
//    int sum = root.val + Math.max(0, left) + Math.max(0, right);
    int k = maxPathHelper(root);
    return currentmax;   
    }
	private int maxPathHelper(TreeNode root)  // (must) start from root, what is the max sum value?
	{//System.out.println("current visit" + root.val + " and the sum is " + thissum);
		if (root == null) return 0;
		int left = Integer.MIN_VALUE;
		int right = Integer.MIN_VALUE;
		//if (root == null) return 0;
		if (root.left != null) left = maxPathHelper(root.left);
		else left = 0;
		if (root.right != null) right = maxPathHelper(root.right);
		else right = 0;
		int thissum = root.val + Math.max(0, left) + Math.max(0, right);
		//System.out.println("current visit" + root.val + " and the sum is " + thissum);
		currentmax = Math.max(currentmax, thissum);
		return root.val + Math.max(0, Math.max(right, left));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
