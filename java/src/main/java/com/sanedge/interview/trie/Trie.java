package com.sanedge.interview.trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
  Map<Character, TrieNode> children;

  boolean isEnd;

  public TrieNode() {
    children = new HashMap<>();
    isEnd = false;
  }
}

public class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode node = root;

    for (char ch : word.toCharArray()) {
      if (!node.children.containsKey(ch)) {
        node.children.put(ch, new TrieNode());
      }

      node = node.children.get(ch);
    }

    node.isEnd = true;
  }

  public boolean search(String word) {
    TrieNode node = root;

    for (char ch : word.toCharArray()) {
      if (!node.children.containsKey(ch)) {
        return false;
      }

      node = node.children.get(ch);
    }

    return node.isEnd;
  }

  public boolean startsWith(String prefix) {
    TrieNode node = root;

    for (char ch : prefix.toCharArray()) {
      if (!node.children.containsKey(ch)) {
        return false;
      }

      node = node.children.get(ch);
    }

    return true;
  }

}
