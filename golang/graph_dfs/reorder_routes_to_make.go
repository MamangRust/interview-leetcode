package main

func minReorder(n int, connections [][]int) int {
	graph := make(map[int][][]int)

	for _, connection := range connections {
		a, b := connection[0], connection[1]

		graph[a] = append(graph[a], []int{b, 1})
		graph[b] = append(graph[b], []int{a, 0})
	}

	visited := make([]bool, n)
	count := 0

	var dfs func(node int)
	dfs = func(node int) {
		visited[node] = true

		for _, neighbor := range graph[node] {
			if !visited[neighbor[0]] {
				if neighbor[1] == 1 {
					count++
				}

				dfs(neighbor[0])
			}
		}
	}

	dfs(0)

	return count
}
