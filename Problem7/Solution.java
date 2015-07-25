package Problem7;

public class Solution {
	public static int reverse(int x) {

		if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE)
			return 0;
		int y = x;
		String num = x + "";
		int bitnum = num.length();
		if (x < 0) {
			y = -x;
			bitnum--;
		}

		int answer = 0;

		System.out.println(bitnum);

		for (int i = bitnum - 1; i >= 0; i--) {
			int dex = 0;
			int dexnum = 0;
			dex = (int) (y / Math.pow(10, i));

			y = (int) (y - dex * Math.pow(10, i));

			answer = (int) (answer + dex * Math.pow(10, bitnum - 1 - i));

		}

		if (answer == Integer.MAX_VALUE || -answer == Integer.MIN_VALUE)
			return 0;

		if (x < 0)
			return -answer;
		else
			return (answer);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out
				.println(reverse(-2147483648) + "max is " + Integer.MAX_VALUE);
	}

}
