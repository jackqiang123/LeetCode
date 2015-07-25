package problem153;

//Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//Find the minimum element.
//
//You may assume no duplicate exists in the array.
public class Solution {
	public static int findMin(int[] nums) {
		int start = 0;
		int length = nums.length;
		if (length == 1)
			return nums[0];
		int last = length - 1;
		int min = nums[start];
		while ((last - start) >= 2) {

			int mid = (start + last) / 2;

			if (nums[start] < nums[mid] && nums[mid] < nums[last])
				return nums[start];

			if (nums[mid] > nums[start]) // in this case, the min is the last
											// part
			{

				start = mid;

			}

			else {
				last = mid;
			}
			// System.out.println("current start is "+
			// start+"  and the current end is "+ last);
		}

		for (int i = start; i <= last; i++) {
			if (min > nums[i])
				min = nums[i];

		}
		return min;

	}

	public static void main(String[] args) {
		int a[] = { 4, 1, 2, 3 };
		System.out.println(findMin(a));
	}
}
