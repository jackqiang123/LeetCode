package problem117;

//import problem116.TreeLinkNode;

//Follow up for problem "Populating Next Right Pointers in Each Node".
//
//What if the given tree could be any binary tree? Would your previous solution still work?
//
//Note:
//
//You may only use constant extra space.
//For example,
//Given the following binary tree,
//         1
//       /  \
//      2    3
//     / \    \
//    4   5    7
//After calling your function, the tree should look like:
//         1 -> NULL
//       /  \
//      2 -> 3 -> NULL
//     / \    \
//    4-> 5 -> 7 -> NULL

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
		connect(root.left);
		connect(root.right);
		TreeLinkNode leftrightmost = root.left;
		TreeLinkNode rightleftmost = root.right;
		int level = 0;
	//	System.out.println("we are dealing with the root's subtree " + root.val );
		while (leftrightmost != null && rightleftmost != null) {
			

			level++;
		//	System.out.println("the current level is " + level  +" connect " + leftrightmost.val + "  -> " + rightleftmost.val );
	
			leftrightmost.next = rightleftmost;
			
			leftrightmost = findright(root.left, level);
	
			rightleftmost = findleft(root.right, level);
			

		}
		level = 0;
	}

	private static TreeLinkNode findleft(TreeLinkNode root, int level) {
		if (root == null) return null;
		if (level == 0)
			return root;

		if (root.left != null) {
			TreeLinkNode temp = findleft(root.left, level - 1);
			if (temp != null)
				return temp;
		}
		if (root.right != null) {
			TreeLinkNode temp = findleft(root.right, level - 1);
			if (temp != null)
				return temp;
		}

		return null;
	}

	private static TreeLinkNode findright(TreeLinkNode root, int level) {
		if (level == 0)
			return root;
		if (root.right != null) {
			TreeLinkNode temp = findright(root.right, level - 1);
			if (temp != null)
				return temp;
		}
		if (root.left != null) {
			TreeLinkNode temp = findright(root.left, level - 1);
			if (temp != null)
				return temp;
		}

		return null;
	}

	public static void main(String[] args) {
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
		System.out.println(node4.next.val);

	}

}
