package main

func isValid(s string) bool {
	stack := []rune{}

	mapping := map[rune]rune{')': '(', '}': '{', ']': '['}

	for _, char := range s {
		if open, found := mapping[char]; found {
			if len(stack) == 0 || stack[len(stack)-1] != open {
				return false
			}

			stack = stack[:len(stack)-1]
		} else {
			stack = append(stack, char)
		}
	}

	return len(stack) == 0
}
