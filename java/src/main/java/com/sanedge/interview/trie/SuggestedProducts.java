package com.sanedge.interview.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuggestedProducts {
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Arrays.sort(products);

    List<List<String>> result = new ArrayList<>();
    StringBuilder prefix = new StringBuilder();

    for (int i = 0; i < searchWord.length(); i++) {
      prefix.append(searchWord.charAt(i));

      List<String> suggestions = new ArrayList<>();
      for (String product : products) {
        if (product.startsWith(prefix.toString())) {
          suggestions.add(product);
        }

        if (suggestions.size() == 3) {
          break;
        }
      }
      result.add(suggestions);
    }

    return result;
  }

}
