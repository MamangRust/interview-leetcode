package main

type Graph map[string]map[string]float64

func calcEquation(equations [][]string, values []float64, queries [][]string) []float64 {
	graph := make(Graph)

	for i, eq := range equations {
		a, b := eq[0], eq[1]

		if graph[a] == nil {
			graph[a] = make(map[string]float64)
		}

		if graph[b] == nil {
			graph[b] = make(map[string]float64)
		}

		graph[a][b] = values[i]
		graph[b][a] = 1.0 / values[i]
	}

	var dfs func(start, end string, visited map[string]bool) float64

	dfs = func(start, end string, visited map[string]bool) float64 {
		if _, ok := graph[start]; !ok {
			return -1.0
		}

		if ratio, found := graph[start][end]; found {
			return ratio
		}

		visited[start] = true

		for neighbor, value := range graph[start] {
			if visited[neighbor] {
				continue
			}

			product := dfs(neighbor, end, visited)

			if product != -1.0 {
				return value * product
			}

		}

		return -1.0
	}

	results := make([]float64, len(queries))

	for i, query := range queries {
		start, end := query[0], query[1]

		if start == end {
			if _, exists := graph[start]; exists {
				results[i] = 1.0

			} else {
				results[i] = -1.0
			}
		} else {
			visited := make(map[string]bool)
			results[i] = dfs(start, end, visited)
		}
	}

	return results
}
