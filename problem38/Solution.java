package problem38;
//The count-and-say sequence is the sequence of integers beginning as follows:
//1, 11, 21, 1211, 111221, ...
//
//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.
//Given an integer n, generate the nth sequence.
//
//Note: The sequence of integers will be represented as a string.
public class Solution {
    public static String countAndSay(int n) {
    if (n==1) return "1";
    if (n==2) return "11";
    else{
    	String num = countAndSay(n-1);
    	int length = num.length();
    	int left = 0;
    	int right = 0;
    	StringBuilder result = new StringBuilder();
    	while(true)
    	{
    		while (right<length && num.charAt(right) == num.charAt(left))
    			right++;
    		result.append(right-left);
    		//System.out.println(left);
    		result.append(num.charAt(left));
    		left = right;
    		if (right >= length) break;
    		
    	}
    	return result.toString();
    	
    	
    }
    	
    	
    }
	public static void main(String[] args) {
		System.out.println(countAndSay(10));
	}

}
