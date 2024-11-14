package main

func mergeAlternately(word1 string, word2 string) string {
	result := []byte{}

	i, j := 0, 0

	for i < len(word1) && j < len(word2) {
		result = append(result, word1[i], word2[j])

		i++

		j++
	}

	if i < len(word1) {
		result = append(result, word1[i:]...)
	}

	if j < len(word2) {
		result = append(result, word2[j:]...)
	}

	return string(result)
}
