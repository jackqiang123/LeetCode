package problem55;

//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Determine if you are able to reach the last index.
//
//For example:
//A = [2,3,1,1,4], return true.
//
//A = [3,2,1,0,4], return false.
public class Solution {
	public static boolean canJump(int[] nums) {
		int length = nums.length;
		// boolean reachable [] = new boolean[length];
		if (length <= 1)
			return true;
		int maxreachindex = 0;
		for (int i = 0; i < length; i++) {

			if (i > maxreachindex)
				return false;
			maxreachindex = Math.max(i + nums[i], maxreachindex);
			// if (maxreachindex >= length - 1)
			// return true;

		}
		return true;
	}

	public static void main(String[] args) {
		int a[] = { 3, 2, 1, 0, 4 };
		System.out.println(canJump(a));
	}
}
