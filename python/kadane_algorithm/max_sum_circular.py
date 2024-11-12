from typing import List

class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        totalSum = 0
        maxSum = nums[0]
        minSum = nums[0]
        currMax = nums[0]
        currMin = nums[0]

        for i in range(len(nums)):
            num = nums[i]

            totalSum += num


            currMax = max(num, currMax+ num)
            maxSum = max(maxSum, currMax)

            currMin = min(num, currMin + num)
            minSum = min(minSum, currMin)


        totalSum += nums[0]

        if maxSum < 0:
            return maxSum


        return max(maxSum, totalSum - minSum)
