package main

func maxProfit_(prices []int) int {
	max_profit := 0

	for i := 1; i < len(prices); i++ {
		if prices[i] > prices[i-1] {
			max_profit += prices[i] - prices[i-1]
		}
	}

	return max_profit
}
