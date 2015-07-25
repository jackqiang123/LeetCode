package problem135;

import java.util.Arrays;

//There are N children standing in a line. Each child is assigned a rating value.
//
//You are giving candies to these children subjected to the following requirements:
//
//Each child must have at least one candy.
//Children with a higher rating get more candies than (either) their neighbors.
//What is the minimum candies you must give?
public class Solution {
    public int candy(int[] r) {
      int len = r.length;
      if (len == 0) return 0;
      int []candy = new int[len];
      Arrays.fill(candy, 1);
      for (int i = 1; i < len; i++)
      {
    	  	if (r[i-1] < r[i])
    	  		candy[i] = candy[i-1]+1;
      }
      for (int i = len-2; i >=0;i--)
      {
    	  if (r[i]>r[i+1] && candy[i]<=candy[i+1]) candy[i] = candy[i+1]+1;
      }
      int res = 0;
      for (int i : candy)
    	  res += i;
      return res;
    }
}
