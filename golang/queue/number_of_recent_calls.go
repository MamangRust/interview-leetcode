package main

import (
	"container/list"
)

type RecentCounter struct {
	queue *list.List
}

func Constructor() RecentCounter {
	return RecentCounter{
		queue: list.New(),
	}
}

func (this *RecentCounter) Ping(t int) int {
	this.queue.PushBack(t)

	for this.queue.Front() != nil && this.queue.Front().Value.(int) < t-3000 {
		this.queue.Remove(this.queue.Front())
	}

	return this.queue.Len()
}
