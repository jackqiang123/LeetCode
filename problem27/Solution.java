package problem27;

public class Solution {

	public static int removeElement(int[] nums, int val) {
		int start = 0;
		int end = nums.length - 1;
	    int newlength = nums.length;
		while (start < end) 
		{
			while (nums[start] != val && start <= end)
			{
				start++;
				if (start>nums.length-1) break;
			}
			// System.out.println("start" + start);
			
			while (nums[end] == val) {
				newlength--;
				
				end--;
				if (end<0) break;
			}
			if (start >= end) {
				return start;
			}
			
			System.out.println("we swap " + start + " and " + end);
			
			swap(nums, start, end);
			newlength--;
			
			end--;
			// for (int i = 0; i < nums.length; i++)
			// System.out.println(nums[i]);

			start++;

		}
		for (int i = 0 ; i< nums.length; i++)
		{
			if (nums[i] == val) return i;
			
		}
		return newlength;

	}

	private static void swap(int[] nums, int start, int end) {
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;

	}

	public static void main(String[] args) {
		int[] a = { 3 ,3 };
		int lastbit = removeElement(a,3);
		for (int i = 0; i < lastbit; i++)
			System.out.println(a[i]);
		System.out.println(lastbit);
	}

}
