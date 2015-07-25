package problem209;

//import java.util.Arrays;
//Given an array of n positive integers and a positive integer s, 
//find the minimal length of a consecutive subarray of which the sum ≥ s. If there isn't one, return 0 instead.
//
//For example, given the array [2,3,1,2,4,3] and s = 7,
//the subarray [4,3] has the minimal length under the problem constraint.
//
//click to show more practice.
//
//More practice:
//If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).


public class Solution {
	public static int minSubArrayLen(int s, int[] nums) {
    int left = 0;
    int right = 0;
    if (nums.length == 0) return 0;
    int currentmax = nums.length+1;
    int sum = nums[0];
    while(right < nums.length && right>=left)
    {
    	if (sum<s)
    	{
    		right++;
    	if (right<nums.length)
    		sum += nums[right];
       	}
    	else 
    	{
    		currentmax = Math.min(right-left+1,currentmax);
    		sum -= nums[left];
    		left = left + 1;
    		
    		
    	}
    	
    }
    return currentmax==nums.length+1? 0:currentmax;    
    
    }
    public static void main(String[]args)
    {
    	int [] p = {1,1};
    	System.out.println(minSubArrayLen(3,p));
    }
}
