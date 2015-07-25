package problem172;
//Given an integer n, return the number of trailing zeroes in n!.
//
//Note: Your solution should be in logarithmic time complexity.
public class Solution {
	public static int trailingZeroes(int n) {
		if (n < 5)
			return 0;

		// first, detminer the must 5^m.

		int num = n;
		int m = 0;
		int count = 0;
		while (num / 5 >= 1) {
			num = num / 5;
			m++;
		}
		// System.out.println(m);
		for (int i = 1; i <= m; i++) {

			count = count + (int) (n / Math.pow(5, i));

		}

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trailingZeroes(25));
	}

}
