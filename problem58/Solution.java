package problem58;
//Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
//
//If the last word does not exist, return 0.
//
//Note: A word is defined as a character sequence consists of non-space characters only.
//
//For example, 
//Given s = "Hello World",
//return 5.
public class Solution {
	
	public static int lengthOfLastWord(String s) {
	
	int length = s.length();
	int i = length -1;
	while(i>=0 && s.charAt(i) == ' ')
	{
		i--;		
	}
	System.out.println("i is" + i );
	if (i == 0) return 1;
	if (i==-1) return 0;
	
	int j = i;
	while(j>=0 && s.charAt(j) != ' ')
	{
		j--;
		
	}
	return i-j;
        
    }
public static void main(String []arsg){
	
	String s = " ";
	System.out.println(lengthOfLastWord(s));
}

}
