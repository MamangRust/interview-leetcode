package main

func searchRange(nums []int, target int) []int {
	return []int{
		findFirst(nums, target),
		findLast(nums, target),
	}
}

func findFirst(nums []int, target int) int {
	left, right := 0, len(nums)-1

	firstPos := -1

	for left <= right {
		mid := left + (right-left)/2

		if nums[mid] == target {
			firstPos = mid
			right = mid - 1
		} else if nums[mid] < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}

	return firstPos
}

func findLast(nums []int, target int) int {
	left, right := 0, len(nums)-1

	lastPost := -1

	for left <= right {
		mid := left + (right-left)/2

		if nums[mid] == target {
			lastPost = mid

			left = mid + 1
		} else if nums[mid] < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}

	return lastPost
}
