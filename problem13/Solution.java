package problem13;

public class Solution {
	 public static int romanToInt(String s) {
		 s = s.toLowerCase();
		 int result = findNumber(s.charAt(0));
		// System.out.println(result);
		
		// System.out.println(s);
		 for (int i = 1; i<s.length();i++)
		 {	 int previous = findNumber(s.charAt(i-1));
			 int current = findNumber(s.charAt(i));
			// System.out.println(current);
			 if (current>previous)
			 {
				 result -= 2*previous;
			 }
			 result += current;
			// System.out.println(result);
			 
		 }
		 return result;
		 
		 
	        
	    }
	private static int findNumber(char s){
	    int number=0;
	    switch (s){
	        case 'i': number = 1; break;

	        case 'v': number = 5; break;

	        case 'x': number = 10; break;

	        case 'l': number = 50; break;

	        case 'c': number = 100; break;

	        case 'd': number = 500; break;

	        case 'm': number = 1000; break;
	    }
	    return number;

	}
	public static void main(String[]rgs)
	{
		
		System.out.println(romanToInt("DCXXI"));
	}

}
