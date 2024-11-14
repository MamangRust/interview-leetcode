package main

func minCostClimbingStairs(cost []int) int {
	n := len(cost)

	if n == 2 {
		return min(cost[0], cost[1])
	}

	dp1, dp2 := cost[0], cost[1]

	for i := 2; i < n; i++ {
		current := cost[i] + min(dp1, dp2)

		dp1, dp2 = dp2, current
	}

	return min(dp1, dp2)
}
