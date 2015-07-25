package problem96;

//Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
//
//For example,
//Given n = 3, there are a total of 5 unique BST's.
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
public class Solution {
	public static int numTrees(int n) {
		if (n == 0 || n == 1)
			return 1;
		int[] output = new int[n + 1];
		output[0] = 1;
		for (int i = 1; i <= n; i++)
			for (int j = 0; j < i; j++)
				output[i] = output[i] + output[j] * output[i-j-1];

		return output[n];

	}
	public static void main(String []args)
	{
		System.out.println(numTrees(3));
	}
}
