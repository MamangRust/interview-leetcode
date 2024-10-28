package main

import "math"

func candy(ratings []int) int {
	n := len(ratings)

	if n == 0 {
		return 0
	}

	candies := make([]int, n)

	for i := range candies {
		candies[i] = 1
	}

	for i := 1; i < n; i++ {
		if ratings[i] > ratings[i-1] {
			candies[i] = candies[i-1] + 1
		}
	}

	for i := n - 2; i >= 0; i-- {
		if ratings[i] > ratings[i+1] {
			candies[i] = int(math.Max(float64(candies[i]), float64(candies[i+1]+1)))
		}
	}

	totalCandies := 0
	for _, c := range candies {
		totalCandies += c
	}

	return totalCandies
}
