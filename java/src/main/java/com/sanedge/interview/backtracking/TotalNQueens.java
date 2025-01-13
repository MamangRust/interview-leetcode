package com.sanedge.interview.backtracking;

import java.util.HashMap;
import java.util.Map;

public class TotalNQueens {

    private int count = 0;

    public int totalNQueens(int n) {
        backtrack(0, n, new HashMap<>(), new HashMap<>(), new HashMap<>());
        return count;
    }

    private void backtrack(
        int row,
        int n,
        Map<Integer, Boolean> cols,
        Map<Integer, Boolean> diags1,
        Map<Integer, Boolean> diags2
    ) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int diag1 = row - col;
            int diag2 = row + col;

            if (
                cols.getOrDefault(col, false) ||
                diags1.getOrDefault(diag1, false) ||
                diags2.getOrDefault(diag2, false)
            ) {
                continue;
            }

            cols.put(col, true);
            diags1.put(diag1, true);
            diags2.put(diag2, true);

            backtrack(row + 1, n, cols, diags1, diags2);

            cols.put(col, false);
            diags1.put(diag1, false);
            diags2.put(diag2, false);
        }
    }
}
