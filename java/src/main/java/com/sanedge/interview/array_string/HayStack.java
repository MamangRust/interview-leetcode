package com.sanedge.interview.array_string;

public class HayStack {

    public int strStr(String haystack, String needle) {
        if (needle == "") {
            return 0;
        }

        int haystack_len = haystack.length();
        int needle_len = needle.length();

        for (int i = 0; i <= haystack_len - needle_len; i++) {
            if (haystack.substring(i, i + needle_len).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
