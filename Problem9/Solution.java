package Problem9;

public class Solution {

	public static boolean isPalindrome(int x) {

		// first we find the highest bit
		if (x < 0)
			return false;
		double div = 1.0;
		int bit = 1;
		while (x / div >= 1) {
			// System.out.println(x/div+"intial dev="+div+"that is");
			div = div * 10;
			bit++;
		}
		div = div / 10;
		// System.out.println(bit-1+"adsf"+div);

		int high = bit - 1;
		int low = 1;
		while (high >= low) {
			// System.out.println((int)(x / div)+"adsfadsf" + x%10+"dev" + div);
			// System.out.println(1000000001/1000000000);
			if ((int) (x / div) != (int) x % 10)
				return false;

			x = (int) ((x % div) / 10);
			// System.out.println(x);
			div = div / 100;
			high = high - 2;

		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(11));
	}

}
