package N_Queens;

import java.util.ArrayList;
import java.util.Iterator;

//Given an integer n, return all distinct solutions to the n-queens puzzle.
//
//Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//
//For example,
//There exist two distinct solutions to the 4-queens puzzle:
//
//[
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
public class Solution {

	private ArrayList<String[]> result = new ArrayList<String[]>();

	public ArrayList<String[]> solveNQueens(int n) {
		if (n == 1)
		{
			String []s = {"Q"};
			result.add(s);
		}
			
		
		
		if (n<=3)
			 return result;
		int[][] board = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				board[i][j] = 0;

		enumate(board, 0);
		return this.result;
	}

	private void enumate(int[][] board, int line) // current board and current
													// line
	{
		if (line == board.length) {
			// System.out.println("we add a result");
			addtoresput(board);
		}

		for (int i = 0; i < board.length; i++) {

			// System.out.println("we want to add a q at:" + line +" ,"+i);
			if (isAttack(board, line, i) == false) // whether attack if we put
			{
				// first clear this line
				for (int p = 0; p < board.length; p++) {
					board[line][p] = 0;
				}
				board[line][i] = 1; // put a queen
				enumate(board, line + 1); // it at line,i postion
			} else {
				// System.out.println("we fail in this track");
			}

		}

	}

	private void addtoresput(int[][] board) {
		// TODO Auto-generated method stub
		String[] currentresult = new String[board.length];
		for (int i = 0; i < board.length; i++) {
			String s = "";
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 1)
					s = s + "Q";
				else
					s = s + ".";
			}
			currentresult[i] = s;

		}
		this.result.add(currentresult);
		// System.out.println(currentresult);

	}

	public void printMatrix(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.printf("%4d", matrix[row][col]);
			}
			System.out.println();
		}
	}

	private boolean isAttack(int[][] board, int line, int j) {
		for (int i = 0; i < line; i++) // only check x direction and diagnoal
		{
			if (board[i][j] == 1) {
				// System.out.println("fail due to the same column see"+
				// i+","+j+"with value");
				// printMatrix(board);
				return true;
			}
			if (line - i - 1 >= 0) {
				if (j - i - 1 >= 0)
					if (board[line - i - 1][j - i - 1] == 1) {
						// System.out.println("fail due to the min d "+ (line -
						// i - 1)+","+(j - i - 1)+"with value");
						// printMatrix(board);
						return true;
					}
				if (j + i + 1 <= board.length - 1)
					if (board[line - i - 1][j + i + 1] == 1) {
						// System.out.println("fail due to the main d "+ (line -
						// i - 1)+","+(j + i + 1)+"with value");
						// printMatrix(board);
						return true;
					}

			}

		}
		return false;

	}

	public static void main(String[] args) {
		Solution p = new Solution();
		ArrayList<String[]> myresult = p.solveNQueens(4);
		Iterator<String[]> myit = myresult.iterator();
		while (myit.hasNext()) {
			String[] s = (String[]) myit.next();
			for (int i = 0; i < s.length; i++)
				System.out.println(s[i]);
			System.out.println();

		}

	}

}
