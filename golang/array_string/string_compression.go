package main

import "strconv"

func compress(chars []byte) int {
	write := 0

	for read := 0; read < len(chars); {
		char := chars[read]

		count := 0

		for read < len(chars) && chars[read] == char {
			read++

			count++
		}

		chars[write] = char

		write++

		if count > 1 {
			for _, c := range strconv.Itoa(count) {
				chars[write] = byte(c)

				write++
			}
		}
	}

	return write
}
