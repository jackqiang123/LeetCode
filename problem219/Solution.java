package problem219;

import java.util.HashMap;

//Given an array of integers and an integer k, 
//find out whether there there are two distinct indices i and j in the 
//array such that nums[i] = nums[j] and the difference between i and j is at most k.
public class Solution {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums.length == 0) return false;
		HashMap<Integer, Integer> mymap = new HashMap<Integer, Integer>(); // value
																			// ->
																			// index

		for (int i = 0; i < nums.length; i++) {
			if (!mymap.containsKey(nums[i])) {
				mymap.put(nums[i], i);
			} else {
				if (i - mymap.get(nums[i]) <= k)
					return true;
				else
					mymap.put(nums[i], i);
			}

		}
		return false;

	}
}
