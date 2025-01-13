package com.sanedge.interview.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack("", 0, 0, n, result);
        return result;
    }

    private void backtrack(
        String current,
        int open,
        int close,
        int n,
        List<String> result
    ) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        if (open < n) {
            backtrack(current + "(", open + 1, close, n, result);
        }

        if (close < open) {
            backtrack(current + ")", open, close + 1, n, result);
        }
    }
}
