package problem231;

//Given an integer, write a function to determine if it is a power of two.
//
//Credits:
//Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
public class Solution {
	public static boolean isPowerOfTwo(int n) {

		if (n <= 0) {
			return false;
		}

		while (n > 1) {
			if ((n & 1) == 1)
				return false;
			n = n >> 1;

		}
		return true;

	}

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(-4));
	}
}
