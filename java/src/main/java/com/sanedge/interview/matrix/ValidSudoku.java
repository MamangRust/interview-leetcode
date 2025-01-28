package com.sanedge.interview.matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    Set<Character>[] rows = new HashSet[9];
    Set<Character>[] cols = new HashSet[9];
    Set<Character>[] boxes = new HashSet[9];

    for (int i = 0; i < 9; i++) {
      rows[i] = new HashSet<>();
      cols[i] = new HashSet<>();
      boxes[i] = new HashSet<>();
    }

    for (int r = 0; r < 9; r++) {
      for (int c = 0; c < 9; c++) {
        char num = board[r][c];

        if (num == '.') {
          continue;
        }

        if (rows[r].contains(num)) {
          return false;
        }

        rows[r].add(num);

        if (cols[c].contains(num)) {
          return false;
        }

        cols[c].add(num);

        int boxIndex = (r / 3) * 3 + (c / 3);

        if (boxes[boxIndex].contains(num)) {
          return false;
        }

        boxes[boxIndex].add(num);
      }
    }

    return true;
  }

}
