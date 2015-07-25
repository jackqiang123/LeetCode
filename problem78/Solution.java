package problem78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//Given a set of distinct integers, nums, return all possible subsets.
//
//Note:
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
//For example,
//If nums = [1,2,3], a solution is:
//
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
public class Solution {
public static List<List<Integer>> subsets(int[] nums) {
	ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
	ArrayList<Integer> cur = new ArrayList<Integer>();
	result.add(cur);
	Arrays.sort(nums);
	
	
	for (int i : nums)
	{
		int n =  result.size();
		//List<Integer> mylist = new ArrayList<Integer>();
		for (int j = 0; j<n;j++)
		{
			List<Integer> mylist = new ArrayList<Integer>(result.get(j));
			mylist.add(i);
			result.add(mylist);
			
		}
	//	result.add(mylist);
		
	}
	
	
	
	return result;
 }

//private static void dfs(ArrayList<List<Integer>> result,
//		ArrayList<Integer> cur, int[] nums, int start) {
//	
//	ArrayList<Integer> myresult = new ArrayList<Integer> (cur);
//	result.add(myresult);
//
//    Iterator<Integer> myit = cur.iterator();
//	while(myit.hasNext())
//	{
//		while(myit.hasNext())
//		{
//			System.out.print(myit.next() +",");
//		}
//		System.out.println();
//	}
//	
//	
//	
//	
//	for (int i = start;i < nums.length;i++)
//	{
//			
//		cur.add(nums[i]);
//		dfs(result,cur,nums,i+1);
//		cur.add(cur.size()-1);
//		//dfs(result,cur,nums,i+1);
//	}
//}
//	
//	
////	
////	    result.add(cur); // not participate the next round
////	    Iterator<Integer> myit = cur.iterator();
////		while(myit.hasNext())
////		{
////			while(myit.hasNext())
////			{
////				System.out.print(myit.next() +",");
////			}
////			System.out.println();
////		}
////	    if (i>=nums.length) return;
////	    cur.add(nums[i]);
////	    dfs(result,cur,nums,i+1);
////	    cur.remove(cur.size()-1);
////	   
////	
////	
////	
////}
//
//private static void dfsadd(ArrayList<List<Integer>> result, ArrayList<Integer> cur,
//		int[] nums, int start) {
//	if (start>=nums.length) return;
//	for (int i=start;i<nums.length;i++)
//	{
//		
//		dfsnotadd(result,cur,nums,i+1);
//		cur.add(nums[i]);
//		dfsadd(result,cur,nums,i+1);
//		cur.remove(cur.size()-1);	
//		
//	}
//	
//}
//
//private static void dfsnotadd(ArrayList<List<Integer>> result, ArrayList<Integer> cur,
//		int[] nums, int start) {
//
//	
//	
//	if (start>=nums.length) return;
//	for (int i=start;i<nums.length;i++)
//	{
//		
//		dfsnotadd(result,cur,nums,i+1);
//		cur.add(nums[i]);
//		dfsadd(result,cur,nums,i+1);
//		cur.remove(cur.size()-1);	
//		
//	}
//	// TODO Auto-generated method stub
//	
//}
//
public static void main(String []args)
{
	int p [] = {1,2,3};
	ArrayList<List<Integer>> result = (ArrayList<List<Integer>>) subsets(p);
	Iterator<List<Integer>> it = result.iterator();
	while(it.hasNext())
	{
		Iterator<Integer> myit = it.next().iterator();
		while(myit.hasNext())
		{
			System.out.print(myit.next() +",");
		}
		System.out.println();
	}

}


}
