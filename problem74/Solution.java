package problem74;

//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//Integers in each row are sorted from left to right.
//The first integer of each row is greater than the last integer of the previous row.
//For example,
//
//Consider the following matrix:
//
//[
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//Given target = 3, return true.

public class Solution {

	public static boolean searchMatrix(int[][] matrix, int target) {

		int m = matrix.length;
		int n = matrix[0].length;

		int starty = 0;
		int endy = m - 1;
		int mid = (starty + endy) / 2;

		while (endy - starty > 1) {
			if (target >= matrix[mid][0])
				starty = mid;
			else
				endy = mid;
			// System.out.println("the start is " + starty + " the end y is " +
			// endy);
			mid = (starty + endy) / 2;
		}
		int objectrow = mid;
		if (target >= matrix[endy][0])
			objectrow = endy;
		// System.out.println("the obj line is" + objectrow);
		int startx = 0;
		int endx = n - 1;
		mid = (startx + endx) / 2;
		System.out.println("the mid is" + mid);
		while (endx - startx > 1) {
			if (target >= matrix[objectrow][mid])
				startx = mid;
			else
				endx = mid;
			mid = (startx + endx) / 2;
		}
		if (target == matrix[objectrow][mid])
		   return true;
		else{
			if (mid-1>=0)
				if(target == matrix[objectrow][mid - 1])
					return true;
			if (mid+1<=n-1)
				if(target == matrix[objectrow][mid + 1])
					return true;
		}
				
			return false;

	}

	public static void main(String[] args) {
		int m[][] = { { 1 } };
		System.out.println(searchMatrix(m, 0));
	}

}
