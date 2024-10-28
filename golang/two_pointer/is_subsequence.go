package main

func preprocess(t string) map[rune][]int {
	charIndices := make(map[rune][]int)

	for i, char := range t {
		charIndices[char] = append(charIndices[char], i)
	}

	return charIndices
}

func isSubsequenceOptimized(s string, t string) bool {
	charIndices := preprocess(t)

	currentIndex := -1

	for _, char := range s {
		indices, exists := charIndices[char]

		if !exists {
			return false
		}

		found := false

		for _, index := range indices {
			if index > currentIndex {
				currentIndex = index

				found = true

				break
			}
		}

		if !found {
			return false
		}
	}

	return true
}
