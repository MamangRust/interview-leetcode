from typing import List
from collections import deque, defaultdict


class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        graph = defaultdict(list)
        in_degree = [0] * numCourses

        for course, prereq in prerequisites:
            graph[prereq].append(course)

            in_degree[course] += 1


        queue = deque([i for i in range(numCourses) if in_degree[i] == 0])
        order = []

        while queue:
            course = queue.popleft()

            order.append(course)

            for next_course in graph[course]:
                in_degree[next_course] -= 1

                if in_degree[next_course] == 0:
                    queue.append(next_course)


        if len(order) != numCourses:
            return []

        return order
