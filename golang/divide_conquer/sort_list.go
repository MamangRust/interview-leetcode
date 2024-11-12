package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func sortList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	n := 0

	current := head

	for current != nil {
		n++
		current = current.Next
	}

	dummy := &ListNode{Next: head}

	step := 1

	for step < n {
		prev, curr := dummy, dummy.Next
		for curr != nil {
			left := curr

			right := split(left, step)

			curr = split(right, step)

			prev.Next = merge(left, right)

			for prev.Next != nil {
				prev = prev.Next
			}
		}

		step *= 2
	}

	return dummy.Next
}

func split(head *ListNode, step int) *ListNode {
	for i := 1; head != nil && i < step; i++ {
		head = head.Next
	}

	if head == nil {
		return nil
	}

	next := head.Next

	head.Next = nil

	return next
}

func findMiddle(head *ListNode) *ListNode {
	slow, fast := head, head
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	return slow
}

func merge(left, right *ListNode) *ListNode {
	dummy := &ListNode{}
	curr := dummy

	for left != nil && right != nil {
		if left.Val < right.Val {
			curr.Next = left
			left = left.Next
		} else {
			curr.Next = right
			right = right.Next
		}

		curr = curr.Next
	}

	if left != nil {
		curr.Next = left

	} else {
		curr.Next = right
	}

	return dummy.Next
}

func printList(head *ListNode) {
	for head != nil {
		fmt.Print(head.Val, " ")
		head = head.Next
	}
	fmt.Println()
}

func createList(arr []int) *ListNode {
	dummy := &ListNode{}

	curr := dummy

	for _, val := range arr {
		curr.Next = &ListNode{
			Val: val,
		}

		curr = curr.Next
	}

	return dummy.Next
}
