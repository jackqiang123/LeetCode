package problem37;

import java.util.HashSet;
import java.util.Set;

//Write a program to solve a Sudoku puzzle by filling the empty cells.
//
//Empty cells are indicated by the character '.'.
//
//You may assume that there will be only one unique solution.
//
//
//A sudoku puzzle...
//

public class Solution {
	private boolean find = false;

	public void solveSudoku(char[][] board) {

		Set<Integer>[] allset = new HashSet[9];
		Set<Integer>[] rowset = new HashSet[9];
		Set<Integer>[] colset = new HashSet[9];
		for (int i = 0; i < 9; i++) {
			allset[i] = new HashSet<Integer>();
			rowset[i] = new HashSet<Integer>();
			colset[i] = new HashSet<Integer>();
		}
		// initialized
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {

					rowset[i].add(board[i][j] - '0');
					colset[j].add(board[i][j] - '0');
					allset[i / 3 * 3 + j / 3].add(board[i][j] - '0');
				}
			}

		backtracking(board, allset, colset, rowset, 0);

	}

	private void backtracking(char[][] board, Set<Integer>[] allset, Set<Integer>[] colset,
			Set<Integer>[] rowset, int i) {
		// TODO Auto-generated method stub
		// System.out.println("current is look at " + i);

		if (find == true)
			return;

		if (i == 81) {// System.out.println("return here");
			find = true;
			return;
		}

		int x = i / 9;
		int y = i % 9;
		// System.out.println("current is look at " + x + ", " + y);

		if (board[x][y] != '.') {// System.out.println("skip");
			backtracking(board, allset, colset, rowset, i + 1);
		}

		else {
			for (int j = 1; j <= 9; j++) {

				if (!allset[(x / 3) * 3 + y / 3].contains(j) && !rowset[x].contains(j) && !colset[y].contains(j)) {

					board[x][y] = (char) (j + '0');

					// char [][]p = board;
					// for (int ii = 0; ii < 9; ii++) {
					// for (int jj = 0; jj < 9; jj++)
					// System.out.print(p[ii][jj] + " ");
					// System.out.println();
					// }

					allset[(x / 3) * 3 + y / 3].add(j);
					rowset[x].add(j);
					colset[y].add(j);

					backtracking(board, allset, colset, rowset, i + 1);

					if (find == true)
						return;
					// System.out.println("fail at" + (i+1));

					allset[(x / 3) * 3 + y / 3].remove(j);
					rowset[x].remove(j);
					colset[y].remove(j);
					board[x][y] = '.';
				}

			}
		}

	}

	public static void main(String[] arrs) {

		char[][] p = { "53..7....".toCharArray(), "6..195...".toCharArray(), ".98....6.".toCharArray(),
				"8...6...3".toCharArray(), "4..8.3..1".toCharArray(), "7...2...6".toCharArray(),
				".6....28.".toCharArray(), "...419..5".toCharArray(), "....8..79".toCharArray() };
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				System.out.print(p[i][j] + "  ");
			System.out.println();
		}
		System.out.println("------");
		//solveSudoku(p);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				System.out.print(p[i][j] + "  ");
			System.out.println();
		}
		// System.out.println(1/3*3 + 5/3);
	}

}
