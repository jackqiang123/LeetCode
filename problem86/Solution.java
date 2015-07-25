package problem86;

//import java.util.LinkedList;
//import java.util.Queue;

import ListNode.ListNode;

//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//You should preserve the original relative order of the nodes in each of the two partitions.
//
//For example,
//Given 1->4->3->2->5->2 and x = 3,
//return 1->2->2->4->3->5.
public class Solution {
	public ListNode partition(ListNode head, int x) {
		if (head == null)
			return head;
		ListNode left = new ListNode(0);
		ListNode right = new ListNode(0);
		ListNode curleft = left;
		ListNode curright = right;
		while(head!=null)
		{
			if (head.val<x)
			{
				curleft.next = head;
				curleft = curleft.next;
			}
			else{
				curright.next = head;
				curright = curright.next;
				
			}
	
			
			head = head.next; 
			
		}
		curleft.next = right.next;
		curright.next = null;
		return left.next;
		
		
		
//		Queue<ListNode> left = new LinkedList<ListNode>();// this leads to over memeory
//		Queue<ListNode> right = new LinkedList<ListNode>();
//		ListNode current = head;
//		while (current != null) {
//			if (current.val < x)
//				left.offer(current);
//			else
//				right.offer(current);
//			current = current.next;
//		}
//		left.addAll(right);
//		ListNode result = left.poll();
//		ListNode currentnode = result;
//		while (left.isEmpty() == false) {
//			currentnode.next = left.poll();
//			currentnode = currentnode.next;
//		}
//		
//
//		return result;
	}
	}
