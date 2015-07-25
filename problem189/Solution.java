package problem189;
//Rotate an array of n elements to the right by k steps.
//
//For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
//
//Note:
//Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
//
//[show hint]
//
//Related problem: Reverse Words in a String II
public class Solution {
	public static void rotate(int []nums, int k)
	{
		int length = nums.length;
		k = k % length;
		if (k == 0) return;
		reverse(nums,0,length-1);
		reverse(nums,0,k-1);
		reverse(nums,k,length-1);
	}

	private static void reverse(int[] nums, int start, int end) {
		while(start<end)
			{swap(nums,start,end);start++;end--;}
		
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		
	}


}

//	public static void rotate(int []nums, int k)
//	{  
//	int length = nums.length;
//    if (length == 0) return;
//    k = k % length;
//    if (k == 0) return;
//	//let lenght = p1 * p2, all are prime
//	}
//    public static void rotatehelper(int[] nums, int k) {
//	
//     int length = nums.length;
//     if (length == 0) return;
//     k = k % length;
//     if (k == 0) return;
//     int temp;
//     int index = 0;
//     int copy = nums[0];
//     for (int i = 0;i < length; i++)
//     {
//    	// copy = nums[index];
//    	 
//    	 index = (index + k) % length;
//    //	 System.out.println("current idnex is " + index);
//    	 temp = nums[index];
//    	 nums[index] = copy;	 
//    	 copy=temp;
//    	 
//     }
//    }
//    
//    public static void main(String[]args)
//    {
//    	int []p ={1,2,3,4,5,6};
//    	rotate(p,2);
//    	for (int k =0 ;k<p.length;k++)
//    		System.out.print(p[k]+",");
//    }
//}
