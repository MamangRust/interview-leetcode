package main

func zigzagLevelOrder(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}

	result := [][]int{}
	queue := []*TreeNode{root}

	leftToRight := true

	for len(queue) > 0 {
		levelSize := len(queue)

		currentLevel := make([]int, levelSize)

		for i := 0; i < levelSize; i++ {
			node := queue[0]
			queue = queue[1:]

			if leftToRight {
				currentLevel[i] = node.Val
			} else {
				currentLevel[levelSize-1-i] = node.Val
			}

			if node.Left != nil {
				queue = append(queue, node.Left)
			}

			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}

		result = append(result, currentLevel)

		leftToRight = !leftToRight
	}

	return result
}
