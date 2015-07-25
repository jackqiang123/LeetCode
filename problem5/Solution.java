package problem5;

//Given a string S, find the longest palindromic substring in S. 
//You may assume that the maximum length of S is 1000, 
//and there exists one unique longest palindromic substring.
public class Solution {
	public static String longestPalindrome(String s) {

		if (isPali(s))
			return s;

		if (s.length() == 1)
			return s;

		String lastbest = longestPalindrome(s.substring(0, s.length() - 1));// 0
																			// to
																			// n-2,
																			// string
																			// length
																			// s-1
		// System.out.println("last best is " + lastbest);
		// System.out.println("current string is "+s);
		int length = lastbest.length();

		if (s.length() - 1 - length >= 0
				&& isPali(s.substring(s.length() - 1 - length, s.length()))) {
			// System.out.println("the test string is "+s.substring(s.length() -
			// 1- length, s.length()));

			return s.substring(s.length() - 1 - length, s.length());

		} else if (s.length() - 2 - length > 0) {
			if (isPali(s.substring(s.length() - 2 - length, s.length())))
				return s.substring(s.length() - 2 - length, s.length());

		}
		return lastbest;

		// System.out.println("I am where");
		// return "";

	}

	private static boolean isPali(String s) {

		StringBuilder str = new StringBuilder(s);

		return s.equals(str.reverse().toString());
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("aaaabaaa"));
	}

}
