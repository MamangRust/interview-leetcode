package main

import "sort"

func groupAnagrams(strs []string) [][]string {
	anagrams := make(map[string][]string)

	for _, word := range strs {
		sortedWord := sortString(word)

		anagrams[sortedWord] = append(anagrams[sortedWord], word)
	}

	result := [][]string{}

	for _, group := range anagrams {
		result = append(result, group)
	}

	return result
}

func sortString(s string) string {
	runes := []rune(s)

	sort.Slice(runes, func(i, j int) bool {
		return runes[i] < runes[j]
	})

	return string(runes)
}
