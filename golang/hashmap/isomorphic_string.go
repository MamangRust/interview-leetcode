package main

func isIsomorphic(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	sToT := make(map[byte]byte)

	tToS := make(map[byte]byte)

	for i := 0; i < len(s); i++ {
		charS, charT := s[i], t[i]

		if mappedChar, exists := sToT[charS]; exists && mappedChar != charT {
			return false
		}
		if mappedChar, exists := tToS[charT]; exists && mappedChar != charS {
			return false
		}

		sToT[charS] = charT
		tToS[charT] = charS
	}

	return true
}
