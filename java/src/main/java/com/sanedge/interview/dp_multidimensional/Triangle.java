package com.sanedge.interview.dp_multidimensional;

import java.util.Arrays;

public class Triangle {

    public int minimumTotal(int[][] triangle) {
        if (triangle.length == 0) {
            return 0;
        }

        int[] dp = Arrays.copyOf(
            triangle[triangle.length - 1],
            triangle.length
        );

        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle[i][j] + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}
