package problem92;

import ListNode.ListNode;

//Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
//For example:
//Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//
//return 1->4->3->2->5->NULL.
//
//Note:
//Given m, n satisfy the following condition:
//1 ≤ m ≤ n ≤ length of list.
public class Solution {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
			return head;
		int index = 1;
		ListNode node = head;
		ListNode PreviousAppNode = null;
		ListNode myhead = null;
		ListNode temp = null;
		ListNode tail = null;
		ListNode pPreviousAppNode = new ListNode(0); 
		pPreviousAppNode.next = head;
		while (true) {
			if (index == m - 1)
				PreviousAppNode = node;

			if (index == n) {
				tail = node;
				break;
			}

			node = node.next;
			index++;

		}
		
		if (PreviousAppNode == null) // that is m = 1
		{
			PreviousAppNode = pPreviousAppNode;
		}
		
		
		myhead = PreviousAppNode.next;
		
		PreviousAppNode.next = tail;
		// temp = head.next;

		index = m;

		while (index < n) {
			temp = myhead.next;
			myhead.next = tail.next;
			tail.next = myhead;
			myhead = temp;
			index++;

		}
		
		return (m==1)? pPreviousAppNode.next:head;
	}

	public static void main(String[] args) {

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		ListNode r = reverseBetween(l1, 1, 5);
		// ListNode r = l1;
		while (r != null) {
			System.out.println(r.val);
			r = r.next;
		}
	}
}
