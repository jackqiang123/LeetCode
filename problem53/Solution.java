package problem53;
//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//
//For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
//the contiguous subarray [4,−1,2,1] has the largest sum = 6.



 class Solution {
	 public static int maxSubArray(int[] nums) {
		 int length = nums.length;
		 if (length<=0) return 0;
		 if (length == 1) return nums[0];
		
		 int[] distance2s = new int[length]; // equals the intial value of nums
		 for (int i = 0; i < length;i++)
		  distance2s[i] = nums[i];
		 int currentmax = nums[0];
		for (int i = 1 ; i< length;i++)
		{
			distance2s[i] = max(distance2s[i],distance2s[i-1] + nums[i]);
			if (distance2s[i]>currentmax) currentmax = distance2s[i];
		//	System.out.println(distance2s[i]);
		}
	        return currentmax;
	    }

	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		if (i>=j) return i;
		else return j;
		
	}
	public static void main(String[]args)
	{
		int []a={-2,-4};
		System.out.println(maxSubArray(a));
	}

}
