package problem108;

import TreeNode.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
    	int length = nums.length;
    	if (length == 0) return null;
    	TreeNode root = new TreeNode(nums[length/2]);
    	if (length == 1) return root;
    	root.left = buildtree(nums,0,length/2-1);
    	root.right = buildtree(nums,length/2+1,length-1);
    	return root;
        
    }

	private TreeNode buildtree(int[] nums, int i, int j) {
		if (j<i) return null;
		
	    int mid = (i+j)/2;
		TreeNode node = new TreeNode(nums[mid]);
		if (j-i == 0) return node;
		
		if (mid - i >0)
		{
			node.left = buildtree(nums,i,mid-1);
		}
		if (j - mid > 0)
		{
			node.right = buildtree(nums,mid+1,j);
		}
		return node;
	}

	
	
}
