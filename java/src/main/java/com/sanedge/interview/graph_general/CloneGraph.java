package com.sanedge.interview.graph_general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}

public class CloneGraph {
  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }

    Map<Node, Node> cloned = new HashMap<>();

    return dfs(node, cloned);
  }

  private Node dfs(Node node, Map<Node, Node> cloned) {
    if (node == null) {
      return null;
    }

    if (cloned.containsKey(node)) {
      return cloned.get(node);
    }

    Node copy = new Node(node.val);

    cloned.put(node, copy);

    for (Node neighbor : node.neighbors) {
      copy.neighbors.add(dfs(neighbor, cloned));
    }

    return copy;
  }
}
