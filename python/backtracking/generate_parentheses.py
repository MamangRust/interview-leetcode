from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result=  []


        def backtrack(current: str, open: int, close: int):
            if len(current) == 2 * n:
                result.append(current)

                return

            if open < n:
                backtrack(current + "(", open+1, close)

            if close < open:
                backtrack(current + ")", open, close+1)


        backtrack("", 0, 0)

        return result
