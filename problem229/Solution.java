package problem229;

import java.util.LinkedList;
import java.util.List;

//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
public class Solution {
	public static List<Integer> majorityElement(int[] nums) {
		int len = nums.length;
		int cand1 = 0, cand2 = 0, c1 = 0, c2 = 0;
		List<Integer> res = new LinkedList<Integer>();
		if (len == 0)
			return res;
		for (int x : nums)
		{
			if (x == cand1)
				c1++;
			else if (x == cand2)
				c2++;
			else if (c1 == 0)
			{
				cand1 = x;
				c1 = 1;
			}
			else if (c2 == 0)
			{
				cand2 = x;
				c2 = 1;
			}
			else {
				c1--;c2--;
			}
		}
		
		c1 = 0; c2 = 0;
		for (int i : nums)
		{
			if (i == cand1)
				c1++;
			else if (i == cand2)
				c2++;
		}
		if (c1>len/3) res.add(cand1);
		if (c2>len/3) res.add(cand2);
		return res;
	}
	public static void main(String[]args)
	{
		int p[]={1,3,3,4,4};
		List<Integer> r = majorityElement(p);
		for (int i : r)
			System.out.println(i);
		
	}
}
