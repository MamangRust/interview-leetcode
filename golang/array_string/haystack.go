package main

func strStr(haystack string, needle string) int {
	if needle == "" {
		return 0
	}

	haystack_len, needle_len := len(haystack), len(needle)

	for i := 0; i <= haystack_len-needle_len; i++ {
		if haystack[i:i+needle_len] == needle {
			return i
		}
	}

	return -1
}
