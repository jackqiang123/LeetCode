package problem41;

public class Solution {
    public static int firstMissingPositive(int[] nums) { // put nums[i] to index nums[i], the missing number must be >k+1
    int len = nums.length;
    if (len == 0) return 1;
    int temp;
    int target;
    	for (int i = 0; i<len;i++)
    	{	target = nums[i]-1;
    		while(target != i && target <len && target >= 0 && nums[target]-1!=target)
    		{
    			temp = nums[i];
    			nums[i] = nums[target];
    			nums[target] = temp;
    			target = nums[i]-1;
    		}
    		
    	}
    	for (int i = 0; i< len; i++)
    	{
    		if (nums[i]-1!=i)
    			return i+1;
    	}
    	return len+1;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a ={1,1};
		System.out.println(firstMissingPositive(a));
	}

}
