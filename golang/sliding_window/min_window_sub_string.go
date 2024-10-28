package main

import "math"

func minWindow(s string, t string) string {
	if len(t) > len(s) {
		return ""
	}

	tCount := make(map[byte]int)

	for i := 0; i < len(t); i++ {
		tCount[t[i]]++
	}

	required := len(tCount)
	windowCount := make(map[byte]int)

	left, right, formed := 0, 0, 0

	minLen := math.MaxInt32
	start, end := 0, 0

	for right < len(s) {
		char := s[right]

		windowCount[char]++

		if val, found := tCount[char]; found && windowCount[char] == val {
			formed++
		}

		for left <= right && formed == required {
			if right-left+1 < minLen {
				minLen = right - left + 1

				start, end = left, right
			}

			leftChar := s[left]

			windowCount[leftChar] -= 1

			if val, found := tCount[leftChar]; found && windowCount[leftChar] < val {
				formed--
			}

			left++
		}

		right++
	}

	if minLen == math.MaxInt32 {
		return ""
	}

	return s[start : end+1]
}
