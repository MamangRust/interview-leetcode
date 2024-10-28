package main

func intToRoman(num int) string {
	valueMap := []struct {
		value  int
		symbol string
	}{
		{1000, "M"},
		{900, "CM"},
		{500, "D"},
		{400, "CD"},
		{100, "C"},
		{90, "XC"},
		{50, "L"},
		{40, "XL"},
		{10, "X"},
		{9, "IX"},
		{5, "V"},
		{4, "IV"},
		{1, "I"},
	}

	roman := ""

	for _, pair := range valueMap {
		for num >= pair.value {
			roman += pair.symbol

			num -= pair.value
		}
	}

	return roman
}
