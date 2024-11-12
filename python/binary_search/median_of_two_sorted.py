import math
from typing import List

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            return self.findMedianSortedArrays(nums2, nums1)

        x, y = len(nums1), len(nums2)

        low, high = 0, x

        while low <= high:
            partitionX = low + high // 2

            partitionY = (x + y + 1) // 2 - partitionX

            max_left_x = -math.inf

            if partitionX != 0:
                max_left_x = nums1[partitionX-1]


            min_right_x = math.inf

            if partitionX != x:
                min_right_x = nums1[partitionX]


            max_left_y = math.inf

            if partitionY != y:
                max_left_y = nums2[partitionY-1]


            min_right_y = math.inf

            if partitionY != y:
                min_right_y = nums2[partitionY]


            if max_left_x <= min_right_y and max_left_y <= min_right_x:
                if( x + y) % 2 == 0:
                    return float(max(max_left_x, max_left_y)+min(min_right_x, min_right_y)) // 2.0
                else:
                    return max(max_left_x, max_left_y)

            elif max_left_x > min_right_y:
                high = partitionX - 1
            else:
                low = partitionX + 1

        return 0.0
