package problem24;

import ListNode.ListNode;

public class Solution {
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode myhead = head.next;

		ListNode p1 = head;
		// ListNode p2 = head.next;
		ListNode p2;
		ListNode p3 = null;

		while (p1 != null && p1.next != null) {
		
			p2 = p1.next;
			p3 = p2.next;
	
			p2.next = p1;
			if (p3!=null && p3.next!=null)
			p1.next = p3.next;
			else 
				p1.next = p3;	
			
			p1 = p3;
		//	System.out.println("p1 = "+p1.val+"  p2 = "+p2.val);
			// ListNode test = myhead;
			// while(test!=null)
			// {System.out.println(test.val); test= test.next;}
			// System.out.println();
		}

		return myhead;
	}
	public static void main(String[]args)
	{
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		swapPairs(n1);
	}
}
