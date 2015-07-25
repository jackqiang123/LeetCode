package problem48;
//You are given an n x n 2D matrix representing an image.
//
//Rotate the image by 90 degrees (clockwise).
//
//Follow up:
//Could you do this in-place?
public class Solution {
    public static void rotate(int[][] matrix) {
        int dim = matrix.length;
        if (dim == 1) return;
        
        for (int i = 0; i< dim/2; i++)
        {
        	for (int j = 0; j< dim ;j++)
        	{
        		swap(matrix,i,j,dim-1-i,j);
        	}
        }
        for (int i = 0; i< dim; i++)
        {
        	for (int j = i+1; j< dim ;j++)
        	{
        		swap(matrix,i,j,j,i);
        	}
        }
        
    }

	private static void swap(int[][] matrix, int i, int j, int p, int q) {
		int temp = matrix[i][j];
		matrix[i][j] = matrix[p][q];
		matrix[p][q] = temp;
		
	}
	
	public static void main(String []args)
	{
		int p [][]= {{1,2},{3,4}};
		int dim = p.length;
		rotate(p);
		 for (int i = 0; i< dim; i++)
	        {
	        	for (int j = 0; j< dim ;j++)
	        	{
	        		System.out.print(p[i][j]+" ");
	        	}
	        	System.out.println();
	        }
		
	}
}