package problem54;

import java.util.LinkedList;
import java.util.List;

//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
//For example,
//Given the following matrix:
//
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//You should return [1,2,3,6,9,8,7,4,5].
public class Solution {
	
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new LinkedList<Integer>();
		if (matrix.length==0)return res;
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];

		helper(res, matrix, 0, 0, visited,0);
		return res;

	}

	private static void helper(List<Integer> res, int[][] matrix, int i, int j, boolean[][] visited, int direction) {
		res.add(matrix[i][j]);
		visited[i][j] = true;
		//System.out.println("add a result " + matrix[i][j]);
		
		if (direction == 0)
		{
			if (j + 1 < matrix[0].length && !visited[i][j + 1])
				helper(res, matrix, i, j + 1, visited,0);
			else if (i + 1 < matrix.length && !visited[i + 1][j]) 
				helper(res, matrix, i+1, j, visited,1);
			else return;
		}
		else if (direction == 1)
		{
			if (i + 1 < matrix.length && !visited[i + 1][j]) 
				helper(res, matrix, i+1, j, visited,1);
			else if (j - 1 >= 0 && !visited[i][j - 1])
				helper(res, matrix, i, j - 1, visited,2);
			else return;
		}
		else if (direction == 2)
		{
			if (j - 1 >= 0 && !visited[i][j - 1])
				helper(res, matrix, i, j - 1, visited,2);
			else if (i - 1 >= 0 && !visited[i - 1][j])
				helper(res, matrix, i - 1, j, visited,3);
			else return;
		}
		else if (direction == 3)
		{
			if (i - 1 >= 0 && !visited[i - 1][j])
				helper(res, matrix, i - 1, j, visited,3);
			else if (j + 1 < matrix[0].length && !visited[i][j + 1])
				helper(res, matrix, i, j+1, visited,0);
			else return;
			
		}
		
		
	}
	
	public static void main(String[]args)
	{
		int [][]p = {{1,2,3},{4,5,6},{7,8,9}};
		List<Integer> ls = spiralOrder(p);
		for (int k : ls)
			System.out.println(k);
	}
}
