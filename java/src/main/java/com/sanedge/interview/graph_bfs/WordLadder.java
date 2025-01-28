package com.sanedge.interview.graph_bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    public int ladderLength(
        String beginWord,
        String endWord,
        List<String> wordList
    ) {
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<WordStep> queue = new LinkedList<>();
        queue.offer(new WordStep(beginWord, 1));

        while (!queue.isEmpty()) {
            WordStep current = queue.poll();
            String word = current.word;
            int steps = current.steps;

            if (word.equals(endWord)) {
                return steps;
            }

            char[] wordChars = word.toCharArray();

            for (int i = 0; i < wordChars.length; i++) {
                char originalChar = wordChars[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    wordChars[i] = c;

                    String newWord = new String(wordChars);

                    if (wordSet.contains(newWord)) {
                        queue.offer(new WordStep(newWord, steps + 1));
                        wordSet.remove(newWord);
                    }
                }

                wordChars[i] = originalChar;
            }
        }

        return 0;
    }

    private static class WordStep {

        String word;
        int steps;

        WordStep(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
}
