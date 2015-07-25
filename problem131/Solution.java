package problem131;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//Return all possible palindrome partitioning of s.
//
//For example, given s = "aab",
//Return
//
//  [
//    ["aa","b"],
//    ["a","a","b"]
//  ]
public class Solution {
	public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> cur = new ArrayList<String>();
		backtracking(result, cur, s, 0);
		return result;
	}

	private static void backtracking(List<List<String>> result,
			List<String> cur, String s, int start) {

		if (start >= s.length()) { // finished checking all seq, and all
									// elements in cur are palindrome
			List<String> mycur = new ArrayList<String>(cur);
			
			//System.out.println("we add a result");
			result.add(mycur);
			//return;
		}
		else{String mystring;
		
			for (int j = start; j < s.length(); j++) {
				
				mystring = s.substring(start, j+1);
				//int length = mystring.length();
				//System.out.println("now we are testing the Stri:" + mystring + "  and i = " + i + " and j = "+j);
				if (judge(mystring) == true) 
				{ // add mystring into to cur if the current one is ok. else do nothing, but go on backtracking
					cur.add(mystring);
				//	System.out.println("going into backtracking, we are adding " + mystring);
					backtracking(result, cur, s, j+1);
				//	System.out.println("out of backtracking, we are moving " + cur.get(cur.size()-1) + " and the current i j is "+ i + "," + j);
					cur.remove(cur.size() - 1);
				}
				

			}

		}

	}

	private static boolean judge(String mystring) {
		int p1 = 0;
		int p2 = mystring.length() - 1;
		while (p2 > p1) {
			if (mystring.charAt(p1) != mystring.charAt(p2))
				return false;
			p1++;
			p2--;

		}
		return true;
	}

	public static void main(String[] args) {
		String s = "aba";
		List<List<String>> result = partition(s);
		Iterator<List<String>> it = result.iterator();
		while (it.hasNext()) {
			Iterator<String> myit = it.next().iterator();
			while (myit.hasNext()) {
				System.out.print(myit.next() + ",");
			}
			System.out.println("next solution is");
		}

	}

}
