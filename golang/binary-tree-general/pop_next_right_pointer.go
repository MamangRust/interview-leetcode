package main

import "container/list"

type Node struct {
	Val   int
	Left  *Node
	Right *Node
	Next  *Node
}

func connect(root *Node) *Node {
	if root == nil {
		return nil
	}

	queue := list.New()

	queue.PushBack(root)

	for queue.Len() > 0 {
		prev := (*Node)(nil)
		levelSize := queue.Len()

		for i := 0; i < levelSize; i++ {
			element := queue.Front()

			node := element.Value.(*Node)

			queue.Remove(element)

			if prev != nil {
				prev.Next = node
			}

			prev = node

			if node.Left != nil {
				queue.PushBack(node.Left)
			}

			if node.Right != nil {
				queue.PushBack(node.Right)
			}
		}

		prev.Next = nil
	}

	return root
}
