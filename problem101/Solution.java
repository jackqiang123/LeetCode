package problem101;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import TreeNode.TreeNode;
//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
//For example, this binary tree is symmetric:
//
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//But the following is not:
//    1
//   / \
//  2   2
//   \   \
//   3    3
//construct tree is preorder- and postorder, check the visited result;

public class Solution {
	public static boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		
	return check(root.left,root.right);
		
		
	}

	private static boolean check(TreeNode left, TreeNode right) {
		if (left == null && right == null) return true;
		if (left == null || right == null) return false;
		return (left.val == right.val) && check(right.right,left.left) && check(right.left,left.right);
	}
}