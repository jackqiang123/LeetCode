package problem215;
//Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//For example,
//Given [3,2,1,5,6,4] and k = 2, return 5.
//
//Note: 
//You may assume k is always valid, 1 ≤ k ≤ array's length.
public class Solution {//we use quicksort to find the k's max element
    public static int findKthLargest(int[] nums, int k) {
    return quickselection(nums,0,nums.length-1,k-1);  
    }

private static int quickselection(int[] nums, int start, int end, int k) {
	if (end == start) return nums[start];
	
	int pivotIndex = (start+end)/2;
	pivotIndex = partition(nums,start,end,pivotIndex);
	if (pivotIndex == k) return nums[k];
	if (pivotIndex < k) return quickselection(nums,Math.min(end, pivotIndex+1),end,k);
	else return quickselection(nums,start,Math.max(start, pivotIndex-1),k);
}

private static int partition(int[] nums, int start, int end, int pivotIndex) {
	int pivotValue = nums[pivotIndex];
	//System.out.println(pivotIndex);
	swap(nums,pivotIndex,end);
//	for (int k : nums)
//	{System.out.print(k+",");}
//	System.out.println();
	int left = start;
	for (int i = start; i < end; i++)
	{
		if (nums[i]>pivotValue)
		{
			swap(nums,i,left);
			left++;
		}
	}
	swap(nums,left,end);
	//System.out.println("start and end is " + start + "," + end + " and left is " + left);
//	for (int k : nums)
//	{System.out.print(k+",");}
//	System.out.println();
	return left;
}

private static void swap(int[] nums, int i, int j) {
	int t = nums[i];
	nums[i] = nums[j];
	nums[j] = t;
	
}

public static void main(String[]args)
{
	int a [] = {3,2,1,5,6,4};
	System.out.println(findKthLargest(a,2));
}
}

// sudo code 

//In quicksort, there is a subprocedure called partition that can, in linear time, group a list (ranging from indices left to right) into two parts, those less than a certain element, and those greater than or equal to the element. Here is pseudocode that performs a partition about the element list[pivotIndex]:
//
//	 function partition(list, left, right, pivotIndex)
//	     pivotValue := list[pivotIndex]
//	     swap list[pivotIndex] and list[right]  // Move pivot to end
//	     storeIndex := left
//	     for i from left to right-1
//	         if list[i] < pivotValue
//	             swap list[storeIndex] and list[i]
//	             increment storeIndex
//	     swap list[right] and list[storeIndex]  // Move pivot to its final place
//	     return storeIndex
//	In quicksort, we recursively sort both branches, leading to best-case Ω(n log n) time. However, when doing selection, we already know which partition our 
//desired element lies in, since the pivot is in its final sorted position, with all those preceding it in an unsorted order and all those following it in an unsorted order.
//Therefore, a single recursive call locates the desired element in the correct partition, and we build upon this for quickselect:
//
//	  // Returns the n-th smallest element of list within left..right inclusive
//	  // (i.e. left <= n <= right).
//	  // The size of the list is not changing with each recursion.
//	  // Thus, n does not need to be updated with each round.
//	  function select(list, left, right, n)
//	     if left = right        // If the list contains only one element,
//	         return list[left]  // return that element
//	     pivotIndex  := ...     // select a pivotIndex between left and right,
//	                            // e.g., left + floor(rand() * (right - left + 1))
//	     pivotIndex  := partition(list, left, right, pivotIndex)
//	     // The pivot is in its final sorted position
//	     if n = pivotIndex
//	         return list[n]
//	     else if n < pivotIndex
//	         return select(list, left, pivotIndex - 1, n)
//	     else
//	         return select(list, pivotIndex + 1, right, n)