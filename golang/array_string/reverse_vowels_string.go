package main

func isVowel(ch rune) bool {
	vowels := "aeiouAEIOU"

	for _, v := range vowels {
		if ch == v {
			return true
		}
	}

	return false
}

func reverseVowels(s string) string {
	runes := []rune(s)

	left, right := 0, len(runes)-1

	for left < right {
		for left < right && !isVowel(runes[left]) {
			left++
		}

		for left < right && !isVowel(runes[right]) {
			right--
		}

		if left < right {
			runes[left], runes[right] = runes[right], runes[left]

			left++

			right--
		}
	}

	return string(runes)
}
