package main

func longestZigZag(root *TreeNode) int {
	maxLen := 0

	dfs(root, -1, 0, &maxLen)

	return maxLen
}

func dfs(node *TreeNode, isLeft int, length int, maxLen *int) {
	if node == nil {
		return
	}

	if length > *maxLen {
		*maxLen = length
	}

	if isLeft != 1 {
		dfs(node.Left, 1, length+1, maxLen)
	} else {
		dfs(node.Left, 1, 1, maxLen)
	}

	if isLeft != 0 {
		dfs(node.Right, 0, length+1, maxLen)
	} else {
		dfs(node.Right, 0, 1, maxLen)
	}
}

func max(nums ...int) int {
	m := nums[0]
	for _, num := range nums {
		if num > m {
			m = num
		}
	}
	return m
}
