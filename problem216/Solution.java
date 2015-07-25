package problem216;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Find all possible combinations of k numbers that add up to a number n, given that only numbers 
//from 1 to 9 can be used and each combination should be a unique set of numbers.
//
//Ensure that numbers within the set are sorted in ascending order.
//
//
//Example 1:
//
//Input: k = 3, n = 7
//
//Output:
//
//[[1,2,4]]
//
//Example 2:
//
//Input: k = 3, n = 9
//
//Output:
//
//[[1,2,6], [1,3,5], [2,3,4]]

public class Solution {
public static List<List<Integer>> combinationSum3(int k, int n) {
	
	List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> cur = new ArrayList<Integer>();
    int start = 1;
    int target = n;
    int num = k;
	recu(result,cur,start,num,target);
	return result;
    }

private static void recu(List<List<Integer>> result, List<Integer> cur, int start,
		int num, int target) {
	
	if (target==0 && num == 0) {
//		System.out.println("we add a result");
		List<Integer> mycur = new ArrayList<Integer>(cur); 
//		
//		
//		Iterator<Integer> it = cur.iterator();
//		while (it.hasNext()) {{
//			
//				System.out.print(it.next() + ", ");
//			}
//			System.out.println();
//		}
		
		result.add(mycur); return;}
	if (num<0) return;
	if (target<0) return;
	else{
		
		for (int i = start; i<=9;i++)
		{
			cur.add(i);
			recu(result,cur,i+1,num-1,target-i);
			cur.remove(cur.size()-1);
		}
		
		
	}
	
	
}


public static void main(String[]args)
{	ArrayList<List<Integer>> result = (ArrayList<List<Integer>>) combinationSum3(
		3, 9);
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
