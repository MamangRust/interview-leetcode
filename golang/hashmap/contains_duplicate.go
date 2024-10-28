package main

func containsNearbyDuplicate(nums []int, k int) bool {
	numIndices := make(map[int]int)

	for i, num := range nums {
		if j, found := numIndices[num]; found && i-j <= k {
			return true
		}

		numIndices[num] = i
	}

	return false
}
