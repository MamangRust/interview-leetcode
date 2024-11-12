package main

import "unicode"

func calculate(s string) int {
	stack := []int{}
	currentNumber := 0

	result := 0
	sign := 1

	for _, char := range s {
		if unicode.IsDigit(char) {
			currentNumber = currentNumber*10 + int(char-'0')
		} else if char == '+' {
			result += sign * currentNumber
			currentNumber = 0
			sign = 1
		} else if char == '-' {
			result += sign * currentNumber
			currentNumber = 0

			sign = -1
		} else if char == '(' {
			stack = append(stack, result)
			stack = append(stack, sign)

			result = 0
			sign = 1
		} else if char == ')' {

			result += sign * currentNumber
			currentNumber = 0
			sign = stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			prevResult := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			result = prevResult + sign*result
		}
	}

	result += sign * currentNumber

	return result
}
