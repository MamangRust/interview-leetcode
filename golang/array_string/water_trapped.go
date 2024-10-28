package main

func trap(height []int) int {
	if len(height) == 0 {
		return 0
	}

	left, right := 0, len(height)-1

	left_max, right_max := height[left], height[right]

	water_trapped := 0

	for left < right {
		if height[left] < height[right] {
			left_max = max(left_max, height[left])

			water_trapped += left_max - height[left]

			left += 1
		} else {
			right_max = max(right_max, height[right])

			water_trapped += right_max - height[right]

			right -= 1
		}
	}

	return water_trapped
}
