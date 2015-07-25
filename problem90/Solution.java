package problem90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//Given a collection of integers that might contain duplicates, nums, return all possible subsets.
//
//Note:
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
//For example,
//If nums = [1,2,2], a solution is:
//
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
public class Solution {
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> cur = new ArrayList<Integer>();
		result.add(cur);
		int lengthofdup = 1;
		int lastvalue = nums[0];
		for (int i = 0; i < nums.length; i++) {
			int size = result.size();
			if (i != 0) {

				if (nums[i] == lastvalue)
					lengthofdup++;
				else {
					lastvalue = nums[i];
					lengthofdup = 1;
				}
			}
			//System.out.println("lengthofdup is " + lengthofdup);
			for (int j = 0; j < size; j++) {
				if (lengthofdup != 1 && j < size - size / lengthofdup)
					continue;
				List<Integer> temp = new ArrayList<Integer>(result.get(j));
				temp.add(nums[i]);
				result.add(temp);

			}

		}
		return result;

	}

	public static void main(String[] args) {
		int p[] = { 1, 2, 2, 2 };
		ArrayList<List<Integer>> result = (ArrayList<List<Integer>>) subsetsWithDup(p);
		Iterator<List<Integer>> it = result.iterator();
		while (it.hasNext()) {
			Iterator<Integer> myit = it.next().iterator();
			while (myit.hasNext()) {
				System.out.print(myit.next() + ", ");
			}
			System.out.println();
		}

	}

}
