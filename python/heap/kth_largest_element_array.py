from random import randint

from typing import List


class Solution:
    def findKthLarges(self, nums: List[int], k: int) -> int:
        return self.quickSelect(nums, 0, len(nums)-1 , len(nums) - k)

    def quickSelect(self, nums: List[int], left:  int, right: int, k: int) -> int:
        if left == right:
            return nums[left]

        pivotIndex = left + randint(0,right - left + 1)
        pivotIndex = self.partition(nums, left, right, pivotIndex)

        if k == pivotIndex:
            return nums[k]
        elif k < pivotIndex:
            return self.quickSelect(nums, left, pivotIndex - 1, k)
        else:
            return self.quickSelect(nums, pivotIndex + 1, right, k)

        return -1

    def partition(self, nums: List[int], left: int, right: int, pivotIndex: int) -> int:
        pivot = nums[pivotIndex]

        nums[pivotIndex], nums[right] = nums[right], nums[pivotIndex]

        storeIndex = left


        for i in range(left, right):
            if nums[i] < pivot:
                nums[storeIndex], nums[i] = nums[i], nums[storeIndex]
                storeIndex += 1

        nums[right], nums[storeIndex] = nums[storeIndex], nums[right]

        return storeIndex
