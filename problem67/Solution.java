package problem67;
//Given two binary strings, return their sum (also a binary string).
//
//For example,
//a = "11"
//b = "1"
//Return "100".
public class Solution {
    public static String addBinary(String a, String b) {
    int carry = 0;
    int alen = a.length();
    int blen = b.length();
    if (alen + blen == 0) return "0";
    int aindex = alen-1;
    int bindex = blen-1;
    StringBuilder result = new StringBuilder();
    while(aindex>=0 && bindex>=0)
    {
    	int ca = a.charAt(aindex)-'0';
    	int ba = b.charAt(bindex)-'0';
    	int bit = (ca + ba + carry)%2;
    	carry = (ca + ba + carry)/2;
    	result.append(bit);
    	aindex--;
    	bindex--;
    }
    while(aindex>=0)
    {  	
    int ca = a.charAt(aindex)-'0';
	//int ba = b.charAt(bindex)-'0';
	int bit = (ca + carry)%2;
	carry = (ca + carry)/2;
	result.append(bit);
	aindex--;
    }
    while(bindex>=0)
    {
   //   	int ca = a.charAt(aindex)-'0';
    	int ba = b.charAt(bindex)-'0';
    	int bit = ( ba + carry)%2;
    	carry = ( ba + carry)/2;
    	result.append(bit);
    	bindex--;

    }
    if (carry == 1) result.append(1);

    
    
    return result.reverse().toString();
    }
    public static void main(String[]args)
    {
    	String a = "";
    	String b = "";
    	System.out.println(addBinary(a,b));
    }
}
