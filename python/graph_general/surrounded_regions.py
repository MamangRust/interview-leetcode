from typing import List

class Solution:
    def solve(self, board: List[List[str]]) -> None:
        if not board or not board[0]:
            return


        rows, cols = len(board), len(board[0])

        def dfs(r, c):
            if r < 0 or r >= rows or c < 0 or c >= cols or board[r][c] != 'O':
                return

            board[r][c] = '#'

            dfs(r + 1, c)  # bawah
            dfs(r - 1, c)  # atas
            dfs(r, c + 1)  # kanan
            dfs(r, c - 1)  # kiri

        for i in range(rows):
            if board[i][0] == 'O':
                dfs(i, 0)

            if board[i][cols-1] == 'O':
                dfs(i ,cols - 1)

        for j in range(cols):
            if board[0][j] == 'O':
                dfs(0, j)
            if board[rows - 1][j] == 'O':
                dfs(rows - 1, j)


        for i in range(rows):
            for j in range(cols):
                if board[i][j] == 'O':
                    board[i][j] =  'X'
                elif board[i][j] == '#':
                    board[i][j] = 'O'
