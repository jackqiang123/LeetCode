package problem214;

//Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
//
//For example:
//
//Given "aacecaaa", return "aaacecaaa".
//
//Given "abcd", return "dcbabcd".
//
//Credits:
public class Solution {
    public static String shortestPalindrome(String s) {
	if (s.length()<=1) return s;
	String curs = s + " " + new StringBuilder(s).reverse().toString();
	int trace [] = new int [curs.length()];
	for (int i = 1; i<trace.length; i++ )
	{
		int curindex = trace[i-1];
		while(curindex > 0 && curs.charAt(curindex) != curs.charAt(i))
		{
			curindex = trace[curindex - 1];
		}
		if (curs.charAt( curindex) == curs.charAt(i))
			trace[i] = curindex + 1;
	}
	
	return new StringBuilder(s.substring(trace[trace.length-1])).reverse().toString()+s;
    	
    	
    }
//	    public static String shortestPalindrome(String s) {
//	        if(s.length() <= 1){ return s; }
//	        String curs = s + " " + new StringBuilder(s).reverse().toString();
//	        int[] trace = new int[curs.length()];
//	        for(int i = 1 ; i < curs.length() ; i++){
//	            int curindex = trace[i-1];
//	            while(curindex > 0 && curs.charAt(curindex) != curs.charAt(i)){
//	                curindex = trace[curindex-1];
//	            }
//	            if(curs.charAt(curindex) == curs.charAt(i)){
//	                trace[i] = curindex+1;
//	            }
//	        }
//	        return new StringBuilder(s.substring(trace[curs.length()-1])).reverse().toString() + s;
//	    }
	
//	public static String shortestPalindrome(String s) {
//		StringBuilder s1 = new StringBuilder(s);
//
//		int count = s1.length();
//		while (!isPali(s1,count)) {
//			count--;
//		}
//
//		String app = s1.substring(count);
//		StringBuilder a = new StringBuilder(app);
//		
//		return a.reverse().toString() + s;
//
//	}
//
//	private static boolean isPali(StringBuilder s1, int count) {
//		if (count == 1)
//			return true;
//		int left = 0;
//		int right = count - 1;
//		while (left < right) {
//			if (s1.charAt(left) != s1.charAt(right))
//				return false;
//			left++;
//			right--;
//		}
//		return true;
//	}

	public static void main(String[] args) {
		System.out.println(shortestPalindrome("abcd"));
	}

}
