package main

func minPathSum(grid [][]int) int {
	if len(grid) == 0 || len(grid[0]) == 0 {
		return 0
	}

	rows := len(grid)
	cols := len(grid[0])

	for i := 1; i < rows; i++ {
		grid[i][0] += grid[i-1][0]
	}

	for j := 1; j < cols; j++ {
		grid[0][j] += grid[0][j-1]
	}

	for i := 1; i < rows; i++ {
		for j := 1; j < cols; j++ {
			grid[i][j] += min(grid[i-1][j], grid[i][j-1])
		}
	}

	return grid[rows-1][cols-1]
}
