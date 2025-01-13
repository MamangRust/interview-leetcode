package com.sanedge.interview.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinePhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, String> digitToLetters = new HashMap<>();

        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        backtrack(digits, 0, new StringBuilder(), digitToLetters, result);

        return result;
    }

    private void backtrack(
        String digits,
        int index,
        StringBuilder path,
        Map<Character, String> digitToLetters,
        List<String> result
    ) {
        if (index == digits.length()) {
            result.add(path.toString());

            return;
        }

        char currentDigit = digits.charAt(index);
        String letters = digitToLetters.get(currentDigit);

        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));

            backtrack(digits, index + 1, path, digitToLetters, result);

            path.deleteCharAt(path.length() - 1);
        }
    }
}
