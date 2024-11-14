package main

import "sort"

func maxScore(nums1 []int, nums2 []int, k int) int64 {
	n := len(nums1)
	pairs := make([][2]int, n)

	for i := 0; i < n; i++ {
		pairs[i] = [2]int{nums1[i], nums2[i]}
	}

	sort.Slice(pairs, func(i, j int) bool {
		return pairs[i][1] > pairs[j][1]
	})

	sum := 0

	nums1Values := make([]int, k)

	for i := 0; i < k; i++ {
		sum += pairs[i][0]
		nums1Values[i] = pairs[i][0]
	}

	sort.Ints(nums1Values)

	result := int64(sum) * int64(pairs[k-1][1])

	for i := k; i < n; i++ {
		if pairs[i][0] > nums1Values[0] {
			sum = sum - nums1Values[0] + pairs[i][0] // Fixed the sign here
			nums1Values[0] = pairs[i][0]
			sort.Ints(nums1Values)
			newResult := int64(sum) * int64(pairs[i][1])
			if newResult > result {
				result = newResult
			}
		}
	}

	return result
}
