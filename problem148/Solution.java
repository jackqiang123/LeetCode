package problem148;

//Sort a linked list in O(n log n) time using constant space complexity.
import ListNode.ListNode;

public class Solution {
	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode mid = findMid(head);// find the mid, and mark mid->pre.next =
										// null
		ListNode left = sortList(head);
		ListNode right = sortList(mid);
		return merge(left, right);

	}

	private static ListNode merge(ListNode left, ListNode right) {
		if (left == null)
			return right;
		if (right == null)
			return left;
		ListNode head = null;
		if (left.val < right.val) {
			head = left;
			left = left.next;
		} else {
			head = right;
			right = right.next;
		}
		ListNode mergehead = head;
		while (left != null && right != null) {
			if (left.val < right.val) {
				head.next = left;
				left = left.next;
				head = head.next;
			} else {
				head.next = right;
				right = right.next;
				head = head.next;

			}
		}
		if (left == null)
			head.next = right;
		else if (right == null)
			head.next = left;

		return mergehead;
	}

	private static ListNode findMid(ListNode head) {
		if (head == null || head.next == null)
			return head;
		if (head.next.next == null) {
			ListNode temp = head.next;
			head.next = null;
			return temp;
		}

		ListNode p1 = head;
		ListNode p2 = head;
		//ListNode pre = head;

		while (p2.next != null && p2.next.next != null) {
			p1 = p1.next;
			//pre = p2.next;
			p2 = p2.next.next;

		}
		ListNode mid = p1.next;
		p1.next = null;
		return mid;
	}
	
	
	public static void main(String[]args)
	{
		
		ListNode p1 = new ListNode(4);
		ListNode p2 = new ListNode(3);
		ListNode p3 = new ListNode(1);
		ListNode p4 = new ListNode(5);
		ListNode p5 = new ListNode(2);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		
		ListNode result =sortList(p1);
		while(result!=null)
		{System.out.print(result.val+ ","); result = result.next;}
		
//		ListNode m = findMid(p1);
//		
//		while(p1!=null)
//		{System.out.print(p1.val+ ","); p1 = p1.next;}
//		System.out.println();
//		while(m!=null)
//		{System.out.print(m.val+ ","); m = m.next;}
		
		
		
	}
	
}
