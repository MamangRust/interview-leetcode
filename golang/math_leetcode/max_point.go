package main

import "fmt"

type Point struct {
	x, y int
}

func maxPoints(points [][]int) int {
	if len(points) <= 2 {
		return len(points)
	}

	maxPoints := 0

	for i := 0; i < len(points); i++ {
		slopes := make(map[string]int)
		duplicate := 1
		currentMax := 0

		for j := i + 1; j < len(points); j++ {
			if points[i][0] == points[j][0] && points[i][1] == points[j][1] {
				duplicate++

				continue
			}

			dx := points[j][0] - points[i][0]

			dy := points[j][1] - points[i][1]

			g := Abs(dx, dy)
			dx /= g
			dy /= g

			slope := fmt.Sprintf("%d/%d", dy, dx)

			slopes[slope]++
			currentMax = max(currentMax, slopes[slope])
		}

		maxPoints = max(maxPoints, currentMax+duplicate)
	}

	return maxPoints
}

func Abs(a, b int) int {
	for b != 0 {
		a, b = b, a%b

	}

	return a
}
