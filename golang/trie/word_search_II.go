package main

type TrieNode struct {
	children map[rune]*TrieNode
	word     string
}

type Trie struct {
	root *TrieNode
}

func ConstructorTrie() *Trie {
	return &Trie{
		root: &TrieNode{
			children: make(map[rune]*TrieNode),
		},
	}
}

func (t *Trie) Insert(word string) {
	node := t.root

	for _, char := range word {
		if _, found := node.children[char]; !found {
			node.children[char] = &TrieNode{
				children: make(map[rune]*TrieNode),
			}
		}
		node = node.children[char]
	}

	node.word = word
}

func findWords(board [][]byte, words []string) []string {
	trie := ConstructorTrie()

	for _, word := range words {
		trie.Insert(word)
	}

	rows := len(board)
	cols := len(board[0])
	result := []string{}
	visited := make([][]bool, rows)
	for i := range visited {
		visited[i] = make([]bool, cols)
	}

	var dfs func(r, c int, node *TrieNode)

	dfs = func(r, c int, node *TrieNode) {
		if r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] || board[r][c] == '#' {
			return
		}

		char := rune(board[r][c])

		nextNode, exists := node.children[char]

		if !exists {
			return
		}

		visited[r][c] = true

		if nextNode.word != "" {
			result = append(result, nextNode.word)
			nextNode.word = ""
		}

		dfs(r+1, c, nextNode) // bawah
		dfs(r-1, c, nextNode) // atas
		dfs(r, c+1, nextNode) // kanan
		dfs(r, c-1, nextNode) // kiri

		visited[r][c] = false
	}

	for r := 0; r < rows; r++ {
		for c := 0; c < cols; c++ {
			if _, exists := trie.root.children[rune(board[r][c])]; exists {
				dfs(r, c, trie.root)
			}
		}
	}

	return result
}
