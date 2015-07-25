package problem50;

public class Solution {
    public static double myPow(double x, int n) {
    	if (n == 0) return 1;
    	if (n%2 == 0) return myPow(x*x, n/2);
    	else if (n>=1) return x*myPow(x,n-1);
    	else return myPow(x,n+1)/x;
        
    }
    
    public static void main(String[]args)
    {
    	System.out.println(myPow(3,-2));
    }
}