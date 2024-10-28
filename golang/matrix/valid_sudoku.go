package main

func isValidSudoku(board [][]byte) bool {
	rows := make([]map[byte]bool, 9)
	cols := make([]map[byte]bool, 9)
	boxes := make([]map[byte]bool, 9)

	for i := 0; i < 9; i++ {
		rows[i] = make(map[byte]bool)
		cols[i] = make(map[byte]bool)
		boxes[i] = make(map[byte]bool)
	}

	for r := 0; r < 9; r++ {
		for c := 0; c < 9; c++ {
			num := board[r][c]

			if num == '.' {
				continue
			}

			if rows[r][num] {
				return false
			}

			rows[r][num] = true

			if cols[c][num] {
				return false
			}

			cols[c][num] = true

			boxIndex := (r/3)*3 + c/3

			if boxes[boxIndex][num] {
				return false
			}

			boxes[boxIndex][num] = true

		}
	}

	return true
}
