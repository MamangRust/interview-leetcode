class TrieNode:
    def __init__(self):
        self.children = {}
        self.word = ""



class Trie:
    def __init__(self) -> None:
        self.root = TrieNode()


    def insert(self, word: str) -> None:
        node = self.root

        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()

            node = node.children[char]

        node.word = word



class Solution:
    def findWords(self, board, words):
        trie = Trie()

        for word in words:
            trie.insert(word)


        rows = len(board)
        cols = len(board[0])
        result = []
        visited = [[False] * cols for _ in range(rows)]


        def dfs(r, c, node):
            if r < 0 or r >= rows or c < 0 or c >= cols or visited[r][c] or board[r][c] == '#':
                return

            char = board[r][c]

            if char not in node.chidren:
                return


            next_node = node.children[char]

            if next_node.word:
                result.append(next_node.word)

                next_node.word = ""

            visited[r][c] = True


            dfs(r+1, c, next_node)  # Down
            dfs(r-1, c, next_node)  # Up
            dfs(r, c+1, next_node)  # Right
            dfs(r, c-1, next_node)  # Left

            visited[r][c] = False


        for r in range(rows):
            for c in range(cols):
                if board[r][c] in trie.root.children:
                    dfs(r, c, trie.root)


        return result
