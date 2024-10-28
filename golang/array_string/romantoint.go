package main

func romanToInt(s string) int {
	roman_to_int := map[byte]int{
		'I': 1,
		'V': 5,
		'X': 10,
		'L': 50,
		'C': 100,
		'D': 500,
		'M': 1000,
	}

	total := 0

	for i := 0; i < len(s); i++ {
		if i < len(s)-1 && roman_to_int[s[i]] < roman_to_int[s[i+1]] {
			total -= roman_to_int[s[i]]
		} else {
			total += roman_to_int[s[i]]
		}
	}

	return total
}
