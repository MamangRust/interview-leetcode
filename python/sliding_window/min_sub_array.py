from typing import List


class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int | float:
        n = len(nums)

        left, currentSum, minLength = 0, 0, float("inf")

        for right in range(n):
            currentSum += nums[right]

            while currentSum >= target:
                minLength = min(minLength, right - left + 1)

                currentSum -= nums[left]

                left += 1

        return minLength if minLength != float("inf") else 0
