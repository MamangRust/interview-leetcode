package main

import (
	"container/heap"
	"sort"
)

type Project struct {
	profit, capital int
}

type PriorityQueue []int

func (pq PriorityQueue) Len() int {
	return len(pq)
}

func (pq PriorityQueue) Less(i, j int) bool {
	return pq[i] > pq[j]
}

func (pq PriorityQueue) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
}

func (pq *PriorityQueue) Push(x interface{}) {
	*pq = append(*pq, x.(int))
}

func (pq *PriorityQueue) Pop() interface{} {
	old := *pq
	n := len(old)

	x := old[n-1]
	*pq = old[0 : n-1]

	return x
}

func findMaximizedCapital(k int, w int, profits []int, capital []int) int {
	projects := make([]Project, len(profits))

	for i := range profits {
		projects[i] = Project{
			profits[i],
			capital[i],
		}
	}

	sort.Slice(projects, func(i, j int) bool {
		return projects[i].capital < projects[j].capital
	})

	pq := &PriorityQueue{}

	heap.Init(pq)

	index := 0

	for i := 0; i < k; i++ {
		for index < len(projects) && projects[index].capital <= w {
			heap.Push(pq, projects[index].profit)

			index++
		}

		if pq.Len() == 0 {
			break
		}

		w += heap.Pop(pq).(int)
	}

	return w
}
