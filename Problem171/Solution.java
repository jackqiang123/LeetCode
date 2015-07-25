package Problem171;

//Given a column title as appear in an Excel sheet, return its corresponding column number.
//
//For example:
//
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//    
class Solution {

	public static int titleToNumber(String s) {

		int length = s.length();
		int answer = 0;
		if (s == null)
			return 0;
		
		for (int i = 0; i < length; i++) {
			int currentbit = s.charAt(i) - 'A' + 1;
			if (currentbit < 1 || currentbit > 26)
				return 0;
			answer = (int) (answer + currentbit * Math.pow(26, length - i - 1));
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(titleToNumber("ABCDEF"));

	}

}
