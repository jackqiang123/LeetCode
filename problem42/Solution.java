package problem42;

//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//For example, 
//Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
//
//
//The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
public class Solution {

	public static int trap(int[] height) {
		if (height.length == 0) return 0;
		int max = 0;
		int leftmax = height[0];
		int rightmax = height[height.length - 1];
		int left = 0;
		int right = height.length - 1;

		while (left < right) {
			leftmax = Math.max(leftmax, height[left]);
			rightmax = Math.max(rightmax, height[right]);

			if (leftmax <= rightmax) {
				max += leftmax - height[left];
				left++;
			} else {
				max += rightmax - height[right];
				right--;

			}

		}
		return max;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int [] p = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(p));


	}

}
