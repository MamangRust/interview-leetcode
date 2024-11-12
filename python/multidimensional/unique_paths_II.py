from typing import List


class Solution:
    def uniquePathsWithObstacles(self, obstaclesGrid: List[List[int]]) -> int:
        if len(obstaclesGrid) == 0 or len(obstaclesGrid) == 0:
            return 0


        rows = len(obstaclesGrid)
        cols = len(obstaclesGrid[0])

        if obstaclesGrid[0][0] == 1:
            return 0

        obstaclesGrid[0][0] = 1

        for j in range(1, cols):
            if obstaclesGrid[0][j] == 1:
                obstaclesGrid[0][j] = obstaclesGrid[0][j-1]



        for i in range(1, rows):
            if obstaclesGrid[i][0] == 1:
                obstaclesGrid[i][0] = 0
            else:
                obstaclesGrid[i][0] = obstaclesGrid[i-1][0]



        for i in range(1, rows):
            for j in range(1, cols):
                if obstaclesGrid[i][j] == 1:
                    obstaclesGrid[i][j] = 0
                else:
                    obstaclesGrid[i][j] = obstaclesGrid[i-1][j] + obstaclesGrid[i ][j-1]


        return obstaclesGrid[rows-1][cols-1]
