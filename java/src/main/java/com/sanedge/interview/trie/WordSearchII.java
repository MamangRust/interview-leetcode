package com.sanedge.interview.trie;

import java.util.*;

class TrieNode {
  Map<Character, TrieNode> children;
  String word;

  public TrieNode() {
    children = new HashMap<>();
    word = null;
  }
}

class Trie {
  TrieNode root;

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

    node.word = word;
  }
}

public class WordSearchII {
  public List<String> findWords(char[][] board, String[] words) {
    Trie trie = new Trie();

    for (String word : words) {
      trie.insert(word);
    }

    int rows = board.length;
    int cols = board[0].length;
    List<String> result = new ArrayList<>();
    boolean[][] visited = new boolean[rows][cols];

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (trie.root.children.containsKey(board[r][c])) {
          dfs(board, r, c, trie.root, visited, result);
        }
      }
    }

    return result;
  }

  private void dfs(char[][] board, int r, int c, TrieNode node, boolean[][] visited, List<String> result) {
    if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c] || board[r][c] == '#') {
      return;
    }

    char ch = board[r][c];
    TrieNode nextNode = node.children.get(ch);

    if (nextNode == null) {
      return;
    }

    visited[r][c] = true;

    if (nextNode.word != null) {
      result.add(nextNode.word);
      nextNode.word = null;
    }

    dfs(board, r + 1, c, nextNode, visited, result);
    dfs(board, r - 1, c, nextNode, visited, result);
    dfs(board, r, c + 1, nextNode, visited, result);
    dfs(board, r, c - 1, nextNode, visited, result);
    visited[r][c] = false;
  }
}
