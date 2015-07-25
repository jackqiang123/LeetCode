package problem76;

import java.util.HashMap;

//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
//For example,
//S = "ADOBECODEBANC"
//T = "ABC"
//Minimum window is "BANC".
//
//Note:
//If there is no such window in S that covers all characters in T, return the emtpy string "".
//
//If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
public class Solution {
	public static String minWindow(String s, String t) {
		if (s.length() < t.length()) return "";
		
		HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			if (dict.containsKey(t.charAt(i)))
				dict.put(t.charAt(i), dict.get(t.charAt(i)) + 1);
			else
				dict.put(t.charAt(i), 1);
		}

		int currentwin = Integer.MAX_VALUE;
		int currleft = -1;

		int left = 0;
		int right = left;

		HashMap<Character, Integer> have = new HashMap<Character, Integer>();

		int length = s.length();

		while (right <= length && left <= right) {
			// System.out.println("the current left and right is " + left + ","
			// + right);

			if (!matches(dict, have)) {

				if (right < length && dict.containsKey(s.charAt(right)))
					have.put(
							s.charAt(right),
							have.containsKey(s.charAt(right)) ? have.get(s
									.charAt(right)) + 1 : 1);
				right++;
				continue;
			} else {
				// System.out.println("get a match");
				while ((!dict.containsKey(s.charAt(left)) || have.get(s
						.charAt(left)) > dict.get(s.charAt(left)))
						&& left <= right) {
					if (!dict.containsKey(s.charAt(left)))
						left++;
					else {
						// System.out.println("now updating " + s.charAt(left) +
						// "  " + (have.get(s.charAt(left))-1));
						have.put(s.charAt(left), have.get(s.charAt(left)) - 1);
						left++;
					}

				} // the current left must be on the marginal

				if (currentwin > right - left) {
					currentwin = right - left;
					currleft = left;
					// System.out.println("update the win");
				}
				if (dict.containsKey(s.charAt(left))) {
					have.put(s.charAt(left),
							Math.max(have.get(s.charAt(left)) - 1, 0));
					left++;
				}
				// while (!dict.containsKey(s.charAt(left)) ||
				// have.get(s.charAt(left)) > dict.get(s.charAt(left)))
				// {
				//
				// //System.out.println("left is moving to " + (left+1));
				// if (!dict.containsKey(s.charAt(left))) left
				//
				//
				// left++;
				// }
				// have.put(s.charAt(left), Math.max(have.get(s.charAt(left)) -
				// 1, 0));
				// left++;
			}

		}

	//	System.out.println(currentwin + " with left at " + currleft );
		if (currleft != -1)
			return s.substring(currleft, currleft + currentwin);
		else
			return "";
	}

	private static boolean matches(HashMap<Character, Integer> dict,
			HashMap<Character, Integer> have) {
		for (char c : dict.keySet()) {
			if (have.containsKey(c) == false)
				return false;
			// System.out.println(c+ "   "+ dict.get(c) + "   " + have.get(c));
			if (dict.get(c) > have.get(c))
				return false;

		}

		return true;
	}

	public static void main(String[] args) {

		String S = "a";
		String T = "b";
		System.out.println(minWindow(S, T));

	}

}
