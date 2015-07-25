package problem43;

//Given two numbers represented as strings, return multiplication of the numbers as a string.
//
//Note: The numbers can be arbitrarily large and are non-negative.

// we convert the string into a int vector, such that long int can be represented
public class Solution {
	public static String multiply(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		int result[] = new int[len1 + len2];
		if (num1.equals("0") || num2.equals("0")) return "0";
		int n1[] = new int[len1];
		int n2[] = new int[len2];
		
		// n1 and n2 are reversed
		for (int i = 0; i < len1; i++) {
			n1[len1 - 1 - i] = num1.charAt(i) - '0';
		}

		for (int j = 0; j < len2; j++) {
			n2[len2 - 1 - j] = num2.charAt(j) - '0'; // put the n2
		}
		int carry = 0;
		for (int j = 0; j < len2; j++) {

			int nm2 = n2[j];
			
			for (int i = 0; i < len1; i++) {
				int nm1 = n1[i];
		
				int temp = result[j + i] + (nm2 * nm1) + carry;
				result[j + i] = temp % 10;
				carry = temp / 10;
			//	System.out.println("the carry is " + carry );
			//	System.out.println("put new result " + temp%10 + " at position " + (i+j) );
			}
			result[len1+j] = carry;
			//System.out.println("put new result " + carry + " at position " + (len1+j) );
			carry = 0;
		}

	

		StringBuilder r = new StringBuilder();
		int index = result.length - 1;
		while (index >= 0) {
			if (result[index] != 0)
				break;
			index--;

		}
		
		while (index >= 0) {

			r.append(result[index]);
			index--;

		}
		
		return r.toString();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiply("99", "99"));
	}

}
