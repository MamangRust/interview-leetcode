package com.sanedge.interview.graph_general;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
  public double[] calcEquation(List<List<String>> equantions, double[] values, List<List<String>> queries) {
    Map<String, Map<String, Double>> graph = new HashMap<>();

    for (int i = 0; i < equantions.size(); i++) {
      String a = equantions.get(i).get(0);
      String b = equantions.get(i).get(1);
      double value = values[i];

      graph.computeIfAbsent(a, k -> new HashMap<>()).put(b, value);
      graph.computeIfAbsent(b, k -> new HashMap<>()).put(a, 1.0 / value);
    }

    double[] results = new double[queries.size()];

    for (int i = 0; i < queries.size(); i++) {
      String start = queries.get(i).get(0);
      String end = queries.get(i).get(1);

      if (start.equals(end)) {
        if (graph.containsKey(start)) {
          results[i] = 1.0;
        } else {
          results[i] = -1.0;
        }
      } else {
        Set<String> visited = new HashSet<>();

        results[i] = dfs(start, end, visited, graph);
      }
    }

    return results;
  }

  public double dfs(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph) {
    if (!graph.containsKey(start)) {
      return -1.0;
    }

    if (graph.get(start).containsKey(end)) {
      return graph.get(start).get(end);
    }

    visited.add(start);

    for (Map.Entry<String, Double> neigbor : graph.get(start).entrySet()) {
      String nextNode = neigbor.getKey();

      double value = neigbor.getValue();

      if (visited.contains(nextNode)) {
        continue;
      }

      double product = dfs(nextNode, end, visited, graph);

      if (product != -1.0) {
        return value * product;
      }
    }

    return -1.0;
  }
}
