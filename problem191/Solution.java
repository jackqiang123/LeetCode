package problem191;

public class Solution {
	 public static int hammingWeight(int n) {
		
		    int count = 0;
		    
		    for (int i = 0; i< 32; i++)
		    {
		         if ((n & (1 << i)) != 0)
		        	 count++;
		    }
		 
		    return count;
	    }
	 public static void main(String []args)
	 {
		 int bit = 147483648;
		 System.out.println(Integer.toBinaryString(bit));
		 //System.out.println(Integer.toBinaryString(1 << 31 ));
		 System.out.println(hammingWeight(bit));
	 }
}
