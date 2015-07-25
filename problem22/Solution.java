package problem22;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//For example, given n = 3, a solution set is:
//
//"((()))", "(()())", "(())()", "()(())", "()()()"
public class Solution {
	public static List<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		if (n==0) return result;
		int left = n;
		int right = n;
		String pair = "(";
		dfs(result, pair, left - 1, right);

		return result;

	}

	private static void dfs(ArrayList<String> result, String pair, int left,
			int right) {
		if (right == 0 && left == 0) {
			result.add(pair);
			return;
		} else {
			if (left > right)
				return;
			else {
				if (left > 0) {
					dfs(result, pair + "(", left - 1, right);

				}
				if (right > 0) {
					dfs(result, pair + ")", left, right - 1);

				}

			}

		}

	}

	public static void main(String[] args) {
		ArrayList<String> p = (ArrayList<String>) generateParenthesis(3);
		Iterator<String> it = p.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}