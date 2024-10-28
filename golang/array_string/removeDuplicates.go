package main

func removeDuplicate(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	slow := 0

	for fast := 1; fast < len(nums); fast++ {
		if nums[fast] != nums[slow] {
			slow += 1
			nums[slow] = nums[fast]
		}
	}

	return slow + 1
}
