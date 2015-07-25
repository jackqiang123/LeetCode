package problem120;

import java.util.Iterator;
import java.util.List;

//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//
//For example, given the following triangle
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
//
//Note:
//Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
public class Solution {
	 public int minimumTotal(List<List<Integer>> triangle) {
	 for (int l = triangle.size()-2; l>=0;l--)
	 {
		 for (int i = 0; i<triangle.get(l).size();i++)
		 {
			 int newdistance = triangle.get(l).get(i) + min(triangle.get(l+1).get(i),triangle.get(l+1).get(i+1));
			 List<Integer> currentlevel = triangle.get(l);
			 currentlevel.set(i, newdistance);
			 
		 }
		 
	 }
	 return triangle.get(0).get(0);
	 
	 
	 }

	private int min(int a,int b) {
		if (a<=b) return a;
		else return b;
		
	}
}
