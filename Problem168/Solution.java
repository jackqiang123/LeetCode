package Problem168;

public class Solution {

	public static String convertToTitle(int n) {

		if (n <= 0 || n > Integer.MAX_VALUE)
			return "";
		// int div = 1;
		// int bit = 1;
		// while (n / div > 26) {
		// div = div * 26;
		// bit = bit + 1;
		// }
		// now we get the div, such that n/div will fall in the range of 1-26

		// char[] result = new char[bit];
		String answer = "";

		// System.out.println("the max div is" + div + " the bits are" + bit);
		int index = 0;
		// System.out.println(getcurrentchar(1));
		answer = getcurrentchar(n) + answer;

		// System.out.println(answer);

		while (((n - answer.charAt(index) + 64) / 26) >= 1) {
			System.out.println("current n is" + n +  "current bit is " + (answer.charAt(index) - 64));
			n = (n - answer.charAt(index) + 64) / 26;
			System.out.println("new n is" + n +  "current bit is " + (answer.charAt(index) - 64));
			// System.out.println("current char"+getcurrentchar(n));
			answer = getcurrentchar(n) + answer;
			System.out.println(answer + "****"+n);

			//index++;
		}

		// System.out.println(answer);
		return answer;

	}

	private static String getcurrentchar(int k) {
		if (k % 26 != 0)
			return "" + (char) (k % 26 + 64);
		else // current bit hope to put an 0.
		{
			if (k - k % 26 == 0) // if the current bit is the highest bit
				return (k + 64) + "";
			else
				// the current bit is not highest bit
				return "Z";
		}
	}

	public static void main(String[] args) {

		System.out.println(convertToTitle(12850896));

	}

}
