package problem29;

//Divide two integers without using multiplication, division and mod operator.
//
//If it is overflow, return MAX_INT.
public class Solution {
	public static int divide(int dividend, int divisor) {
		long did = dividend;
		long div = divisor;
		int sign = 1;
		if (divisor == 0)
			return -1;
		
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;
		if (did < 0) {
			sign = -sign;
			did = -did;
		}
		if (div < 0) {
			sign = -sign;
			div = -div;
		}
		long result = divide(did, div);
		return (int) (sign == 1 ? result : -result);
	}

	private static long divide(long did, long div) {
		long divtemp = div;
		int bit = 0; // number of bits
		if (div == 1) return did;
		if (did < div)
			return 0;
		while (divtemp <= did) {
			divtemp = divtemp << 1; // times 2, until divtemp > did
			bit++;
		}
		System.out.println(bit);
		int result = 1;
		int lastbit = 1;
		
	//	System.out.println("the  temp is" + did);
		while (bit > 1) {
			// System.out.println("the current bit is" + bit);
			// System.out.println("the current resuit is" + result);
			result <<= 1;
			if (lastbit == 1)
				did = did - (div<<(bit-1));
			if (did>(div<<(bit-2)))
			{
				result++;
				lastbit = 1;
			}
			else lastbit = 0;
			
			//System.out.println("the resuit is" + Integer.toBinaryString(result));
			bit--;
		}

		return result;
	}

	public static void main(String[] args) {
		int a = 56;
	//	a<<1;
	//	System.out.println(2147483647 / 3);
	System.out.println(divide(6, 1));
		//System.out.println(divide(1000, 23))
	//System.out.println(23<<3);
	}
}
