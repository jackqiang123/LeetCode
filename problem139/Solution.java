package problem139;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//For example, given
//s = "leetcode",
//dict = ["leet", "code"].
//
//Return true because "leetcode" can be segmented as "leet code".
public class Solution {
	public boolean wordBreak(String s, Set<String> wordDict) {
		int len = s.length();
		boolean[] check = new boolean[len + 1]; // whether the current substring
												// can be made of worddict
		check[0] = true;
		int maxlen = Integer.MAX_VALUE;
		for (String ss : wordDict)
			maxlen = Math.max(maxlen, ss.length());
		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= maxlen && j <= i; j++) {
				if (check[i - j]) {
					if (wordDict.contains(s.substring(i - j, i))) {
						check[i] = true;
						break;
					}
				}

			}

		}

		return check[len];
	}

	// public boolean wordBreak(String s, Set<String> wordDict) {
	// int len = s.length();
	// HashMap<String,Boolean> myset =new HashMap<String,Boolean>();
	// for (String ss : wordDict)
	// myset.put(ss, true);
	// for (int i = 1; i <= len ; i++)
	// {
	// if (wordDict.contains(s.substring(0, i)))
	// {
	//
	// if (myset.containsKey(s.substring(i)))
	// {
	// return myset.get(s.substring(i));
	// }
	//
	// boolean b = wordBreak(s.substring(i),wordDict);
	// myset.put(s.substring(i), b);
	//
	// if (b)
	// return true;
	// }
	//
	// }
	// return false;
	//
	// }
}
