package problem95;

import java.util.LinkedList;
import java.util.List;

import TreeNode.TreeNode;

//Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
//
//For example,
//Given n = 3, your program should return all 5 unique BST's shown below.
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
public class Solution {
	public static List<TreeNode> generateTrees(int n) {
		// List<TreeNode> result = new LinkedList<TreeNode>();
		if (n == 0)
		{
			List<TreeNode> result = new LinkedList<TreeNode>();
			TreeNode r = null;
			result.add(r);
			return result;
			
			
		}
		List<TreeNode> result = generateTree(1, n); // start at 1, with length n
		return result;
	}

	private static List<TreeNode> generateTree(int start, int len) {
		List<TreeNode> result = new LinkedList<TreeNode>();
		//TreeNode temp = null;
		if (len == 0)
		{return result;}
		if (len == 1) {
			TreeNode root = new TreeNode(start);
			result.add(root);
		}

		for (int l = 0; l <= len - 1; l++) {
			List<TreeNode> leftresult = generateTree(start, l); // from start to
																// start + l -1
																// (include)
			
			List<TreeNode> rightresult = generateTree(start + 1 + l, len - 1
					- l);
		
			int leftsize = leftresult.size();
			int rightsize = rightresult.size();
			if (leftsize == 0)
			{

				
				for (TreeNode right : rightresult) {
					TreeNode root = new TreeNode(start + l);			
					root.left = null; 
					root.right = right;
					result.add(root);
				}
				
				
			}
			else if (rightsize == 0)
			{
				for (TreeNode left : leftresult) {
					TreeNode root = new TreeNode(start + len - 1);			
					root.right = null; 
					root.left = left;
					result.add(root);					
				}
				
			}
			
			{
			
			for (TreeNode left : leftresult) {
				for (TreeNode right : rightresult) {
					TreeNode root = new TreeNode(start + l);
					root.left = left;
					root.right = right;
				//	System.out.println("add a result");
					result.add(root);

				}
			}
			}

		}

		return result;

	}
	public static void main(String []args)
	{
		List<TreeNode> r = generateTrees(3);
		System.out.println(r.size());
		
//		List<TreeNode> r = new LinkedList<TreeNode>();
//		for (TreeNode k : r) {
//		System.out.println("hello");
//		}
		
	}
	
}
