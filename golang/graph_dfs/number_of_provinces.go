package main

func findCircleNum(isConnected [][]int) int {
	n := len(isConnected)
	visited := make([]bool, n)
	provinces := 0

	var dfs func(int)

	dfs = func(city int) {
		visited[city] = true

		for neighbor := 0; neighbor < n; neighbor++ {
			if isConnected[city][neighbor] == 1 && !visited[neighbor] {
				dfs(neighbor)
			}
		}
	}

	for i := 0; i < n; i++ {
		if !visited[i] {
			provinces++
			dfs(i)
		}
	}

	return provinces
}
