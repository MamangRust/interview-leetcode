package main

func rob(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	if len(nums) == 1 {
		return nums[0]
	}

	prev2, prev1 := 0, 0

	for _, num := range nums {
		current := max(prev1, prev2+num)

		prev2 = prev1

		prev1 = current
	}

	return prev1
}
