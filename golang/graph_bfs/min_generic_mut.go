package main

func minMutation(start string, end string, bank []string) int {
	bankSet := make(map[string]bool)

	for _, gene := range bank {
		bankSet[gene] = true
	}

	if !bankSet[end] {
		return -1
	}

	genes := []byte{'A', 'C', 'G', 'T'}
	queue := []struct {
		gene  string
		steps int
	}{{start, 0}}

	for len(queue) > 0 {
		current := queue[0]
		queue = queue[1:]

		if current.gene == end {
			return current.steps
		}

		for i := 0; i < len(current.gene); i++ {
			for _, g := range genes {

				mutatedGene := []byte(current.gene)
				mutatedGene[i] = g
				mutated := string(mutatedGene)

				if bankSet[mutated] {
					queue = append(queue, struct {
						gene  string
						steps int
					}{mutated, current.steps + 1})
					delete(bankSet, mutated)
				}
			}
		}
	}

	return -1
}
