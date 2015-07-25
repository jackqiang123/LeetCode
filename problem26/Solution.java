package problem26;
//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
//
//Do not allocate extra space for another array, you must do this in place with constant memory.
//
//For example,
//Given input array nums = [1,1,2],
//
//Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
public class Solution {
	public static int removeDuplicates(int[] nums) {
		
		int length = nums.length;
		if (length == 0) return 0;
		int p1 = 1;
		int p2 = 1;
		int lastvalue = nums[0];
		while(p2<length)
		{
			if (lastvalue == nums[p2])
				p2++;
			else{
			
		     nums[p1] = nums[p2];
		     lastvalue = nums[p2];
		     p2++;p1++;
				
			}
			
			
			
		}
		return p1;
		
	}
	
	public static void main(String[]args)
	{
		
		int p[]= {1,1,2,2,2,5,6};
		int r = removeDuplicates(p);
		for (int i =0; i<r;i++)
		{
			System.out.print(p[i]+",");
			
			
		}
	}
        
}
