package problem213;

//After robbing those houses on that street, the thief has found himself a new place for 
//his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. 
//That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.
//
//Given a list of non-negative integers representing the amount of money of each house,
//determine the maximum amount of money you can rob tonight without alerting the police.
public class Solution {
    public static int rob(int[] nums) {
     int length = nums.length;
     if (length == 0) return 0;
     if (length == 1) return nums[0];
     int bene1 = findmaxbene(nums,0,length-2);
  //   System.out.println(bene1);

     int bene2 = findmaxbene(nums,1,length-1);
 //   System.out.println(bene2);

     return Math.max(bene1,bene2);
    }
	private static int findmaxbene(int[] nums, int start, int end) {
		int len = end - start + 1;
		if (len == 1) return nums[start];
		int bene [] = new int[len];
		bene[0] = nums[start];
		bene[1] = Math.max(nums[start+1],bene[0]);
		for (int i = 2; i<len;i++)
		{
			bene[i] = Math.max(bene[i-1],bene[i-2]+nums[i+start]);
		}
//		for (int l :bene)
//			System.out.print(l+",");
//		System.out.println();
		return bene[len-1];
	}
	public static void main(String[] args) {
		int[] a = { 1,3,1,3,100};
		System.out.println(rob(a));

	}

}
