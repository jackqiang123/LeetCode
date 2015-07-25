package problem103;

import java.util.LinkedList;
import java.util.List;
//import java.util.Queue;
//import java.util.Stack;

import TreeNode.TreeNode;
//Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
//
//For example:
//Given binary tree {3,9,20,#,#,15,7},
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its zigzag level order traversal as:
//[
//  [3],
//  [20,9],
//  [15,7]
//]

public class Solution {
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (root == null)
			return result;
		dfs(root, 1, result);
		return result;

	}

	private static void dfs(TreeNode root, int level, List<List<Integer>> result)
	// TODO Auto-generated method stub
	{
		if (root == null)
			return;
		System.out.println("we are adding " + root.val + "  to level "+level);
		visit(root.val, level, result);
		if (root.left!=null)
			dfs(root.left, level + 1, result);
		if (root.right!=null)
			dfs(root.right, level + 1, result);
	}

	private static void visit(int currentvisit, int level, List<List<Integer>> result) {
		if (result.size() >= level) {
			List<Integer> cur = result.get(level - 1);
	//		System.out.println()
			if (level % 2 == 1)
				cur.add(currentvisit);
			else
				cur.add(0,currentvisit);
		//	result.add(cur);

		} else {
			List<Integer> cur = new LinkedList<Integer>();
			cur.add(currentvisit);
			result.add(cur);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(9);
		TreeNode n3 = new TreeNode(20);
		TreeNode n4 = new TreeNode(15);
		TreeNode n5 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;
		List<List<Integer>> result = zigzagLevelOrder(n1);
		for (List<Integer> k : result)
		{
			for (Integer s : k)
				System.out.print(s+",");
			System.out.println();
		}

	}

}
