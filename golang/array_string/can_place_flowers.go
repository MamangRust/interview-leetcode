package main

func canPlaceFlowers(flowerbed []int, n int) bool {
	length := len(flowerbed)

	for i := 0; i < length; i++ {
		if flowerbed[i] == 0 {
			emptyLeft := (i == 0 || flowerbed[i-1] == 0)
			emptyRight := (i == length-1 || flowerbed[i+1] == 0)

			if emptyLeft && emptyRight {
				flowerbed[i] = 1

				n--

				if n == 0 {
					return true
				}
			}
		}
	}

	return n <= 0
}
