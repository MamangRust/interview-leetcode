package main

func largestAltitude(gain []int) int {
	result := 0

	sum := 0

	for _, n := range gain {
		sum += n

		result = max(result, sum)
	}

	return result
}
