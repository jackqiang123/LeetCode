package problem10;
//Implement regular expression matching with support for '.' and '*'.
//
//'.' Matches any single character.
//'*' Matches zero or more of the preceding element.
//
//The matching should cover the entire input string (not partial).
//
//The function prototype should be:
//bool isMatch(const char *s, const char *p)
//
//Some examples:
//isMatch("aa","a") → false
//isMatch("aa","aa") → true
//isMatch("aaa","aa") → false
//isMatch("aa", "a*") → true
//isMatch("aa", ".*") → true
//isMatch("ab", ".*") → true
//isMatch("aab", "c*a*b") → true


public class Solution {
	
	public boolean isMatch(String s, String p) 
	{
		if (p.isEmpty())
			return s.isEmpty();
		
		if (p.length() == 1)
		{
			if (s.isEmpty())	return false;
			if (s.charAt(0)!=p.charAt(0) && p.charAt(0) != '.') return false;
			else return isMatch(s.substring(1),p.substring(1));
		} 
		// next all string is with length >=2
		
		if (p.charAt(1) != '*')
		{
			if (s.isEmpty())	return false;
			if (s.charAt(0)!=p.charAt(0) && p.charAt(0) != '.') return false;
			else return isMatch(s.substring(1),p.substring(1));
		} 
		
		else{
			
			while(!s.isEmpty())
		{
			if (s.charAt(0) == p.charAt(0) ||p.charAt(0) == '.')
			{
				
				if (isMatch(s,p.substring(2)))
					return true;
				else s = s.substring(1);
			}
			else return isMatch(s,p.substring(2));
		}
				
		return isMatch(s,p.substring(2));
		}
		
		
		
			
    }
	
	
}
