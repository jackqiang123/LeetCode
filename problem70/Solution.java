package problem70;

//You are climbing a stair case. It takes n steps to reach to the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
public class Solution {
	public int climbStairs(int n) {
		if (n <= 2)
			return n;
		int[] c = new int[n];
		c[0] = 1; c[1] = 2;
		for (int i = 2;i<n;i++)
		{
			c[i] = c[i-1]+c[i-2];
		}
		return c[n-1];
	}

}
