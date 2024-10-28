package main

import "strings"

func reverseWords(s string) string {
	words := strings.Fields(s)

	var reversedWords []string

	for i := len(words) - 1; i >= 0; i-- {
		reversedWords = append(reversedWords, words[i])
	}

	return strings.Join(reversedWords, " ")
}
