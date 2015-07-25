package problem205;

import java.util.HashMap;

//Given two strings s and t, determine if they are isomorphic.
//
//Two strings are isomorphic if the characters in s can be replaced to get t.
//
//All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
//
//For example,
//Given "egg", "add", return true.
//
//Given "foo", "bar", return false.
//
//Given "paper", "title", return true.
//
//Note:
//You may assume both s and t have the same length.
public class Solution {
	public boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> mymap = new HashMap<Character, Character>(); // change
																					// the
																					// char
																					// in
																					// s
																					// to
																					// match
																					// t
		if (s.length() == 0 || s.equals(t))
			return true;
		for (int i = 0; i < s.length(); i++) {
			char cs = s.charAt(i);
			char ct = t.charAt(i);

			if (mymap.containsKey(cs)) {
				if (mymap.get(cs) != ct)
					return false;
			} else {
				if (mymap.containsValue(ct))
					return false;
				else
					mymap.put(cs, ct);

			}

		}
		return true;

	}
}
