package problem162;

public class Solution {
	  public static int findPeakElement(int[] nums) {
		  int length = nums.length;
		  if (length<=1) return 0;
		  int start = 0;
		  int end = nums.length-1;
		  return findp(nums,start,end);
	        
	    }

	private static int findp(int[] nums, int start, int end) {
		if (start == end) return start;
		if (end-start == 1) {if (nums[start]>nums[end]) return start;else return end;}
		else{
			int mid = (start+end)/2;
			if (nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]) return mid;
			else if (nums[mid]<nums[mid-1]&&nums[mid]>nums[mid+1]) return findp(nums,start,mid-1);
			else return findp(nums,mid+1,end);
			
			
		}
	}



public static void main(String[]args)
{
int[] p = {3,2,1};
System.out.println(findPeakElement(p));
		
}
}