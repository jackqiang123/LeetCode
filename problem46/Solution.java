package problem46;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Given a collection of numbers, return all possible permutations.
//
//For example,
//[1,2,3] have the following permutations:
//[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
public class Solution {
	public static ArrayList<ArrayList<Integer>> permute(int[] nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int dim = nums.length;
		if (dim == 0)
			return result;
		else if (dim == 1) {
			ArrayList<Integer> tempe = new ArrayList<Integer>();
			
			tempe.add(nums[0]);
			result.add(tempe);
			
			return result;
		} else {
			int n = nums.length - 1;

			int next[] = new int[n];
            System.arraycopy(nums, 0, next, 0, n);
			System.out.println();
			// List<List<Integer>> temp = new ArrayList<List<Integer>>();
			ArrayList<ArrayList<Integer>> temp = permute(next);

			for (ArrayList<Integer> list : temp) {
				int length = list.size();

				for (int j = 0; j <= length; j++) {
					
					ArrayList<Integer> mylist = new ArrayList<Integer>(list);
					//System.out.println(" adding the following element " +nums[n]);
					mylist.add(j, nums[n]);
                  
					result.add(mylist);

				}
			}

			return result;
		}
	}

	public static void main(String[] args) {
		int[] a = {1,2};
		//stem.out.print(a[0]);
		permute(a);
	}
}
