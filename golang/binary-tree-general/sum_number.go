package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func sumNumbers(root *TreeNode) int {
	return dfs(root, 0)
}

func dfs(node *TreeNode, current_sum int) int {
	if node == nil {
		return 0
	}

	current_sum = current_sum*10 + node.Val

	if node.Left == nil && node.Right == nil {
		return current_sum
	}

	left_sum := dfs(node.Left, current_sum)
	right_sum := dfs(node.Right, current_sum)

	return left_sum + right_sum
}
