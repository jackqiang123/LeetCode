package problem227;

import java.util.LinkedList;
import java.util.Stack;

//Implement a basic calculator to evaluate a simple expression string.
//
//The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
//
//You may assume that the given expression is always valid.
//
//Some examples:
//"3+2*2" = 7
//" 3/2 " = 1
//" 3+5 / 2 " = 5
public class Solution {
	public static int calculate(String s) {
		Stack<Integer> numstack = new Stack<Integer>();
		Stack<String> operstack = new Stack<String>();
		s = s.replaceAll(" ", "");
		String[] num = s.split("\\+|-|\\*|/");
//		for (String i : num) {
//			System.out.println(i);
//		}
		String[] op = s.split("[0-9]+");

//		for (String i : op) {
//			System.out.println(i);
//		}

		String input[] = new String[num.length * 2 - 1];
		input[0] = num[0];
		for (int i = 1; i < num.length; i = i + 1) {
			input[2 * i - 1] = op[i];
			input[2 * i] = num[i];
		}
//		for (String i : input) {
//			System.out.println(i);
//		}

		for (int i = 0; i < input.length; i++) {
			String current = input[i];
		//	System.out.println("the currernt i is " + i);
			if (current.equals("+") || current.equals("-")
					|| current.equals("*") || current.equals("/")) {
				if (operstack.isEmpty())
					operstack.push(current);
				else {
				//	System.out.println("the current top of oper is " + operstack.peek());
					while (operstack.peek().equals("*")
							|| operstack.peek().equals("/")) {
						int nlater = numstack.pop();
						int nfirst = numstack.pop();
						if (operstack.peek().equals("*")) {
							operstack.pop();
							numstack.push(nlater * nfirst);
						//	System.out.println("push back the number " + numstack.peek()  + " and the top of oper is " + operstack.peek() );
						} else {
							operstack.pop();
							numstack.push(nfirst / nfirst);
						//	System.out.println("push back the number " + numstack.peek() + " and the top of oper is " + operstack.peek() );
						}
					}

					if (current.equals("*") || current.equals("/"))
					{	//System.out.println("push " + current);
						operstack.push(current);
						}
					else {
						while (!operstack.isEmpty()) {
							//System.out.println("the current oper is " + operstack.peek());
							int nlater = numstack.pop();
							int nfirst = numstack.pop();
							if (operstack.peek().equals("+"))
							{operstack.pop();	numstack.push(nlater + nfirst); 	//System.out.println("push back the number " + numstack.peek());
							}
							else
							{operstack.pop();	numstack.push(nfirst - nlater);}
						}
						operstack.push(current);
					}

				}

			}
			else numstack.push(Integer.parseInt(current));

		}
	//	System.out.println(operstack.isEmpty());
		while(operstack.isEmpty()==false)
		{
		int nlater = numstack.pop();
		int nfirst = numstack.pop();
		String current = operstack.pop();
	//	System.out.println("the current op os " + current); 
		if (current.equals("*")) numstack.push(nfirst*nlater);
		else if (current.equals("/")) numstack.push(nfirst/nlater);
		else if (current.equals("-")) numstack.push( nfirst-nlater);
		else numstack.push(nfirst+nlater);
		}
		return numstack.pop();
	}

	public static void main(String[] args) {
		System.out.println(calculate("0-2147483648"));
		// System.out.println('+' == '+');
	}
}
