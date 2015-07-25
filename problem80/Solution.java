package problem80;

//Follow up for "Remove Duplicates":
//What if duplicates are allowed at most twice?
//
//For example,
//Given sorted array nums = [1,1,1,2,2,3],
//
//Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
public class Solution {
	public static int removeDuplicates(int[] nums) {
		int length = nums.length;
		int p1 = 1;// mark the left end
		int p2 = 1; // mark the right end
		int count = 1;
		if (length <= 2)
			return length;
		int lastvalue = nums[0];

		while (p2 < length) {
			if (lastvalue == nums[p2]) {
				if (count == 1) {
					count++;
					nums[p1] = nums[p2];
					p1++;
					p2++;
				} else {
					p2++;
				}

			} else {

				count = 1;
				nums[p1] = nums[p2];
				lastvalue = nums[p1];
				p1++;
				p2++;
			}

		}
		return p1;
	}

	public static void main(String[] args) {
		int[] a = { 1, 1, 1, 1 };
		System.out.println(removeDuplicates(a));
		for (int i : a)
			System.out.print(i);

	}
}
