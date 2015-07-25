package problem16;

import java.util.Arrays;

//Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//For example, given array S = {-1 2 1 -4}, and target = 1.
//
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
public class Solution {
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		if (nums.length < 3)
			return -1;
		int currentbest = nums[0] + nums[1] + nums[2];
		
		int j, k;
		for (int i = 0; i < nums.length - 2; i++) {
			j = i + 1;
			k = nums.length - 1;
			while (j < k) {
				if (nums[i] + nums[j] + nums[k] == target)
					{ return target;}
				else if (nums[i] + nums[j] + nums[k] < target) {
					int temp = nums[i] + nums[j] + nums[k];
					
					if (Math.abs(temp - target) < Math
							.abs(currentbest - target))
						currentbest = temp;
					j++;
				} else {
					int temp = nums[i] + nums[j] + nums[k];
					
					if (Math.abs(temp - target) < Math
							.abs(currentbest - target))
						currentbest = temp;
					k--;

				}

			}

		}
		
		return currentbest;
	}

	public static void main(String[] args) {
		int[] a = {-1,2,1,-4};
		System.out.println(threeSumClosest(a, 1));

	}
}
