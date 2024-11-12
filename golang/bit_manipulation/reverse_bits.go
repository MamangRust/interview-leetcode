package main

func reverseBits(num uint32) uint32 {
	var result uint32 = 0

	for i := 0; i < 32; i++ {
		result <<= 1
		result |= num & 1

		num >>= 1
	}

	return result
}
