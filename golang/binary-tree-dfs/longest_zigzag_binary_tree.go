package main

func getLeafSequence(root *TreeNode, leaves *[]int) {
	if root == nil {
		return
	}

	if root.Left == nil && root.Right == nil {
		*leaves = append(*leaves, root.Val)
	}

	getLeafSequence(root.Left, leaves)
	getLeafSequence(root.Right, leaves)
}

func leafSimilar(root1 *TreeNode, root2 *TreeNode) bool {
	var leaves1, leaves2 []int

	getLeafSequence(root1, &leaves1)
	getLeafSequence(root2, &leaves2)

	if len(leaves1) != len(leaves2) {
		return false
	}

	for i := 0; i < len(leaves1); i++ {
		if leaves1[i] != leaves2[i] {
			return false
		}
	}

	return true
}
