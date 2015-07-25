package Problem4;

//here are two sorted arrays nums1 and nums2 of size m and n respectively. 
//Find the median of the two sorted arrays. 
//The overall run time complexity should be O(log (m+n)).
public class Solution {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int total[] = new int[nums1.length + nums2.length];
		int p1 = 0;
		int p2 = 0;
		int i = 0;
		for (; i < nums1.length + nums2.length && p1 < nums1.length
				&& p2 < nums2.length; i++) {
			if (nums1[p1] > nums2[p2])
				total[i] = nums2[p2++];
			else
				total[i] = nums1[p1++];

		}
		if (p2 < nums2.length) {
			while (i < total.length) {
				total[i++] = nums2[p2++];
			}
		}
		if (p1 < nums1.length ) {
			while (i < total.length) {
				total[i++] = nums1[p1++];
				
			}
		}
		
		if (total.length % 2 == 1)
			{ return total[total.length / 2];}
		else
			return (total[total.length / 2] + total[total.length / 2 - 1]) / 2.0;

	}
	public static void main(String[]args)
	{
		int a[] = {};
		int b[] = {1};
		System.out.println(findMedianSortedArrays(b,a));
	}
}
