package problem106;

import TreeNode.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    TreeNode root = helper(inorder,0,inorder.length-1,postorder,postorder.length-1);
	return root;    
    }
    
	private TreeNode helper(int[] inorder, int start, int end, int[] postorder, int rootindex) {
		
		if (start>end || rootindex < 0) return null;
		
		int rootvalue = postorder[rootindex];
		
		TreeNode root = new TreeNode(rootvalue);
		
		int inorderrootindex = 0;
		for (inorderrootindex = start; inorderrootindex<=end;inorderrootindex++)
		{
			if (inorder[inorderrootindex] == rootvalue)
				break;
		}
		
		
		root.right = helper(inorder,inorderrootindex+1,end,postorder,rootindex-1);
		int rightlen = end - inorderrootindex;
		root.left = helper(inorder,start,inorderrootindex-1,postorder,rootindex-1-rightlen);

		
		
		
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}



