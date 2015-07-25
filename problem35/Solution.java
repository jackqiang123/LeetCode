package problem35;

//Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
//You may assume no duplicates in the array.
//
//Here are few examples.
//[1,3,5,6], 5 → 2
//[1,3,5,6], 2 → 1
//[1,3,5,6], 7 → 4
//[1,3,5,6], 0 → 0

public class Solution {
	public static int searchInsert(int[] nums, int target) {

		int length = nums.length;
		int index = length / 2; // the current search index
		int start = 0;
		int end = length - 1;
		while (true) {

			if (nums[index] == target)
				return index;

			if (end - start <= 1) {
				if (target <= nums[start])
					return start;
				if (target == nums[end])
					return end;
				if (target > nums[end])
					return end + 1;
				if (target > nums[start])
					return start + 1;

			}

			if (nums[index] < target) {
				start = index;
				index = (start + end) / 2;
			} else {
				end = index;
				index = (start + end) / 2;
			}

		}

	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 6 };
		System.out.println(searchInsert(a, 5));
	}

}
