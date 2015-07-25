package problem17;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Given a digit string, return all possible letter combinations that the number could represent.
//
//A mapping of digit to letters (just like on the telephone buttons) is given below.
//
//
//
//Input:Digit string "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//Note:
//Although the above answer is in lexicographical order, your answer could be in any order you want.
public class Solution {
	private final static String[] mapping =  {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
public static List<String> letterCombinations(String digits) {
     List<String> result = new ArrayList<String>();
     StringBuilder partialRes = new StringBuilder(digits.length());
     int length = digits.length();
     int []number = new int[length];
     for (int i = 0; i<length;i++)
     {
    	 number[i] = Integer.parseInt(digits.substring(i, i+1));
     }
     
     backtracking(result,partialRes, number ,0);
     
     return result;
    }

private static void backtracking(List<String> result, StringBuilder partialRes, int[] number, int start) {
	//System.out.println("the length is " + number.length);
	if (start == number.length)
	{
	//System.out.println("we add a result as " + partialRes);
		String mycur = new String(partialRes);
		result.add(partialRes.toString());
		return;
	}
	else{
		
		char [] mychar;
		
			
		 mychar = getcharbynum(number[start]);
		//System.out.println("the current number is" + number[i]);
		//System.out.println("the start i is" +"the current cur is " + cur + " and i is" + i);
		for (int j =0 ; j<mychar.length;j++)
		{
			partialRes.append(mychar[j]);
			backtracking(result,partialRes,number,start+1);	
			partialRes.deleteCharAt(partialRes.length()-1);
			
		}
		
		
	}
	
}

private static char[] getcharbynum(int n) {
	return mapping[n].toCharArray();
}
public static void main (String[]args)
{
	List<String> r =letterCombinations("24");
	Iterator<String> it = r.iterator();
	while(it.hasNext())
	{
		System.out.print(it.next()+",");
	}
	
}


}
