package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func rotateRight(head *ListNode, k int) *ListNode {
	if head == nil || head.Next == nil || k == 0 {
		return head
	}

	length := 1
	tail := head

	for tail.Next != nil {
		tail = tail.Next
		length++
	}

	tail.Next = head

	k = k % length

	stepsToNewTail := length - k

	newTail := head

	for i := 0; i < stepsToNewTail-1; i++ {
		newTail = newTail.Next
	}

	newHead := newTail.Next

	newTail.Next = nil

	return newHead
}
