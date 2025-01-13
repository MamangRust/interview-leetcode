package com.sanedge.interview.array_string;

public class IntToRoman {

    public String intToRoman(int num) {
        ValueSymbol[] valueMap = {
            new ValueSymbol(1000, "M"),
            new ValueSymbol(900, "CM"),
            new ValueSymbol(500, "D"),
            new ValueSymbol(400, "CD"),
            new ValueSymbol(100, "C"),
            new ValueSymbol(90, "XC"),
            new ValueSymbol(50, "L"),
            new ValueSymbol(40, "XL"),
            new ValueSymbol(10, "X"),
            new ValueSymbol(9, "IX"),
            new ValueSymbol(5, "V"),
            new ValueSymbol(4, "IV"),
            new ValueSymbol(1, "I"),
        };

        StringBuilder roman = new StringBuilder();

        for (ValueSymbol pair : valueMap) {
            roman.append(pair.symbol);

            num -= pair.value;
        }

        return roman.toString();
    }

    private static class ValueSymbol {

        int value;
        String symbol;

        ValueSymbol(int value, String symbol) {
            this.value = value;
            this.symbol = symbol;
        }
    }
}
