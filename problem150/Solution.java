package problem150;

import java.util.Stack;

//Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
//Some examples:
//  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
public class Solution {
    public int evalRPN(String[] tokens) {
     Stack<Integer> mystack = new Stack<Integer>();   
     for (String s : tokens)
     {
    	 	if (s.equals("+") || s.equals("-") || s.equals("*") ||s.equals("/") )
    	 	{
    	 	int x2 = mystack.pop();
    	 	int x1 = mystack.pop();
    	 	if (s.equals("+")) mystack.push(x1+x2);
    	 	else if (s.equals("-")) mystack.push(x1-x2);
    	 	else if (s.equals("*")) mystack.push(x1*x2);
    	 	else mystack.push(x1/x2);
    	 	}
    	 	else 
    	 	{
    	 		mystack.push(Integer.parseInt(s));
    	 	}
     }
     return mystack.pop();
    }
    public static void main(String[]args)
    {
    	
    }
}
