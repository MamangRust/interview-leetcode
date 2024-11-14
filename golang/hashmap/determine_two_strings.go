package main

import "sort"

func closeStrings(word1 string, word2 string) bool {
	if len(word1) != len(word2) {
		return false
	}

	freq1 := make(map[rune]int)
	freq2 := make(map[rune]int)

	for _, c := range word1 {
		freq1[c]++
	}

	for _, c := range word2 {
		freq2[c]++
	}

	for c := range freq1 {
		if _, exists := freq2[c]; !exists {
			return false
		}
	}

	for c := range freq2 {
		if _, exists := freq1[c]; !exists {
			return false
		}
	}

	freqs1 := []int{}
	freqs2 := []int{}

	for _, count := range freq1 {
		freqs1 = append(freqs1, count)
	}

	for _, count := range freq2 {
		freqs2 = append(freqs2, count)
	}

	sort.Ints(freqs1)
	sort.Ints(freqs2)

	for i := 0; i < len(freqs1); i++ {
		if freqs1[i] != freqs2[i] {
			return false
		}
	}

	return true
}
