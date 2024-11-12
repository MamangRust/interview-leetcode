package main

func longestPalindrome(s string) string {
	if len(s) < 2 {
		return s
	}

	start, maxLength := 0, 1

	expandAroundCenter := func(left, right int) {
		for left >= 0 && right < len(s) && s[left] == s[right] {
			if right-left+1 > maxLength {
				start = left

				maxLength = right - left + 1
			}

			left--
			right++
		}
	}

	for i := 0; i < len(s); i++ {
		expandAroundCenter(i, i)
		expandAroundCenter(i, i+1)
	}

	return s[start : start+maxLength]
}
