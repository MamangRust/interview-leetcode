package main

import (
	"strings"
)

func convert(s string, numRows int) string {
	if numRows == 1 {
		return s
	}

	rows := make([]string, min(numRows, len(s)))

	curRow := 0

	goingDown := false

	for _, char := range s {
		rows[curRow] += string(char)

		if curRow == 0 || curRow == numRows-1 {
			goingDown = !goingDown
		}

		if goingDown {
			curRow++
		} else {
			curRow--
		}
	}

	return strings.Join(rows, "")
}
