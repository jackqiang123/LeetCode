package problem200;
//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
//Example 1:
//
//11110
//11010
//11000
//00000
//Answer: 1
//
//Example 2:
//
//11000
//11000
//00100
//00011
//Answer: 3
public class Solution {
    public static int numIslands(char[][] grid) {
    	int height = grid.length;
    	if (height == 0) return 0;
    	int width = grid[0].length;
    	int landmark = 0;
    	int [][] visited = new int [height][width]; // 0 is unvisited, -1 is water
    	for (int i = 0; i<height;i++)
    		for (int j = 0; j< width; j++)
    			if(visited[i][j] == 0 && grid[i][j] == '1')  // not visited land
    			{	
    				landmark++;

    			bfs(grid,i,j,visited,landmark);	//dfs the current node if it has not been visited}
    			}
    	

    	return landmark;
        
    }
	private static void bfs(char[][] grid, int i, int j, int[][] visited,int landmark) {
		if (i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == '0' || visited[i][j] > 0) //invalid index
			return; 
	//	System.out.println("going to visit" + i +","+j);
		visited[i][j] = landmark;
		bfs(grid,i-1,j,visited,landmark);	
		bfs(grid,i+1,j,visited,landmark);
		bfs(grid,i,j-1,visited,landmark);
		bfs(grid,i,j+1,visited,landmark);
	}
//	private static int visit(char[][] grid, int i, int j, int[][] visited) {
//		if (grid[i][j] == '0') return -1;
//	
//		if (i-1>=0 && i-1<grid.length && j>=0 && j<grid[0].length && visited[i-1][j]>0)
//			return visited[i-1][j];
//		if (i+1>=0 && i+1<grid.length && j>=0 && j<grid[0].length && visited[i+1][j]>0)
//			return visited[i+1][j];
//		if (i>=0 && i<grid.length && j-1>=0 && j-1<grid[0].length && visited[i][j-1]>0)
//			return visited[i][j-1];
//		if (i>=0 && i<grid.length && j+1>=0 && j+1<grid[0].length && visited[i][j+1]>0)
//			return visited[i][j+1];
//		result++;
	//	return landmark;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char [][] p = new char[4][5];
		p[0] = "1110".toCharArray();
		p[1] = "11010".toCharArray();
		p[2] = "11000".toCharArray();
		p[3] = "00000".toCharArray();
		System.out.println(numIslands(p));
		}

}
