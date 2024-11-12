package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func countNodes(root *TreeNode) int {
	if root == nil {
		return 0
	}

	left_depth := getDepth(root.Left)
	right_depth := getDepth(root.Right)

	if left_depth == right_depth {
		return 1<<left_depth + countNodes(root.Right)
	} else {
		return 1<<right_depth + countNodes(root.Left)
	}
}

func getDepth(node *TreeNode) int {
	depth := 0

	for node != nil {
		depth += 1

		node = node.Left
	}

	return depth
}
