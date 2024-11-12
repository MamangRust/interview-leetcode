package main

import "container/heap"

type Pair struct {
	num1, num2, i, j int
}

type PriorityQueue []Pair

func (pq PriorityQueue) Len() int {
	return len(pq)
}

func (pq PriorityQueue) Less(i, j int) bool {
	return (pq[i].num1 + pq[i].num2) < (pq[j].num1 + pq[j].num2)
}
func (pq PriorityQueue) Swap(i, j int) { pq[i], pq[j] = pq[j], pq[i] }

func (pq *PriorityQueue) Push(x interface{}) {
	*pq = append(*pq, x.(Pair))
}

func (pq *PriorityQueue) Pop() interface{} {
	old := *pq
	n := len(old)

	x := old[n-1]

	*pq = old[0 : n-1]

	return x
}

func kSmallestPairs(nums1 []int, nums2 []int, k int) [][]int {
	if len(nums1) == 0 || len(nums2) == 0 || k == 0 {
		return [][]int{}
	}

	pq := &PriorityQueue{}

	heap.Init(pq)

	for i := 0; i < len(nums1) && i < k; i++ {
		heap.Push(pq, Pair{nums1[i], nums2[0], i, 0})
	}

	result := [][]int{}

	for k > 0 && pq.Len() > 0 {
		pair := heap.Pop(pq).(Pair)

		result = append(result, []int{pair.num1, pair.num2})

		k--

		if pair.j+1 < len(nums2) {
			heap.Push(pq, Pair{pair.num1, nums2[pair.j+1], pair.i, pair.j + 1})
		}
	}

	return result
}
