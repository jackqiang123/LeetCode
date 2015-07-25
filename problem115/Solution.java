package problem115;
//Given a string S and a string T, count the number of distinct subsequences of T in S.
//
//A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
//Here is an example:
//S = "rabbbit", T = "rabbit"
//
//Return 3.
public class Solution {
    public static int numDistinct(String s, String t) {
    int slen = s.length();
 
    int tlen = t.length();
    
    if (slen == 0 && tlen == 0) return 1;
    if (slen == 0) return 0;
    if (tlen == 0) return 1;
    int d[][] = new int[slen+1][tlen+1];
    for (int i = 0; i <= slen;i++)
    	d[i][0] = 1;
    for (int j = 1; j<= tlen;j++)
    	d[0][j] = 0;
    for (int i = 1; i <=slen;i++)
    	for (int j = 1; j<=tlen;j++)
    		{System.out.println(i+","+j);d[i][j] = d[i-1][j] + (s.charAt(i-1) == t.charAt(j-1) ? d[i-1][j-1]:0);}
    
    
    return d[slen][tlen];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDistinct("as","s"));
	}

}
