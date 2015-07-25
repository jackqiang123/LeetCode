package problem97;

//import java.util.HashMap;

//Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
//
//For example,
//Given:
//s1 = "aabcc",
//s2 = "dbbca",
//
//When s3 = "aadbbcbcac", return true.
//When s3 = "aadbbbaccc", return false.
public class Solution {
	public static boolean isInterleave(String s1, String s2, String s3) {
		int len3 = s3.length();
		int len2 = s2.length();
		int len1 = s1.length();
		if (len3 != len2 + len1)
			return false;
		if (len1 == 0)
			return s3.equals(s2);
		if (len2 == 0)
			return s3.equals(s1);
		boolean[][] d = new boolean[len1 + 1][len2 + 1];
		// d[i][j] whether the s1(0,i) and s2(0,j) interleave s3(0,i+j)
		for (int i = 0; i <= len1; i++)
			d[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
		for (int i = 0; i <= len2; i++)
			d[0][i] = s2.substring(0, i).equals(s3.substring(0, i));
		for (int i = 1; i <= len1; i++)

			for (int j = 1; j <= len2; j++) // s2.sub(0,j)
			{
				char ca = s1.charAt(i-1);
				char cb = s2.charAt(j-1);
				char cc = s3.charAt(i + j -1);
				if (ca == cc && cb == cc)
					d[i][j] = d[i - 1][j] || d[i][j - 1];
				else if (ca == cc)
					d[i][j] = d[i - 1][j];
				else if (cb == cc)
					d[i][j] = d[i][j - 1];
				else
					d[i][j] = false;

			}

		return d[len1][len2];
	}

	// public static boolean isInterleave(String s1, String s2, String s3) {
	// int len3 = s3.length();
	// int len2 = s2.length();
	// int len1 = s1.length();
	// if (len3 != len2 + len1) return false;
	// if (len1 == 0) return s3.equals(s2);
	// if (len2 == 0) return s3.equals(s1);
	// // the following, none are zero
	// char cc = s3.charAt(len3-1) ;
	// char ca = s1.charAt(len1-1);
	// char cb = s2.charAt(len2-1);
	// if (cc == ca && cc == cb)
	// return isInterleave(s1.substring(0, len1-1),s2,s3.substring(0, len3-1))
	// || isInterleave(s1,s2.substring(0, len2-1),s3.substring(0, len3-1));
	// else if (cc == ca)
	// return isInterleave(s1.substring(0, len1-1),s2,s3.substring(0, len3-1));
	// else if (cc == cb)
	// return isInterleave(s1,s2.substring(0, len2-1),s3.substring(0, len3-1));
	// else return false;
	//
	// }
	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		System.out.println(isInterleave(s1, s2, s3));
	}
}
