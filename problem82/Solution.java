package problem82;

import java.util.ArrayList;
import java.util.HashSet;

import ListNode.ListNode;

//Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
//
//For example,
//Given 1->2->3->3->4->4->5, return 1->2->5.
//Given 1->1->1->2->3, return 2->3.
public class Solution {
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode sudohead = new ListNode(0);
		if (head == null || head.next == null)
			return head;

		sudohead.next = head;
		ListNode pre = sudohead;
		ListNode p1 = head;
		ListNode p2 = head.next;
		boolean flag = false;

		k: while (p1.next != null) {
			while (p2 != null && p1.val == p2.val) {
				flag = true;
				p1.next = p2.next;
				p2 = p2.next;
			}

			// if flag is true, then delete the duplicates
			if (flag) {

				flag = false;
				p1 = p2;
				pre.next = p1;
				if (p1 == null)
					break k;
				p2 = p1.next;
			} else {
				pre = pre.next;
				p1 = p1.next;
				p2 = p2.next;

			}

		}

		return sudohead.next;

	}

	public static void main(String[] args) {
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(3);
		ListNode p3 = new ListNode(3);
		ListNode p4 = new ListNode(4);
		ListNode p5 = new ListNode(5);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;

		ListNode result = deleteDuplicates(p1);
		while (result != null) {
			System.out.print(result.val + ",");
			result = result.next;
		}

	}

}
