package problem151;
//Given an input string, reverse the string word by word.
//
//For example,
//Given s = "the sky is blue",
//return "blue is sky the".
//
//Update (2015-02-12):
//For C programmers: Try to solve it in-place in O(1) space.
//
//click to show clarification.
//
//Clarification:
//What constitutes a word?
//A sequence of non-space characters constitutes a word.
//Could the input string contain leading or trailing spaces?
//Yes. However, your reversed string should not contain leading or trailing spaces.
//How about multiple spaces between two words?
//Reduce them to a single space in the reversed string.
public class Solution {
    public static String reverseWords(String s) {
    	String ss = s.trim();
    	String[]r = ss.split("\\s+");
    	StringBuilder result = new StringBuilder();
    	for (int i = r.length-1; i>=0;i--)
    	{
    		result.append(r[i]);
    		if (i!=0)
    			result.append(" ");
    	}
    	return result.toString();
    			
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(reverseWords("the "));
	}

}
