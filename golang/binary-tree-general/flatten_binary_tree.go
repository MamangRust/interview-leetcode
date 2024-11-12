package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func flatten(root *TreeNode) {
	if root == nil {
		return
	}

	current := root

	for current != nil {
		if current.Left != nil {
			right_most := current.Left

			for right_most.Right != nil {
				right_most = right_most.Right
			}

			right_most.Right = current.Right

			current.Right = current.Left

			current.Left = nil
		}

		current = current.Right
	}
}
