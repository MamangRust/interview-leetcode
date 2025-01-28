package com.sanedge.interview.dp_multidimensional;

public class BestTimeBuySellStockIV {

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }

        if (k >= prices.length / 2) {
            return maxProfitUnlimited(prices);
        }

        int[][] profit = new int[k + 1][prices.length];

        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];

            for (int j = 1; j < prices.length; j++) {
                profit[i][j] = Math.max(profit[i][j - 1], prices[j] + maxDiff);

                maxDiff = Math.max(maxDiff, profit[i - 1][j] - prices[j]);
            }
        }

        return profit[k][prices.length - 1];
    }

    private int maxProfitUnlimited(int[] prices) {
        int totalProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                totalProfit += prices[i] - prices[i - 1];
            }
        }

        return totalProfit;
    }
}
