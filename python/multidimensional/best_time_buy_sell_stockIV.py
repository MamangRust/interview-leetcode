from typing import List


class Solution:
    def maxProfit(self, k:int,prices: List[int]) -> int:
        if len(prices) == 0 or k == 0:
            return 0

        if k >= len(prices) // 2:
            return self.maxProfitUnlimited(prices)


        profit = [[0] * len(prices) for _ in range(k+1)]

        for i in range(1, k + 1):
            maxDiff = -prices[0]

            for j in range(1, len(prices)):
                profit[i][j ] = max(profit[i][j-1], prices[j] + maxDiff)
                maxDiff = max(maxDiff, profit[i-1][j] - prices[j])


        return profit[k][len(prices)-1]


    def maxProfitUnlimited(self, prices):
        totalProfit = 0

        for i in range(1, len(prices)):
            if prices[i] > prices[i-1]:
                totalProfit += prices[i] - prices[i-1]

        return totalProfit
