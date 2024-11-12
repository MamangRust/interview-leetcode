
from typing import Dict


class Solution:
    def totalNQueens(self, n: int) -> int:
        count = 0

        def backtrack(row: int, cols: Dict[int, bool], diags1: Dict[int, bool], diags2: Dict[int, bool]):
            nonlocal count

            if row == n:
                count += 1

                return

            for col in range(n):
                diag1 = row - col

                diag2 = row + col


                if cols.get(col, False) or diags1.get(diag1, False) or diags2.get(diag2, False):
                    continue

                cols[col] = True
                diags1[diag1] = True
                diags2[diag2] = True

                backtrack(row + 1, cols, diags1, diags2)

                # Unmark the current column and diagonals
                cols[col] = False
                diags1[diag1] = False
                diags2[diag2] = False


        backtrack(0, {}, {}, {})

        return count
