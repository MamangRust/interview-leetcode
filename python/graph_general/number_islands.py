from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0

        num_islands = 0
        rows, cols = len(grid), len(grid[0])

        def dfs(r, c):
            if r < 0 or r >= rows or c < 0 or c >= cols or grid[r][c] == '0':
                return

            grid[r][c] = '0'

            dfs(r + 1, c)  # bawah
            dfs(r - 1, c)  # atas
            dfs(r, c + 1)  # kanan
            dfs(r, c - 1)  # kiri

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == '1':
                    num_islands += 1

                    dfs(r,c)

        return num_islands
