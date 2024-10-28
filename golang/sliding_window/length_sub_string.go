package main

func lengthOfLongestSubString(s string) int {
	charIndex := make(map[byte]int)

	left, maxLength := 0, 0

	for right := 0; right < len(s); right++ {
		if idx, found := charIndex[s[right]]; found && idx >= left {
			left = idx + 1
		}

		charIndex[s[right]] = right

		maxLength = max(maxLength, right-left+1)
	}

	return maxLength
}
