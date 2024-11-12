package main

type WordDictionary struct {
	children map[rune]*WordDictionary
	isEnd    bool
}

func Constructor() WordDictionary {
	return WordDictionary{
		children: make(map[rune]*WordDictionary),
	}
}

func (wd *WordDictionary) AddWord(word string) {
	node := wd

	for _, char := range word {
		if _, found := node.children[char]; !found {
			node.children[char] = &WordDictionary{children: make(map[rune]*WordDictionary)}
		}
		node = node.children[char]
	}
	node.isEnd = true
}

func (wd *WordDictionary) Search(word string) bool {
	return wd.searchHelper([]rune(word), 0)
}

func (wd *WordDictionary) searchHelper(word []rune, index int) bool {
	if index == len(word) {
		return wd.isEnd
	}

	char := word[index]

	if char == '.' {
		for _, child := range wd.children {
			if child.searchHelper(word, index+1) {
				return true
			}
		}

		return false
	}

	if nextNode, found := wd.children[char]; found {
		return nextNode.searchHelper(word, index+1)
	}

	return false
}
