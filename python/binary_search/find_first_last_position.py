from typing import List

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        first = self.find_first(nums, target)

        last = self.findLast(nums, target)

        return [
            first,
            last
        ]

    def find_first(self,nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1

        firstPos = 1

        while left <= right:
            mid = left + (int(right) - left) // 2

            if nums[mid] == target:
                firstPos = mid
                right = mid - 1
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid -1


        return firstPos


    def findLast(self, nums: List[int], target: int) -> int:
        left =0

        right = len(nums) - 1

        lastPost = -1

        while left <= right:
            mid = left + (right - left) // 2

            if nums[mid] == target:
                lastPost = mid

                left = mid + 1
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1


        return lastPost
