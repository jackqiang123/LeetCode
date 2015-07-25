package problem160;

import java.util.HashMap;
//Write a program to find the node at which the intersection of two singly linked lists begins.
//
//
//For example, the following two linked lists:
//
//A:          a1 → a2
//                   ↘
//                     c1 → c2 → c3
//                   ↗            
//B:     b1 → b2 → b3
//begin to intersect at node c1.



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 class ListNode {
	      int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	 }

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if (headA == null || headB == null) return null;
    	
    	HashMap<ListNode,Boolean> mymap= new HashMap<>();
    	
    	mymap.put(headA, true);
    	while(headA.next!=null)
    	{
    		headA = headA.next;
    		mymap.put(headA, true);		
    	}
    	if (mymap.containsKey(headB)) return headB;
    	while (headB.next!=null)
    	{
    		headB = headB.next;
    		if (mymap.containsKey(headB)) return headB;
    	}
        return null;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}


