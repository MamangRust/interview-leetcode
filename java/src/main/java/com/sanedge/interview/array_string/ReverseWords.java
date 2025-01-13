package com.sanedge.interview.array_string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        List<String> wordList = Arrays.asList(words);

        Collections.reverse(wordList);

        return String.join(" ", wordList);
    }
}
