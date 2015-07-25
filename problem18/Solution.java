package problem18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
//Note:
//Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
//The solution set must not contain duplicate quadruplets.
//    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
//
//    A solution set is:
//    (-1,  0, 0, 1)
//    (-2, -1, 1, 2)
//    (-2,  0, 0, 2)
public class Solution {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        int length = nums.length;
        for (int i = 0; i < length - 3; i++)
        {
        	
        	for (int j = i + 1; j < length-2; j++ )
        	{
        		
        		int p = j + 1;
        		int q = nums.length-1;
        		while(p<q){
        		if (nums[i]+nums[j]+nums[p]+nums[q] == target)
        		{
        			List<Integer> ls = new ArrayList<Integer>();
        			ls.add(nums[i]);
        			ls.add(nums[j]);
        			ls.add(nums[p]);
        			ls.add(nums[q]);
        			//System.out.println(nums[i]+",")
        			r.add(ls);
        			while(p+1<q && nums[p] == nums[p+1]) p++;
        			while(p+1<q &&nums[q-1] == nums[q]) q--;
        		
        			while(j+1<p && nums[j] == nums[j+1]) j++;
        			while(i+1<j && nums[i] == nums[i+1]) i++; 
        			
        		//	System.out.println("idnex is "+i+","+j+","+p+","+q+",");
        			
        			
        			p++;q--;
        		}
        		else if (nums[i]+nums[j]+nums[p]+nums[q]  < target)
        		{
        			p++;
        		}
        		else q--;
        		}
        		
        	
        		// for this term, we need to move j such that not duplicated j.
        	}
        	
        	
        
        	
        }
        return r;
    }
	
	public static void main(String[]args)
	{
		//int []S = {-5,-4,-3,-2,-1,0,0,1,2,3,4,5};
	//	int []S ={-5,-3,-2,0,0,4,4,5};
		//int[]S ={0,0,0,0};
		int[]S={0,2,2,2,10,-3,-9,2,-10,-4,-9,-2,2,8,7};
		//int []S={-1,-5,-5,-3,2,5,0,4};
		Iterator<List<Integer>> it = fourSum(S,6).iterator();
		while (it.hasNext()) {
			Iterator<Integer> myit = it.next().iterator();
			while (myit.hasNext()) {
				System.out.print(myit.next() + ",");
			}
			System.out.println();
		}
	}
	
}
