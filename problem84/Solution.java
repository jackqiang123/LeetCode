package problem84;

import java.util.Stack;

//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
//
//
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//
//
//The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
//For example,
//Given height = [2,1,5,6,2,3],
//return 10.
public class Solution {
    public static int largestRectangleArea(int[] h) {
    int len = h.length;
    if (len == 0) return 0;
    int currentmax = h[0];
    Stack<Integer> mystack = new Stack<Integer>();
    int index = 0;
    while(index<len)
    {
    	if (mystack.isEmpty() || h[mystack.peek()] < h[index]) {mystack.push(index);index++;continue;}
    	
    	int curindex = mystack.pop();
    	
    	int height = h[curindex];
    	
    	int left = mystack.isEmpty()? -1:mystack.peek();
    	int width = index - left - 1;
    //	System.out.println("the height is " + height + " and the width is " + width);	
    	currentmax = Math.max(currentmax, height*width);
    	
    	
    	
    }
    while(!mystack.isEmpty())
    {
    	int curindex = mystack.pop();
    	
    	int height = h[curindex];
    	
    	int left = mystack.isEmpty()? -1:mystack.peek();
    	int width = index - left - 1;
  // 	System.out.println("the height is " + height + " and the width is " + width);	
    	currentmax = Math.max(currentmax, height*width);
    }
    return currentmax;
    }
    public static void main(String[]args)
    {
    	int [] p = {2,1,5,6,2,3};
    	System.out.println(largestRectangleArea(p));
    }
}
