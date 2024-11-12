package main

import "container/list"

func snakesAndLadders(board [][]int) int {
	n := len(board)

	getCoordinates := func(square int) (int, int) {
		row := (square - 1) / n
		col := (square - 1) % n

		if row%2 == 1 {
			col = n - 1 - col
		}

		return n - 1 - row, col
	}

	visited := make([]bool, n*n+1)
	queue := list.New()
	queue.PushBack([2]int{1, 0})
	visited[1] = true

	for queue.Len() > 0 {
		element := queue.Remove(queue.Front()).([2]int)
		square, moves := element[0], element[1]

		if square == n*n {
			return moves
		}

		for i := 1; i <= 6; i++ {
			nextSquare := square + i

			if nextSquare > n*n {
				break
			}

			row, col := getCoordinates(nextSquare)

			if board[row][col] != -1 {
				nextSquare = board[row][col]
			}

			if !visited[nextSquare] {
				visited[nextSquare] = true

				queue.PushBack([2]int{nextSquare, moves + 1})
			}
		}
	}

	return -1
}
