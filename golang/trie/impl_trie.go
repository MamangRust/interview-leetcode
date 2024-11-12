package main

type TrieNode struct {
	children map[rune]*TrieNode
	isEnd    bool
}

type Trie struct {
	root *TrieNode
}

func Constructor() Trie {
	return Trie{
		root: &TrieNode{children: make(map[rune]*TrieNode)},
	}
}

func (t *Trie) Insert(word string) {
	node := t.root

	for _, char := range word {
		if _, found := node.children[char]; !found {
			node.children[char] = &TrieNode{children: make(map[rune]*TrieNode)}
		}
		node = node.children[char]
	}

	node.isEnd = true
}

func (t *Trie) Search(word string) bool {
	node := t.root

	for _, char := range word {
		if _, found := node.children[char]; !found {
			return false
		}

		node = node.children[char]
	}

	return node.isEnd
}

func (t *Trie) StartsWith(prefix string) bool {
	node := t.root

	for _, char := range prefix {
		if _, found := node.children[char]; !found {
			return false
		}

		node = node.children[char]
	}

	return true
}
