package com.sanedge.interview.array_string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public int romanToInt(String s) {
        Map<Character, Integer> romanToInt = new HashMap<>();
        romanToInt.put('I', 1);
        romanToInt.put('V', 5);
        romanToInt.put('X', 10);
        romanToInt.put('L', 50);
        romanToInt.put('C', 100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);

        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            if (
                i < s.length() - 1 &&
                romanToInt.get(s.charAt(i)) < romanToInt.get(s.charAt(i + 1))
            ) {
                total -= romanToInt.get(s.charAt(i));
            } else {
                total += romanToInt.get(s.charAt(i));
            }
        }

        return total;
    }
}
