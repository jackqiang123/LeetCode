package problem113;

import java.util.LinkedList;
import java.util.List;

import TreeNode.TreeNode;

//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
//For example:
//Given the below binary tree and sum = 22,
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//return
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
public class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (root == null) return result;
		LinkedList<Integer> cur = new LinkedList<Integer>();
		pathSumhelper(root, cur, sum, result);
		return result;

	}

	private void pathSumhelper(TreeNode root, LinkedList<Integer> cur, int sum,
			List<List<Integer>> result) {

		if (root.left == null && root.right == null) {
			if (root.val == sum) {
				LinkedList<Integer> mycur = new LinkedList<Integer>(cur);
				mycur.add(root.val);
				result.add(mycur);
				return;
			} else
				return;
		}

		else {
			cur.add(root.val);
			if (root.left != null) {

				pathSumhelper(root.left, cur, sum - root.val, result);

			}
			if (root.right != null) {

				pathSumhelper(root.right, cur, sum - root.val, result);

			}
			cur.removeLast();

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
