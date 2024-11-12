package main

func insert(intervals [][]int, new_interval []int) [][]int {
	result := [][]int{}
	i := 0
	n := len(intervals)

	for i < n && intervals[i][1] < new_interval[0] {
		result = append(result, intervals[i])
		i++
	}

	for i < n && intervals[i][0] <= new_interval[1] {
		new_interval[0] = min(new_interval[0], intervals[i][0])
		new_interval[1] = max(new_interval[1], intervals[i][1])

		i++
	}

	result = append(result, new_interval)

	for i < n {
		result = append(result, intervals[i])

		i++
	}

	return result
}
