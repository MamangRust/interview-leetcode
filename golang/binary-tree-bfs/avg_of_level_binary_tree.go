package main

func averageOfLevels(root *TreeNode) []float64 {
	if root == nil {
		return []float64{}
	}

	averages := []float64{}
	queue := []*TreeNode{root}

	for len(queue) > 0 {
		levelSize := len(queue)

		levelSum := 0

		for i := 0; i < levelSize; i++ {
			node := queue[0]
			queue = queue[1:]

			levelSum += node.Val

			if node.Left != nil {
				queue = append(queue, node.Left)
			}

			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}

		averages = append(averages, float64(levelSum)/float64(levelSize))
	}

	return averages
}
