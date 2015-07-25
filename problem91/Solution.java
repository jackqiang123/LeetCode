package problem91;

//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//Given an encoded message containing digits, determine the total number of ways to decode it.
//
//For example,
//Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//
//The number of ways decoding "12" is 2.
public class Solution {
	public static int numDecodings(String s) {
		if (s.equals("0")) return 0;
		if (s.length() <= 1)
			return s.length();

		int d[] = new int[s.length()];
		d[0] = 1;
		
		
		if (s.charAt(1) == '0' && (s.charAt(0)!='1' && s.charAt(0)!='2')) return 0;
		
		
		if (s.charAt(0) == '1' || s.charAt(0) == '2') {
			if (s.charAt(0) == '1')
				d[1] = 2;
			else if (s.charAt(0) == '2') {
				if (s.charAt(1) <= '6' )
					d[1] = 2;
				else
					d[1] = 1;
			}
		} else
			d[1] = 1;
		if (s.charAt(1) == '0') d[1] = 1;
		if (s.charAt(0) == '0') return 0;
	//	if (s.charAt(0) != '1' && s.charAt(0) != '2') return 0;
//		for (int i : d)
//			System.out.print(i+",");
//		System.out.println();
		if (s.length() == 2)
			return d[1];

		for (int i = 2; i < d.length; i++) {
			if (s.charAt(i) == '0') {
				if (s.charAt(i-1) != '1' && s.charAt(i-1) != '2') return 0;
				d[i] = d[i - 2];
				continue;
			}
			if (s.charAt(i-1) == '1')
				d[i] = d[i - 1] + d[i - 2];
			else if (s.charAt(i-1)  == '2') {
				if (s.charAt(i)  <= '6' && s.charAt(i)  >= '1')
					d[i] = d[i - 1] + d[i - 2];
				else
					d[i] = d[i - 1];
			} 
			else
				d[i] = d[i - 1];
		}
	
		return d[d.length-1];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodings("10"));
	}

}
