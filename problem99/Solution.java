package problem99;

import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;

import TreeNode.TreeNode;

//Two elements of a binary search tree (BST) are swapped by mistake.
//
//Recover the tree without changing its structure.
//
//Note:
//A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
//confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

// here we only need to swap the val of the treenode
public class Solution {
	public void recoverTree(TreeNode root) {

		List<TreeNode> temp = new ArrayList<TreeNode>();

		TreeNode e1 = null, e2 = null;

		dfs(root, temp);

		int len = temp.size();
		int lastvalue = temp.get(0).val;
		int lastindex = 0;
		for (int i = 0; i < len - 1; i++) {
			if (temp.get(i).val > temp.get(i + 1).val) {
				lastvalue = temp.get(i).val;
				e1 = temp.get(i);
				lastindex = i;
				break;
			}
		}
		for (int j = lastindex + 1; j < len - 1; j++) {
			if (lastvalue > temp.get(j).val && lastvalue < temp.get(j + 1).val) {
				e2 = temp.get(j);
				break;
			}
		}
		if (e2 == null) e2 = temp.get(len-1);

		int t = e1.val;
		e1.val = e2.val;
		e2.val = t;

	}

	private void dfs(TreeNode root, List<TreeNode> temp) {
		if (root == null)
			return;
		if (root.left != null)
			dfs(root.left, temp);

		temp.add(root);

		if (root.right != null)
			dfs(root.right, temp);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
