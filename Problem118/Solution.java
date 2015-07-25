package Problem118;

import java.util.LinkedList;
import java.util.List;

//Given numRows, generate the first numRows of Pascal's triangle.
//
//For example, given numRows = 5,
//Return
//
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]

public class Solution {

	public static List<List<Integer>> generate(int numRows) {

		LinkedList result = new LinkedList();
		if (numRows == 0)
			return result;
		LinkedList<Integer> firstline = new LinkedList<Integer>();
		firstline.add(1);
		result.add(firstline);
		LinkedList<Integer> lastlist = firstline;
		for (int i = 2; i <= numRows; i++) {
			LinkedList<Integer> line = newlist(lastlist);
			lastlist = line;
			// System.out.println(line.size());
			result.add(line);

		}

		return result;
	}

	private static LinkedList<Integer> newlist(LinkedList<Integer> lastlist) {
		int length = lastlist.size();
		LinkedList<Integer> currentone = new LinkedList<Integer>();
		for (int i = 0; i <= length; i++) {
			if (i == 0 || i == length)
				currentone.add(1);
			else {
				currentone.add(lastlist.get(i - 1) + lastlist.get(i));
			}
		}

		return currentone;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList result = (LinkedList) generate(8);
		System.out.println(result.toString());
	}

}
