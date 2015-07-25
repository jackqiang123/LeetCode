package problem88;

//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
//Note:
//You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
public class Solution {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int p1 = m - 1;
		int p2 = n - 1;
		int k = m + n - 1;
		while (p1 >= 0 && p2 >= 0) {

			if (nums1[p1] >= nums2[p2]) {
				nums1[k] = nums1[p1];
				p1--;
				k--;
			} else {
				nums1[k] = nums2[p2];
				p2--;
				k--;
			}

		}
		while (p2 >= 0) {

			nums1[k] = nums2[p2];
			k--;
			p2--;
		}
	}
	
	public static void main(String[]args)
	{
		int a1[]= {1,2,4,0,0,0};
		int a2[] = {0,2,3};
		merge(a1,3,a2,3);
		for (int i : a1)
		System.out.print(i+" ");
		
	}
	
}
