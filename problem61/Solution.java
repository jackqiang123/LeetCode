package problem61;

import ListNode.ListNode;

//Given a list, rotate the list to the right by k places, where k is non-negative.
//
//For example:
//Given 1->2->3->4->5->NULL and k = 2,
//return 4->5->1->2->3->NULL.
public class Solution {
	public static ListNode rotateRight(ListNode head, int k) {
		int count = 0;
		ListNode countp = head;
		if (head == null || k == 0) return head; 
		
		
		while(countp != null)
		{countp = countp.next;count++;}
	//	System.out.println(count);
		k = k %count;
		
		
	
		ListNode r1 = head;
		ListNode r2 = head;
		count = k;

		while (count > 0) {
			count--;
			if (r2.next != null)
				r2 = r2.next;
			else {
				System.out.println("k is too large");
				return r2;
			}
		}// let r2 first run k steps;

		while (r2.next != null) {
			r1 = r1.next;
			r2 = r2.next;
		}// now r1 is the right place to rotate
		r2.next = head;
		ListNode result = r1.next;
		r1.next = null;

		return result;

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
		//p4.next = p5;
		ListNode result = rotateRight(p1,5);
		while(result!=null)
		{System.out.print(result.val+ ","); result = result.next;}
	}

}
