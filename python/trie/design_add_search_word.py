

class WordDictionary:
    def __init__(self):
        self.children = {}
        self.is_end = False

    def addWord(self, word: str) -> None:
        node = self

        for char in word:
            if char not in node.children:
                node.children[char] = WordDictionary()

            node = node.children[char]

        node.is_end = True


    def search(self, word: str) -> bool:
        return self._search_helper(word, 0)


    def _search_helper(self, word: str, index: int) -> bool:
        if index == len(word):
            return self.is_end


        char = word[index]


        if char == '.':
            for child in self.children.values():
                if child._search_helper(word, index + 1):
                    return True
            return False

        if char in self.children:
            return self.children[char]._search_helper(word, index + 1)

        return False
