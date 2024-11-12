import heapq

from typing import List, Tuple

class Pair:
    def __init__(self, num1: int, num2: int, i: int, j: int):
        self.num1 = num1
        self.num2 = num2
        self.i = i
        self.j = j

    def __lt__(self, other: 'Pair') -> bool:
        return (self.num1 + self.num2) < (other.num1 + other.num2)


class Solution:
    def k_smallest_pairs(self, nums1: List[int], nums2: List[int], k:int) -> List[List[int]]:
        if not nums1 or not nums2 or k == 0:
            return []

        min_heap: List[Pair] = []
        result: List[List[int]] = []

        for i in range(min(k, len(nums1))):
            heapq.heappush(min_heap, Pair(nums1[i], nums2[0], i, 0))

        while k > 0 and min_heap:
            pair = heapq.heappop(min_heap)

            result.append([pair.num1, pair.num2])
            k -= 1

            if pair.j + 1 < len(nums2):
                next_pair = Pair(
                    pair.num1,
                    nums2[pair.j +1],
                    pair.i,
                    pair.j + 1
                )

                heapq.heappush(min_heap, next_pair)


        return result
