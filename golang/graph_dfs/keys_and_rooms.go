package main

func canVisitAllRooms(rooms [][]int) bool {
	visited := make([]bool, len(rooms))
	visited[0] = true

	queue := []int{0}

	for len(queue) > 0 {
		room := queue[0]
		queue = queue[1:]

		for _, key := range rooms[room] {
			if !visited[key] {
				visited[key] = true

				queue = append(queue, key)
			}
		}
	}

	for _, v := range visited {
		if !v {
			return false
		}
	}

	return true
}
