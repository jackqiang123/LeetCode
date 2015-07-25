package problem3;

import java.util.HashMap;


//Given a string, find the length of the longest substring without repeating characters. 
//For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
//which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
public class Solution {
	public static int lengthOfLongestSubstring(String s) {
		int l = 0;
		int currentmax = 0;
		int length = s.length();
		HashMap<Character,Integer> mymap = new HashMap<Character,Integer>();
		int i = 0;
		int j = 0;
		while (true) {
			
			if (i>=length || j>=length) return currentmax; 
			
			char c = s.charAt(j);
			
			if (!mymap.containsKey(c))
			{
				mymap.put(c, j);
				l++;
				if (l>currentmax) currentmax = l;
				j++;	
			}
			else{// we find a existing key
				int lastidnex = mymap.get(c);
				
				
				if(lastidnex<i)
				{
					mymap.put(c, j); //always update the key
					l++;
					if (l>currentmax) currentmax = l;
					j++;
				}
				else{
					
					l = j - mymap.get(c);
					i = mymap.get(c)+1;
					mymap.put(c, j); //always update the key
					j++;
					
				}
//				if (mymap.get(c))
//				l = j - mymap.get(c);
//				i = mymap.get(c)+1;
//				
//				mymap.put(c, j); //always update the key
//				//l = 1;
//				j++;
				
			}
			
		}
	}
	
	public static void main(String[]args)
	{
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

}
