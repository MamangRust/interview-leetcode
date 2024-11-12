package main

func maxSubarraySumCircular(nums []int) int {
	totalSum := 0
	maxSum := nums[0]
	minSum := nums[0]
	currMax := nums[0]
	currMin := nums[0]

	for i := 1; i < len(nums); i++ {
		num := nums[i]
		totalSum += num

		// Kadane untuk maksimum subarray linier
		currMax = max(num, currMax+num)
		maxSum = max(maxSum, currMax)

		// Kadane untuk minimum subarray linier
		currMin = min(num, currMin+num)
		minSum = min(minSum, currMin)
	}

	totalSum += nums[0]

	if maxSum < 0 {
		return maxSum
	}

	return max(maxSum, totalSum-minSum)
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
