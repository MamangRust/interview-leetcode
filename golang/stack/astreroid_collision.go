package main

func asteroidCollision(asteroids []int) []int {
	stack := []int{}

	for _, asteroid := range asteroids {
		for len(stack) > 0 && asteroid < 0 && stack[len(stack)-1] > 0 {
			if stack[len(stack)-1] > -asteroid {
				asteroid = 0

				break
			} else if stack[len(stack)-1] < -asteroid {
				stack = stack[:len(stack)-1]
			} else {
				stack = stack[:len(stack)-1]

				asteroid = 0

				break
			}
		}

		if asteroid != 0 {
			stack = append(stack, asteroid)
		}
	}

	return stack
}
