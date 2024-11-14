package main

func predictPartyVictory(senate string) string {
	radiantQueue := []int{}
	direQueue := []int{}

	for i, s := range senate {
		if s == 'R' {
			radiantQueue = append(radiantQueue, i)
		} else {
			direQueue = append(direQueue, i)
		}
	}

	for len(radiantQueue) > 0 && len(direQueue) > 0 {
		radiant := radiantQueue[0]
		dire := direQueue[0]

		radiantQueue = radiantQueue[1:]
		direQueue = direQueue[1:]

		if radiant < dire {
			radiantQueue = append(radiantQueue, radiant+len(senate))
		} else {
			direQueue = append(direQueue, dire+len(senate))
		}
	}

	if len(radiantQueue) > 0 {
		return "Radiant"
	} else {
		return "Dire"
	}
}
