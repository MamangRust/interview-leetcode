package com.sanedge.interview.graph_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceMaze {

    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { entrance[0], entrance[1], 0 });

        maze[entrance[0]][entrance[1]] = '#';

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int dist = current[2];

            if (
                (row != entrance[0] || col != entrance[1]) &&
                (row == 0 || col == 0 || row == rows - 1 || col == cols - 1)
            ) {
                return dist;
            }

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (
                    newRow >= 0 &&
                    newRow < rows &&
                    newCol >= 0 &&
                    newCol < cols &&
                    maze[newRow][newCol] == '.'
                ) {
                    maze[newRow][newCol] = '#';
                    queue.offer(new int[] { newRow, newCol, dist + 1 });
                }
            }
        }

        return -1;
    }
}
