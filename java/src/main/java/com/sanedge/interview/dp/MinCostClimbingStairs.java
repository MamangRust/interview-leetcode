package com.sanedge.interview.dp;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        if (n == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int dp1 = cost[0];
        int dp2 = cost[1];

        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(dp1, dp2);

            dp1 = dp2;
            dp2 = current;
        }

        return Math.min(dp1, dp2);
    }
}
