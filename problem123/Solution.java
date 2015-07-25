package problem123;

//Say you have an array for which the ith element is the price of a given stock on day i.
//
//Design an algorithm to find the maximum profit. You may complete at most two transactions.
//
//Note:
//You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
public class Solution {
	public int maxProfit(int[] prices) {
		return findpro(prices, 2);
	}

	private int findpro(int[] p, int K) {
		int len = p.length;
		if (len <= 1)
			return 0;
		//int max = 0;

		int dp[][] = new int[K + 1][len];
		// dp[k][t] is the benefit by at most k times transcations, at time t
		// dp[0][t] is set to be 0, since 0 times is allowed.
		// dp[k][0] is set to be 0, since no time is allowed.
		// dp[k][t] = max{dp[k][t-1],max_(0->t-1)(dp[k-1][tt]+p[t]-p[tt])}
		for (int k = 1; k <= 2; k++) {
			int temp = dp[k - 1][0] - p[0];
			for (int t = 1; t < len; t++) {
				temp = Math.max(temp, dp[k - 1][t - 1] - p[t - 1]);
				dp[k][t] = Math.max(dp[k][t - 1], temp + p[t]);

			}

		}

		return dp[K][len-1];
	}
}
