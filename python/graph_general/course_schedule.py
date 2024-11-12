from typing import List
from collections import deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = {i: [] for i in range(numCourses)}

        in_degree = [0] * numCourses

        for course, preq in prerequisites:
            graph[preq].append(course)

            in_degree[course] += 1


        queue = deque([i for i in range(numCourses) if in_degree[i] == 0])
        completed_courses = 0

        while queue:
            course = queue.popleft()

            completed_courses += 1

            for next_course in graph[course]:
                in_degree[next_course] -= 1

                if in_degree[next_course] == 0:
                    queue.append(next_course)


        return completed_courses == numCourses
