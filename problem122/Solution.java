package problem122;

public class Solution {
	public int maxProfit(int[] prices) {
		int time = prices.length;
		if (time <= 1)
			return 0;

		int currentmax = 0;

		for (int d = 0; d < time - 1; d++) // decide the buying date
		{
			int diff = prices[d + 1] - prices[d];
			if (diff > 0) {
				currentmax = currentmax+diff;
			}

		}

		return currentmax;
	}

}
