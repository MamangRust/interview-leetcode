package main

func orangesRotting(grid [][]int) int {
	rows, cols := len(grid), len(grid[0])

	directions := [][2]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}

	queue := [][]int{}
	healthyCount := 0

	for i := 0; i < rows; i++ {
		for j := 0; j < cols; j++ {
			if grid[i][j] == 2 {
				queue = append(queue, []int{i, j, 0})
			} else if grid[i][j] == 1 {
				healthyCount++
			}
		}
	}
	if healthyCount == 0 {
		return 0
	}

	time := 0

	for len(queue) > 0 {
		current := queue[0]
		queue = queue[1:]

		row, col, t := current[0], current[1], current[2]

		time = max(time, t)

		for _, dir := range directions {
			newRow, newCol := row+dir[0], col+dir[1]

			if newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1 {
				grid[newRow][newCol] = 2
				queue = append(queue, []int{newRow, newCol, t + 1})
				healthyCount--
			}
		}

	}
	if healthyCount > 0 {
		return -1
	}
	return time
}
