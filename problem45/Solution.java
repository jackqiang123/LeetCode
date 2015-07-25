package problem45;

//iven an array of non-negative integers, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Your goal is to reach the last index in the minimum number of jumps.
//
//For example:
//Given array A = [2,3,1,1,4]
//
//The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
public class Solution {
	public static int jump(int[] nums) {

		int length = nums.length;
		if (length == 1) return 0;
		int lastmax = nums[0];
		
		int currentmax = 0;
		int step = 1;
		if (lastmax >= length-1) return step;
		for (int i = 1; i < length; i++) {
			currentmax = Math.max(currentmax, i + nums[i]);
			if (lastmax == i) {
				step++;
				lastmax = currentmax;
			}
			if (lastmax >= length-1) return step;
			if (lastmax < i) return -1;

		}
		return step;
	}
	public static void main(String[]args)
	{
		int [] a = {1,2};
		System.out.println(jump(a));
	}
}
