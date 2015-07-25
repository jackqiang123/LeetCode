package problem235;

import TreeNode.TreeNode;

//Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
//
//According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
//
//        _______6______
//       /              \
//    ___2__          ___8__
//   /      \        /      \
//   0      _4       7       9
//         /  \
//         3   5
//For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	
    	if (root == p || root == q || root == null) return root;
        boolean leftcontains = contains(root.left,p,q);
        boolean rightcontains = contains(root.right,p,q);
        if (leftcontains && rightcontains) return root;
        else if (leftcontains) return lowestCommonAncestor(root.left,p,q);
        else return lowestCommonAncestor(root.right,p,q);
    }

	private boolean contains(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return false;
		if (root == p || root == q) return true;
		else return contains(root.left,p,q) || contains(root.right,p,q);
		
	}
}
