from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums) <= 1:
            return 0

        jumps = 0
        current_end = 0
        farhest = 0

        for i in range(len(nums) - 1):
            farhest = max(farhest, i + nums[i])

            if i == current_end:
                jumps += 1

                current_end = farhest

                if current_end >= len(nums) - 1:
                    break

        return jumps
