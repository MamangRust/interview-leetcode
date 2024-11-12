package main

func partition(head *ListNode, x int) *ListNode {
	leftDummy := &ListNode{}
	rightDummy := &ListNode{}

	left := leftDummy
	right := rightDummy

	current := head

	for current != nil {
		if current.Val < x {
			left.Next = current
			left = left.Next
		} else {
			right.Next = current
			right = right.Next
		}

		current = current.Next
	}

	right.Next = nil
	left.Next = rightDummy.Next

	return leftDummy.Next
}
