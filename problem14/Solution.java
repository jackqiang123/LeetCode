package problem14;

//Write a function to find the longest common prefix string amongst an array of strings.
public class Solution {
	public static String longestCommonPrefix(String[] strs) {
		int length = strs.length;
		if (length == 0)
			return "";
		
		int minStringlength = Integer.MAX_VALUE;
		for (int i = 0; i < length; i++) {
			if (minStringlength > strs[i].length())
				minStringlength = strs[i].length();
		}
		
		//System.out.println(minStringlength);
		if (minStringlength == 0) return "";
		for (int j = 1; j <= minStringlength; j++) {
			String prefix = strs[0].substring(0, j);
			for (String s : strs) {
				if (!prefix.equals(s.substring(0, j)))
					return prefix.substring(0, prefix.length() - 1);
			}
		}
		return strs[0].substring(0, minStringlength);
	}

	public static void main(String[] args) {
		String[] a = {""};

		System.out.println(longestCommonPrefix(a));
	}

}
