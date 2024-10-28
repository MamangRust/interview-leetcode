package main

import "math"

func minSubArrayLen(target int, nums []int) int {
	n := len(nums)

	left, currentSum, minLength := 0, 0, math.MaxInt32

	for right := 0; right < n; right++ {
		currentSum += nums[right]

		for currentSum >= target {
			if minLength > right-left+1 {
				minLength = right - left + 1
			}

			currentSum -= nums[left]

			left++
		}
	}

	if minLength == math.MaxInt32 {
		return 0
	}

	return minLength
}
