package problem125;

//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//For example,
//"A man, a plan, a canal: Panama" is a palindrome.
//"race a car" is not a palindrome.
//
//Note:
//Have you consider that the string might be empty? This is a good question to ask during an interview.
//
//For the purpose of this problem, we define empty string as valid palindrome.
public class Solution {
	public static boolean isPalindrome(String s) {

		if (s.length() == 0)
			return true;
		s = s.toLowerCase();
		char[] check = s.toCharArray();
		int left = 0;
		int right = check.length - 1;
		while (left < right) {
			
			if (! ((check[left]<='z'&&check[left]>='a') || (check[left]<='9'&&check[left]>='0')))
			{	left++;continue;}
			
			if (! ((check[right]<='z'&&check[right]>='a') || (check[right]<='9'&&check[right]>='0')))
			{	right--;continue;}
			
//			if (check[left]>'z' || check[left]<'a')
//			{	left++;continue;}
//			if (check[right]>'z' || check[right]<'a')
//			{	right--;continue;}
			if (check[left] == check[right]) {
				left++;
				right--;
			} else
				return false;
			
		}
		return true;
	}

	public static void main(String[] args) {
		//String s = "Hellp";
		//System.out.println('a');
		System.out.println(isPalindrome("a."));
	}
}
