package problem203;

import ListNode.ListNode;

//Remove all elements from a linked list of integers that have value val.
//Example
//Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
//Return: 1 --> 2 --> 3 --> 4 --> 5
//
//Credits:
//Special thanks to @mithmatt for adding this problem and creating all test cases.
public class Solution {

	public static ListNode removeElements(ListNode head, int val) {
		if (head == null) 
			return head;
		while (head != null && head.val == val) {
			head = head.next;
		}
		if (head == null) 
			return head;
		ListNode p = head;
		p = p.next;
		ListNode pre = head;
		while (p != null) {
			if (p.val == val) {
				pre.next = p.next;
				p = p.next;
			} else {
				pre = pre.next;
				p = p.next;
			}

		}

		return head;
	}

	public static void main(String[] args) {
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(1);
		ListNode p3 = new ListNode(1);
		ListNode p4 = new ListNode(1);
		ListNode p5 = new ListNode(1);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		ListNode result = removeElements(p1, 1);
//		while (result != null) {
//			System.out.print(result.val + ",");
//			result = result.next;
//		}
	}



}
