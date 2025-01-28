package com.sanedge.interview.graph_dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {

    public boolean canVisitAllRoom(List<List<Integer>> rooms) {
        int n = rooms.size();

        boolean[] visited = new boolean[n];
        visited[0] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int room = queue.poll();

            for (int key : rooms.get(room)) {
                if (!visited[key]) {
                    visited[key] = true;
                    queue.offer(key);
                }
            }
        }

        

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }
}
