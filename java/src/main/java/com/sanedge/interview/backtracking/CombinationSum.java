package com.sanedge.interview.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(
        int[] candidates,
        int remaining,
        int start,
        List<Integer> path,
        List<List<Integer>> result
    ) {
        if (remaining == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remaining) {
                continue;
            }
            path.add(candidates[i]);

            backtrack(candidates, remaining - candidates[i], i, path, result);

            path.remove(path.size() - 1);
        }
    }
}
