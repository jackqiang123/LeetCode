package problem238;

import java.util.Arrays;

//Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
//Solve it without division and in O(n).
//
//For example, given [1,2,3,4], return [24,12,8,6].
//
//Follow up:
//Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
public class Solution {
    public int[] productExceptSelf(int[] nums) {
    int len = nums.length;
    int [] res = new int[len];
    int [] revoder = new int[len];    
    if (len == 0) return res;
    res[0] = 1;
    for (int i = 1; i < len ; i++)
    {
    	res [i] = res[i-1]*nums[i-1];
    }
    revoder[len-1] = 1;
    for (int j = len-2; j >=0; j--)
    {
    	revoder[j] = revoder[j+1] * nums[j+1];
    	res [j] = res[j] * revoder[j];
    }
    res[len-1] *= revoder[len-1];
    return res;
    }
}
