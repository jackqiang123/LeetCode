package problem199;

import java.util.LinkedList;
import java.util.List;

import TreeNode.TreeNode;

//Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
//For example:
//Given the following binary tree,
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
//You should return [1, 3, 4].
public class Solution {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new LinkedList<Integer>();
		if (root == null)
			return result;
		dfs(root, result, 0);
		return result;
	}

	private void dfs(TreeNode root, List<Integer> result, int height) {
		if (result.size() <= height)
			result.add(height, root.val);
		else
			result.set(height, root.val);

		if (root.left != null)
			dfs(root.left, result, height + 1);
		if (root.right != null)
			dfs(root.right, result, height + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
