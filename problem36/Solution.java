package problem36;

import java.util.HashSet;

//etermine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
//
//The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
public class Solution {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			if (!checkbyindex(board, 0, i, 8, i))
				return false;
			if (!checkbyindex(board, i, 0, i, 8))
				return false;
		}

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				if (!checkbyindex(board, i * 3, j * 3, i * 3 + 2, j * 3 + 2))
					return false;
			}

		return true;

	}

	private boolean checkbyindex(char[][] board, int x1, int y1, int x2, int y2) {
		HashSet<Character> myset = new HashSet<Character>();
		
		for (int i = x1; i<=x2; i++)
			for (int j = y1; j<=y2; j++)
			{
				if (board[i][j]!='.')
					if (myset.add(board[i][j]) == false) return false;
				
			}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
