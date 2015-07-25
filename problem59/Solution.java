package problem59;

//Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
//For example,
//Given n = 3,
//
//You should return the following matrix:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
public class Solution {
	public static int[][] generateMatrix(int n) {
		if (n == 0)
			return null;
		int[][] result = new int[n][n];
		int start = 0;
		int end = n - 1;
		int num = 1;
		while (start <= end) {
			for (int i = start; i <= end; i++) {
				result[start][i] = num;
				num++;
			}
			for (int i = start + 1; i <= end; i++) {
				result[i][end] = num;
				num++;
			}
			for (int i = end - 1; i >= start; i--) {
				result[end][i] = num;
				num++;
			}
			for (int i = end - 1; i > start; i--) {
				//System.out.println("the current i is" + i+ "the current num is" + num);
				result[i][start] = num;
				num++;
			}
			start++;
			end--;
		}
		return result;
	}
public static void main(String []args)
{
	int n = 33;
	int [][] p = generateMatrix(n);
	for(int i = 0; i< n;i++){
		for(int j = 0; j< n;j++){
			System.out.print(p[i][j]+" ");
		}
	System.out.println();
	}
}
}