package problem109;

import ListNode.ListNode;
import TreeNode.TreeNode;

//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
public class Solution {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return new TreeNode(head.val);

		ListNode mid = findmid(head); // find the middle and set the mid to be
										// zero
		TreeNode root = new TreeNode(mid.val);
		TreeNode left = sortedListToBST(head);
		ListNode temp = mid.next;
		mid.next = null;
		TreeNode right = sortedListToBST(temp);
		root.left = left;
		root.right = right;
		return root;
	}

	private ListNode findmid(ListNode head) {

		ListNode r1 = head;
		ListNode r2 = head;

		while (r2.next != null) {
			if (r2.next != null) {
				r2 = r2.next;
				r1 = r1.next;
			} else
				break;
			if (r2.next != null)
				r2 = r2.next;
			else
				break;

		}
		r2 = head;
		while (r2.next != r1) {
			r2 = r2.next;
		}
		r2.next = null;
		return r1;
	}

}
