package com.sanedge.interview.dp_multidimensional;

public class MinPathSum {

    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int j = 1; j < cols; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[rows - 1][cols - 1];
    }
}
