package com.sanedge.interview.hashmap;

import java.util.HashMap;
import java.util.Map;

public class EqualPairs {
  public static int equalPairs(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;

    Map<String, Integer> rowMap = new HashMap<>();

    int count = 0;

    for (int i = 0; i < m; i++) {
      StringBuilder rowKey = new StringBuilder();

      for (int j = 0; j < n; j++) {
        if (j > 0) {
          rowKey.append(",");
        }

        rowKey.append(mat[i][j]);
      }

      rowMap.put(rowKey.toString(), rowMap.getOrDefault(rowKey.toString(), 0) + 1);
    }

    for (int j = 0; j < n; j++) {
      StringBuilder colKey = new StringBuilder();

      for (int i = 0; i < m; i++) {
        if (i > 0) {
          colKey.append(",");
        }

        colKey.append(mat[i][j]);
      }
      count += rowMap.getOrDefault(colKey.toString(), 0);
    }

    return count;
  }
}
