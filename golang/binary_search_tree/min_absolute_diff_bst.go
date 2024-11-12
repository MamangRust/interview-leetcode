package main

import "math"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func getMinimumDifference(root *TreeNode) int {
	minDiff := math.MaxInt32

	var prev *int

	var inorder func(node *TreeNode)
	inorder = func(node *TreeNode) {
		if node == nil {
			return
		}

		// Traversal ke kiri
		inorder(node.Left)

		// Proses node saat ini
		if prev != nil {
			minDiff = min(minDiff, node.Val-*prev)
		}
		prev = &node.Val

		// Traversal ke kanan
		inorder(node.Right)
	}

	inorder(root)
	return minDiff
}
