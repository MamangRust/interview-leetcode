package main

func permute(nums []int) [][]int {
	var result [][]int

	var backtrack func(path []int, used []bool)

	backtrack = func(path []int, used []bool) {
		if len(path) == len(nums) {
			permutation := make([]int, len(path))

			copy(permutation, path)

			result = append(result, permutation)

			return
		}

		for i := 0; i < len(nums); i++ {
			if used[i] {
				continue
			}

			used[i] = true

			path = append(path, nums[i])

			backtrack(path, used)

			path = path[:len(path)-1]

			used[i] = false
		}
	}

	backtrack([]int{}, make([]bool, len(nums)))
	return result
}
