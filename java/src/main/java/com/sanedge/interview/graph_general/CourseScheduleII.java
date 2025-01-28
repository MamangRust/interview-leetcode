package com.sanedge.interview.graph_general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleII {
  public int[] findOrder(int numCourses, int[][] prerequisited) {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    int[] inDegree = new int[numCourses];

    for (int[] pre : prerequisited) {
      int course = pre[0];
      int prereq = pre[1];

      graph.computeIfAbsent(prereq, k -> new ArrayList<>()).add(course);

      inDegree[course]++;
    }

    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        queue.offer(i);
      }
    }

    List<Integer> order = new ArrayList<>();

    while (!queue.isEmpty()) {
      int course = queue.poll();

      order.add(course);

      if (graph.containsKey(course)) {
        for (int nextCourse : graph.get(course)) {
          inDegree[nextCourse]--;

          if (inDegree[nextCourse] == 0) {
            queue.offer(nextCourse);
          }
        }
      }
    }

    if (order.size() != numCourses) {
      return new int[0];
    }

    int[] result = new int[order.size()];

    for (int i = 0; i < order.size(); i++) {
      result[i] = order.get(i);
    }

    return result;
  }

}
