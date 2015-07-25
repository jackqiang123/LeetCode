package problem33;

//Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//You are given a target value to search. If found in the array return its index, otherwise return -1.
//
//You may assume no duplicate exists in the array.
public class Solution {
	public static int search(int[] nums, int target) {

		if (nums.length == 0)
			return -1;

		int left = 0;
		int right = nums.length - 1;
		int mid = (left + right) / 2;

		while (left <= right) {
			mid = (left + right) / 2;
			if (nums[mid] == target)
				return mid;
			if (mid+1<= nums.length-1 && nums[mid+1] == target) return mid+1;

			if (nums[mid] > nums[left]) {
				if (target >= nums[left] && target <= nums[mid])
					right = mid - 1;
				else
					left = mid + 1;

			} else {
				if (target <= nums[right] && target >= nums[mid])
					left = mid + 1;
				else
					right = mid - 1;

			}

		}
		return -1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p = { 4,1};
		System.out.println(search(p, 1));

	}
}
