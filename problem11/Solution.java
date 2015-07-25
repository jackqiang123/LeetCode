package problem11;
//Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
//Find two lines, which together with x-axis forms a container, such that the container contains the most water.
public class Solution {
    public static int maxArea(int[] height) {
    	int start = 0;
    	int end = height.length-1;
    	int currentcapacity = min(height[start],height[end])*(end-start);
    	while(start < end)
    	{
    		if (height[start]>height[end])
    			end--;
    		else start++;
    		
    		int capacity = min(height[start],height[end])*(end-start);
    		System.out.println(capacity);
    		if (capacity>currentcapacity) currentcapacity = capacity; 
    	}
        return currentcapacity;
    }

	private static int min(int i, int j) {
		// TODO Auto-generated method stub
		if (i>=j) return j;
		else return i;
		
	}
	public static void main(String[]args)
	{
		int p [] = {1,2,4,3};
		maxArea(p);
	}
	
}