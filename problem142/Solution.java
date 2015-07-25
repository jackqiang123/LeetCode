package problem142;

import ListNode.ListNode;
//Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
//Follow up:
//Can you solve it without using extra space?
//		

public class Solution {
	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;

		ListNode r1 = head;
		ListNode r2 = head;
		while (true) {
			if (r1.next != null)
				r1 = r1.next;
			else
				return null;
			if (r2.next != null && r2.next.next != null)
				r2 = r2.next.next;
			else
				return null;
			if (r1 == r2) {
				break;
			} // here r1 meets r2, has cycle.

		}

		r1 = head;
		while (r1 != r2) {
			r1 = r1.next;
			r2 = r2.next;

		}
		return r1;

	}
}
