package main

import "fmt"

type Node struct {
	Val         bool
	IsLeaf      bool
	TopLeft     *Node
	TopRight    *Node
	BottomLeft  *Node
	BottomRight *Node
}

func construct(grid [][]int) *Node {
	return build(grid, 0, 0, len(grid))
}

func build(grid [][]int, x, y, size int) *Node {
	if size == 1 {
		return &Node{
			Val:    grid[x][y] == 1,
			IsLeaf: true,
		}
	}

	allSame := true

	val := grid[x][y]

	for i := x; i < x+size; i++ {
		for j := y; j < y+size; j++ {
			if grid[i][j] != val {
				allSame = false

				break
			}
		}
		if !allSame {
			break
		}
	}

	if allSame {
		return &Node{
			Val:    val == 1,
			IsLeaf: true,
		}
	}

	mid := size / 2

	topLeft := build(grid, x, y, mid)
	topRight := build(grid, x, y+mid, mid)
	bottomLeft := build(grid, x+mid, y, mid)
	bottomRight := build(grid, x+mid, y+mid, mid)

	return &Node{
		IsLeaf:      false,
		TopLeft:     topLeft,
		TopRight:    topRight,
		BottomLeft:  bottomLeft,
		BottomRight: bottomRight,
	}
}

func printQuadTree(node *Node) {
	if node == nil {
		return
	}

	if node.IsLeaf {
		fmt.Printf("Leaf: %v\n", node.Val)

		return
	}

	fmt.Println("Non-Leaf:")
	printQuadTree(node.TopLeft)
	printQuadTree(node.TopRight)
	printQuadTree(node.BottomLeft)
	printQuadTree(node.BottomRight)
}
