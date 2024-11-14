package main

func maxProfit(k int, prices []int) int {
	if len(prices) == 0 || k == 0 {
		return 0
	}

	if k >= len(prices)/2 {
		return maxProfitUnlimited(prices)
	}

	profit := make([][]int, k+1)

	for i := range profit {
		profit[i] = make([]int, len(prices))
	}

	for i := 1; i <= k; i++ {
		maxDiff := -prices[0]

		for j := 1; j < len(prices); j++ {
			profit[i][j] = max(profit[i][j-1], prices[j]+maxDiff)

			maxDiff = max(maxDiff, profit[i-1][j]-prices[j])
		}
	}

	return profit[k][len(prices)-1]
}

func maxProfitUnlimited(prices []int) int {
	totalProfit := 0

	for i := 1; i < len(prices); i++ {
		if prices[i] > prices[i-1] {
			totalProfit += prices[i] - prices[i-1]
		}
	}

	return totalProfit
}
