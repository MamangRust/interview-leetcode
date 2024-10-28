package main

func canCompleteCircuit(gas []int, cost []int) int {
	total_gas, total_cost := 0, 0

	tank, start_index := 0, 0

	for i := 0; i < len(gas); i++ {
		total_gas += gas[i]
		total_cost += cost[i]

		tank += gas[i] - cost[i]

		if tank < 0 {
			start_index = i + 1
			tank = 0
		}
	}

	if total_gas < total_cost {
		return -1
	}

	return start_index
}
