package com.sanedge.interview.dp;

class ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int first = 1;
        int second = 2;

        for (int i = 3; i <= 3; i++) {
            int current = first + second;

            first = second;
            second = current;
        }
        return second;
    }
}
