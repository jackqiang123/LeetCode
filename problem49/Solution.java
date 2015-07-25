package problem49;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//Given an array of strings, return all groups of strings that are anagrams.
//
//Note: All inputs will be in lower-case.
public class Solution {
	public static List<String> anagrams(String[] strs) {
		HashMap<String, Integer> mymap = new HashMap<String, Integer>(); // from
																			// a
																			// ordered
																			// string
																			// to
																			// the
																			// originial
																			// string

		List<String> result = new LinkedList<String>();
		if (strs.length == 0)
			return result;
		for (int i = 0; i < strs.length; i++) {
			char[] arr = strs[i].toCharArray();
			Arrays.sort(arr);

			String k = new String(arr);
			if (!mymap.containsKey(k)) {
				// System.out.println(" put key " + k );
				mymap.put(k, 1);
			} else {
				int value = mymap.get(k);
				mymap.put(k, value + 1);
				// System.out.println("key " + k + " value is increases to " +
				// (value+1));
			}
		}

		for (int i = 0; i < strs.length; i++) {
			char[] arr = strs[i].toCharArray();
			Arrays.sort(arr);
			String k = new String(arr);
			if (mymap.containsKey(k) && mymap.get(k) > 1)
				result.add(strs[i]);
		}

		return result;

	}

	public static void main(String[] args) {
		String[] a = { "", "" };
		anagrams(a);

	}
}
