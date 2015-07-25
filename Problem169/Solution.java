package Problem169;

import java.util.HashMap;

public class Solution {
	 public static int majorityElement(int[] num) {
		 HashMap<Integer, Integer> mymap = new HashMap<Integer, Integer>();
		 int n = num.length;
		 int threshold = (int) Math.ceil(n/2.0);
		 if( n == 1) return num[0];
		 for (int i = 0; i<n;i++)
		 {   
			 if (mymap.containsKey(num[i])) 
			 {
				 int value = mymap.get(num[i]);
				 value++;
				 if (value>=threshold)
					 return num[i];
				 mymap.put(num[i], value);
			 }
			 else{
				 mymap.put(num[i], 1);
			 }
		 }
		
		 
	        return -1;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num ={2,2};
		System.out.println(majorityElement(num));
	}

}
