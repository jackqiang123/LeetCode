package problem57;

import java.util.LinkedList;
import java.util.List;

import Interval.Interval;

//Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//
//You may assume that the intervals were initially sorted according to their start times.
//
//Example 1:
//Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
//
//Example 2:
//Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
//
//This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	int nleft = newInterval.start;
    	//int nright = newInterval.end;
    	int index = 0;
    	boolean isInsert = false;
    	for (Interval i : intervals)
    	{
    		if (i.start >= nleft) // find the position to insert newInterval
    			{
    			isInsert = true;
    			intervals.add(index, newInterval);break;
    			
    			}
    		else index++;
    	}
        if (isInsert == false) intervals.add(index, newInterval);
        
        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
        
        
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
