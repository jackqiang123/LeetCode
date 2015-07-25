package problem126;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
//
//Only one letter can be changed at a time
//Each intermediate word must exist in the dictionary
//For example,
//
//Given:
//start = "hit"
//end = "cog"
//dict = ["hot","dot","dog","lot","log"]
//Return
//  [
//    ["hit","hot","dot","dog","cog"],
//    ["hit","hot","lot","log","cog"]
//  ]
//Note:
//All words have the same length.
//All words contain only lowercase alphabetic characters.
//Show Tags
//Hide Similar Problems
public class Solution {
	public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
		dict.add(end);
		List<List<String>> res = new LinkedList<List<String>>();
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);
		int min = Integer.MAX_VALUE;
		HashMap<String, List<String>> pathmap = new HashMap<String, List<String>>();
		HashMap<String, Integer> stepmap = new HashMap<String, Integer>();
		for (String s : dict)
			stepmap.put(s, Integer.MAX_VALUE);// inilized all node as infinite
												// long
		stepmap.put(start, 0);
		while (queue.isEmpty() == false) {
			String word = queue.poll();
			int step = stepmap.get(word) + 1; // the step to all neigh of word
			if (step > min)
				break; // the current word is over the min length; directly
						// finish
			List<String> neigh = findneigh(word, dict);
			for (String newword : neigh) // for each neigh of word
			{
				int newworddis = stepmap.get(newword);
				if (step > newworddis)
					continue;
				else if (step < newworddis) {
					queue.add(newword);
					stepmap.put(newword, step);
				}

				if (pathmap.get(newword) == null) {
					List<String> ls = new LinkedList<String>();
					ls.add(word);
					pathmap.put(newword, ls);
				} else {
					pathmap.get(newword).add(word);
				}

				if (end.equals(newword))
					min = step;
			}

		}

		List<String> cur = new LinkedList<String>();
		backtrace(res, cur, pathmap, start, end);

		return res;
	}

	private static void backtrace(List<List<String>> res, List<String> cur, HashMap<String, List<String>> pathmap,
			String start, String end) {

		if (start.equals(end)) {
			cur.add(0, end);
			res.add(new LinkedList<String>(cur));
			cur.remove(0);
			return;
		}

		cur.add(0, end);
		if (pathmap.get(end) != null) {
			List<String> ls = pathmap.get(end);
			for (String s : ls) {

				backtrace(res, cur, pathmap, start, s);

			}
		}
		cur.remove(0);

	}

	private static List<String> findneigh(String word, Set<String> dict) // find the
																	// neigh of
																	// dict in
																	// dict
	{
		List<String> nei = new LinkedList<String>();
		int len = word.length();
		for (int i = 0; i < len; i++) {
			StringBuilder s = new StringBuilder(word);
			for (char cc = 'a'; cc <= 'z'; cc++) {
				s.setCharAt(i, cc);
				String ss = s.toString();
				if (dict.contains(ss))
					nei.add(ss);
			}
		}
		return nei;

	}

	public static void main(String[]args)
	{
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		List<List<String>> r = findLadders("hit","cog",dict);
		for (List<String> s : r)
		{
			for (String w : s)
			{
				System.out.print(w);
			}
			System.out.println();
		}
	}
}
