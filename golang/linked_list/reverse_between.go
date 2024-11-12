package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseBetween(head *ListNode, left int, right int) *ListNode {
	if head == nil || left == right {
		return head
	}

	dummy := &ListNode{Next: head}

	prev := dummy

	for i := 0; i < left-1; i++ {
		prev = prev.Next
	}

	reverseStart := prev.Next
	then := reverseStart.Next

	for i := 0; i < right-left; i++ {
		reverseStart.Next = then.Next

		then.Next = prev.Next
		prev.Next = then
		then = reverseStart.Next
	}

	return dummy.Next
}
