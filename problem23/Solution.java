package problem23;

import ListNode.ListNode;

//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
public class Solution {// merge part by part
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) return null;
		if (lists.length == 1) return lists[0];
		ListNode l1 = mergeList(lists, 0, lists.length / 2);
		ListNode l2 = mergeList(lists, lists.length / 2 + 1, lists.length - 1);
		ListNode result = merge(l1, l2);
		return result;
	}

	private ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head;
		ListNode result;
		if (l1.val < l2.val) {
			result = l1;
			head = l1;
			l1 = l1.next;
		} else {
			result = l2;
			head = l2;
			l2 = l2.next;
		}
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				head.next = l1;
				l1 = l1.next;
				head = head.next;
			} else {
				head.next = l2;
				l2 = l2.next;
				head = head.next;

			}

		}
		if (l1 == null)
			head.next = l2;
		else if (l2 == null)
			head.next = l1;

		return result;
	}

	private ListNode mergeList(ListNode[] lists, int start, int end) {
		if (start > end)
			return null;
		if (end == start)
			return lists[start];
		if (end - start == 1)
			return merge(lists[start], lists[end]);
		// else, we will recursively do it.
		int length = end - start + 1;
		ListNode l1 = mergeList(lists, start, start + length / 2);
		ListNode l2 = mergeList(lists, start + length / 2 + 1, end);
		return merge(l1, l2);
	}
}
