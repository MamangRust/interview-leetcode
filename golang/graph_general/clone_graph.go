package main

type Node struct {
	Val       int
	Neighbors []*Node
}

func cloneGraph(node *Node) *Node {
	if node == nil {
		return nil
	}

	cloned := make(map[*Node]*Node)

	var dfs func(*Node) *Node

	dfs = func(n *Node) *Node {
		if n == nil {
			return nil
		}

		if clone, found := cloned[n]; found {
			return clone
		}

		copy := &Node{Val: n.Val}

		cloned[n] = copy

		for _, neighbor := range n.Neighbors {
			copy.Neighbors = append(copy.Neighbors, dfs(neighbor))
		}

		return copy
	}

	return dfs(node)
}
