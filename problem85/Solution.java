package problem85;

import java.util.Arrays;

//Given a 2D binary matrix filled with 0's and 1's, 
//find the largest rectangle containing all ones and return its area.
public class Solution {
	public static int maximalRectangle(char[][] matrix) {

		int height = matrix.length;
		if (height == 0) return 0;
		int width = matrix[0].length;
		int maxA = 0;
		int hei[] = new int[width];
		int left[] = new int[width];
		int right[] = new int[width];
		Arrays.fill(hei, 0);
		Arrays.fill(left, 0);
		Arrays.fill(right, width);

		for (int i = 0; i < height; i++) {
			// set the height
			int curleft = 0;
			int curright = width;
			for (int j = 0; j < width; j++) {
				if (matrix[i][j] == '1')
					hei[j]++;
				else {
					hei[j] = 0;
				}
			}
			for (int j = 0; j < width; j++) {
				if (matrix[i][j] == '1')
					left[j] = Math.max(left[j], curleft);
				else {
					left[j] = 0;
					curleft = j + 1;
				}
			}
			for (int j = width - 1; j >= 0; j--) {
				if (matrix[i][j] == '1')
					right[j] = Math.min(right[j], curright);
				else {
					right[j] = width;
					curright = j;
				}
			}
			for (int j = 0; j < width; j++) {
				//System.out.println(left[j]+","+ right[j]+","+hei[j]);
				maxA = Math.max(maxA, Math.abs(right[j] - left[j]) * hei[j]);
			}

		}
		return maxA;
	}
	public static void main(String[]args)
	{
		char [][]p = {{'1'}};
		maximalRectangle(p);
	}
}
