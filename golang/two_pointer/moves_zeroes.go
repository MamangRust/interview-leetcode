package main

func moveZeroes(nums []int) {
	lastNonZeroFoundAt := 0

	for current := 0; current < len(nums); current++ {
		if nums[current] != 0 {
			nums[lastNonZeroFoundAt], nums[current] = nums[current], nums[lastNonZeroFoundAt]

			lastNonZeroFoundAt++
		}
	}
}
