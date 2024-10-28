package main

import (
	"math/rand"
	"time"
)

type RandomizedSet struct {
	values  []int
	indices map[int]int
}

func Constructor() RandomizedSet {
	rand.NewSource(time.Now().UnixNano())

	return RandomizedSet{
		values:  []int{},
		indices: map[int]int{},
	}
}

func (rs *RandomizedSet) Insert(val int) bool {
	if _, exists := rs.indices[val]; exists {
		return false
	}

	rs.values = append(rs.values, val)

	rs.indices[val] = len(rs.values) - 1

	return true
}

func (rs *RandomizedSet) Remove(val int) bool {
	index, exists := rs.indices[val]

	if !exists {
		return false
	}

	lastVal := rs.values[len(rs.values)-1]

	rs.values[index] = lastVal

	rs.indices[lastVal] = index

	rs.values = rs.values[:len(rs.values)-1]

	delete(rs.indices, val)

	return true
}

func (rs *RandomizedSet) GetRandom() int {
	return rs.values[rand.Intn(len(rs.values))]
}
