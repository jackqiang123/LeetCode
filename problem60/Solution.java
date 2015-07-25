package problem60;

import java.util.LinkedList;

//The set [1,2,3,…,n] contains a total of n! unique permutations.
//
//By listing and labeling all of the permutations in order,
//We get the following sequence (ie, for n = 3):
//
//"123"
//"132"
//"213"
//"231"
//"312"
//"321"
//Given n and k, return the kth permutation sequence.
//
//Note: Given n will be between 1 and 9 inclusive.
public class Solution {
public static String getPermutation(int n, int k) {

	StringBuilder result = new StringBuilder();
	int [] fact = new int[n];
	fact[0] = 1;
	for (int i = 1; i < n; i++)
		fact[i] = fact[i-1]*(i+1);
	LinkedList<Integer> num = new LinkedList<Integer>();
	for (int i = 1; i<=n; i++)
		num.add(i);
	int j = n-1;
	k = k-1;
	while(j!=0)
	{
		int ind = k/fact[j-1];
		
		result.append(num.get(ind));
		System.out.println("get the index is" + ind + " current string is " + result.toString());
		
		k = k%fact[j-1];
		System.out.println("the new index is "+n);
		
		num.remove(ind);
		j--;
		
		
	}
	result.append(num.get(0));
	return result.toString();


}


public static void main(String[]args)
{
	
	System.out.println(getPermutation(3,2));;
	}


}
