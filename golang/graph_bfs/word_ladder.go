package main

func ladderLength(beginWord string, endWord string, wordList []string) int {
	wordSet := make(map[string]bool)

	for _, word := range wordList {
		wordSet[word] = true
	}

	if !wordSet[endWord] {
		return 0
	}

	queue := []struct {
		word  string
		steps int
	}{{beginWord, 1}}

	for len(queue) > 0 {
		current := queue[0]
		queue = queue[1:]
		word := current.word
		steps := current.steps

		if word == endWord {
			return steps
		}

		wordBytes := []byte(word)

		for i := 0; i < len(wordBytes); i++ {
			originalChar := wordBytes[i]

			for c := 'a'; c <= 'z'; c++ {
				wordBytes[i] = byte(c)

				newWord := string(wordBytes)

				if wordSet[newWord] {
					queue = append(queue, struct {
						word  string
						steps int
					}{newWord, steps + 1})

					delete(wordSet, newWord)
				}
			}

			wordBytes[i] = originalChar
		}
	}

	return 0
}
