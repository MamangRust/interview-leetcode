package main

func kthSmallest(root *TreeNode, k int) int {
	count := 0
	result := -1

	var inorder func(node *TreeNode)

	inorder = func(node *TreeNode) {
		if node == nil || count >= k {
			return
		}

		// Traversal ke kiri
		inorder(node.Left)

		// Proses node saat ini
		count++
		if count == k {
			result = node.Val
			return
		}

		// Traversal ke kanan
		inorder(node.Right)
	}

	inorder(root)
	return result
}
