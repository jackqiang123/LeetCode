package problem220;
//Given an array of integers, 
//find out whether there are two distinct indices i and j in the array 
//such that the difference between nums[i] and nums[j] is 
//at most t and the difference between i and j is at most k.

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

// since we need range search, we will a bst


public class Solution {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	TreeMap<Integer,Integer> treeset = new TreeMap<Integer,Integer>();

    	int len = nums.length;
    	if (len == 0 || k<= 0 || t <0) return false;
    
    	for (int i = 0; i < len; i++ )
    	{
    		int lowerbound = nums[i]==Integer.MIN_VALUE? nums[i]:nums[i]- t;
    		int upperbound = nums[i]==Integer.MAX_VALUE? nums[i]: nums[i]+t;
    		
    		if (treeset.floorKey(upperbound)!=null && treeset.floorKey(upperbound)>=lowerbound)
    		{	//System.out.println(upperbound+","+lowerbound);
    			//System.out.println("return true since at " + i +","+ treeset.floorKey(upperbound) + "," +treeset.ceilingKey(lowerbound));	
    			return true;}
    		if (i - k >= 0)
    		{	
    			int count = treeset.get(nums[i-k]);
    			if (count == 1) treeset.remove(nums[i-k]);
    			else treeset.put(nums[i-k],treeset.get(nums[i-k])-1);
    		}
    		
    		if (!treeset.containsKey(nums[i])) treeset.put(nums[i], 1);
    		else treeset.put(nums[i],1+treeset.get(nums[i]));
    		
    		
    	}
    	return false;
        
    }
    public static void main(String[]args)
    {
    	int []p = {0,10,22,15,0,5,22,12,1,5};
    	System.out.println(containsNearbyAlmostDuplicate(p,3,3));
    }
   
}
