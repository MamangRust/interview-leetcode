package com.sanedge.interview.graph_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        Queue<int[]> queue = new LinkedList<>();

        int healtyCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j, 0 });
                } else if (grid[i][j] == 1) {
                    healtyCount++;
                }
            }
        }

        if (healtyCount == 0) {
            return 0;
        }

        int time = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int t = current[2];

            time = Math.max(time, t);

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (
                    newRow >= 0 &&
                    newRow < rows &&
                    newCol >= 0 &&
                    newCol < cols &&
                    grid[newRow][newCol] == 1
                ) {
                    grid[newRow][newCol] = 2;

                    queue.offer(new int[] { newRow, newCol, t + 1 });

                    healtyCount--;
                }
            }
        }

        if (healtyCount > 0) {
            return -1;
        }

        return time;
    }
}
