package problem93;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//Given a string containing only digits, restore it by returning all possible valid IP address combinations.
//
//For example:
//Given "25525511135",
//
//return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
public class Solution {

	public static List<String> restoreIpAddresses(String s) {
		LinkedList<String> result = new LinkedList<String>();
		//int pointer = 0;
		int nofd = 0;
		backtracking(result, s, nofd, "");
		return result;

	}

	private static void backtracking(LinkedList<String> result, String s, int nofd,
			String cur) {
		// TODO Auto-generated method stub
		if (nofd >= 3) {
			int curlength = cur.length() - 3;
			//if (curlength < s.length()) return; // if not use up all digits
			
			//System.out.println("the current length is " +(curlength + 1) + " to " + (s.length() ));
			String mystring = s.substring(curlength, s.length() );
		//	System.out.println("the last IP string is" + mystring);
			
			
			
			if (mystring.length() > 3 || mystring.length() == 0)
				return;// the remaining is too long
			
			
			int ip = Integer.parseInt(mystring);
			if (ip <= 255) 
			{
				mystring = cur + mystring;
				result.add(mystring);
			//	System.out.println("we add a result");
				return;
				
			}
			else return;
		} 
		
		else {
			//System.out.println("nofd  == " + nofd);
			
			int remainlength = s.length() - (cur.length() - nofd);
		//	System.out.println("remaining length is" +remainlength);
			if (remainlength <= 0) return;
			
			int usedlength = Math.min(remainlength,3);
			//System.out.println("using length is" +usedlength);		
			
			for (int index = 1; index <= usedlength; index++) {
				
			//	int end = Math.min(cur.length() - nofd + 1+index, s.length());
			//	System.out.println("the start is " + (cur.length() - nofd) );
				
				//System.out.println("the start is " +(cur.length() - nofd ) +" the endding is " + (cur.length() - nofd + index));
				
			//	System.out.println("the current cur is " + cur + " its length is" + cur.length() + " and the remaining length is " + (s.length() - (cur.length() - nofd)));
				String mystring = s.substring(cur.length() - nofd , cur.length() - nofd + index);
				
			//	System.out.println("mystring is " + mystring);
				
				if (Integer.parseInt(mystring) <= 255) 
				
				{
					if (mystring.length()>1 && mystring.charAt(0) == '0') return;
					String newstring = cur + mystring + "." ;
				//	System.out.println("go backtracking with" + newstring);
					backtracking(result, s, nofd + 1, newstring);
				}

			}

		}

	}
	
	public static void main(String []args)
	{//System.out.println("25525511135".substring(0, 11));
		List<String> result = restoreIpAddresses("73822");
		
		Iterator<String> it = result.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
			
	}
}
