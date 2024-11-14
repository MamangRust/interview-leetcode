package main

func maxOperations(nums []int, k int) int {
	count := 0

	freqMap := make(map[int]int)

	for _, num := range nums {
		complement := k - num

		if freqMap[complement] > 0 {
			count++
			freqMap[complement]--
		} else {
			freqMap[num]++
		}
	}

	return count
}
