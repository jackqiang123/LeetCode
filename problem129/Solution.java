package problem129;

import TreeNode.TreeNode;

//Sum Root to Leaf Numbers Total Accepted: 44600 Total Submissions: 147035 My Submissions Question Solution 
//Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//
//An example is the root-to-leaf path 1->2->3 which represents the number 123.
//
//Find the total sum of all root-to-leaf numbers.
//
//For example,
//
//    1
//   / \
//  2   3
//The root-to-leaf path 1->2 represents the number 12.
//The root-to-leaf path 1->3 represents the number 13.
//
//Return the sum = 12 + 13 = 25.
public class Solution {
	
    public static int sumNumbers(TreeNode root) {
        if (root == null) return 0;
       
        return dfs(0,root);
    }

	private static int dfs(int sum, TreeNode root) {
		if (root.left == null && root.right == null) return (int) (sum*10+root.val);
		else {
			
		if(root.left!= null && root.right!=null) {
			int left = dfs(sum*10+root.val,root.left);
			System.out.println("left is " + left);
			
			int right = dfs(sum*10+root.val,root.right);
			System.out.println("right is " + right);
			return left+right;}
		else if (root.left !=null) return dfs(sum*10+root.val,root.left);
		else return dfs(sum*10+root.val,root.right);
			
			
			
		}
	}
	
	public static void main(String[]args)
	{
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
	//	n1.right = n3;
		System.out.println(sumNumbers(n1));
		
	}

}
