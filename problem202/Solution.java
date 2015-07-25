package problem202;

import java.util.HashSet;

//Write an algorithm to determine if a number is "happy".
//
//A happy number is a number defined by the following process: Starting with any positive integer, 
//replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), 
//or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
//
//Example: 19 is a happy number
//
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
public class Solution {
	public static boolean isHappy(int n) {
		  
		  HashSet<Integer> mymap = new HashSet<Integer>();
		  if (n == 1 || n ==0) return true;
		  
		  while(mymap.contains(n) == false)
		  {
			  mymap.add(n);
			  
			  n = check(n);
			  if (n == 1)
				  return true;
			
		  }
		  
		  return false;
		
	        
	    }
  
	public static int check(int n) {
		// compute the digit square sum
		int sum = 0;
		//int length = 1;
		int number = n;
	    while(number >= 10)	
	    {
	   // 	length++;
	    	sum = (int) (sum + (number%10)*(number%10));
	    	
	    	number = number/10;
	    	
	    }
	    sum = (int) (sum + number*number);
			return sum;
	}

	public static void main(String[]args)
	{
		System.out.println(isHappy(19));
	}
}
