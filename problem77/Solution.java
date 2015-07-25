package problem77;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
//For example,
//If n = 4 and k = 2, a solution is:
//
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
public class Solution {
	
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
		 ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		combine(result, new ArrayList<Integer>(), 1, n, k);
		return result;

	}

	private static void combine(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> arrayList, int start, int n,
			int k) {
		if (k == 0) {
			
			result.add(new ArrayList<Integer>(arrayList));
			return;
		} else {
			for (int i = start; i <= n; i++) {
				arrayList.add(i);
				combine(result,arrayList, i + 1, n, k - 1);
				arrayList.remove(arrayList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> result = combine(2, 1);
		Iterator<ArrayList<Integer>> it = result.iterator();
		while (it.hasNext()) {
			
			Iterator<Integer> myit = it.next().iterator();
			while (myit.hasNext()) {
				
				System.out.print(myit.next());
			}
			System.out.println();

		}
	}
}