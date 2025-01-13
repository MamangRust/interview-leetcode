package com.sanedge.interview.dp;

public class NumTilings {

    private static final int MOD = 1_000_000_007;

    public int numTilings(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        int[] dp2 = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp2[1] = 0;
        dp2[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + 2 * dp2[i - 1]) % MOD;
            dp2[i] = (dp[i - 2] + dp2[i - 1]) % MOD;
        }

        return dp[n];
    }
}
