package problem65;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Validate if a given string is numeric.
//
//Some examples:
//"0" => true
//" 0.1 " => true
//"abc" => false
//"1 a" => false
//"2e10" => true
//Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.


// directly return 
//    return s.matches("(\\s*)[+-]?  ((\\.[0-9]+)|([0-9]+(\\.[0-9]*)?))  (e[+-]?[0-9]+)?(\\s*)");
//
public class Solution {
	public static boolean isNumber(String s) {
		s = s.trim();
		//System.out.println(s);
		if (s.equals("")) return false;
 		if (s.contains(".")) {
			//System.out.println("get in");
 			Pattern p1 = Pattern.compile("[-|\\+]?+[0-9]*\\.[0-9]*+");
			Matcher m1 = p1.matcher(s);
			
			if (m1.matches() == false) {System.out.println("get in");return false;}
			String[] n = s.split("\\.");
			if (n.length > 2 || n.length == 0)
				return false;
		
			if (n.length == 1)
			{	
				Pattern p = Pattern.compile("-|\\+?+[0-9]*");
				Matcher m = p.matcher(n[0]);
				if (!m.matches())
					return false;
			}
		//	System.out.println(n[0] + ". " + n[1]);
		//	if (n[0].equals("") || n[1].equals("")) return false;
			else 
			{
			
				Pattern p = Pattern.compile("-|\\+?+[0-9]*");
			Matcher m = p.matcher(n[0]);
			if (!m.matches())
				return false;
			p = Pattern.compile("[0-9]*");
			m = p.matcher(n[1]);
			if (!m.matches())
				return false;
		
			}
			}

		else {
			if (s.contains("e")) {
				String[] n = s.split("e");
			//	System.out.println(n[0] + "-  e  -" + n[1]);
				if (n.length != 2)
					return false;
				if (n[1].equals("")) return false;
				else {
					Pattern p = Pattern.compile("-|\\+?+[0-9]+");
					Matcher m = p.matcher(n[0]);
					if (!m.matches())
						return false;
					m = p.matcher(n[1]);
					if (!m.matches())
						return false;
				}
			} 
			else {
				
				Pattern p = Pattern.compile("-|\\+?+[0-9]+");
				Matcher m = p.matcher(s);
				return m.matches();
			}
		}
		return true;
	}

	public static void main(String[] args) {
	//	String [] k = "...".split("//.");
	//	System.out.println(k.length);
		String s = "1.e-9";
		System.out.println(s.matches("(\\s*)[+-]?((\\.[0-9]+)|([0-9]+(\\.[0-9]*)?))(e[+-]?[0-9]+)?(\\s*)"));
	}
}
