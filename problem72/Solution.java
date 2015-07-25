package problem72;
//Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
//
//You have the following 3 operations permitted on a word:
//
//a) Insert a character
//b) Delete a character
//c) Replace a character

//F[i][j] is the distance between w1.sub(0,i) and w2.sub(0.j)
// we want to obtain f[i][j] from previous. that is 
// f[i][j] = f[i-1][j-1] + 1
// f[i][j] = f[i-1][j] + 1
//	f[i][j] = f[i][j-1] + 1
public class Solution {
    public static int minDistance(String w1, String w2) {
       int m = w1.length();
       int n = w2.length(); 
       int[][]distance = new int[m+1][n+1];
       distance[0][0] = 0;
       for (int i = 1; i<n+1; i++) distance[0][i] = i;
       for (int i = 1; i<m+1; i++) distance[i][0] = i;
       
       for (int i = 1; i<=m; i++)
       {
    	   for (int j = 1; j<=n; j++)
    	   {
    		   int cost = w1.charAt(i-1) == w2.charAt(j-1) ? 0:1;
    		   distance[i][j] =  Math.min(Math.min(1 +distance[i-1][j], 1 +distance[i][j-1]), distance[i-1][j-1]+cost);
    		   
    		   
    	   }
       }
         
//       for (int i = 0; i<=m; i++)
//       {
//    	   for (int j = 0; j<=n;j++)
//    		    System.out.print(distance[i][j]);
//    	   System.out.println();
//       }
       
       
       return distance[m][n];
    }
  public static void main(String[]arges)
  {
	  System.out.println(minDistance("ab","bc"));
  }
}

//int minDistance(string word1, string word2) {
//    int  m = word1.length(), n = word2.length();
//    if (m == 0) return n;
//    if (n == 0) return m;
//
//    // table[i][j]: distance from words1.substr(0, i) to words2.substr(0, j) 
//    int table[m+1][n+1];
//    for (int i = 0; i <= m; ++i) table[i][0] = i;
//    for (int j = 0; j <= n; ++j) table[0][j] = j;
//    // table[i][j] is the min distance between the next three values
//    // from table[i-1][j], table[i][j-1], or table[i-1][j-1] to table[i][j]
//    for (int i = 1; i <= m; ++i) {
//        for (int j = 1; j <= n; ++j) {
//            int cost = (word1[i-1] == word2[j-1] ? 0 : 1);
//            table[i][j] = min(min(table[i-1][j] + 1, table[i][j-1] + 1), table[i-1][j-1] + cost);
//        }
//    }
//
//    return table[m][n];
//}