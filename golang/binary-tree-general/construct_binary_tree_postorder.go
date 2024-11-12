package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func buildTree(inorder []int, postorder []int) *TreeNode {
	inorderMap := make(map[int]int)

	for i, val := range inorder {
		inorderMap[val] = i
	}

	var helper func(inLeft, inRight int) *TreeNode

	helper = func(inLeft, inRight int) *TreeNode {
		if inLeft > inRight {
			return nil
		}

		rootVal := postorder[len(postorder)-1]
		postorder = postorder[:len(postorder)-1]

		root := &TreeNode{Val: rootVal}

		index := inorderMap[rootVal]

		root.Right = helper(index+1, inRight)
		root.Left = helper(inLeft, index-1)

		return root
	}

	return helper(0, len(inorder)-1)
}
