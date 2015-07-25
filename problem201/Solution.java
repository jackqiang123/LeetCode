package problem201;

//Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
//
//For example, given the range [5, 7], you should return 4.

public class Solution {
	public static int rangeBitwiseAnd(int m, int n) {
		int result = 0;
		int bit = 0;
		int num = m;
		if (m == Integer.MAX_VALUE && n == m) return m;
		while (num > 0) {
			num = num >> 1;
			bit++;
		}
		num = n;
		int nbit = 0;
		while (num > 0) {
			num = num >> 1;
			nbit++;
		}
		if (nbit > bit) return 0; 
//		System.out.println(bit);
		for (int i = 0; i < bit; i++) { // System.out.println((n>>1)<=m);

		
			if((m>>(bit - 1 -i)) == 0 && (n>>(bit - 1 -i)) == 1){
				result = result << (bit - i - 1);
				return result;
			}
			//System.out.println("the current resut is " + result);
			int currentbit = (m>>(bit - 1 -i))&(n>>(bit - 1 -i));
			result += currentbit;
			result = result << 1;
			//System.out.println("the current resut is " + result);
			m = m & (~(1 << ((bit - i - 1))));
			n = n & (~(1 << ((bit - i - 1))));
		//	System.out.println("the current resut is " + m + " *----* " + n);
		}
		return result>>1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(1 & 2);
		System.out.println(rangeBitwiseAnd(11, 13));
	}

}
