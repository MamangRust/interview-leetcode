package com.sanedge.interview.trie;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
  private Map<Character, WordDictionary> children;
  private boolean isEnd;

  public WordDictionary() {
    children = new HashMap<>();
    isEnd = false;

  }

  public void addWord(String word) {
    WordDictionary node = this;

    for (char ch : word.toCharArray()) {
      if (!node.children.containsKey(ch)) {
        node.children.put(ch, new WordDictionary());
      }
      node = node.children.get(ch);
    }

    node.isEnd = true;
  }

  public boolean search(String word) {
    return searchHelper(word, 0);
  }

  private boolean searchHelper(String word, int index) {
    if (index == word.length()) {
      return isEnd;
    }

    char ch = word.charAt(index);

    if (ch == '.') {
      for (WordDictionary child : children.values()) {
        if (child.searchHelper(word, index + 1)) {
          return true;
        }
      }

      return false;
    } else {
      if (children.containsKey(ch)) {
        return children.get(ch).searchHelper(word, index + 1);
      } else {
        return false;
      }
    }
  }

}
