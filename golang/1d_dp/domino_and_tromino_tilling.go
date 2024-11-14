package main

func numTilings(n int) int {
	const mod = 1_000_000_007

	if n <= 2 {
		return n
	}

	dp := make([]int, n+1)
	dp2 := make([]int, n+1)

	dp[0], dp[1], dp[2] = 1, 1, 2
	dp2[1], dp2[2] = 0, 1

	for i := 3; i <= n; i++ {
		dp[i] = (dp[i-1] + dp[i-2] + 2*dp2[i-1]) % mod
		dp2[i] = (dp[i-2] + dp2[i-1]) % mod
	}

	return dp[n]
}
