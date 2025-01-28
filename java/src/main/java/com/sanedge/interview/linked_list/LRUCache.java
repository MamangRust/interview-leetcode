package com.sanedge.interview.linked_list;

import java.util.HashMap;
import java.util.Map;

class DoublyLinkedListNode {
  int key, value;
  DoublyLinkedListNode prev, next;

  public DoublyLinkedListNode() {
  }

  public DoublyLinkedListNode(int key, int value) {
    this.key = key;
    this.value = value;
  }
}

public class LRUCache {
  private int capacity;
  private Map<Integer, DoublyLinkedListNode> cache;
  private DoublyLinkedListNode head, tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.cache = new HashMap<>();
    this.head = new DoublyLinkedListNode();
    this.tail = new DoublyLinkedListNode();
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (cache.containsKey(key)) {
      DoublyLinkedListNode node = cache.get(key);
      moveToFront(node);
      return node.value;
    }

    return -1;
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      DoublyLinkedListNode node = cache.get(key);
      node.value = value;
      moveToFront(node);
    } else {
      if (cache.size() >= capacity) {
        removeLRU();
      }
      DoublyLinkedListNode newNode = new DoublyLinkedListNode(key, value);
      cache.put(key, newNode);
      addToFront(newNode);
    }
  }

  private void moveToFront(DoublyLinkedListNode node) {
    removeNode(node);
    addToFront(node);
  }

  private void addToFront(DoublyLinkedListNode node) {
    node.next = head.next;
    node.prev = head;
    head.next.prev = node;
    node.next = node;
  }

  private void removeNode(DoublyLinkedListNode node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void removeLRU() {
    DoublyLinkedListNode lru = tail.prev;
    removeNode(lru);
    cache.remove(lru.key);
  }

}
