from typing import List


class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        total_gas, total_cost = 0, 0

        tank, start_index = 0, 0

        for i in range(len(gas)):
            total_gas += gas[i]
            total_cost += cost[i]

            tank += gas[i] - cost[i]

            if tank < 0:
                start_index = i + 1
                tank = 0

        return start_index if total_gas >= total_cost else -1
