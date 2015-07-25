package problem68;

import java.util.LinkedList;
import java.util.List;

//Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
//
//You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
//
//Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
//
//For the last line of text, it should be left justified and no extra space is inserted between words.
//
//For example,
//words: ["This", "is", "an", "example", "of", "text", "justification."]
//L: 16.
//
//Return the formatted lines as:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
//Note: Each word is guaranteed not to exceed L in length.
//
//click to show corner cases.
//
//Corner Cases:
//A line other than the last line might contain only one word. What should you do in this case?
//In this case, that line should be left-justified.
public class Solution {
	public static List<String> fullJustify(String[] words, int maxWidth) {

		int len = words.length;
		List<String> result = new LinkedList<String>();
		int index = 1;
		StringBuilder current = new StringBuilder();
		current.append(words[0]);
		if (len == 1){
			for (int i = current.length(); i< maxWidth; i++) 
				current.append(" ");
			result.add(current.toString());
			}
		
		while (index < len) {
		//	System.out.println("the current index is ---" + index);
			String cur = words[index];
			
			if (current.toString().equals("")) {//System.out.println(cur + " is append to an empty builder");
			current.append(cur);}
			
			else if (cur.length() + 1 + current.length() <= maxWidth) {
				current.append(" ");
				current.append(cur);
				//System.out.println("current string builder " + current.toString() + " its len is "+ current.length());
			} else {
				result.add(redistibuted(current, maxWidth));
				current = new StringBuilder();
				current.append(cur);
		
			}
			
			if (index == len - 1) {
				int whitelen = maxWidth - current.length();
				//System.out.println("the whitelen is ---" + whitelen);
				for (int i = 0; i < whitelen; i++)
					current.append(' ');
				result.add(current.toString());
			}
			index++;

		}
		return result;

	}

	private static String redistibuted(StringBuilder current, int maxWidth) {
		// System.out.println("the current string is ---" + current);
		String[] p = current.toString().split(" ");
		int len = p.length;
		if (len == 1) {
			 System.out.println("single string ---" + current);
			int whitelen = maxWidth - p[0].length();
			System.out.println("white length is " + whitelen);
			for (int i = 0; i < whitelen; i++) {
				p[0] = p[0] + " ";
			}
			return p[0];
		} else {
			int total = 0;
			for (String a : p) {
				total += a.length();
			}
			int totalwhite = maxWidth - total;
			int average = totalwhite / (len - 1);
			int additional = totalwhite - average * (len - 1);
			StringBuilder result = new StringBuilder();
			result.append(p[0]);
			for (int i = 1; i < len; i++) {
				for (int w = 0; w < average; w++)
					result.append(" ");
				if (additional > 0) {
					result.append(" ");
					additional--;
				}
				result.append(p[i]);
			}

			return result.toString();

		}

	}

	public static void main(String[] args) {
		String[] a = {"What","must","be","shall","be."};
		String[]t = {"a"};
		List<String> r = fullJustify(a, 12);
		for (String p : r)
			System.out.println(p);
		;
	}
}
