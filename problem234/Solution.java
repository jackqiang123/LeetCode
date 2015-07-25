package problem234;

import ListNode.ListNode;

//Given a singly linked list, determine if it is a palindrome.
//
//Follow up:
//Could you do it in O(n) time and O(1) space?
public class Solution {
	public static boolean isPalindrome(ListNode head) {
		int num = 0; // num is the node in the list
		ListNode h = head;
		while (h != null) {
			num++;
			h = h.next;
		}
		if (num <= 1) return true;
		if (num == 2) return head.val == head.next.val;
			
		
		
		int count = 0;
		int mid = num / 2;
		ListNode leftlast = null;
		ListNode rightfirst = null;

		ListNode n = head;
		while (true) {
			if (count == mid - 1)
				leftlast = n;
			if (num % 2 == 0 && count == mid) {
				rightfirst = n;
				break;
			}
			if (num % 2 == 1 && count == mid + 1) {
				rightfirst = n;
				break;
			}
			n = n.next;
			count++;
		}
		leftlast.next = null;//System.out.println("the rightfirst is " + rightfirst.val);
		ListNode right = reverse(rightfirst);
		
		
		for (int i = 0; i < mid; i++) {
		//	System.out.println("the left is " + head.val);
		//	System.out.println("the right is " + right.val);
			if (head.val != right.val)
				return false;
			else {
				head = head.next;	
				right = right.next;
			}
		}

		return true;
	}

	private static ListNode reverse(ListNode head) {
		ListNode tail = head;
		while (tail.next != null) {
			tail = tail.next;
		} // find the tail

		while (head != tail) {
			ListNode tnext = tail.next;
			tail.next = head;
			ListNode temp = head.next;
			head.next = tnext;
			head = temp;
		}

		return tail;
	}
	public static void main(String[]args)
	{
		ListNode n1 = new ListNode (1);
		ListNode n2 = new ListNode (4);
		ListNode n3 = new ListNode (-1);
		ListNode n4 = new ListNode (-1);
		ListNode n5 = new ListNode (4);
		ListNode n6 = new ListNode (1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		isPalindrome(n1);
	}
}
