package problem66;
// plus one compuations
public class Solution {
	public static int[] plusOne(int[] digits) {
		int length = digits.length;
		// boolean increlength = false;
		int increone = 1;
		for (int i = length - 1; i >= 0; i--) {

			int value = digits[i] + increone;
			if (value >= 10) {
				increone = 1;
				digits[i] = value % 10;
			} else {
				digits[i] = value;
				increone = 0;
			}

			if (increone == 0)
				break;

		}
		if (increone == 1) {
			digits = new int[length + 1];
			digits[0] = 1;
		}

		return digits;
	}

	public static void main(String[] args) {
		int[] a = { 9, 9, 9 };
		int[] p = plusOne(a);
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]);
		}
	}

}
