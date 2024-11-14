package main

import "container/heap"

type Worker struct {
	cost  int
	index int
}

type MinHeap []Worker

func (h MinHeap) Len() int           { return len(h) }
func (h MinHeap) Less(i, j int) bool { return h[i].cost < h[j].cost }
func (h MinHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *MinHeap) Push(x interface{}) {
	*h = append(*h, x.(Worker))
}

func (h *MinHeap) Pop() interface{} {
	old := *h
	n := len(old)
	item := old[n-1]
	*h = old[0 : n-1]
	return item
}

func totalCost(costs []int, k int, candidates int) int64 {
	n := len(costs)
	leftHeap := &MinHeap{}
	rightHeap := &MinHeap{}

	for i := 0; i < candidates; i++ {
		heap.Push(leftHeap, Worker{cost: costs[i], index: i})
		heap.Push(rightHeap, Worker{cost: costs[n-i-1], index: n - i - 1})
	}

	totalCost := int64(0)
	leftIndex, rightIndex := candidates, n-candidates-1

	for i := 0; i < k; i++ {
		var minCostWorker Worker

		if leftHeap.Len() > 0 && (rightHeap.Len() == 0 || (*leftHeap)[0].cost <= (*rightHeap)[0].cost) {
			minCostWorker = heap.Pop(leftHeap).(Worker)

			// Add the next available worker from the left side if possible
			if leftIndex <= rightIndex {
				heap.Push(leftHeap, Worker{cost: costs[leftIndex], index: leftIndex})
				leftIndex++
			}
		} else {
			minCostWorker = heap.Pop(rightHeap).(Worker)

			// Add the next available worker from the right side if possible
			if leftIndex <= rightIndex {
				heap.Push(rightHeap, Worker{cost: costs[rightIndex], index: rightIndex})
				rightIndex--
			}
		}

		totalCost += int64(minCostWorker.cost)
	}

	return totalCost
}
