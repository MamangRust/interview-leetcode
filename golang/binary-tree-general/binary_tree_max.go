package main

import "math"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func maxPathSum(root *TreeNode) int {
	maxSum := math.MinInt32
	calculateMaxPath(root, &maxSum)

	return maxSum
}

func calculateMaxPath(node *TreeNode, maxSum *int) int {
	if node == nil {
		return 0
	}

	left_gain := max(calculateMaxPath(node.Left, maxSum), 0)
	right_gain := max(calculateMaxPath(node.Right, maxSum), 0)

	current_path_sum := node.Val + left_gain + right_gain

	*maxSum = max(*maxSum, current_path_sum)

	return node.Val + max(left_gain, right_gain)
}
