package Problem100;

//Given two binary trees, write a function to check if they are equal or not.
//
//Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		// null case
		if (p == null || q == null) {
			if (p == null && q == null) return true;
			else return false;
			
		}

		// directly equal
		if (p == q)
			return true;

		return DFS(p, q);

	}

	private static boolean DFS(TreeNode p, TreeNode q) {

		if (p == null || q == null) {
			if (p == null && q == null) return true;
			else return false;
			
		}

		if (p.val != q.val)
			return false;

		if (DFS(p.left, q.left) == false)
			return false;

		if (DFS(p.right, q.right) == false)
			return false;

		return true;
	}

	public static void main(String[] args) {
		TreeNode p = null;

		TreeNode q = new TreeNode(0);
		q.right = new TreeNode(0);
		q.right.left = new TreeNode(1);

		System.out.println(isSameTree(q, p));

	}
}
