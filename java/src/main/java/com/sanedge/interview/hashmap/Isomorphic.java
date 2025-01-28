package com.sanedge.interview.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {

  public static boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    Map<Character, Character> sTot = new HashMap<>();
    Map<Character, Character> tTos = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char charS = s.charAt(i);
      char charT = t.charAt(i);

      if (sTot.containsKey(charS) && sTot.get(charS) != charT) {
        return false;
      }

      if (tTos.containsKey(charT) && tTos.get(charT) != charS) {
        return false;
      }

      sTot.put(charS, charT);
      tTos.put(charT, charS);
    }

    return true;
  }
}
