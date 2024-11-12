package main

func maxProfit(prices []int) int {
	if len(prices) == 0 {
		return 0
	}

	firstBuy, firstSell := -prices[0], 0
	secondBuy, secondSell := -prices[0], 0

	for _, price := range prices[1:] {
		firstBuy = max(firstBuy, -price)
		firstSell = max(firstSell, firstBuy+price)

		secondBuy = max(secondBuy, firstSell-price)

		secondSell = max(secondSell, secondBuy+price)
	}

	return secondSell
}
