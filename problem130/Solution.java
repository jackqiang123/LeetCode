package problem130;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
//
//A region is captured by flipping all 'O's into 'X's in that surrounded region.
//
//For example,
//X X X X
//X O O X
//X X O X
//X O X X
//After running your function, the board should be:
//
//X X X X
//X X X X
//X X X X
//X O X X
class Node {
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	public static void solve(char[][] board) {
		int hei = board.length;
		if (hei == 0)
			return;
		int width = board[0].length;
	//	boolean bounardy[][] = new boolean[hei][width];
		// boolean visited[][] = new boolean[hei][width];

		for (int i = 0; i < hei; i++) {

			if (board[i][0] == 'O')
				bfs(board, i, 0);

			if (board[i][width - 1] == 'O')
				bfs(board, i, width - 1);
		}

		for (int j = 0; j < width; j++) {
			if (board[0][j] == 'O')
				bfs(board, 0, j);
			if (board[hei - 1][j] == 'O')
				bfs(board, hei - 1, j);
		}

		// for (int i = 0; i < hei; i++)
		// for (int j = 0; j < width; j++)
		// System.out.println(bounardy[i][j]);

		for (int i = 0; i < hei; i++)
			for (int j = 0; j < width; j++)
			{	if (board[i][j] == 'B')
					board[i][j] = 'O';
				else if (board[i][j] == 'O')
					board[i][j] = 'X';
			}
	}

	private static void bfs(char[][] board, int i, int j) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'X')
			return;

		int hei = board.length;
		int width = board[0].length;

		Stack<Node> queue = new Stack<Node>();
		queue.push(new Node(i, j));
		while (queue.isEmpty() == false) {
			Node n = queue.pop();
			// System.out.println(n.x + "," + n.y);
			board[n.x][n.y] = 'B';
			// visited[n.x][n.y] = true;
			if (n.x >= 1 && board[n.x - 1][n.y] == 'O')
				queue.push(new Node(n.x - 1, n.y));
			if (n.x + 1 < hei && board[n.x + 1][n.y] == 'O')
				queue.push(new Node(n.x + 1, n.y));
			if (n.y - 1 >= 0 && board[n.x][n.y - 1] == 'O')
				queue.push(new Node(n.x, n.y - 1));
			if (n.y + 1 < width && board[n.x][n.y + 1] == 'O')
				queue.push(new Node(n.x, n.y + 1));
		}

	}

	public static void main(String[] args) {
		char[][] p = { "OO".toCharArray(), "OO".toCharArray() };
		solve(p);
	}
}
