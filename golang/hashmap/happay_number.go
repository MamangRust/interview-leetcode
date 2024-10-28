package main

func getNext(number int) int {
	total_sum := 0

	for number > 0 {
		digit := number % 10

		total_sum += digit * digit

		number /= 10

	}

	return total_sum
}

func isHappy(n int) bool {
	seen := make(map[int]bool)

	for n != 1 && !seen[n] {
		seen[n] = true

		n = getNext(n)
	}

	return n == 1
}
