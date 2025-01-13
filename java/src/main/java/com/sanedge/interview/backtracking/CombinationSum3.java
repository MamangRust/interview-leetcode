package com.sanedge.interview.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(1, k, n, current, result);
        return result;
    }

    private void backtrack(
        int start,
        int k,
        int remaining,
        List<Integer> current,
        List<List<Integer>> result
    ) {
        if (current.size() == k) {
            if (remaining == 0) {
                result.add(new ArrayList<>(current));
            }

            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > remaining) {
                break;
            }

            current.add(i);

            backtrack(i + 1, k, remaining - i, current, result);

            current.remove(current.size() - 1);
        }
    }
}
