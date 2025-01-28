package com.sanedge.interview.graph_general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {
  public boolean canFinish(int numCourses, int[][] prerequisited) {
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
        queue.add(i);
      }
    }

    int completedCourse = 0;

    while (!queue.isEmpty()) {
      int course = queue.poll();

      completedCourse++;

      if (graph.containsKey(course)) {
        for (int nextCourse : graph.get(course)) {
          inDegree[nextCourse]--;

          if (inDegree[nextCourse] == 0) {
            queue.add(nextCourse);
          }
        }
      }
    }

    return completedCourse == numCourses;
  }
}
