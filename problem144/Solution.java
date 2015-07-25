package problem144;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree, return the preorder traversal of its nodes' values.
//
//For example:
//Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
//return [1,2,3].
//
//Note: Recursive solution is trivial, could you do it iteratively?

///**
// * Definition for a binary tree node.
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode(int x) { val = x; }
// * }
// */


 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	     TreeNode(int x) { val = x; }
	  }
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<Integer>();
    	if (root == null) return result;
    	result.add(root.val);
    	if (root.left != null) visit(root.left,result);
    	
    	if (root.right != null) visit(root.right,result);
        return result;
    }

	private void visit(TreeNode node, List<Integer> result) {
		if (node == null) return;
		result.add(node.val);
		if (node.left != null) visit(node.left,result);
		;
		if (node.right != null) visit(node.right,result);
		
	}
   
}