package main

import "sort"

func successfulPairs(spells []int, potions []int, success int64) []int {
	sort.Ints(potions)

	n := len(potions)
	result := make([]int, len(spells))

	for i, spell := range spells {
		minPotionStrength := (success + int64(spell) - 1) / int64(spell)

		idx := sort.Search(n, func(j int) bool {
			return int64(potions[j]) >= minPotionStrength
		})

		result[i] = n - idx
	}

	return result
}
