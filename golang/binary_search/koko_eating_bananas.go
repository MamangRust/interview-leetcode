package main

func minEatingSpeed(piles []int, h int) int {
	canFinish := func(k int) bool {
		time := 0

		for _, pile := range piles {
			time += (pile + k - 1) / k
		}

		return time <= h
	}

	left, right := 1, 0

	for _, pile := range piles {
		if pile > right {
			right = pile
		}
	}

	for left < right {
		mid := (left + right) / 2

		if canFinish(mid) {
			right = mid
		} else {
			left = mid + 1
		}
	}

	return left
}
