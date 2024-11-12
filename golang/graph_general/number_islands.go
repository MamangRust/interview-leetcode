package main

func numIslands(grid [][]byte) int {
	if len(grid) == 0 {
		return 0
	}

	numIslands := 0

	rows := len(grid)
	cols := len(grid[0])

	var dfs func(r, c int)

	dfs = func(r, c int) {
		if r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == '0' {
			return
		}

		grid[r][c] = '0'

		dfs(r+1, c) // bawah
		dfs(r-1, c) // atas
		dfs(r, c+1) // kanan
		dfs(r, c-1) // kiri
	}

	for r := 0; r < rows; r++ {

		for c := 0; c < cols; c++ {
			if grid[r][c] == '1' {
				numIslands++
				dfs(r, c)
			}
		}
	}

	return numIslands
}
