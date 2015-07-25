package N_QueensII;

//Follow up for N-Queens problem.
//
//Now, instead outputting board configurations, return the total number of distinct solutions.
public class Solution {

	private int N;

	public int totalNQueens(int n) {
		if (n == 1)
			return 1;
		if (n <= 3)
			return 0;
		int[][] board = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				board[i][j] = 0;

		enumate(board, 0);
		return this.N;

	}

	private void enumate(int[][] board, int line) // current board and current
													// line
	{
		if (line == board.length) {
			// System.out.println("we add a result");
			// addtoresput(board);
			N++;
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

}
