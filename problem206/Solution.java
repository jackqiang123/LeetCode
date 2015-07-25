package problem206;

import ListNode.ListNode;

//Reverse a singly linked list.
public class Solution {
	public static ListNode reverseList(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode c0 = head;
		
		ListNode c1 = c0.next;
		c0.next = null;
		ListNode c2 = null;
		if (c1.next != null)
			c2 = c1.next;

		while (c2 != null) {
			
			c1.next = c0;
			c0 = c1;
			c1 = c2;
			c2 = c2.next;
		}

		c1.next = c0;
		return c1;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(0);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		ListNode head = reverseList(n1);
		while (head != null)
		{
			System.out.println(head.val);
			head = head.next;
		}
	}

}
