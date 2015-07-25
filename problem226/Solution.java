package problem226;

import TreeNode.TreeNode;

//Invert a binary tree.
//
//4
///   \
//2     7
/// \   / \
//1   3 6   9
//to
//4
///   \
//7     2
/// \   / \
//9   6 3   1
public class Solution {
    public TreeNode invertTree(TreeNode root) {
    	if (root == null) return root;
    	TreeNode leftc = invertTree(root.left);
    	TreeNode rightc = invertTree(root.right);
    	root.left = rightc;
    	root.right = leftc;
    	return root;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
