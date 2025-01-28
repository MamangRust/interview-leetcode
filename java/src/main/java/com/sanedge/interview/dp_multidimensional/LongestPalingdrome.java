package com.sanedge.interview.dp_multidimensional;

public class LongestPalingdrome {

    private int start = 0;
    private int maxLength = 1;

    public String longestPalingdrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i);
            expandAroundCenter(s, i, i + 1);
        }

        return s.substring(start, start + maxLength);
    }

    private void expandAroundCenter(String s, int left, int right) {
        while (
            left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)
        ) {
            int currentLength = right - left + 1;

            if (currentLength > maxLength) {
                start = left;
                maxLength = currentLength;
            }

            left--;
            right++;
        }
    }
}
