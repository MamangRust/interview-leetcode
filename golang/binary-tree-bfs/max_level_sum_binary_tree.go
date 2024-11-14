package main

func maxLevelSum(root *TreeNode) int {
	if root == nil {
		return 0
	}

	level := 1
	maxLevel := 1
	maxSum := root.Val

	queue := []*TreeNode{root}

	for len(queue) > 0 {
		levelSum := 0

		nextQueue := []*TreeNode{}

		for _, node := range queue {
			levelSum += node.Val

			if node.Left != nil {
				nextQueue = append(nextQueue, node.Left)
			}

			if node.Right != nil {
				nextQueue = append(nextQueue, node.Right)
			}
		}

		if levelSum > maxSum {
			maxSum = levelSum
			maxLevel = level
		}

		queue = nextQueue

		level++
	}

	return maxLevel
}
