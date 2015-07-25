package problem69;
//Implement int sqrt(int x).
//
//Compute and return the square root of x.
public class Solution {
    public static int mySqrt(int x) {
    	if (x == 0) return 0;
    	int left = 1;
    	int right = x;
    	int k = (left+right)/2;
    	while(true)
    	{
    		k = (left+right)/2;
    		if (k > x/k)
    		{
    			right = k -1;
    		}
    		else {
    			if (k+1>x/(k+1)) return k;
    			left = k+1;
    		}
    	}
    	//return k;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.sqrt(2147395599));
		System.out.println((2147395599*2147395599));
	}

}
