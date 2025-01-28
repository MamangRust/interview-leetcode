package com.sanedge.interview.graph_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadders {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        boolean[] visited = new boolean[n * n + 1];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 1, 0 });
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] element = queue.poll();
            int square = element[0];
            int moves = element[1];

            if (square == n * n) {
                return moves;
            }

            for (int i = 1; i <= 6; i++) {
                int nextSquare = square + i;

                if (nextSquare > n * n) {
                    break;
                }

                int[] coordinates = getCoordinates(nextSquare, n);
                int row = coordinates[0];
                int col = coordinates[1];

                if (board[row][col] != -1) {
                    nextSquare = board[row][col];
                }

                if (!visited[nextSquare]) {
                    visited[nextSquare] = true;
                    queue.offer(new int[] { nextSquare, moves + 1 });
                }
            }
        }

        return -1;
    }

    private int[] getCoordinates(int square, int n) {
        int row = (square - 1) / n;
        int col = (square - 1) % n;

        if (row % 2 == 1) {
            col = n - 1 - col;
        }

        return new int[] { n - 1 - row, col };
    }
}
