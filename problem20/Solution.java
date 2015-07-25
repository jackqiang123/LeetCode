package problem20;

import java.util.Stack;

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
public class Solution {
	public static boolean isValid(String s) {

		int length = s.length();
		Stack<Character> Mystack = new Stack<Character>();
		for (int i = 0; i < length; i++) {
			char currentchar = s.charAt(i);
			if (Mystack.isEmpty()) {
				Mystack.push(currentchar);
			} else {
				if (currentchar == '(' || currentchar == '['
						|| currentchar == '{')
					Mystack.push(currentchar);
				else {
					if (currentchar == ')' && Mystack.peek() == '(')
						Mystack.pop();
					else if (currentchar == ']' && Mystack.peek() == '[')
						Mystack.pop();
					else if (currentchar == '}' && Mystack.peek() == '{')
						Mystack.pop();
					else
						return false;

				}

			}

		}
		if (Mystack.isEmpty())
			return true;
		else
			return false;

	}

	public static void main(String[] args) {
		String s = "((){})";
		System.out.println(isValid(s));
	}

}
