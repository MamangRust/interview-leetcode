package com.sanedge.interview.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Project {
  int profit;
  int capital;

  Project(int profit, int capital) {
    this.profit = profit;
    this.capital = capital;
  }
}

public class Ipo {
  public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    List<Project> projects = new ArrayList<>();

    for (int i = 0; i < profits.length; i++) {
      projects.add(new Project(profits[i], capital[i]));
    }

    projects.sort(Comparator.comparingInt(p -> p.capital));

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    int index = 0;

    for (int i = 0; i < k; i++) {
      while (index < projects.size() && projects.get(index).capital <= w) {
        pq.offer(projects.get(index).profit);
        index++;
      }

      if (pq.isEmpty()) {
        break;
      }

      w += pq.poll();
    }

    return w;
  }

}
