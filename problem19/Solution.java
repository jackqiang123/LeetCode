package problem19;

import ListNode.ListNode;

//Given a linked list, remove the nth node from the end of list and return its head.
//
//For example,
//
//   Given linked list: 1->2->3->4->5, and n = 2.
//
//   After removing the second node from the end, the linked list becomes 1->2->3->5.
//Note:
//Given n will always be valid.
//Try to do this in one pass.
public class Solution {
	 public static ListNode removeNthFromEnd(ListNode head, int n) {
	     ListNode p1 = head;
	     ListNode p1previous = head;
	     ListNode p2 = head;
	     int i = n;
	     while (i>1)
	     {
	    	 i--;
	    	 p2 = p2.next;
	    	
	     }
	    
	     if (p2.next == null) 
	    	 {
	    	// System.out.println("l");
	    	 return p1.next;}
	
		 while(p2.next!=null)
		 {
			 p1previous = p1;
			 p1 = p1.next;
			 p2 = p2.next;
		 }
		
		 System.out.println("last p1 is "+p1.val);
		 System.out.println("last p1previous is "+p1previous.val);
		 
		 p1previous.next = p1.next;
		 
		 return head;
	    }
	 
	 public static void main(String []args)
	 {
		 ListNode n1 = new ListNode(1);
		 ListNode n2 = new ListNode(2);
		
		 n1.next = n2;
	
		
		 
		 ListNode p = removeNthFromEnd(n1,2);
		 while(p != null)
		 {
			 System.out.print(p.val+",");
			 p = p.next;
		 }
		 
	 }
	 
	 
}
