package main

func twoSum(nums []int, target int) []int {
	numToIndex := make(map[int]int)

	for index, num := range nums {
		complement := target - num

		if idx, found := numToIndex[complement]; found {
			return []int{idx, index}
		}

		numToIndex[num] = index
	}

	return nil
}
