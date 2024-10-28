package main

import "strconv"

func summaryRanges(nums []int) []string {
	ranges := []string{}

	if len(nums) == 0 {
		return ranges
	}

	start := nums[0]

	for i := 1; i <= len(nums); i++ {
		if nums[i] != nums[i-1]+1 {
			if start == nums[i-1] {
				ranges = append(ranges, strconv.Itoa(start))
			} else {
				ranges = append(ranges, strconv.Itoa(start)+"->"+strconv.Itoa(nums[i-1]))
			}

			start = nums[i]
		}
	}

	if start == nums[len(nums)-1] {
		ranges = append(ranges, strconv.Itoa(start))
	} else {
		ranges = append(ranges, strconv.Itoa(start)+"->"+strconv.Itoa(nums[len(nums)-1]))
	}

	return ranges
}
