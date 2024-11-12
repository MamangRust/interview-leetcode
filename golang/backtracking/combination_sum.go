package main

func combinationSum(candidates []int, target int) [][]int {
	var result [][]int

	var backtrack func(start int, path []int, remaining int)

	backtrack = func(start int, path []int, remaining int) {
		if remaining == 0 {
			combination := make([]int, len(path))

			copy(combination, path)
			result = append(result, combination)

			return
		}

		for i := start; i < len(candidates); i++ {
			if candidates[i] > remaining {
				continue
			}

			path = append(path, candidates[i])

			backtrack(i, path, remaining-candidates[i])

			path = path[:len(path)-1]
		}
	}

	backtrack(0, []int{}, target)

	return result

}
