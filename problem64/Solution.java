package problem64;
//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
//Note: You can only move either down or right at any point in time.
public class Solution {
    public static int minPathSum(int[][] grid) {
    	int height = grid.length;
    	int width = grid[0].length;
    	int path [][] = new int[height][width];
    	path[0][0] = grid[0][0];
    	for(int i = 0; i<height;i++)
    		for(int j = 0; j<width; j++)
    		{
    			if (i == 0 && j == 0) continue;
    			if (i == 0) 
    			{
    				
    				path[i][j] = path[i][j-1] + grid[i][j]; 
    				
    			}
    			else{
    				if (j == 0)
    					path[i][j] = path[i-1][j]+grid[i][j];
    				else
    				{
    					if (path[i-1][j] <= path[i][j-1]) path[i][j] = path[i-1][j] + grid[i][j];
    					else path[i][j] = path[i][j-1] + grid[i][j];
    					
    				}
    			}
    				
    		}
       return path[height-1][width-1]; 
    }
    public static void main(String []args)
    {
    	int p[][] = new int [1][1];
    	for (int i = 0; i< p.length;i++)
    	{	for (int j = 0; j<p[0].length; j++)
    		{		p[i][j] = (int)(Math.random() * 5);
    		System.out.print(p[i][j]+" ");
    		}
    	System.out.println();
    	}
    	
    	System.out.println(minPathSum(p));	
    }
}