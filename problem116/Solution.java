package problem116;

//Given a binary tree
//
//struct TreeLinkNode {
//  TreeLinkNode *left;
//  TreeLinkNode *right;
//  TreeLinkNode *next;
//}
//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//
//Initially, all next pointers are set to NULL.
//
//Note:
//
//You may only use constant extra space.
//You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
//For example,
//Given the following perfect binary tree,
//     1
//   /  \
//  2    3
// / \  / \
//4  5  6  7
//After calling your function, the tree should look like:
//     1 -> NULL
//   /  \
//  2 -> 3 -> NULL
// / \  / \
//4->5->6->7 -> NULL

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

public class Solution {
	public static void connect(TreeLinkNode root) {
		if (root == null)
			return;
		if (root.left != null && root.right != null) 
		{
			
		
			connect(root.left);
			connect(root.right);
			TreeLinkNode temp1 = root.left;
			TreeLinkNode temp2 = root.right;
			
			while(temp1 != null && temp2!=null)
			{
				//System.out.println("connecting" + temp1.val +" to "+temp2.val);
				//System.out.println("address tempe" + temp1 +" address 3 "+temp2.val);
				temp1.next = temp2;
				temp1 = temp1.right;
				temp2 = temp2.left;
				
			}
			
		}

	}


	public static void main(String []args){
		TreeLinkNode node0 = new TreeLinkNode(0);
		TreeLinkNode node1 = new TreeLinkNode(1);
		TreeLinkNode node2 = new TreeLinkNode(2);
		TreeLinkNode node3 = new TreeLinkNode(3);
		TreeLinkNode node4 = new TreeLinkNode(4);
		TreeLinkNode node5 = new TreeLinkNode(5);
		TreeLinkNode node6 = new TreeLinkNode(6);

		node0.left=node1;
		node0.right=node2;
		
		node1.left = node3;
		node1.right =node4;
		node2.left = node5;
		node2.right = node6;
		
		
		
		connect(node0);
		
		System.out.println(node5.next.val);
		
		
	}
}