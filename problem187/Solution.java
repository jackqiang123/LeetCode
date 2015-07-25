package problem187;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
//
//Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
//
//For example,
//
//Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
//
//Return:
//["AAAAACCCCC", "CCCCCAAAAA"].
public class Solution {
	public static List<String> findRepeatedDnaSequences(String s) {
		HashMap<Integer, Boolean> myset = new HashMap<Integer, Boolean>();
		List<String> result = new LinkedList<String>();
		int length = s.length();
		for (int i = 0; i < length - 9; i++) {
			int key = convert(s.substring(i, i + 10));
			if (!myset.containsKey(key))
				myset.put(key, false);
			else {
				if (myset.get(key) == false) {
					myset.put(key, true);
					result.add(s.substring(i, i + 10));
				//	System.out.println("we add a result ---"+s.substring(i, i + 10));
				}

			}
		}
		return result;

	}

	private static int convert(String s) {
		int r = 0;
		for (int i = 0; i<10;i++)
		{
			char c = s.charAt(i);
			if (c == 'A') r += 1;
			if (c == 'C') r += 2;
			if (c == 'G') r += 3;
			if (c == 'T') r += 4;
			r = r*4;
		}
		r = r/4;
		return r;
	}
	
	public static void main(String[]args)
	{
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		
		List<String> r = findRepeatedDnaSequences(s);
	}
}
