package problem198;

//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
public class Solution {
	public static int rob(int[] nums) {
		if (nums.length == 0) return 0;
		int[] bene = new int[nums.length];
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return max(nums[0], nums[1]);
		bene[0] = nums[0];
		bene[1] = nums[1];
		bene[2] = nums[0] + nums[2];
		for (int i = 3; i < nums.length; i++) {
			bene[i] = max(nums[i] + bene[i - 3], nums[i] + bene[i - 2]);

		}
		return max(bene[nums.length - 1], bene[nums.length - 2]);
	}

	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		if (i >= j)
			return i;
		else
			return j;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 1, 2 };
		System.out.print(rob(a));

	}
}
