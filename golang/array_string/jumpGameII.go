package main

func jump(nums []int) int {
	if len(nums) <= 1 {
		return 0
	}

	jumps := 0      // Count of jumps needed
	currentEnd := 0 // End of the current jump range
	farthest := 0   // Farthest point we can reach

	for i := 0; i < len(nums)-1; i++ {
		// Update the farthest we can reach from the current position
		farthest = max(farthest, i+nums[i])

		// If we have reached the end of the current jump range
		if i == currentEnd {
			jumps++
			currentEnd = farthest // Update the end of the next jump range

			// Early exit if we can already reach the last index
			if currentEnd >= len(nums)-1 {
				break
			}
		}
	}

	return jumps
}

func max(a, b int) int {
	if a > b {
		return a
	}

	return b
}
