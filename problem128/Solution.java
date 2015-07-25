package problem128;

import java.util.HashMap;

//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//For example,
//Given [100, 4, 200, 1, 3, 2],
//The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
//Your algorithm should run in O(n) complexity.
public class Solution {
	public static int longestConsecutive(int[] nums) {
		HashMap<Integer, Integer> mymap = new HashMap<Integer, Integer>();
		if (nums.length == 0)
			return 0;
		// int currentmax = 1;
		int start, end;
		int result = 0;
		for (int i : nums) {
			if (!mymap.containsKey(i)) {
				if (mymap.containsKey(i - 1))
					start = i - mymap.get(i - 1);
				else
					start = i;
				if (mymap.containsKey(i + 1))
					end = i + mymap.get(i + 1);
				else
					end = i;
				int leng = end - start + 1;
				result = Math.max(leng, result);
				mymap.put(i,leng);
				mymap.put(start, leng);
				mymap.put(end, leng);

			}

		}
		return result;

	}

	public static void main(String[] arggs) {
		int a[] = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
		System.out.println(longestConsecutive(a));
	}

}
