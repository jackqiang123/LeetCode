package problem228;

import java.util.LinkedList;
import java.util.List;

//Given a sorted integer array without duplicates, return the summary of its ranges.
//
//For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
public class Solution {
	public static List<String> summaryRanges(int[] nums) {
		List<String> result = new LinkedList<String>();
		int len = nums.length;
		if (len == 0)
			return result;
		if (len == 1) {
			result.add(nums[0] + "");
			return result;
		}

		int left = 0;
		int right = 0;

		while (true) {
			if (right == len - 1) {
				if (left == right) {
					result.add(nums[left] + "");
					return result;
				} else {
					result.add(nums[left] + "->" + nums[right]);
					return result;
				}
			} else {
				if (nums[right + 1] == nums[right] + 1)
					right++;
				else {
					if (left == right) {
						result.add(nums[left] + "");
					} else {
						result.add(nums[left] + "->" + nums[right]);
					}
					left = right + 1;
					right = left;
				}

			}

		}

	}

	public static void main(String[] args) {
		int[] p = { 0,2 };
		List<String> r = summaryRanges(p);
		for (String k : r) {
			System.out.println(k);
		}
	}
}
