package problem152;
//find the contiguous subarray which has the max product
public class Solution {
	public static int maxProduct(int[]nums)
	{
		int len = nums.length;
		if (len == 0) return 0;
		int max [] = new int [len]; // if the currentone is the endding point
		int min [] = new int [len];
		max[0] = nums[0];
		min[0] = nums[0];
		int currentmax = max[0];
		for (int i = 1; i < len; i++)
		{
			max[i] = Math.max(nums[i],Math.max(nums[i]*max[i-1],nums[i]*min[i-1]));
			currentmax = Math.max(currentmax, max[i]);
			min[i] = Math.min(nums[i],Math.min(nums[i]*min[i-1],nums[i]*max[i-1]));	
		}
		return currentmax;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []p = {-1,2,-1,2};
		System.out.println(maxProduct(p));
	}

}
