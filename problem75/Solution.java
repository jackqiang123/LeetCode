package problem75;
//Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//
//Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.


public class Solution {
public void sortColors(int[] nums) {
	int red = 0;
	int white = 0;
	//int blue = 0;
	int length = nums.length;
	for (int i = 0; i< length; i++)
	{
		if (nums[i]==0) red++;
		else if (nums[i] == 1) white++;
		//else blue++;
	}
	for (int i = 0; i< red; i++)
	{
		nums[i] = 0;
	}
	for (int i = red; i< red+white; i++)
	{
		nums[i] = 1;
	}
	for (int i = red+white; i< length; i++)
	{
		nums[i] = 2;
	}
        
    }

}
