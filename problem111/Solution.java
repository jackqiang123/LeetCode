package problem111;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }


public class Solution {
	
	
	
    public int minDepth(TreeNode root) {
    	if (root == null) return 0;
    	
        int bestsofar = Integer.MAX_VALUE;
        return DFS(root,bestsofar,0);
    }

	private int DFS(TreeNode node, int bestsofar, int currentdept) {
		currentdept = currentdept+1;
		if (currentdept >= bestsofar)
			 return bestsofar;
		if (node.right == null && node.left == null)
		{
			if (currentdept < bestsofar)
				bestsofar = currentdept;
			return bestsofar;
		}
		int leftdep = Integer.MAX_VALUE;
		int rightdep = Integer.MAX_VALUE;
		if (node.left!=null) {leftdep = DFS(node.left, bestsofar,currentdept);}
		if (node.right!=null) {rightdep = DFS(node.right, bestsofar,currentdept);}
		if (leftdep < rightdep) return leftdep;
		else return rightdep;
		
	}
}