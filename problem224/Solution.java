package problem224;

import java.util.Stack;

//mplement a basic calculator to evaluate a simple expression string.
//
//The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
//
//You may assume that the given expression is always valid.
//
//Some examples:
//"1 + 1" = 2
//" 2-1 + 2 " = 3
//"(1+(4+5+2)-3)+(6+8)" = 23
//Note: Do not use the eval built-in library function.
public class Solution {
	public static int calculate(String s) {
		s = s.trim();
		int res = 0;
		int len = s.length();
		if (len == 0)
			return 0;
		int cur = 0;
		boolean newnum = false;
		Stack<Integer> num = new Stack<Integer>();
		Stack<Character> ope = new Stack<Character>();
		for (int i = 0; i < len ;i++)
		{
			char ch = s.charAt(i);
			if (ch == ' ') continue;
			if (Character.isDigit(ch))
			{	newnum = true;
				cur = cur * 10 + ch - '0';
				if (i == len-1) 
					num.push(cur);
				continue;
			}
			else 
			{	if (newnum)
					num.push(cur);
					//System.out.println("int stack " + num.peek());
				cur = 0; newnum = false;
			}
			
			
			if (ch == '(' || ch == '+' || ch =='-')
			{
				ope.push(ch); continue;
			}
			
			
			
			if (ch == ')')
			{
				int temp = 0;
				while(true)
				{
					char oper = ope.pop();					
					if (oper == '(')
					{
						num.push(num.pop() + temp);
						//System.out.println("after ()" + (num.peek()));
						break;
					}
					else
					{
						if (oper == '+') temp+=num.pop();
						else temp = -num.pop()+temp;
					}
					
				}
				
			}
		}	
//		for (int i : num)
//			System.out.println(i);
		
		if (ope.isEmpty()) return num.pop();
		
		while(!ope.isEmpty())
		{
		
			char oper = ope.pop();
			if (oper == '+') res = res + num.pop();
			else res = res - num.pop();
			
			
		}
		//System.out.println(num.peek());
		res = res + num.pop();
		
		
		return res;
	}

	public static void main(String[] args) {
		System.out.println(calculate(" 0"));
	}
}
