package problem221;

import java.util.Arrays;

//Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
//
//For example, given the following matrix:
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//Return 4.
//Credits:
//Special thanks to @Freezen for adding this problem and creating all test cases.
public class Solution {
    public static int maximalSquare(char[][] matrix) {
        int hei = matrix.length;
        if (hei==0) return 0;
        int width = matrix[0].length;
        int left[]=new int[width];
        int right[]=new int [width];
        int height[] = new int[width];
        int maxA = 0;
        Arrays.fill(left, 0);
        Arrays.fill(right, width);
        Arrays.fill(height, 0);
        
        for (int h = 0; h < hei; h++)
        {
        		int curleft = 0;
        		int curright = width;
        		for (int i = 0; i < width; i++)
        		{
        			if (matrix[h][i] == '1')
        				height[i]++;
        			else height[i] = 0;
        		}
        		for (int i = 0; i < width; i++)
        		{
        			if (matrix[h][i]  == '1')
        				left[i] = Math.max(left[i], curleft);
        			else 
        			{
        				curleft = i+1;
        				left[i] = 0;
        			}
        		}
        		for (int i = width-1; i >=0 ; i--)
        		{
        			if (matrix[h][i]  == '1')
        				right[i] = Math.min(right[i], curright);
        			else 
        			{
        				curright = i;
        				right[i] = width;
        			}
        		}
        		for (int i = 0; i < width; i ++)
        		{
        			int l = Math.min(height[i], right[i]-left[i]);
        			if (l < 0) continue;
        			maxA = Math.max(maxA, l*l);
        		}
        	
        	
        }
        
       
        
        return maxA;
    }
    public static void main(String[]args)
    {
    	char [][]p = {"10".toCharArray()};//,"10111".toCharArray(),"11111".toCharArray(),"10010".toCharArray()};
    	System.out.println(maximalSquare(p));
    			//1 0 1 0 0
    			//1 0 1 1 1
    			//1 1 1 1 1
    			//1 0 0 1 0
    }
}
