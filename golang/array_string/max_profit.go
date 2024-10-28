package main

import "math"

func maxProfit(prices []int) int {
	minPrice := math.MaxInt32

	maxProfit := 0

	for _, price := range prices {
		if price < minPrice {
			minPrice = price
		}

		profit := price - minPrice

		if profit > maxProfit {
			maxProfit = profit
		}
	}

	return maxProfit
}
