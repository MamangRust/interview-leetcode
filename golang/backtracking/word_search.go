package main

func exist(board [][]byte, word string) bool {
	rows := len(board)
	cols := len(board[0])

	var dfs func(r, c, index int) bool

	dfs = func(r, c, index int) bool {
		if index == len(word) {
			return true
		}

		if r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != word[index] {
			return false
		}

		temp := board[r][c]
		board[r][c] = '#'

		directions := [][2]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}

		for _, dir := range directions {
			newR, newC := r+dir[0], c+dir[1]

			if dfs(newR, newC, index+1) {
				return true
			}
		}

		board[r][c] = temp

		return false
	}

	for r := 0; r < rows; r++ {
		for c := 0; c < cols; c++ {
			if board[r][c] == word[0] && dfs(r, c, 0) {
				return true
			}
		}
	}

	return false
}
