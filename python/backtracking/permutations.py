from typing import List

class Solution:
    def permutate(self, nums: List[int]) -> List[List[int]]:
        result = []

        def backtrack(path: List[int], used: List[bool]):
            if len(path) == len(nums):
                result.append(path[:])
                return

            for i in range(len(nums)):
                if used[i]:
                    continue


                used[i] = True

                path.append(nums[i])

                backtrack(path, used)

                path = path[:len(path)-1]

                used[i] = False


        backtrack([], [False] * len(nums))
        return result
