package main

func letterCombinations(digits string) []string {
	if len(digits) == 0 {
		return []string{}
	}

	digitToLetters := map[byte]string{
		'2': "abc",
		'3': "def",
		'4': "ghi",
		'5': "jkl",
		'6': "mno",
		'7': "pqrs",
		'8': "tuv",
		'9': "wxyz",
	}

	var result []string

	var backtrack func(index int, path string)

	backtrack = func(index int, path string) {
		if index == len(digits) {
			result = append(result, path)

			return
		}

		letters := digitToLetters[digits[index]]

		for i := 0; i < len(letters); i++ {
			backtrack(index+1, path+string(letters[i]))
		}
	}

	backtrack(0, "")

	return result
}
