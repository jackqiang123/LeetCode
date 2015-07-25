package problem147;

import ListNode.ListNode;

//Sort a linked list using insertion sort.
public class Solution {
	public static ListNode insertionSortList(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode sudohead = new ListNode(0);
		sudohead.next = head;
		ListNode insertnode = sudohead;
		ListNode leftend = head;
		ListNode selection = head.next; // current selection node

		ListNode nextselection = selection.next;
		// System.out.println("selection == "+ selection.val);
		// System.out.println("nextselection == "+ nextselection.val);
		boolean inserted = false;

		while (selection != null) {

			insertnode = sudohead;

			// System.out.println("selection == "+ selection.val);
			// System.out.println("leftend == "+ leftend.val);
			// System.out.println("nextselection == "+ nextselection.val);

			while (insertnode != leftend) {
				if (insertnode.next != null
						&& insertnode.next.val > selection.val) {
					inserted = true;
					selection.next = insertnode.next;
					insertnode.next = selection;
					break;

				} else {
					insertnode = insertnode.next;
				}
			}
			// System.out.println("inserted == "+ inserted);

			if (inserted == true) {
				leftend.next = nextselection;
				inserted = false;

			} else {
				leftend = selection;

			}

			// finish a period of insert selection node

			selection = nextselection;

			if (selection != null)
				nextselection = selection.next;

			// System.out.println();
		}

		return sudohead.next;
	}

	public static void main(String[] args) {
		ListNode p1 = new ListNode(6);
		ListNode p2 = new ListNode(3);
		ListNode p3 = new ListNode(10);
		ListNode p4 = new ListNode(4);
		ListNode p5 = new ListNode(1);
		// p1.next = p2;
		// p2.next = p3;
		// p3.next = p4;
		// p4.next = p5;
		ListNode result = insertionSortList(p1);
		while (result != null) {
			System.out.print(result.val + ",");
			result = result.next;
		}
	}
}
