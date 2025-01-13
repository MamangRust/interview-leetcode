package com.sanedge.interview.array_string;

public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        int curRow = 0;
        boolean goinDown = false;

        for (char c : s.toCharArray()) {
            rows[curRow].append(c);

            if (curRow == 0 || curRow == numRows - 1) {
                goinDown = !goinDown;
            }

            curRow += goinDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
