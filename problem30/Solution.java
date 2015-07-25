package problem30;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//You are given a string, s, and a list of words, words, that are all of the same length. 
//Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
//
//For example, given:
//s: "barfoothefoobarman"
//words: ["foo", "bar"]
//
//You should return the indices: [0,9].
//(order does not matter).
public class Solution {
	
	
	
	public static List<Integer> findSubstring(String S, String[] L) {
	    final HashMap<String, Integer> need = new HashMap<String, Integer>();
	    for (int i = 0; i < L.length; i++) {
	        need.put(L[i], need.get(L[i]) == null ? 1 : need.get(L[i]) + 1);
	    }
	    LinkedList<Integer> result = new LinkedList<Integer>();
	    for (int i = 0; i < L[0].length(); i++) {
	        populateResult(result, S, L, i, need);
	    }
	    return result;
	}
	private static void populateResult(List<Integer> result, String S, String[] L, 
	                            int start, final HashMap<String, Integer> need) {
	    int k = L[0].length();
	    HashMap<String, Integer> has = new HashMap<String, Integer>();
	    for (int end = start; end <= S.length() - k; end += k) {
	        String sub = S.substring(end, end + k);
	        if (need.containsKey(sub)) {
	            while (has.get(sub) == need.get(sub)) {
	                String tmp = S.substring(start, start + k);
	                has.put(tmp, has.get(tmp) - 1);
	                start += k;
	            }
	            has.put(sub, has.get(sub) == null ? 1 : has.get(sub) + 1);
	            if (end - start + k == L.length * L[0].length())
	                result.add(start);
	        } else {
	            has.clear();
	            start = end + k;
	        }
	    }
	}
/*	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new LinkedList<Integer>();
		if (words.length == 0)
			return result;
		HashSet<String> dict = new HashSet<String>();

		for (String ss : words)
			dict.add(ss);

		HashMap<String, Integer> mymap = new HashMap<String, Integer>();
		int unitlength = words[0].length();// the unit word length
		int left = 0;
		int right = 0;
		for (int i = 0; i < s.length() - unitlength; i++) {
			 System.out.println("current i is " + i + "  current left and right is " + left + "   " +
			 right);
			String cur = s.substring(i, i + unitlength);

			if (!dict.contains(cur)) {
				left = i + 1;
				right = i + 1;
				continue;
			}

			if (!mymap.containsKey(cur)) {
				mymap.put(cur, i);
				right = i + unitlength;
				i = right - 1;
				if (right - left == words.length * unitlength) {
					result.add(left);
					System.out.println("add result" + left) ;
					left = left + unitlength;;
				}
			} else {
				int index = mymap.get(cur);
				System.out.println("find a duplicate " + index);
				if (index < left) {
					mymap.put(cur, i);
					right = i + unitlength;
					i = right - 1;
					if (right - left == words.length * unitlength) {
						result.add(left); System.out.println("add result" +
											 left) ;
						left = left + unitlength;
					}
				} else {
					left = index + unitlength;
					mymap.put(cur, i);
					right = i + unitlength;
					i = right - 1;
					if (right - left == words.length * unitlength) {
						result.add(left); System.out.println("add result" +
											 left) ;
						left = left + unitlength;
					}
				}

			}

		}
		return result;
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] test = { "word","good","best","good"};
		List<Integer> r = findSubstring("wordgoodgoodgoodbestword", test);
		for (Integer k : r)
			System.out.println(k);
	}

}
