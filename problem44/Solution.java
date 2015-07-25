package problem44;
//'?' Matches any single character.
//'*' Matches any sequence of characters (including the empty sequence).
//
//The matching should cover the entire input string (not partial).
//
//The function prototype should be:
//bool isMatch(const char *s, const char *p)
//
//Some examples:
//isMatch("aa","a") → false
//isMatch("aa","aa") → true
//isMatch("aaa","aa") → false
//isMatch("aa", "*") → true
//isMatch("aa", "a*") → true
//isMatch("ab", "?*") → true
//isMatch("aab", "c*a*b") → false
public class Solution {
    public static boolean isMatch(String s, String pattern) {
     int i = 0;
     int j = 0;
     int start = -1;
     int mark = -1;
     while(i < s.length())
     {
    	 if (j < pattern.length() && (s.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?'))
    	 {
    		 i++;j++; //matches, advance
    	 }
    	 else if (j < pattern.length() && pattern.charAt(j) == '*')
    	 {
    		 start = j; // find j is a * .remember this start
    		 j++;
    		 mark = i;
    	 }
    	 else if (start != -1) // current position is not matches, but we have a *
    	 {
    		 j = start + 1;
    		 mark++;
    		 i = mark;
    	 }
 
    	 else return false;
     }
   	 while(j<pattern.length() && pattern.charAt(j) == '*') j++;
    return j == pattern.length();
    }
    public static void main(String[]args)
    {String s = "ag34aa";
    String p = "a*a";
    	System.out.println(isMatch(s,p));
    }
}
