package problem237;

import ListNode.ListNode;

//rite a function to delete a node (except the tail) in a singly linked list, given only access to that node.
//
//SupposeWd the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
public class Solution {
    public static void deleteNode(ListNode node) {
    
    		while(node.next!=null)
    		{
    			node.val = node.next.val;
    			if (node.next.next == null)
    			{	node.next = null; break;}
    			node = node.next;
    			
    			
    		}
    		
        
    }
    public static void main(String[]args)
    {
    	ListNode n0 = new ListNode(0);
    	ListNode n1 = new ListNode(1); n0.next = n1;
    	deleteNode(n0);
    	while(n0!=null)
    	{		System.out.println(n0.val);n0 = n0.next;}
    }
}
