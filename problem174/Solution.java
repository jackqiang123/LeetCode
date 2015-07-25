package problem174;
//The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
//
//The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
//
//Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
//
//In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
//
//
//Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
//
//For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
public class Solution {
	public static int calculateMinimumHP(int[][] d) {
    	int hei = d.length;
    	int width = d[0].length;
    	int dp [][] = new int [hei][width];
    	dp[hei-1][width-1] = d[hei-1][width-1] > 0? 1: (1-d[hei-1][width-1]);
    	for (int i = hei-2; i >=0 ;i--)
    		dp[i][width-1] = (dp[i+1][width-1] - d[i][width-1]) > 0 ? dp[i+1][width-1] - d[i][width-1] : 1;
    	for (int i = width-2; i >=0; i--)
    		dp[hei-1][i] = (dp[hei-1][i+1] - d[hei-1][i]) > 0 ?  (dp[hei-1][i+1] - d[hei-1][i]) : 1;
    		for (int j = width-2; j>=0; j--)
    			for (int i = hei-2; i>=0; i--)
    			{
    				int m = Math.min(dp[i][j+1], dp[i+1][j]);
    				dp[i][j] = (m-d[i][j])>0 ? (m-d[i][j]):1;
    			}
    		return dp[0][0];
    }
    public static void main(String[]args)
    {
    	int [][]p = {{1,-3,3},{0,-2,0},{-3,-3,-3}};
    	System.out.println(calculateMinimumHP(p));
    }
}
