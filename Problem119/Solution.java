package Problem119;

import java.util.ArrayList;

import java.util.List;

//Given an index k, return the kth row of the Pascal's triangle.
//
//For example, given k = 3,
//Return [1,3,3,1].
//
//Note:
//Could you optimize your algorithm to use only O(k) extra space?
public class Solution {

	public static List<Integer> getRow(int rowIndex) {
       
		ArrayList<Integer> result = new ArrayList<Integer>();
		rowIndex++;
		if (rowIndex < 0)
			return result;
		result.add(1);
        
		if (rowIndex == 1 || rowIndex == 0)
			return result;

		result.add(1);
		
		if (rowIndex == 2)
			return result;

		// 1 1 -> 0 1 1. then do for 0 to 0, we will have 1 1 1, and then 3/2-1
		// 1 1
		// int currentlength = 1;

		// we only do the first half

		for (int i = 3; i <= rowIndex; i++) {
			result.add(0, 0);
			for (int j = 0; j < i / 2; j++) {
				result.set(j, result.get(j) + result.get(j + 1));
			}
			if (i % 2 == 1) // if the current one is an odd
			{
				result.set(i / 2, result.get(i / 2) * 2);
//				System.out.println("current one is middle and we put "
//						+ (i / 2) + " with value" + result.get(i / 2) * 2);
			}
			for (int j = 0; j < i / 2; j++) {
				// if (i != 8)
				result.set(i - 1 - j, result.get(j));
			}
//			System.out.println(result.toString());
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 、、LinkedList result = (LinkedList) generate(4);
		System.out.println(getRow(20).toString());
	}

}
