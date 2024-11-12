from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        maxSum = nums[0]

        currentSum = nums[0]

        for i in range(len(nums)):
            currentSum = max(nums[i], currentSum+nums[i])

            maxSum = max(maxSum, currentSum)


        return maxSum
