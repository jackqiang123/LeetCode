package problem164;

import java.util.Arrays;

//given an unsorted array, find the max gap between successive elements
public class Solution {
	public static int maximumGap(int[]nums)
	{
		int len = nums.length;
		if (len < 2) return 0;
		int max = nums[0];
		int min = nums[0];
		for (int i : nums)
		{
			max = Math.max(max, i);
			min = Math.min(min, i);
		}
		int gap = Math.max(1,(max-min)/len); // this is a lower bound of the gap.
		int k = (max-min)/gap + 1;
		int intervalmin [] = new int[k];
		int intervalmax [] = new int[k];
		Arrays.fill(intervalmin, Integer.MAX_VALUE);
		Arrays.fill(intervalmax, Integer.MIN_VALUE);
		for (int p : nums)
		{
			int index = (p - min)/gap;
		//	System.out.println(p + " is putted in the idnex " + index);
			intervalmin[index] = Math.min(intervalmin[index], p);
			intervalmax[index] = Math.max(intervalmax[index], p);		
		}
		int current = gap;
		int left = 0; int right = 1;
		//System.out.println(k);						
		while(right < k)
		{	
			if (intervalmin[right] == Integer.MAX_VALUE)
			{	right++;continue;}
			current = Math.max(intervalmin[right]-intervalmax[left],current);
			left = right;
			right = right+1;
		}
		
		return current;

		
	}
	public static void main(String[]args)
	{
		//int []p = {15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740};
		int [] p = {1,4,6};
		Arrays.sort(p);
//		for (int i = 0; i<p.length-1;i++)
//		{System.out.println(p[i+1]-p[i]);}
		System.out.println(maximumGap(p));
		
		
	}

}
