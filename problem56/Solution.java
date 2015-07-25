package problem56;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import Interval.Interval;

//Given a collection of intervals, merge all overlapping intervals.
//
//For example,
//Given [1,3],[2,6],[8,10],[15,18],
//return [1,6],[8,10],[15,18].
class Index implements Comparable<Index> {
	int x;
	boolean left = true;

	Index(int x, boolean l) {
		this.x = x;
		this.left = l;
	}

	public int compareTo(Index that) {
		if (this.x > that.x)
			return 1;
		else if (this.x < that.x)
			return -1;
		else {
			if (!this.left && that.left)
				return 1;
			else if (this.left && !that.left)
				return -1;
		}
		return 0;
	}
}

public class Solution {

	public static List<Interval> merge(List<Interval> intervals) {
		int length = intervals.size() * 2;
		Index[] myindex = new Index[length];
		int k = 0;
		for (Interval i : intervals) {
			//if(i.start == i.end) continue;
			myindex[k] = new Index(i.start, true);
			myindex[k + 1] = new Index(i.end, false);
			k += 2;
		}
		Arrays.sort(myindex);
		List<Interval> result = new LinkedList<Interval>();
		// boolean LastIsLeft = true;
		int lastleft = 0;
		int count = 1;
		for (int i = 1; i < myindex.length; i++) {

			if (myindex[i].left == true)
				count++;
			else
				count--;

			if (count == 0) // no match right end, i must be right
			{
				if (i == myindex.length - 1)
					result.add(new Interval(myindex[lastleft].x, myindex[i].x));
				else {

					if (myindex[i].x == myindex[i + 1].x)
						count++;
					else
						result.add(new Interval(myindex[lastleft].x,
								myindex[i].x));
					lastleft = i + 1;
				}

			}

		}

		return result;
	}
	public static void main(String[]args)
	{
		List<Interval> i = new LinkedList<Interval>();
		i.add(new Interval(2,3));	
		i.add(new Interval(5,5));	
		i.add(new Interval(2,2));	
		i.add(new Interval(3,4));
		i = merge(i);
		for (Interval p : i)
		{
			System.out.println(p.start+","+p.end);
			
		}
	}
}