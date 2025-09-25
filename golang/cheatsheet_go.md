# Go (Golang) LeetCode Cheatsheet

This cheatsheet provides a quick reference for common Go syntax, data structures, and algorithms frequently used in LeetCode problems.

---

## 1. Common Utilities

### Min/Max Functions

Go's `math` package provides `Min` and `Max` for `float64`, but not for integers. You'll often need to define your own.

```go
func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
```

### Integer Constants

Useful for initializations, like finding a minimum value in an array.

```go
import "math"

maxInt := math.MaxInt32
minInt := math.MinInt32
```

### String to Integer Conversion

```go
import "strconv"

// String to int
num, err := strconv.Atoi("123")

// Int to string
str := strconv.Itoa(123)
```

---

## 2. Data Structures

### Slices (Dynamic Arrays)

```go
// Initialization
var arr []int
arr := []int{1, 2, 3}
arr := make([]int, 5) // length 5, capacity 5
arr := make([]int, 0, 5) // length 0, capacity 5

// Add element
arr = append(arr, 4)

// Slicing (sub-array)
sub := arr[1:3] // elements at index 1 and 2

// Length and Capacity
len(arr)
cap(arr)
```

### Hash Maps (map)

```go
// Initialization
ages := make(map[string]int)
ages := map[string]int{
    "alice": 25,
    "bob":   30,
}

// Add or update
ages["charlie"] = 35

// Access
age := ages["alice"]

// Check for existence
age, ok := ages["dave"]
if ok {
    // key exists
}

// Delete
delete(ages, "bob")

// Iterate
for key, value := range ages {
    fmt.Printf("%s: %d\n", key, value)
}
```

### Stack

Can be easily implemented using a slice.

```go
stack := []int{}

// Push
stack = append(stack, 10)

// Pop
if len(stack) > 0 {
    element := stack[len(stack)-1]
    stack = stack[:len(stack)-1]
}

// Peek
if len(stack) > 0 {
    element := stack[len(stack)-1]
}
```

### Queue

Can be implemented using a slice.

```go
queue := []int{}

// Enqueue
queue = append(queue, 10)

// Dequeue
if len(queue) > 0 {
    element := queue[0]
    queue = queue[1:]
}

// Peek
if len(queue) > 0 {
    element := queue[0]
}
```

### Heap (Priority Queue)

Requires implementing the `container/heap` interface.

```go
import "container/heap"

// 1. Define your item and priority queue types
type IntHeap []int

func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] } // For Min-Heap
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *IntHeap) Push(x interface{}) {
    *h = append(*h, x.(int))
}

func (h *IntHeap) Pop() interface{} {
    old := *h
    n := len(old)
    x := old[n-1]
    *h = old[0 : n-1]
    return x
}

// 2. Usage
minHeap := &IntHeap{2, 1, 5}
heap.Init(minHeap)

// Push
heap.Push(minHeap, 0)

// Pop (returns the minimum element)
minElement := heap.Pop(minHeap).(int)
fmt.Printf("min element: %d\n", minElement) // Output: 0
```

### Binary Tree Node

```go
type TreeNode struct {
    Val   int
    Left  *TreeNode
    Right *TreeNode
}
```

### Linked List Node

```go
type ListNode struct {
    Val  int
    Next *ListNode
}
```

---

## 3. Algorithms

### Sorting

```go
import "sort"

// Sort integers
nums := []int{3, 1, 4, 1, 5, 9}
sort.Ints(nums)

// Sort strings
strs := []string{"c", "a", "b"}
sort.Strings(strs)

// Custom sort (e.g., sort by length)
sort.Slice(strs, func(i, j int) bool {
    return len(strs[i]) < len(strs[j])
})
```

### Binary Search

`sort.SearchInts` is useful for finding an element in a **sorted** slice.

```go
nums := []int{1, 2, 4, 5, 6}

// Find index of value 4
index := sort.SearchInts(nums, 4) // returns 2

// If value is not found, it returns the index where it would be inserted
index = sort.SearchInts(nums, 3) // returns 2
```

### Two Pointers

A common pattern for searching pairs in a sorted array.

```go
left, right := 0, len(nums)-1

for left < right {
    sum := nums[left] + nums[right]
    if sum == target {
        // Found pair
        break
    } else if sum < target {
        left++
    } else {
        right--
    }
}
```

### Sliding Window

Used for finding a subarray or substring that satisfies certain conditions.

```go
left, right := 0, 0

for right < len(nums) {
    // Expand the window by including nums[right]
    // ...

    for /* condition to shrink window is met */ {
        // Shrink the window from the left
        // ...
        left++
    }

    right++
}
```

### Breadth-First Search (BFS) - Tree

Uses a queue to traverse level by level.

```go
func bfs(root *TreeNode) {
    if root == nil {
        return
    }
    queue := []*TreeNode{root}

    for len(queue) > 0 {
        levelSize := len(queue)
        for i := 0; i < levelSize; i++ {
            node := queue[0]
            queue = queue[1:]

            // Process node
            fmt.Println(node.Val)

            if node.Left != nil {
                queue = append(queue, node.Left)
            }
            if node.Right != nil {
                queue = append(queue, node.Right)
            }
        }
    }
}
```

### Depth-First Search (DFS) - Tree (Recursion)

```go
// Pre-order traversal
func dfsPreOrder(node *TreeNode) {
    if node == nil {
        return
    }
    fmt.Println(node.Val) // Process node
    dfsPreOrder(node.Left)
    dfsPreOrder(node.Right)
}

// In-order traversal
func dfsInOrder(node *TreeNode) {
    if node == nil {
        return
    }
    dfsInOrder(node.Left)
    fmt.Println(node.Val) // Process node
    dfsInOrder(node.Right)
}
```

### Dynamic Programming

```go
// 1D DP (e.g., Fibonacci)
dp := make([]int, n+1)
dp[0] = 0
dp[1] = 1
for i := 2; i <= n; i++ {
    dp[i] = dp[i-1] + dp[i-2]
}

// 2D DP
dp := make([][]int, rows)
for i := range dp {
    dp[i] = make([]int, cols)
}
dp[i][j] = ...
```

```
