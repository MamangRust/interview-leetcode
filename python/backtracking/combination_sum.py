from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        def backtrack(start: int, path: List[int], remaining: int):
            if remaining == 0:
                result.append(list(path))

                return


            for i in range(start,  len(candidates)):
                if candidates[i] >  remaining:
                    continue


                path.append(candidates[i])

                backtrack(i, path, remaining-candidates[i])

                path.pop()


        backtrack(0, [], target)


        return result
