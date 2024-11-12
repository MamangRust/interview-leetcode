from typing import List, Dict

class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], quaries: List[List[str]]) -> List[float]:
        graph = {}

        for (a, b), value in zip(equations, values):
            if a not in graph:
                graph[a] = {}

            if b not in graph:
                graph[b] = {}

            graph[a][b] = value
            graph[b][a] = 1.0/value

        def dfs(start: str, end: str, visited: set) -> float:
            if start not in graph:
                return -1.0

            if end in graph[start]:
                return graph[start][end]

            visited.add(start)

            for neighbor, value in graph[start].items():
                if neighbor in visited:
                    continue

                product = dfs(neighbor, end, visited)

                if product != -1.0:
                    return value * product

            return -1.0

        results = []

        for start, end in quaries:
            if start == end:
                results.append(1.0 if start in graph else -1.0)
            else:
                results.append(dfs(start, end, set()))


        return results
