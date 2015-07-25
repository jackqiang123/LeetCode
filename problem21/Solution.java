package problem21;

//Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode mylist;
		if (l1.val <= l2.val) {
			mylist = l1;
			l1 = l1.next;

		} else {
			mylist = l2;
			l2 = l2.next;
		}
		ListNode result = mylist;

		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				mylist.next = l1;
				l1 = l1.next;

			} else {
				mylist.next = l2;
				l2 = l2.next;
			}
			mylist = mylist.next;
		}

		if (l1 == null)
			mylist.next = l2;
		else if (l2 == null)
			mylist.next = l1;

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}