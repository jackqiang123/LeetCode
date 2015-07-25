package problem107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import TreeNode.TreeNode;

//Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//
//For example:
//Given binary tree {3,9,20,#,#,15,7},
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its bottom-up level order traversal as:
//[
//  [15,7],
//  [9,20],
//  [3]
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
			result.add(0,currentlist);
		}
		return result;

	}
	public static void main(String[]args)
	{
		
	
	}
}