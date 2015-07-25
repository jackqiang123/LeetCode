package problem102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import TreeNode.TreeNode;

//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
//For example:
//Given binary tree {3,9,20,#,#,15,7},
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its level order traversal as:
//[
//  [3],
//  [9,20],
//  [15,7]
//]

public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> myqueue = new LinkedList<TreeNode>(); // used to do BFS
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) return result;
		myqueue.offer(root);
		while (myqueue.isEmpty() == false) {
			ArrayList<Integer> currentlist = new ArrayList<Integer>();;// = new ArrayList<Integer>();
			int queuesize = myqueue.size();
			for (int i = 0; i < queuesize; i++) {
				//currentlist = new ArrayList<Integer>();
				TreeNode n = myqueue.poll();
				currentlist.add(n.val);
				if (n.left != null)
					myqueue.offer(n.left);
				if (n.right != null)
					myqueue.offer(n.right);
				

			}
			result.add(currentlist);
		}
		return result;

	}
	public static void main(String[]args)
	{
		
	
	}
}