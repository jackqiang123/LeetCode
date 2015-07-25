package problem39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//The same repeated number may be chosen from C unlimited number of times.
//
//Note:
//All numbers (including target) will be positive integers.
//Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//The solution set must not contain duplicate combinations.
//For example, given candidate set 2,3,6,7 and target 7, 
//A solution set is: 
//[7] 
//[2, 2, 3] 
public class Solution {
	 public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		 ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		// ArrayList<List<Integer>> temp = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		 List<Integer> cur = new ArrayList<Integer>();
		 recurise(cur, result,candidates,0,target);
		
	       return result; 
	    }

	private static void recurise(List<Integer> cur, ArrayList<List<Integer>> result,
			int[] candidates, int start, int target) {
		if (target == 0) {result.add(cur); return;}
		else if (target >0)
		{
			for (int i = start; i<candidates.length;i++)
			{
				 List<Integer> mycur = new ArrayList<Integer>(cur);
				 mycur.add(candidates[i]);
				 recurise(mycur,result,candidates,i,target-candidates[i]);
				
			}
			
		}
		else return;
		
		
	}
	
	public static void main(String[]args){
		
		int []p = {2,3,6,7};
		ArrayList<List<Integer>> result = (ArrayList<List<Integer>>) combinationSum(p,7);
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
