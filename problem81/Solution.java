package problem81;

//Follow up for "Search in Rotated Sorted Array":
//What if duplicates are allowed?
//
//Would this affect the run-time complexity? How and why?
//
//Write a function to determine if a given target is in the array.
public class Solution {
	public static boolean search(int[] nums, int target) {
		int length = nums.length;
		if (length == 0) return false;
		int left = 0;
		int right = length - 1;
		int mid = (left + right) / 2;

		while (left <= right) {
			//System.out.println("left  == " + left + "  right == " +right);
			mid = (left + right) / 2;
			if (nums[mid] == target)
				return true;
			if (nums[left] == target || nums[right] == target)
				return true;
			else {
				if (right - left <= 1)
					return false;
			}
			if (nums[mid] > target && nums[left] < target) {
				right = mid - 1;
				continue;
			}
			if (nums[mid] < target && nums[right] > target) {
				left = mid + 1;
				continue;
			}

			right--;
			left++;

		}
		return false;

	}
	
	public static void main(String[]args)
	{
		int[]a = {4,5,6,7,0,1,2};
		System.out.println(search(a,5));
	}
}
