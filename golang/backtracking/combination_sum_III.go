package main

func combinationSum3(k int, n int) [][]int {
	var res [][]int

	var current []int

	var backtrack func(start, sum int)

	backtrack = func(start, sum int) {
		if len(current) == k {
			if sum == n {
				combination := make([]int, len(current))

				copy(combination, current)

				res = append(res, combination)
			}
			return
		}

		for i := start; i <= 9; i++ {
			if sum+i > n {
				break
			}

			current = append(current, i)

			backtrack(i+1, sum+i)

			current = current[:len(current)-1]
		}
	}

	backtrack(1, 0)

	return res

}
