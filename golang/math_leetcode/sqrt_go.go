package main

func mySqrt(x int) int {
	if x < 2 {
		return x
	}

	left, right := 2, x/2

	var mid, sqrt int

	for left <= right {
		mid = left + (right-left)/2

		sqrt = mid * mid

		if sqrt == x {
			return mid
		} else if sqrt < x {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}

	return right
}
