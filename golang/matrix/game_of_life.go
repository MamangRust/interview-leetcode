package main

func gameOfLife(board [][]int) {
	rows, cols := len(board), len(board[0])

	countLiveNeighbors := func(r, c int) int {
		directions := [][2]int{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}}

		count := 0

		for _, dir := range directions {
			nr, nc := r+dir[0], c+dir[1]

			if nr >= 0 && nr < rows && nc >= 0 && nc < cols && abs(board[nr][nc]) == 1 {
				count++
			}
		}

		return count
	}

	for r := 0; r < rows; r++ {
		for c := 0; c < cols; c++ {
			liveNeighbors := countLiveNeighbors(r, c)

			if board[r][c] == 1 && (liveNeighbors < 2 || liveNeighbors > 3) {
				board[r][c] = -1
			}

			if board[r][c] == 0 && liveNeighbors == 3 {
				board[r][c] = 2
			}
		}
	}

	for r := 0; r < rows; r++ {
		for c := 0; c < cols; c++ {
			if board[r][c] > 0 {
				board[r][c] = 1
			} else {
				board[r][c] = 0
			}
		}
	}
}

func abs(x int) int {
	if x < 0 {
		return -x
	}

	return x
}
