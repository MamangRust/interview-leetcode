package main

func isVowel(c byte) bool {
	vowels := "aeiouAEIOU"

	for i := 0; i < len(vowels); i++ {
		if c == vowels[i] {
			return true
		}
	}

	return false
}

func maxVowels(s string, k int) int {
	maxVowelCount := 0
	currentVowelCount := 0

	for i := 0; i < k; i++ {
		if isVowel(s[i]) {
			currentVowelCount++
		}
	}

	maxVowelCount = currentVowelCount

	for i := k; i < len(s); i++ {
		if isVowel(s[i]) {
			currentVowelCount++
		}

		if isVowel(s[i-k]) {
			currentVowelCount--
		}

		if currentVowelCount > maxVowelCount {
			maxVowelCount = currentVowelCount
		}
	}

	return maxVowelCount
}
