package problem230;

import TreeNode.TreeNode;

//Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
//
//Note: 
//You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
//
//Follow up:
//What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
//
//Hint:
//
//Try to utilize the property of a BST.
//What if you could modify the BST node's structure?
//The optimal runtime complexity is O(height of BST).
public class Solution {
	public int kthSmallest(TreeNode root, int k) {
		int leftcount = countnode(root.left);
		if (leftcount + 1 == k)
			return root.val;
		else if (leftcount + 1 > k)
			return kthSmallest(root.left, k);
		else
			return kthSmallest(root.right, k - 1 - leftcount);
	}

	private int countnode(TreeNode root) {
		if (root == null)
			return 0;

		return countnode(root.left) + countnode(root.right) + 1;
	}
}
