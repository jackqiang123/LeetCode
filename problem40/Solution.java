package problem40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//Each number in C may only be used once in the combination.
//
//Note:
//All numbers (including target) will be positive integers.
//Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//The solution set must not contain duplicate combinations.
//For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
//A solution set is: 
//[1, 7] 
//[1, 2, 5] 
//[2, 6] 
//[1, 1, 6] 

public class Solution {
	public static List<List<Integer>> combinationSum2(int[] nums, int target) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		List<Integer> cur = new ArrayList<Integer>();
		recurise(cur, result, nums, 0, target);
		return result;
	}

	private static void recurise(List<Integer> cur,
			ArrayList<List<Integer>> result, int[] candidates, int start,
			int target) {
		if (target == 0) {
			List<Integer> mycur = new ArrayList<Integer>(cur);
			result.add(mycur);
			return;
		} else {
			for (int i = start; i < candidates.length; i++) {
				//System.out.println("the current recrusive is " + i);
				// List<Integer> mycur = new ArrayList<Integer>(cur);
				
				if (i == start || candidates[i]!=candidates[i-1]) // why this can be used to check dupliate?
				{
					boolean b1= (i==start);
					boolean b2 = false;
					if (i>0) b2= (candidates[i]!=candidates[i-1]);
				System.out.println("we get a recrusive becuase" +b1 +"or"+b2);
				cur.add(candidates[i]);
				recurise(cur, result, candidates, i + 1, target - candidates[i]);
				cur.remove(cur.size() - 1);
				}
			}

		}

	}

	public static void main(String[] args) {

		int[] p = { 1, 1, 1 ,3};
		ArrayList<List<Integer>> result = (ArrayList<List<Integer>>) combinationSum2(
				p, 3);
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
