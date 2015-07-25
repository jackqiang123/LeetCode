package problem210;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//There are a total of n courses you have to take, labeled from 0 to n - 1.
//
//Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
//
//There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
//
//For example:
//
//2, [[1,0]]
//There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
//
//4, [[1,0],[2,0],[3,1],[3,2]]
//There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. 
//Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
public class Solution {
	public static int[] findOrder(int numCourses, int[][] pre) {
		int[] result = new int[numCourses];
		int[] precount = new int[numCourses];
		if (pre.length == 0)
		{	
			for (int i = 0; i < numCourses; i++)
				result[i] = i;
			return result;}

		HashMap<Integer, LinkedList<Integer>> mymap = new HashMap<Integer, LinkedList<Integer>>();
		for (int i = 0; i < pre.length; i++) {// from pre to dest course
			int key = pre[i][1];
			int val = pre[i][0];
			if (!mymap.containsKey(key))
				mymap.put(key, new LinkedList<Integer>());
			mymap.get(key).add(val);
			precount[val]++;
		}
		Queue<Integer> myqueue = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (precount[i] == 0)
				myqueue.offer(i);
		}
		int index = 0;
		while (!myqueue.isEmpty()) {
			int c = myqueue.poll();
			result[index++] = c;
			if (mymap.get(c)!=null)
			for (int k : mymap.get(c)) {
				precount[k]--;

				if (precount[k] == 0)
					myqueue.offer(k);

			}

		}
		for (int i : precount)
		{
			if (i != 0)
				return new int[0];
		}
	
		
		return result;
	
	
	}
	public static void main(String[]args)
	{
		int [][]p = {{1,0},{2,0},{3,1},{3,2}};
		int [] r = findOrder(4,p);
		for (int c : r)
			System.out.println(c);
	}
}
