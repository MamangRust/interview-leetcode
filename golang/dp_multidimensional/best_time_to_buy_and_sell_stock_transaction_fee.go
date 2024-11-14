package main

func maxProfit(prices []int, fee int) int {
	n := len(prices)

	if n == 0 {
		return 0
	}

	hold, cash := -prices[0], 0

	for i := 1; i < n; i++ {
		hold = max(hold, cash-prices[i])
		cash = max(cash, hold+prices[i]-fee)
	}

	return cash
}
