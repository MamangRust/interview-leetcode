from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) == 0:
            return 0

        firstBuy, firstSell = -prices[0], 0
        secondBuy, secondSell = -prices[0], 0

        for price in prices[1:]:
            firstBuy = max(firstBuy, -price)
    		firstSell = max(firstSell, firstBuy+price)

    		secondBuy = max(secondBuy, firstSell-price)

    		secondSell = max(secondSell, secondBuy+price)

        return secondSell
