package main

func findDifference(nums1 []int, nums2 []int) [][]int {
	set1 := make(map[int]struct{})
	set2 := make(map[int]struct{})

	for _, num := range nums1 {
		set1[num] = struct{}{}
	}
	for _, num := range nums2 {
		set2[num] = struct{}{}
	}

	result1 := []int{}

	for num := range set1 {
		if _, found := set2[num]; !found {
			result1 = append(result1, num)
		}
	}

	result2 := []int{}

	for num := range set2 {
		if _, found := set1[num]; !found {
			result2 = append(result2, num)
		}
	}

	return [][]int{
		result1,
		result2,
	}
}
