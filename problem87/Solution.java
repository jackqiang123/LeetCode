package problem87;

import java.util.Arrays;

//Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
//
//Below is one possible representation of s1 = "great":
//
//    great
//   /    \
//  gr    eat
// / \    /  \
//g   r  e   at
//           / \
//          a   t
//To scramble the string, we may choose any non-leaf node and swap its two children.
//
//For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
//
//    rgeat
//   /    \
//  rg    eat
// / \    /  \
//r   g  e   at
//           / \
//          a   t
//We say that "rgeat" is a scrambled string of "great".
//
//Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
//
//    rgtae
//   /    \
//  rg    tae
// / \    /  \
//r   g  ta  e
//       / \
//      t   a
//We say that "rgtae" is a scrambled string of "great".
//
//Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
public class Solution {
    public static boolean isScramble(String s1, String s2) {
    int len = s1.length();
    if (s1.equals(s2)) return true;
    if (len == 0) return true;
    if (len == 1) return s1.equals(s2);
  //  System.out.println("we are dealing with string " + s1 + ", and , " + s2);
    char []a1 = s1.toCharArray();
    Arrays.sort(a1);
//    String a = new String(a1);
  //  System.out.println("we are dealing with string1 " + a);
    char []a2 = s2.toCharArray();
    Arrays.sort(a2);
  //  String b = new String(a2);
  //  System.out.println("we are dealing with string2 " + b);
    if (new String(a1).equals(new String(a2)) == false) return false;
    
    
    for (int i = 1; i<len; i++)
    {
    	if (isScramble(s1.substring(0, i),s2.substring(0, i)) && isScramble(s1.substring(i),s2.substring(i)))
    		return true;
    	
    	if (isScramble(s1.substring(0, i),s2.substring(len - i)) && isScramble(s1.substring(i),s2.substring(0, len-i)))
    		return true;
    }
    return false;
    
    	
    }
	public static void main(String[] args) {
	String s1= "abc";
	String s2 = "bca";
	System.out.println(isScramble(s1,s2));
	}

}
