package problem154;
//Follow up for "Find Minimum in Rotated Sorted Array":
//What if duplicates are allowed?
//
//Would this affect the run-time complexity? How and why?
//Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//Find the minimum element.
//
//The array may contain duplicates.
public class Solution {
    public static int findMin(int[] nums) {
    	if (nums.length == 1) return nums[0];
    	int left = 0;
    	int right = nums.length-1;
    	int mid = (left+right)/2;
    	while(left <= right)
    	{
    	System.out.println("left == " + left + " right ==" + right);
    		if (nums[left] < nums[right]) return nums[left];
    		if (right - left <= 1)
    		{
    			return Math.min(nums[right],nums[left]);
    			
    		}
    		mid = (left+right)/2;
    		
    		if (nums[left]< nums[mid])
    			left = mid ;
    		else if (nums[left]> nums[mid])
    			right = mid;
    		else {left++;}
    		
    		
    		
    	}
       return -1;
    }
    public static void main(String[]args)
    {
    	
    	int []p ={3,3,1};
    	System.out.println(findMin(p));
    }
}
