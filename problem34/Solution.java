package problem34;
//Given a sorted array of integers, find the starting and ending position of a given target value.
//
//Your algorithm's runtime complexity must be in the order of O(log n).
//
//If the target is not found in the array, return [-1, -1].
//
//For example,
//Given [5, 7, 7, 8, 8, 10] and target value 8,
//return [3, 4].
public class Solution {
    public static int[] searchRange(int[] nums, int target) {
     int length = nums.length;
     if (length == 0) return new int[]{-1,-1};
     int left = 0;
     int right = length - 1;
     int mid = (left + right)/2;
     boolean finder = false;
     
     while(left<=right)
     {
    	 mid = (left+right)/2;
    	 if (nums[mid] == target) {finder = true; break;}
    	 if (nums[mid]>target) {right = mid-1;}
    	 else left = mid+1; 	 
     }
    	
     if (finder == false) return new int[]{-1,-1};
    // System.out.println("the mid is " + mid);
     
     int result[] = {0,0};
     // in the following, we note nums[mid] == target. in the next, we use resultleft and resultright to find the the boundary.
     int tempmid = mid;
     
     left = 0;
     right = mid;
     while(left<=right)
     { //System.out.println(left + ", " + right);
    	 if (right - left<=1) {
    		 if (nums[left] == target) result[0] = left;
    		 else result[0] = right;
    		 break;
    		 }
    	 mid = (left+right)/2;
    	 if (nums[mid] == target)
    		right = mid;
    	 else if (nums[mid] < target) left = mid+1;  	 
     }
     
     
     left = tempmid;
     right = length-1;
     while(left<=right)
     {//System.out.println(left + ", " + right);
    	 if (right - left<=1) {
    		 if (nums[right] == target) result[1] = right;
    		 else result[1] = left;
    		 break;
    		 }
    	 mid = (left+right)/2;
    	 if (nums[mid] == target)
    		left = mid;
    	 else if (nums[mid] > target) right = mid-1;  	 
     }
     return result;
    	
    }
    
    public static void main(String[]args)
    {
    	
    	int []a = {5};
    	int [] r = searchRange(a,5);
    	System.out.print(r[0] + "    " + r[1]);
    	
    }
}
