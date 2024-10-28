package main

func twoSum_II(numbers []int, target int) []int {
	left, right := 0, len(numbers)-1

	for left < right {
		current_sum := numbers[left] + numbers[right]

		if current_sum == target {
			return []int{left + 1, right + 1}
		} else if current_sum < target {
			left += 1
		} else {
			right -= 1
		}
	}

	return []int{-1, -1}
}
