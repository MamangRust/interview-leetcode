package com.sanedge.interview.array_string;

public class MaxProfitII {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }
}
