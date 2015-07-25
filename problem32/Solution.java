package problem32;

import java.util.Stack;

//Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//
//For "(()", the longest valid parentheses substring is "()", which has length = 2.
//
//Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
public class Solution {
    public static int longestValidParentheses(String s) {
    	Stack<Integer> mystack = new Stack<Integer>();
    	
    	for (int i = 0; i<s.length();i++)
    	{
    		char c = s.charAt(i);
    		
    		if (mystack.isEmpty()) mystack.push(i);
    		
    		else if (c == ')' && s.charAt(mystack.peek()) == '(') mystack.pop();
    		
    		else mystack.push(i);	
    	}
    	
    	if (mystack.isEmpty()) return s.length();
    	
    	int left = mystack.pop();
    	int right = s.length();
      	int currentbest = 0;
    	if (right - left -1 > currentbest) currentbest = right - left -1;
    //	System.out.println("left is " + left);
  
		while(true)
    	{
	//	System.out.println("left is " + left);
	//	System.out.println("right is " + right);
			if (mystack.isEmpty())
			{
				right = left;
				left = -1;
				if (right - left -1 > currentbest) currentbest = right - left -1;
				break;
				
			}
			
			else {
				
				right = left;
				left = mystack.pop();
				if (right - left -1 > currentbest) currentbest = right - left -1;
			}
			
	
    	}
    	
    	
    	
        return currentbest;
    }
    
    public static void main(String[] args) {
    	System.out.println(longestValidParentheses("(()))())("));
    }
}
