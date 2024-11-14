package main

func longestOnes(nums []int, k int) int {
	maxLen := 0
	left := 0
	zeroCount := 0

	for right := 0; right < len(nums); right++ {
		if nums[right] == 0 {
			zeroCount++
		}

		for zeroCount > k {
			if nums[left] == 0 {
				zeroCount--
			}

			left++
		}

		maxLen = max(maxLen, right-left+1)
	}

	return maxLen

}
