package problem204;
//Count the number of prime numbers less than a non-negative number, n
public class Solution {
	public static int countPrimes(int n) {
		  if (n<=2) return 0;
		  
		int count = 0;
        boolean []status = new boolean[n-2];
        double sq = Math.sqrt(n);
		for (int i = 2; i < sq;  i++) {
			
			if (status[i-2] == true) continue;
			
			for (int j = i; j<=(n-1)/i;j++)
				status[i*j-2] = true;
			
		}
		for (boolean sta : status)
		{ if (sta == false)
			count++;
		}
		return count;

	}

	public static void main(String[] args) {
		System.out.println(countPrimes(100000));
	}

}
