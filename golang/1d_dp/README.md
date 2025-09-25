# 1D Dynamic Programming Problems

This directory contains solutions to LeetCode problems that can be solved using 1D Dynamic Programming.

---

### 1. `climbing_stairs.go`

**Problem:** You are climbing a staircase. It takes `n` steps to reach the top. Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

This is a classic DP problem where the number of ways to get to step `n` is the sum of the ways to get to step `n-1` and step `n-2`.

- **LeetCode Link:** [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)

### 2. `coin_change.go`

**Problem:** You are given an integer array `coins` representing coins of different denominations and an integer `amount`. Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

This problem is solved by building a DP table `dp[i]` that stores the minimum number of coins to make amount `i`.

- **LeetCode Link:** [Coin Change](https://leetcode.com/problems/coin-change/)

### 3. `domino_and_tromino_tilling.go`

**Problem:** You have two types of tiles: a 2x1 domino shape and an "L" tromino shape. You are given an integer `n`. Return the number of ways to tile a 2 x n board.

This problem requires a more complex DP state to keep track of the different ways the board can be filled at column `i`.

- **LeetCode Link:** [Domino and Tromino Tiling](https://leetcode.com/problems/domino-and-tromino-tiling/)

### 4. `house_robber.go`

**Problem:** You are a robber planning to rob houses along a street. You cannot rob adjacent houses. Given an array `nums` representing the amount of money in each house, return the maximum amount of money you can rob.

The DP solution involves deciding at each house whether to rob it or not, which depends on the maximum amount robbed up to the previous non-adjacent house.

- **LeetCode Link:** [House Robber](https://leetcode.com/problems/house-robber/)

### 5. `longest_increasing_subsequence.go`

**Problem:** Given an integer array `nums`, return the length of the longest strictly increasing subsequence.

A DP approach can be used where `dp[i]` represents the length of the longest increasing subsequence that ends with the element `nums[i]`.

- **LeetCode Link:** [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)

### 6. `min_cost_climbing_stairs.go`

**Problem:** You are given an integer array `cost` where `cost[i]` is the cost of the `i`-th step. Once you pay the cost, you can climb one or two steps. Find the minimum cost to reach the top of the floor.

The minimum cost to reach step `i` is the cost of step `i` plus the minimum of the costs to reach step `i-1` or `i-2`.

- **LeetCode Link:** [Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)

### 7. `n_th_tribonacci_number.go`

**Problem:** The Tribonacci sequence T_n is defined as: T_0 = 0, T_1 = 1, T_2 = 1, and T_n+3 = T_n + T_n+1 + T_n+2. Given `n`, return the value of T_n.

This is a straightforward DP problem where you compute the sequence up to `n` using the given recurrence relation.

- **LeetCode Link:** [N-th Tribonacci Number](https://leetcode.com/problems/n-th-tribonacci-number/)

### 8. `word_break.go`

**Problem:** Given a string `s` and a dictionary of strings `wordDict`, return `true` if `s` can be segmented into a sequence of one or more dictionary words.

The DP solution involves a boolean array `dp` where `dp[i]` is true if the substring `s[0...i-1]` can be segmented.

- **LeetCode Link:** [Word Break](https://leetcode.com/problems/word-break/)
