from typing import List


class Solution:
    def insert(
        self, intervals: List[List[int]], new_interval: List[int]
    ) -> List[List[int]]:
        merged = []
        i = 0
        n = len(intervals)

        while i < n and intervals[i][1] < new_interval[0]:
            merged.append(intervals[i])

            i += 1

        while i < n and intervals[i][0] <= new_interval[1]:
            new_interval[0] = min(new_interval[0], intervals[i][0])
            new_interval[1] = max(new_interval[1], intervals[i][1])

            i += 1

        merged.append(new_interval)

        while i < n:
            merged.append(intervals[i])

            i += 1

        return merged
