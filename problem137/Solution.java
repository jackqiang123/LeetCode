package problem137;

import java.util.HashMap;

//Given an array of integers, every element appears three times except for one. Find that single one.
//
//Note:
//Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
public class Solution {
	 public int singleNumber(int[] nums) {
		 HashMap<Integer,Integer> mymap = new HashMap<Integer,Integer>();
		 for (int i : nums)
		 {
			 if (mymap.containsKey(i))
			 {
				 int value = mymap.get(i);
				 if (value==1)
					 mymap.remove(i);
				 else
					 mymap.put(i, value+1);
			 
			 }
			 else  mymap.put(i, 0);
		 }
		return mymap.keySet().iterator().next();
	        
	    }

}
