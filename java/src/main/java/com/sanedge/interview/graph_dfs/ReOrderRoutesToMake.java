package com.sanedge.interview.graph_dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReOrderRoutesToMake {
  public static int minReOrder(int n, int[][] connections) {
    Map<Integer, List<int[]>> graph = new HashMap();

    for (int[] connection : connections) {
      int a = connection[0];
      int b = connection[1];

      graph.computeIfAbsent(a, k -> new ArrayList<>()).add(new int[] { b, 1 });
      graph.computeIfAbsent(b, k -> new ArrayList<>()).add(new int[] { a, 0 });
    }

    boolean[] visited = new boolean[n];

    int[] count = new int[1];

    dfs(0, graph, visited, count);

    return count[0];

  }

  private static void dfs(int node, Map<Integer, List<int[]>> graph, boolean[] visited, int[] count) {
    visited[node] = true;

    for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
      int nextNode = neighbor[0];
      int direction = neighbor[1];

      if (!visited[nextNode]) {
        if (direction == 1) {
          count[0]++;
        }

        dfs(nextNode, graph, visited, count);
      }
    }
  }

}
