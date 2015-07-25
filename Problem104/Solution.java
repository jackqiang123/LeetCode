package Problem104;
//Given a binary tree, find its maximum depth.
//
//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

  class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }

public class Solution {
	// use dfs

	// private int currentbest = 0;
	public static int maxDepth(TreeNode root) {

		return DFS(root, 1);

	}

	private static int DFS(TreeNode root, int height) {
		int leftlength = 0, rightlength = 0;
		if (root.left!=null)
		   leftlength = DFS(root.left,height);
		
		if (root.right!=null)
		   rightlength = DFS(root.right,height);

		if (leftlength < rightlength)
			return height+rightlength;
		else 
			return height+leftlength;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode mytree = new TreeNode(0);
		
		System.out.println(maxDepth(mytree));

	}

}
