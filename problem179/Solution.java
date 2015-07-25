package problem179;

import java.util.Arrays;
import java.util.Comparator;

//Given a list of non negative integers, arrange them such that they form the largest number.
//
//For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
//
//Note: The result may be very large, so you need to return a string instead of an integer.
public class Solution {
	static class mycompare implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			String s1 = o1.toString();
			String s2 = o2.toString();
			// System.out.println(s1+"+"+s2);
			int l1 = s1.length();
			int l2 = s2.length();
			String ss1 = s1+s2;
			String ss2 = s2+s1;
			int count = 0;
			int len = l1+l2;
	
			while (count<len){
				if (ss1.charAt(count)<ss2.charAt(count))
					return 1;
				else if (ss1.charAt(count)>ss2.charAt(count))
					return -1;
					count++;
			}
			return 0;

		}

	}

	public static String largestNumber(int[] nums) {
		int len = nums.length;
		Integer[] num = new Integer[len];
		boolean flag = false;
		for (int i = 0; i < len; i++)
		{	num[i] = Integer.valueOf(nums[i]); 
		if (nums[i]!=0)
		flag = true;	
		}
		if (flag == false) return "0";
		Arrays.sort(num, new mycompare());
		// for (int i : num)
		// System.out.print(i+",");
		StringBuilder r = new StringBuilder();
		for (int i = 0; i < num.length; i++)
			r.append(num[i]);

		return r.toString();

	}

	public static void main(String[] a) {
		// System.out.println(mycompare.compare(3,30));
		int p[] = {35,99,50,80,14,11,78,4,38,99,65,11,71,52,68,22,32,1,26,82,28 }; // 9534330
		//System.out.println("1231231234">"1231231235")
		System.out.println(largestNumber(p));

	}
}
