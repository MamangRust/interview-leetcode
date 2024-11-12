package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func buildTree(preorder []int, inorder []int) *TreeNode {
	inorderMap := make(map[int]int)

	for i, val := range inorder {
		inorderMap[val] = i
	}

	return build(preorder, 0, len(preorder)-1, 0, len(inorder)-1, inorderMap)
}

func build(preorder []int, preStart, preEnd, inStart, inEnd int, inorderMap map[int]int) *TreeNode {
	if preStart > preEnd || inStart > inEnd {
		return nil
	}

	rootVal := preorder[preStart]
	root := &TreeNode{Val: rootVal}
	rootIndex := inorderMap[rootVal]
	leftTreeSize := rootIndex - inStart

	root.Left = build(preorder, preStart+1, preStart+leftTreeSize, inStart, rootIndex-1, inorderMap)
	root.Right = build(preorder, preStart+leftTreeSize+1, preEnd, rootIndex+1, inEnd, inorderMap)

	return root
}
