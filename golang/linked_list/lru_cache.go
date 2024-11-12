package main

type LRUCache struct {
	capacity int
	cache    map[int]*DoublyLinkedListNode
	head     *DoublyLinkedListNode
	tail     *DoublyLinkedListNode
}

type DoublyLinkedListNode struct {
	key, value int
	prev, next *DoublyLinkedListNode
}

func Constructor(capacity int) LRUCache {
	head := &DoublyLinkedListNode{}
	tail := &DoublyLinkedListNode{}
	head.next = tail
	tail.prev = head

	return LRUCache{
		capacity: capacity,
		cache:    make(map[int]*DoublyLinkedListNode),
		head:     head,
		tail:     tail,
	}
}

func (this *LRUCache) Get(key int) int {
	if node, found := this.cache[key]; found {
		this.moveToFront(node)
		return node.value
	}
	return -1
}

func (this *LRUCache) Put(key int, value int) {
	if node, found := this.cache[key]; found {
		node.value = value
		this.moveToFront(node)
	} else {
		if len(this.cache) >= this.capacity {
			this.removeLRU()
		}
		node := &DoublyLinkedListNode{key: key, value: value}
		this.cache[key] = node
		this.addToFront(node)
	}
}

func (this *LRUCache) moveToFront(node *DoublyLinkedListNode) {
	this.removeNode(node)
	this.addToFront(node)
}

func (this *LRUCache) addToFront(node *DoublyLinkedListNode) {
	node.next = this.head.next
	node.prev = this.head
	this.head.next.prev = node
	this.head.next = node
}

func (this *LRUCache) removeNode(node *DoublyLinkedListNode) {
	node.prev.next = node.next
	node.next.prev = node.prev
}

func (this *LRUCache) removeLRU() {
	lru := this.tail.prev
	this.removeNode(lru)
	delete(this.cache, lru.key)
}
