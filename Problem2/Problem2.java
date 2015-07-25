package Problem2;

/**
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Problem2 {
	
	public static void main(String []args){}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// initial
		int fill = 0;

		ListNode answer = new ListNode(0);
		if (l1.val + l2.val > 9) {
			fill = 1;
			answer = new ListNode(l1.val + l2.val - 10);
		} else {
			fill = 0;
			answer = new ListNode(l1.val + l2.val);
		}

		ListNode head = answer;

		while (l1.next != null || l2.next != null || fill == 1) {

			if (l1.next != null && l2.next != null) {
				l1 = l1.next;
				l2 = l2.next;
				if (l1.val + l2.val + fill < 10) {
					answer.next = new ListNode(l1.val + l2.val + fill);
					fill = 0;
				} else {
					answer.next = new ListNode(l1.val + l2.val + fill - 10);
					fill = 1;
				}
				answer = answer.next;
			}

			else if (l1.next != null) // then l2.next must be null, otherwise it
										// will be done in the first condition
			{
				l1 = l1.next;
				if (l1.val + fill < 10) {
					answer.next = new ListNode(l1.val + fill);
					fill = 0;
				} else {
					answer.next = new ListNode(l1.val + fill - 10);
					fill = 1;
				}
				answer = answer.next;

			}

			else if (l2.next != null)

			{
				l2 = l2.next;
				if (l2.val + fill < 10) {
					answer.next = new ListNode(l2.val + fill);
					fill = 0;
				} else {
					answer.next = new ListNode(l2.val + fill - 10);
					fill = 1;
				}
				answer = answer.next;
			} 
			else // must be the later case.
			{
				answer.next = new ListNode(1);
				break;
			}

		}

		return head;
	}
}
