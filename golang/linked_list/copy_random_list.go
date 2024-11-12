package main

type Node struct {
	Val    int
	Next   *Node
	Random *Node
}

func copyRandomList(head *Node) *Node {
	if head == nil {
		return nil
	}

	current := head

	for current != nil {
		newNode := &Node{Val: current.Val, Next: current.Next}

		current.Next = newNode

		current = newNode.Next
	}

	current = head

	for current != nil {
		if current.Random != nil {
			current.Next.Random = current.Random.Next
		}

		current = current.Next.Next
	}

	original := head
	copyHead := head.Next

	copy := copyHead

	for original != nil {
		original.Next = original.Next.Next

		if copy.Next != nil {
			copy.Next = copy.Next.Next
		}

		original = original.Next

		copy = copy.Next
	}

	return copyHead
}
