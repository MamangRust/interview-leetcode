from typing import List

class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        if len(grid) == 0 or len(grid[0]) == 0:
            return 0

        rows = len(grid)
        cols = len(grid[0])

        for i in range(1, rows + 1):
            grid[i][0] += grid[i-1][0]

        for j in range(1, cols + 1):
            grid[0][j] += grid[0][j-1]



        for i in range(1, rows +1):
            for j in range(1, cols + 1):
                grid[i][j] += min(grid[i - 1][j], grid[i][j - 1])



        return grid[rows-1][cols-1]
