package problem73;

//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
//
//click to show follow up.
//
//Follow up:
//Did you use extra space?
//A straight forward solution using O(mn) space is probably a bad idea.
//A simple improvement uses O(m + n) space, but still not the best solution.
//Could you devise a constant space solution?
public class Solution {
	public static void setZeroes(int[][] matrix) {
		boolean isFirstRowZero = false;
		boolean isFirstColZero = false;
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == 0) {
				isFirstRowZero = true;
				break;
			}
		}
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				isFirstColZero = true;
				break;
			}
		}

		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}

		for (int i = 1; i < n; i++) {
			if (matrix[0][i] == 0) {
				for (int j = 1; j < m; j++)
					matrix[j][i] = 0;
			}

		}

		for (int i = 1; i < m; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < n; j++)
					matrix[i][j] = 0;
			}

		}

		if (isFirstRowZero == true) {
			for (int i = 0; i < n; i++)
				matrix[0][i] = 0;

		}

		if (isFirstColZero == true) {
			for (int i = 0; i < m; i++)
				matrix[i][0] = 0;

		}

	}

	public static void main(String[] args) {
		int a[][] = { { 0 } };
		setZeroes(a);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++)
				System.out.print(a[i][j]);

			System.out.println();
		}
	}

}
