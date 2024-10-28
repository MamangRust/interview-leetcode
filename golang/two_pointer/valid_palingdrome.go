package main

import "unicode"

func isPalingdrome(s string) bool {
	var filteredChars []rune

	for _, char := range s {
		if unicode.IsLetter(char) || unicode.IsDigit(char) {
			filteredChars = append(filteredChars, unicode.ToLower(char))
		}
	}

	for i, j := 0, len(filteredChars)-1; i < j; i, j = i+1, j-1 {
		if filteredChars[i] != filteredChars[j] {
			return false
		}
	}

	return true
}
