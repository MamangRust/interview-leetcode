package main

func findSubstring(s string, words []string) []int {
	if len(s) == 0 || len(words) == 0 {
		return []int{}
	}

	wordLen := len(words[0])
	wordCount := len(words)
	totalLen := wordLen * wordCount

	wordMap := make(map[string]int)

	result := []int{}

	for _, word := range words {
		wordMap[word]++
	}

	for i := 0; i < wordLen; i++ {
		left, right := i, i

		currMap := make(map[string]int)

		for right+wordLen <= len(s) {
			word := s[right : right+wordLen]
			right += wordLen

			if count, found := wordMap[word]; found {
				currMap[word]++

				for currMap[word] > count {
					leftWord := s[left : left+wordLen]

					currMap[leftWord]--
					left += wordLen
				}

				if right-left == totalLen {
					result = append(result, left)
				}
			} else {
				currMap = make(map[string]int)

				left = right
			}
		}
	}

	return result
}
