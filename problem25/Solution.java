package problem25;

import ListNode.ListNode;

//Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//
//If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
//
//You may not alter the values in the nodes, only nodes itself may be changed.
//
//Only constant memory is allowed.
//
//For example,
//Given this linked list: 1->2->3->4->5
//
//For k = 2, you should return: 2->1->4->3->5
//
//For k = 3, you should return: 3->2->1->4->5
class ListNodeGroup {

	ListNode head;
	ListNode tail;

}

public class Solution {

	public static ListNode reverseKGroup(ListNode head, int k) {

		// ListNode currentgrouphead = head;
		if (k == 1)
			return head;

		int numofNodes = 0;
		ListNode count = head;
		while (count != null) {
			numofNodes++;
			if (numofNodes % k == 0) {
			}
			count = count.next;
		}

		int numberofterms = numofNodes / k; // we need this num of rounds

		if (numberofterms == 0)
			return head;
		// we first idenfity a head

		ListNodeGroup previosgroup = reverseKGrouphelper(head, k);
		ListNode result = previosgroup.head;
		ListNodeGroup currentgroup = null;
		for (int i = 1; i < numberofterms; i++) {
			currentgroup = reverseKGrouphelper(previosgroup.tail.next, k);
			previosgroup.tail.next = currentgroup.head;
			previosgroup = currentgroup;

		}

		// if (numofNodes % k == 0)
		// previosgroup.tail.next = null;
		// else
		// previosgroup.tail.next = appNode;

		return result;
	}

	private static ListNodeGroup reverseKGrouphelper(ListNode head, int k) {
		int count = 1;
		ListNode tail = head;
		ListNode myhead = head;
		ListNode temp;
		while (count < k) {
			tail = tail.next;
			count++;
		}
		// System.out.println(tail.next.val);
		count = 1;
		while (count < k) {
			temp = head.next;
			head.next = tail.next;
			tail.next = head;
			head = temp;
			count++;
		}

		ListNodeGroup result = new ListNodeGroup();
		result.head = head;
		result.tail = myhead;

		return result;
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
		// ListNodeGroup r = reverseKGrouphelper(l1,5);
		ListNode r = reverseKGroup(l1, 3);
		// ListNode r = l1;
		while (r != null) {
			System.out.println(r.val);
			r = r.next;
		}
	}
}
