from typing import List


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return 0


        rows = len(matrix)
        cols = len(matrix[0])
        maxSide = 0

        dp = [[0] * (cols + 1) for _ in range(rows + 1)]


        for i in range(1, rows + 1):
            for j in range(1, cols +1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
                    maxSide = max(maxSide, dp[i][j])



        return maxSide * maxSide
