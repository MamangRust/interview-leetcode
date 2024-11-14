package main

func countGoodNodes(node *TreeNode, maxVal int) int {
	if node == nil {
		return 0
	}

	count := 0

	if node.Val >= maxVal {
		count = 1
	}

	newMax := max(maxVal, node.Val)

	count += countGoodNodes(node.Left, newMax)
	count += countGoodNodes(node.Right, newMax)

	return count
}

func goodNodes(root *TreeNode) int {
	return countGoodNodes(root, root.Val)
}
