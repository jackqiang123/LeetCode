package problem15;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//Note:
//Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
//The solution set must not contain duplicate triplets.
//    For example, given array S = {-1 0 1 2 -1 -4},
//
//    A solution set is:
//    (-1, 0, 1)
//    (-1, -1, 2)
public class Solution {
	public static List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);
		int a, b, c;
		int len = nums.length;
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		for (int i = 0; i < len - 2; i++) {

			a = nums[i];
			if (i>=1 && a == nums[i-1]) continue;

			for (int j = i + 1, k = len - 1; j < k;) {
				b = nums[j];
				c = nums[k];
				if (a + b + c == 0) {
					List<Integer> list = new LinkedList<Integer>();
					list.add(a);
					
					list.add(b);
					
					list.add(c);
					// System.out.println("generate a result");
					result.add(list);
					j++;
					k--;
					while(j<k && b==nums[j])j++;while(j<k && c==nums[k]) k--;
				} else if (a + b + c < 0)
					j++;
				else
					k--;

			}
			
		}
		return result;

	}

	public static void main(String[] args) {
		int[] p = { -2,0,1,1,2};
		Iterator<List<Integer>> it = threeSum(p).iterator();
		while (it.hasNext()) {
			Iterator<Integer> myit = it.next().iterator();
			while (myit.hasNext()) {
				System.out.print(myit.next() + ",");
			}
			System.out.println();
		}

	}

}
