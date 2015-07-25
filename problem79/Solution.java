package problem79;
//Given a 2D board and a word, find if the word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. 
//The same letter cell may not be used more than once.
//
//For example,
//Given board =
//
//[
//  ["ABCE"],
//  ["SFCS"],
//  ["ADEE"]
//]
//word = "ABCCED", -> returns true,
//word = "SEE", -> returns true,
//word = "ABCB", -> returns false.
public class Solution {
public static boolean exist(char[][] board, String word) {
      
        
       // int length = word.length();
        for (int i = 0; i<board.length;i++)
    		for (int j = 0; j<board[0].length;j++)
    		{  
    		//	boolean visited[][]= new boolean[board.length][board[0].length];
    			if (dfs(board,word,i,j) == true)
    				return true;
    			
    		}
        
        return false;
    }

private static boolean dfs(char[][] board, String word,int i,int j) { // i,j is the position to be checked
	// TODO Auto-generated method stub
	if (word.isEmpty()) return true;
	
	if (i<0 || i>=board.length || j<0 || j>=board[0].length) return false; // invalid position
	if (board[i][j] == '*') return false;
	else if (board[i][j] != word.charAt(0)) return false;
	else
	{	char tempe = board [i][j] ;
		board [i][j] = '*';
		if (dfs(board,word.substring(1),i-1,j)) 
			return true;
		if (dfs(board,word.substring(1),i+1,j)) 
			return true;
		if (dfs(board,word.substring(1),i,j-1)) 
			return true;
		if (dfs(board,word.substring(1),i,j+1)) 
			return true;
		board [i][j] = tempe;
		return false;
		
		
	}
	
	
	// else, backtracking
	
	
}
public static void main(String[]args)
{
	
char board[][] = {"ABCD".toCharArray(),"SFCS".toCharArray(),"ADEE".toCharArray()};
System.out.println(exist(board,"ABCB")+"");
}

}
