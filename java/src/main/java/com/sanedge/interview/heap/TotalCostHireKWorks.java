package com.sanedge.interview.heap;

import java.util.PriorityQueue;

class Worker implements Comparable<Worker> {
  int cost;
  int index;

  public Worker(int cost, int index) {
    this.cost = cost;
    this.index = index;
  }

  @Override
  public int compareTo(Worker worker) {
    return Integer.compare(this.cost, worker.cost);
  }
}

public class TotalCostHireKWorks {
  public static long totalCost(int[] costs, int k, int candidates) {
    int n = costs.length;

    PriorityQueue<Worker> leftHeap = new PriorityQueue<>();
    PriorityQueue<Worker> rightHeap = new PriorityQueue<>();

    for (int i = 0; i < candidates; i++) {
      leftHeap.offer(new Worker(costs[i], i));
      rightHeap.offer(new Worker(costs[n - i - 1], n - i - 1));
    }

    long totalCost = 0;
    int leftIndex = candidates;
    int rightIndex = n - candidates - 1;

    for (int i = 0; i < k; i++) {
      Worker minCostWorker;

      if (!leftHeap.isEmpty() && (rightHeap.isEmpty() || leftHeap.peek().cost <= rightHeap.peek().cost)) {
        minCostWorker = leftHeap.poll();

        if (leftIndex <= rightIndex) {
          leftHeap.offer(new Worker(costs[rightIndex], rightIndex));
          leftIndex++;
        }
      } else {
        minCostWorker = rightHeap.poll();

        if (leftIndex <= rightIndex) {
          rightHeap.offer(new Worker(costs[rightIndex], rightIndex));

          rightIndex--;
        }
      }
      totalCost += minCostWorker.cost;
    }

    return totalCost;

  }

}
