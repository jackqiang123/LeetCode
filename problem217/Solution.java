package problem217;

import java.util.HashSet;

//Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
public class Solution {
public boolean containsDuplicate(int[] nums) {
	if (nums.length==0) return false;
        HashSet<Integer> myhash = new HashSet<Integer>();
        for (int i : nums)
        {
        	if (myhash.contains(i))
        		return true;
        	else myhash.add(i);
        	
        }
        return false;
        
    }
}
