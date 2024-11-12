package main

import "sort"

func merge(intervals [][]int) [][]int {
	if len(intervals) == 0 {
		return [][]int{}
	}

	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})

	merged := [][]int{intervals[0]}

	for i := 1; i < len(intervals); i++ {
		lastMerged := merged[len(merged)-1]

		current := intervals[i]

		if current[0] <= lastMerged[1] {
			lastMerged[1] = max(lastMerged[1], current[1])
		} else {
			merged = append(merged, current)
		}
	}

	return merged
}
