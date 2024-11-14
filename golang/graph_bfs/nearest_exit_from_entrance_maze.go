package main

func nearestExit(maze [][]byte, entrance []int) int {
	rows, cols := len(maze), len(maze[0])

	directions := [][2]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
	queue := [][]int{{
		entrance[0],
		entrance[1],
		0,
	}}

	maze[entrance[0]][entrance[1]] = '#'

	for len(queue) > 0 {
		current := queue[0]
		queue = queue[1:]

		row, col, dist := current[0], current[1], current[2]

		if (row != entrance[0] || col != entrance[1]) && (row == 0 || col == 0 || row == rows-1 || col == cols-1) {
			return dist
		}

		for _, dir := range directions {
			newRow, newCol := row+dir[0], col+dir[1]
			if newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && maze[newRow][newCol] == '.' {
				maze[newRow][newCol] = '#'
				queue = append(queue, []int{newRow, newCol, dist + 1})
			}
		}
	}

	return -1

}
