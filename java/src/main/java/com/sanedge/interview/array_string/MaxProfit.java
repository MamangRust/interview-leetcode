package com.sanedge.interview.array_string;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;

        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }

            int profit = price - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
