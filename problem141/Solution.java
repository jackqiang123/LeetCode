/**
 * 
 */
package problem141;

import ListNode.ListNode;

/**
 * @author lianlu
 *
 */

public class Solution {

	/**
	 * @param args
	 */

	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode p1 = head;

		ListNode p2 = head;

		boolean p2go = false;
		// boolean isLoop = false;
		while (true) {
			if (p1 == null || p2 == null)
				return false;

			p1 = p1.next;

			if (p2go == true) {
				p2 = p2.next;
				p2go = false;
			} else {
				p2go = true;
			}

			if (p1 == p2)
				return true;

		}
		// return isLoop;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
