package problem207;

import java.util.HashMap;
import java.util.List;

//There are a total of n courses you have to take, labeled from 0 to n - 1.
//
//Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
//
//For example:
//
//2, [[1,0]]
//There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
//
//2, [[1,0],[0,1]]
//There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
//
//Note:
//The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
public class Solution {

    private static boolean[] flag;
	public static boolean canFinish(int num, int[][] prerequisites) {
    	boolean [][] adj = new boolean [num][num];
    	for (int i = 0; i < prerequisites.length; i++)
    	{
    		int dest =  prerequisites[i][0];
    		int source = prerequisites[i][1];
    		adj[source][dest] = true;
    	}
//    	for (int i = 0; i < adj.length; i++)
//    	{
//    		for (int j =0; j< adj[0].length; j++)
//    			System.out.print(adj[i][j] + " ");
//    		System.out.println();
//    	}
    	boolean []visited = new boolean [num];
    	flag = new boolean [num];
    	for (int i = 0; i < num; i++)
    	{	
    	if (!flag[i])
    		if (hasCycle(i,visited,adj))
    			return false;
    	}
    	return true; 	
    }
	private static boolean hasCycle(int start, boolean[] visited, boolean[][] adj) {
		visited[start] = true;

	//	System.out.println("current checking " + start);
		for (int i = 0; i < visited.length; i++)
		{
			
			if (adj[start][i] && (visited[i]|| hasCycle(i,visited,adj) ))
			{	//System.out.println("I am going to say it has cycle " + start); 
			return true;}
		}
	//	System.out.println("I am going to say it has no cycle " + start);
		visited[start] = false;
		flag[start] = true;
		return false;
	}
	public static void main(String[]args)
	{
		int[][]p =  {{0,1}};
		System.out.println(canFinish(2,p));
		
	}
}
