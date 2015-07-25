package problem127;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//Given two words (beginWord and endWord), and a dictionary,
//find the length of shortest transformation sequence from beginWord to endWord, such that:
//
//Only one letter can be changed at a time
//Each intermediate word must exist in the dictionary
//For example,
//
//Given:
//start = "hit"
//end = "cog"
//dict = ["hot","dot","dog","lot","log"]
//As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//return its length 5.
//
//Note:
//Return 0 if there is no such transformation sequence.
//All words have the same length.
//All words contain only lowercase alphabetic characters.
public class Solution {
	public static int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		if (beginWord.length() == 1)
			return 2;
		Queue<String> myqueue = new LinkedList<String>();
		HashSet<String> visit = new HashSet<String>();
		visit.add(beginWord);
		myqueue.add(beginWord);
		myqueue.add("*");
		int step = 1;
		int len = beginWord.length();
		while (!myqueue.isEmpty()) {
			String s = myqueue.poll();
			
			if (!s.equals("*")) 
			{
				if (s.equals(endWord))
					return step;
				
				//System.out.println("checking the neight of " + new String(arr));
				for (int i = 0; i < len; i++) {
					char []arr = s.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						arr[i] = c;
						String p = new String(arr);
						//System.out.println(p);
						if (wordDict.contains(p) && !visit.contains(p)) 
						{//System.out.println("push in queue " + p);
							myqueue.add(p);
							visit.add(p);
						}
					}

				}
			}

			else 
			{

				step++;
			
			if (myqueue.isEmpty() == false)
				myqueue.offer("*");

			}
		}
		return 0;
	}
	public static void main(String[]args)
	{
		Set<String> set = new HashSet();
		set.add("hot");
		set.add("dog");
		set.add("dot");
		System.out.println(ladderLength("hot","dog",set));
	}
}
