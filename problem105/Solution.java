package problem105;

import TreeNode.TreeNode;

//Given preorder and inorder traversal of a tree, construct the binary tree.
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	int len = preorder.length;
    	TreeNode root = helper(preorder,0,inorder,0,len-1);
    	return root;
    }
	private TreeNode helper(int[] preorder, int rootindex, int []inorder, int start, int end) {
		int len = end - start + 1;
		if (len == 0) return null;
		if (rootindex > preorder.length - 1 || start > end) return null;
		
		
		int rootvalue = preorder[rootindex];
		
		TreeNode root = new TreeNode(rootvalue);
		
		if (len == 1) return root;
		int inorderrootindex = start;
		for (int i = start ; i<= end;i++)
		{
			if (inorder[i] == rootvalue)
				{inorderrootindex = i; break;}
			
		}
		
		
		root.left = helper(preorder,rootindex + 1,inorder,start,inorderrootindex-1);
		int leftlength = inorderrootindex - start;
		root.right = helper(preorder, rootindex+1+leftlength,inorder,inorderrootindex+1,end);
		
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
