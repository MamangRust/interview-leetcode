package main

func minFlips(a int, b int, c int) int {
	flips := 0

	for a > 0 || b > 0 || c > 0 {
		bitA := a & 1
		bitB := b & 1
		bitC := c & 1

		if bitC == 1 {
			if bitA == 0 && bitB == 0 {
				flips++
			}
		} else {
			if bitA == 1 && bitB == 1 {
				flips += 2
			} else if bitA == 1 || bitB == 1 {
				flips++
			}
		}

		a >>= 1
		b >>= 1
		c >>= 1
	}

	return flips
}
