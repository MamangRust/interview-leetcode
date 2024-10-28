package main

func removeDuplicate_(nums []int) int {
	if len(nums) <= 2 {
		return len(nums)
	}

	i := 2

	for j := 2; j < len(nums); j++ {
		if nums[j] != nums[i-2] {
			nums[i] = nums[j]

			i += 1
		}
	}

	return i
}
