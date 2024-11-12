package main

import "math"

type MinStack struct {
	stack    []int
	minStack []int
}

func Constructor() MinStack {
	return MinStack{
		stack:    []int{},
		minStack: []int{},
	}
}

func (ms *MinStack) Push(x int) {
	ms.stack = append(ms.stack, x)

	if len(ms.minStack) == 0 || x <= ms.minStack[len(ms.minStack)-1] {
		ms.minStack = append(ms.minStack, x)
	}
}

func (ms *MinStack) Pop() {
	if len(ms.stack) == 0 {
		return
	}

	top := ms.stack[len(ms.stack)-1]

	ms.stack = ms.stack[:len(ms.stack)-1]

	if top == ms.minStack[len(ms.minStack)-1] {
		ms.minStack = ms.minStack[:len(ms.minStack)-1]
	}
}

func (ms *MinStack) Top() int {
	if len(ms.stack) == 0 {
		return 0
	}

	return ms.stack[len(ms.stack)-1]
}

func (ms *MinStack) GetMin() int {
	if len(ms.minStack) == 0 {
		return math.MaxInt32
	}

	return ms.minStack[len(ms.minStack)-1]
}
