package main

import "sort"

func suggestedProducts(products []string, searchWord string) [][]string {

	sort.Strings(products)

	result := [][]string{}
	prefix := ""

	for i := 0; i < len(searchWord); i++ {
		prefix += string(searchWord[i])

		suggestions := []string{}

		for _, product := range products {
			if len(product) >= len(prefix) && product[:len(prefix)] == prefix {
				suggestions = append(suggestions, product)
			}

			if len(suggestions) == 3 {
				break
			}
		}

		result = append(result, suggestions)
	}

	return result
}
