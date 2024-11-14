package main

func guess(num int) int {
	target := 6

	if num < target {
		return 1
	} else if num > target {
		return -1
	}

	return 0
}

func guessNumber(n int) int {
	low, high := 1, n

	for low <= high {
		mid := low + (high-low)/2

		result := guess(mid)

		if result == 0 {
			return mid
		} else if result < 0 {
			high = mid - 1
		} else {
			low = mid + 1
		}
	}

	return -1
}
