package problem222;

import TreeNode.TreeNode;

//Given a complete binary tree, count the number of nodes.
//
//Definition of a complete binary tree from Wikipedia:
//In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
public class Solution {
	
    public int countNodes(TreeNode root) {
    if (root == null) return 0;
    int lc = 0;
    int rc = 0;
    TreeNode l = root;
    TreeNode r = root;
    while(l!=null)
    {
    	lc++; l = l.left;
    }
    
    while(r!=null)
    {
    	rc++; r = r.right;
    }
    if (lc==rc) return 2<<lc - 1;
    int left = countNodes(root.left);
    int right = countNodes(root.right);
    return 1+left+right;
	}
    public static void main(String[]args)
    {
    	
    	System.out.println(2<<0 -1); // note that +-*/ is higher than << and >>
    }
	
}
