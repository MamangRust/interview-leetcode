package main

func uniqueOccurrences(arr []int) bool {
	freqMap := make(map[int]int)

	for _, num := range arr {
		freqMap[num]++
	}

	freqSet := make(map[int]struct{})

	for _, freq := range freqMap {
		if _, exists := freqSet[freq]; exists {
			return false
		}

		freqSet[freq] = struct{}{}
	}

	return true

}
