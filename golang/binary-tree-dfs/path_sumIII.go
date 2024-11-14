package main

func pathSum(root *TreeNode, targetSum int) int {
	prefixSum := make(map[int]int)

	prefixSum[0] = 1

	return dfs(root, 0, targetSum, prefixSum)
}

func dfs(node *TreeNode, currSum, targetSum int, prefixSum map[int]int) int {
	if node == nil {
		return 0
	}

	currSum += node.Val

	numPaths := prefixSum[currSum-targetSum]

	prefixSum[currSum]++

	numPaths += dfs(node.Left, currSum, targetSum, prefixSum)
	numPaths += dfs(node.Right, currSum, targetSum, prefixSum)

	prefixSum[currSum]--

	return numPaths
}
