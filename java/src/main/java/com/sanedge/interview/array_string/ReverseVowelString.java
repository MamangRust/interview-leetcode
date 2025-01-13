package com.sanedge.interview.array_string;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelString {

    private boolean isVowel(char ch) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        return vowels.contains(ch);
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            while (left < right && !isVowel(chars[left])) {
                left++;
            }

            while (left < right && !isVowel(chars[right])) {
                right--;
            }

            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }
        }

        return new String(chars);
    }
}
