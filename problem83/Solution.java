package problem83;

import ListNode.ListNode;

//Given a sorted linked list, delete all duplicates such that each element appear only once.
//
//For example,
//Given 1->1->2, return 1->2.
//Given 1->1->2->3->3, return 1->2->3.
///**
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) { val = x; }
// * }
// */
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		ListNode node = head;
		while (node != null) {
			while (node.next != null) {
				if (node.next.val == node.val)
					node.next = node.next.next;
				else
					break;
			}
			node = node.next;
		}
		return head;

	}

}