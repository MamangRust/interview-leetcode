package main

func totalNQueens(n int) int {
	count := 0

	var backtrack func(row int, cols, diags1, diags2 map[int]bool)
	backtrack = func(row int, cols, diags1, diags2 map[int]bool) {
		if row == n {
			count++

			return
		}

		for col := 0; col < n; col++ {
			diag1 := row - col
			diag2 := row + col

			if cols[col] || diags1[diag1] || diags2[diag2] {
				continue
			}

			cols[col], diags1[diag1], diags2[diag2] = true, true, true

			backtrack(row+1, cols, diags1, diags2)

			cols[col], diags1[diag1], diags2[diag2] = false, false, false

		}
	}

	backtrack(0, map[int]bool{}, map[int]bool{}, map[int]bool{})

	return count

}
