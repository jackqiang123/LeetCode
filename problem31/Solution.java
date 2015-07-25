package problem31;

import java.util.Arrays;

//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
//The replacement must be in-place, do not allocate extra memory.
//
//Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1
public class Solution {
	public static void nextPermutation(int[] nums) {
		int length = nums.length;
		if (length == 1)
			return;

		int start = length - 2;
		int end = length - 1;
		for (int i = length - 1; i >= 1; i--) {
			if (nums[i] > nums[i - 1])
				break;
			else
				start--;

		}
		 System.out.println(start+","+end);
		// start and end marks the during

		if (start == -1)
			Arrays.sort(nums);
		else {
			int goal = end;
			for (int i = length-1;i>start;i--)
			{
				if (nums[i] > nums[start])
					{goal = i; break;}
			}
			swap(nums, start, goal);
			Arrays.sort(nums, start + 1, end + 1);

		}

	}

	private static void swap(int[] nums, int start, int end) {
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 2, 3, 1 };
		nextPermutation(a);
		for (int p : a)
			System.out.print(p + ",");
	}

}
