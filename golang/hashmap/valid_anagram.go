package main

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	charCount := make(map[rune]int)

	for _, char := range s {
		charCount[char]++
	}

	for _, char := range t {
		if _, exists := charCount[char]; exists {
			charCount[char]--

			if charCount[char] < 0 {
				return false
			}
		} else {
			return false
		}
	}

	for _, count := range charCount {
		if count != 0 {
			return false
		}
	}

	return true
}
