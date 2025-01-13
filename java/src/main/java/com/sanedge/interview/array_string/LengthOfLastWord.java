package com.sanedge.interview.array_string;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        s = s.trim();

        if (s.isEmpty()) {
            return 0;
        }

        String[] words = s.split("\\s+");

        return words[words.length - 1].length();
    }
}
