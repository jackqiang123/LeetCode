package problem121;

//Say you have an array for which the ith element is the price of a given stock on day i.
//
//If you were only permitted to complete at most one transaction 
//(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

public class Solution {
	public static int maxProfit(int[] prices) {

		int length = prices.length;
		if (length == 1 || length == 0)
			return 0;
		
		int lowestprice[] = new int[length];
		lowestprice[0] = prices[0];
		int currentbest = 0;
		for (int i = 1; i < length; i++) {
			
			lowestprice[i] = lowestprice[i-1];
			if (lowestprice[i-1] < prices[i-1])
				lowestprice[i] = lowestprice[i-1];
			else
				lowestprice[i] = prices[i-1];
			System.out.println("current lowest at "+i +" is:"+lowestprice[i]);
			int bene = prices[i] - lowestprice[i];
			System.out.println("current price is "+ prices[i]+  " current bene at "+i +" is:"+bene);
			if (bene > currentbest)
				currentbest = bene;

		}
		return currentbest;

	}
	public static void main(String[]args)
	{
		int p []= {2,1,4};
		maxProfit(p);
	}

}