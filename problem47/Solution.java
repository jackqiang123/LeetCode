package problem47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//For example,
//[1,1,2] have the following unique permutations:
//[1,1,2], [1,2,1], and [2,1,1].


public class Solution {
    public static List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        boolean[] visited = new boolean[num.length];
        permute(result, current, num, visited);
        return result;
    }

    private static void permute(List<List<Integer>> result, List<Integer> current, int[] num, boolean[] visited) {
        if (current.size() == num.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for (int i=0; i<visited.length; i++) {
            if (!visited[i]) {
                if (i > 0 && num[i] == num[i-1] && !visited[i-1]) {
                    continue;}
                
                visited[i] = true;
                current.add(num[i]);
                permute(result, current, num, visited);
                current.remove(current.size()-1);
                visited[i] = false;
                
            }
        }
    }
	public static void main(String[]args)
	{
		int p[] = {-1,-1,3,-1,-1,-1,-1,-1,-1};
		Iterator<List<Integer>> it = permuteUnique(p).iterator();
		while(it.hasNext())
		{
			Iterator<Integer> myit = it.next().iterator();
			while(myit.hasNext())
			{
				System.out.println(myit.next()+",");
			}
			System.out.println();
			
		}
		
		
	}
    
    
}



//public class Solution {
//	public static List<List<Integer>> permuteUnique(int[] nums) {
//		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
//		int length = nums.length;
//
//		if (length == 0)
//			return result;
//		if (length == 1) {
//			ArrayList<Integer> temp = new ArrayList<Integer>();
//			temp.add(nums[0]);
//			result.add(temp);
//			return result;
//		} else {
//			int n = nums.length - 1;
//
//			int next[] = new int[n];
//			System.arraycopy(nums, 0, next, 0, n);
//
//			List<List<Integer>> temp = permuteUnique(next);
//
//			for (List<Integer> list : temp) // for each list in the result, we
//											// add a new element
//			{
//
//				int listlength = list.size();
//				for (int i = 0; i <= listlength; i++) // insert in each possible
//														// position
//				{
//					ArrayList<Integer> cur = new ArrayList<Integer>(list);
//					// first check whether the current one is the same as the
//					// current one
//					if (i < listlength) {
//						if (list.get(i) != nums[nums.length - 1]) {
//							cur.add(i, nums[nums.length - 1]);
//							result.add(cur);
//						} else {// if the current one equals the target
//								// if the current one equals the previous one
//							if (i == 0) {
//								cur.add(i, nums[nums.length - 1]);
//								result.add(cur);
//
//							} else {
//								if (cur.get(i) != cur.get(i - 1)) {
//									cur.add(i, nums[nums.length - 1]);
//									result.add(cur);
//								}
//							}
//
//						}
//					} else {
//						if (listlength == 1) {
//							if (cur.get(i - 1) != nums[nums.length - 1]) {
//								cur.add(nums[nums.length - 1]);
//								result.add(cur);
//							}
//
//						} else {
//							if (cur.get(i - 1) == nums[nums.length - 1]) {
//								if (cur.get(i - 1) != cur.get(i - 2)) {
//									cur.add(i, nums[nums.length - 1]);
//								}
//
//							} else {
//								cur.add(i, nums[nums.length - 1]);
//								result.add(cur);
//							}
//						}
//
//					}
//
//				}
//
//			}
//
//		}
//
//		return result;
//	}
//	
//	public static void main(String[]args)
//	{
//		int p[] = {-1,-1,3,-1,-1,-1,-1,-1,-1};
//		Iterator<List<Integer>> it = permuteUnique(p).iterator();
//		while(it.hasNext())
//		{
//			Iterator<Integer> myit = it.next().iterator();
//			while(myit.hasNext())
//			{
//				System.out.println(myit.next()+",");
//			}
//			System.out.println();
//			
//		}
//		
//		
//	}
//	
//	
//}
