package main

import "container/heap"

type SmallestInfiniteSet struct {
	heap         *MinHeap
	extractedSet map[int]bool
	nextNum      int
}

type MinHeap []int

func (h MinHeap) Len() int           { return len(h) }
func (h MinHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h MinHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *MinHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *MinHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func Constructor() SmallestInfiniteSet {
	return SmallestInfiniteSet{
		heap:         &MinHeap{},
		extractedSet: make(map[int]bool),
		nextNum:      1,
	}
}

func (this *SmallestInfiniteSet) Add(num int) {
	if !this.extractedSet[num] {
		heap.Push(this.heap, num)

		this.extractedSet[num] = true
	}
}

func (this *SmallestInfiniteSet) PopSmallest() int {
	if len(*this.heap) > 0 {
		smallest := heap.Pop(this.heap).(int)
		delete(this.extractedSet, smallest)
		return smallest
	}

	this.nextNum++

	return this.nextNum - 1
}

func (this *SmallestInfiniteSet) AddBack(num int) {
	if num < this.nextNum && !this.extractedSet[num] {
		heap.Push(this.heap, num)
		this.extractedSet[num] = true
	}
}
