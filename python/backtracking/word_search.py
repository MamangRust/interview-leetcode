from typing import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows = len(board)

        cols = len(board[0])

        def dfs(r: int, c: int, index: int) -> bool:
            if index == len(word):
                return True

            if r < 0 or r >= rows or c < 0 or c >= cols or board[r][c] != word[index]:
                return False


            temp = board[r][c]

            board[r][c] = '#'

            directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

            for dr, dc in directions:
                new_r, new_c = r + dr, c + dc

                if (dfs, new_r, new_c, index + 1):
                    return True


            board[r][c]= temp


            return False


        for r in range(rows):
            for c in range(cols):
                if board[r][c] == word[0] and dfs(r, c, 0):
                    return True


        return False
