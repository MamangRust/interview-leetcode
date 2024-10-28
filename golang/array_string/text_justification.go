package main

import "strings"

func fullJustify(words []string, maxWidth int) []string {
	var result []string

	var line []string

	lineLength := 0

	for _, word := range words {
		if lineLength+len(word)+len(line) > maxWidth {
			// Distribute spaces evenly
			if len(line) == 1 {
				// If there's only one word, add all spaces at the end
				result = append(result, line[0]+strings.Repeat(" ", maxWidth-lineLength))
			} else {
				// Distribute spaces between words
				totalSpaces := maxWidth - lineLength
				for i := 0; i < totalSpaces; i++ {
					line[i%(len(line)-1)] += " "
				}
				result = append(result, strings.Join(line, ""))
			}
			// Reset for the next line
			line, lineLength = []string{}, 0
		}
		// Add the word to the current line
		line = append(line, word)
		lineLength += len(word)
	}

	lastLine := strings.Join(line, " ")
	result = append(result, lastLine+strings.Repeat(" ", maxWidth-len(lastLine)))

	return result
}
