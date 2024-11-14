package main

import (
	"fmt"
	"strings"
)

func equalPairs(mat [][]int) int {
	m, n := len(mat), len(mat[0])

	rowMap := make(map[string]int)
	count := 0

	for i := 0; i < m; i++ {
		rowKey := make([]string, n)
		for j := 0; j < n; j++ {
			rowKey[j] = fmt.Sprintf("%d", mat[i][j])
		}
		rowMap[strings.Join(rowKey, ",")]++
	}

	for j := 0; j < n; j++ {
		colKey := make([]string, m)
		for i := 0; i < m; i++ {
			colKey[i] = fmt.Sprintf("%d", mat[i][j])
		}
		count += rowMap[strings.Join(colKey, ",")]
	}

	return count
}
