package main

func findOrder(numCourses int, prerequisites [][]int) []int {
	graph := make(map[int][]int)
	inDegree := make([]int, numCourses)

	for _, pre := range prerequisites {
		course, prereq := pre[0], pre[1]

		graph[prereq] = append(graph[prereq], course)

		inDegree[course]++
	}

	queue := []int{}

	for i := 0; i < numCourses; i++ {
		if inDegree[i] == 0 {
			queue = append(queue, i)
		}
	}

	order := []int{}

	for len(queue) > 0 {
		course := queue[0]

		queue = queue[1:]

		order = append(order, course)

		for _, nextCourse := range graph[course] {
			inDegree[nextCourse]--

			if inDegree[nextCourse] == 0 {
				queue = append(queue, nextCourse)
			}
		}
	}

	if len(order) != numCourses {
		return []int{}
	}

	return order
}
