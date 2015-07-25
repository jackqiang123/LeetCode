package problem166;

import java.util.HashMap;
import java.util.Map;

//Given two integers representing the numerator and denominator of a fraction, 
//return the fraction in string format.
//
//If the fractional part is repeating, enclose the repeating part in parentheses.
//
//For example,
//
//Given numerator = 1, denominator = 2, return "0.5".
//Given numerator = 2, denominator = 1, return "2".
//Given numerator = 2, denominator = 3, return "0.(6)".
//Credits:
//Special thanks to @Shangrila for adding this problem and creating all test cases.
public class Solution {
	public static String fractionToDecimal(int num, int den) {
		
		long numerator = num;
		long denominator = den;
//		if (denominator == Integer.MIN_VALUE)
//		{
//			if (numerator == 1) return "-0.0000000004656612873077392578125";
//			else if (numerator == -1) return "0.0000000004656612873077392578125";
//		}
//		if (numerator == Integer.MIN_VALUE)
//		{
//			if (denominator == 1) return numerator+"";
//		//	else return "0.0000000004656612873077392578125";
//			else if ( denominator == -1) return "2147483648";
//			else return (numerator/(denominator*1.0))+"";
//		}
		boolean negat = false;
		if (numerator == 0)
			return "0";
		if (numerator < 0)
			negat = !negat;
		if (denominator < 0)
			negat = !negat;
		numerator = (numerator > 0) ? numerator : -numerator;
		denominator = (denominator > 0) ? denominator : -denominator;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (denominator == 1)
			return negat ? "-" + numerator : "" + numerator;

		long interpart = numerator / denominator;
		String left = negat ? "-" + interpart + "." : interpart + ".";
		String right = "";
		numerator = numerator - interpart * denominator;
		if (numerator == 0)
			return negat ? "-" + interpart : "" + interpart;
		int key = (int)numerator;
		int d = (int)denominator;
		int index = 0;
		
		while (!map.containsKey(key)) // key is the remaining
		{
			//System.out.println((int)key);
			map.put(key, index);
			// System.out.println("we put remaining " + key + " at position " +
			// index);
			key *= 10;

			while (key < d) {
				key = key * 10;
				right += "0";
				index++;
			}

			right += (key / d);
			key = key % d;
			if (key == 0) {
				return left + right;
			}
			index++;
		}

		String rightfirst = right.substring(0, map.get(key));
		
		
		String sub = right.substring(map.get(key));
		//System.out.println(sub);
		if (rightfirst.length() == 0)
		{
			return left + "(" + sub + ")";
		}
		int ll = rightfirst.length() - 1;
		int rr = sub.length() - 1;
		while (rightfirst.charAt(ll) == sub.charAt(rr)) {
			ll--;
			rr--;
			if (rr == -1)
				break;
		}
		rr = sub.length() - 1- rr;
		//System.out.println(rr);
		
		String temp = rightfirst.substring(0, rightfirst.length() - rr) + "("
				+ rightfirst.substring(rightfirst.length() - rr) + sub.substring(0, sub.length() - rr) + ")";
		// String sub = right.substring(map.get(key));
		// int lensub = sub.length();
		//
		// String rightfirst = right.substring(0, map.get(key));
		// int lenrightfirst = rightfirst.length();
		// //System.out.println(rightfirst.substring(lenrightfirst-lensub,lenrightfirst));
		// if (lenrightfirst >= lensub)
		// {
		// if
		// (sub.equals(rightfirst.substring(lenrightfirst-lensub,lenrightfirst)))
		// {
		// String t1 = rightfirst.substring(0, lenrightfirst-lensub);
		// return left + t1 + "(" + sub + ")";
		// }
		// }
		//
		// sub = "(" + sub + ")";
		// right = rightfirst + sub;

		return left + temp;
	}

	public static void main(String[] args) {
		System.out.println(fractionToDecimal(1, 6));
	}
}


//public class Solution {
//    public String fractionToDecimal(int numerator, int denominator) {
//        if (numerator == 0) {
//            return "0";
//        }
//        StringBuilder res = new StringBuilder();
//        // "+" or "-"
//        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
//        long num = Math.abs((long)numerator);
//        long den = Math.abs((long)denominator);
//
//        // integral part
//        res.append(num / den);
//        num %= den;
//        if (num == 0) {
//            return res.toString();
//        }
//
//        // fractional part
//        res.append(".");
//        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
//        map.put(num, res.length());
//        while (num != 0) {
//            num *= 10;
//            res.append(num / den);
//            num %= den;
//            if (map.containsKey(num)) {
//                int index = map.get(num);
//                res.insert(index, "(");
//                res.append(")");
//                break;
//            }
//            else {
//                map.put(num, res.length());
//            }
//        }
//        return res.toString();
//    }
//}