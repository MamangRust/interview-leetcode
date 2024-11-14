package main

func reverseList(head *ListNode) *ListNode {
	var prev *ListNode

	curr := head

	for curr != nil {
		next := curr.Next

		curr.Next = prev

		prev = curr

		curr = next
	}

	return prev
}

func pairSum(head *ListNode) int {
	slow, fast := head, head

	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}

	secondHalf := reverseList(slow)

	maxSum := 0

	firstHalf := head

	for secondHalf != nil {
		twinSum := firstHalf.Val + secondHalf.Val

		if twinSum > maxSum {
			maxSum = twinSum
		}

		firstHalf = firstHalf.Next
		secondHalf = secondHalf.Next
	}

	return maxSum
}
