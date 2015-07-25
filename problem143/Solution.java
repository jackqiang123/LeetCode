package problem143;

import ListNode.ListNode;

//Given a singly linked list L: L0→L1→…→Ln-1→Ln,
//reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//You must do this in-place without altering the nodes' values.
//
//For example,
//Given {1,2,3,4}, reorder it to {1,4,2,3}.
public class Solution {
	public static void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode mid = findmid(head);
		ListNode right = inverse(mid);
		merge(head, right);
	}

	private static void merge(ListNode left, ListNode right) {
		ListNode temp = null;
		ListNode tempright = null;
		while (right != null) {
			temp = left.next;
			tempright = right.next;
			left.next = right;
			right.next = temp;
			left = temp;
			right = tempright;

		}

	}

	private static ListNode inverse(ListNode p) {
		if (p == null || p.next == null)
			return p;

		ListNode head = p;
		while (head.next != null) {
			head = head.next;
		}
		ListNode tail = head;
		// System.out.println(p.val);
		head = p;
		ListNode temp;
		while (head != tail) {
			// System.out.println("loop");
			temp = head.next;
			head.next = tail.next;
			tail.next = head;
			head = temp;
			// System.out.println(head.val);
		}
		return head;

	}

	private static ListNode findmid(ListNode head) {
		ListNode p1 = head;
		ListNode p2 = head;
		ListNode pre = head;
		while (true) {
			pre = p1;
			p1 = p1.next;
			if (p2.next != null && p2.next.next != null) {
				p2 = p2.next.next;

			} else
				break;
		}
		pre.next = null;
		return p1;
	}

	public static void main(String[] args) {
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(2);
		ListNode p3 = new ListNode(3);
		ListNode p4 = new ListNode(4);
		ListNode p5 = new ListNode(5);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		// p4.next = p5;
		reorderList(p1);
		ListNode result = p1;
		while (result != null) {
			System.out.print(result.val + ",");
			result = result.next;
		}
		// System.out.print(findmid(p1).val);
	}

}
