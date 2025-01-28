package com.sanedge.interview.dp_multidimensional;

public class BestTimeToBuyAndSellStockTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        if (n == 0) {
            return 0;
        }

        int hold = -prices[0];
        int cash = 0;

        for (int i = 1; i < n; i++) {
            hold = Math.max(hold, cash - prices[i]);
            cash = Math.max(cash, hold + prices[i] - fee);
        }

        return cash;
    }
}
