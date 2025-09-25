# C++ LeetCode Cheatsheet

This cheatsheet provides a quick reference for common C++ syntax, data structures, and algorithms frequently used in LeetCode problems.

---

## 1. Common Utilities

### Min/Max Functions

C++ provides built-in `min` and `max` functions in the `<algorithm>` header.

```cpp
#include <algorithm>
#include <climits>

int maximum = std::max(a, b);
int minimum = std::min(a, b);

// For multiple values
int max_val = std::max({a, b, c, d});
int min_val = std::min({a, b, c, d});
```

### Integer Constants

Useful for initializations, like finding a minimum value in an array.

```cpp
#include <climits>
#include <limits>

int maxInt = INT_MAX;        // or std::numeric_limits<int>::max()
int minInt = INT_MIN;        // or std::numeric_limits<int>::min()
```

### String to Integer Conversion

```cpp
#include <string>

// String to int
int num = std::stoi("123");

// Int to string
std::string str = std::to_string(123);
```

---

## 2. Data Structures

### Vectors (Dynamic Arrays)

```cpp
#include <vector>

// Initialization
std::vector<int> arr;
std::vector<int> arr = {1, 2, 3};
std::vector<int> arr(5);           // size 5, all elements 0
std::vector<int> arr(5, 10);       // size 5, all elements 10

// Add element
arr.push_back(4);

// Access elements
int element = arr[0];              // no bounds checking
int element = arr.at(0);           // with bounds checking

// Slicing (sub-vector) - requires manual copying
std::vector<int> sub(arr.begin() + 1, arr.begin() + 3); // elements at index 1 and 2

// Size and Capacity
arr.size();
arr.capacity();
arr.empty();                       // check if empty
```

### Hash Maps (unordered_map)

```cpp
#include <unordered_map>

// Initialization
std::unordered_map<std::string, int> ages;
std::unordered_map<std::string, int> ages = {
    {"alice", 25},
    {"bob", 30}
};

// Add or update
ages["charlie"] = 35;

// Access
int age = ages["alice"];           // creates entry if doesn't exist
int age = ages.at("alice");        // throws exception if doesn't exist

// Check for existence
if (ages.find("dave") != ages.end()) {
    // key exists
}
// or
if (ages.count("dave")) {
    // key exists
}

// Delete
ages.erase("bob");

// Iterate
for (const auto& [key, value] : ages) {
    std::cout << key << ": " << value << std::endl;
}
// or (pre-C++17)
for (const auto& pair : ages) {
    std::cout << pair.first << ": " << pair.second << std::endl;
}
```

### Stack

```cpp
#include <stack>

std::stack<int> stack;

// Push
stack.push(10);

// Pop
if (!stack.empty()) {
    int element = stack.top();
    stack.pop();
}

// Peek
if (!stack.empty()) {
    int element = stack.top();
}
```

### Queue

```cpp
#include <queue>

std::queue<int> queue;

// Enqueue
queue.push(10);

// Dequeue
if (!queue.empty()) {
    int element = queue.front();
    queue.pop();
}

// Peek
if (!queue.empty()) {
    int element = queue.front();
}
```

### Priority Queue (Heap)

```cpp
#include <queue>

// Max-heap (default)
std::priority_queue<int> maxHeap;

// Min-heap
std::priority_queue<int, std::vector<int>, std::greater<int>> minHeap;

// Push
maxHeap.push(10);
minHeap.push(10);

// Pop
if (!maxHeap.empty()) {
    int maxElement = maxHeap.top();
    maxHeap.pop();
}

// Custom comparator for complex types
struct Compare {
    bool operator()(const int& a, const int& b) {
        return a > b; // min-heap
    }
};
std::priority_queue<int, std::vector<int>, Compare> customHeap;
```

### Binary Tree Node

```cpp
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
```

### Linked List Node

```cpp
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
```

---

## 3. Algorithms

### Sorting

```cpp
#include <algorithm>
#include <vector>

std::vector<int> nums = {3, 1, 4, 1, 5, 9};

// Sort in ascending order
std::sort(nums.begin(), nums.end());

// Sort in descending order
std::sort(nums.begin(), nums.end(), std::greater<int>());

// Custom sort (e.g., sort by absolute value)
std::sort(nums.begin(), nums.end(), [](int a, int b) {
    return std::abs(a) < std::abs(b);
});
```

### Binary Search

```cpp
#include <algorithm>

std::vector<int> nums = {1, 2, 4, 5, 6};

// Find if element exists
bool found = std::binary_search(nums.begin(), nums.end(), 4);

// Find iterator to element (returns end() if not found)
auto it = std::lower_bound(nums.begin(), nums.end(), 4);
if (it != nums.end() && *it == 4) {
    int index = std::distance(nums.begin(), it);
}

// lower_bound returns first position where element can be inserted
auto it = std::lower_bound(nums.begin(), nums.end(), 3); // points to index 2
int index = std::distance(nums.begin(), it);
```

### Two Pointers

A common pattern for searching pairs in a sorted array.

```cpp
int left = 0, right = nums.size() - 1;

while (left < right) {
    int sum = nums[left] + nums[right];
    if (sum == target) {
        // Found pair
        break;
    } else if (sum < target) {
        left++;
    } else {
        right--;
    }
}
```

### Sliding Window

Used for finding a subarray or substring that satisfies certain conditions.

```cpp
int left = 0, right = 0;

while (right < nums.size()) {
    // Expand the window by including nums[right]
    // ...

    while (/* condition to shrink window is met */) {
        // Shrink the window from the left
        // ...
        left++;
    }

    right++;
}
```

### Breadth-First Search (BFS) - Tree

Uses a queue to traverse level by level.

```cpp
#include <queue>

void bfs(TreeNode* root) {
    if (!root) return;
    
    std::queue<TreeNode*> q;
    q.push(root);
    
    while (!q.empty()) {
        int levelSize = q.size();
        for (int i = 0; i < levelSize; i++) {
            TreeNode* node = q.front();
            q.pop();
            
            // Process node
            std::cout << node->val << std::endl;
            
            if (node->left) q.push(node->left);
            if (node->right) q.push(node->right);
        }
    }
}
```

### Depth-First Search (DFS) - Tree (Recursion)

```cpp
// Pre-order traversal
void dfsPreOrder(TreeNode* node) {
    if (!node) return;
    std::cout << node->val << std::endl; // Process node
    dfsPreOrder(node->left);
    dfsPreOrder(node->right);
}

// In-order traversal
void dfsInOrder(TreeNode* node) {
    if (!node) return;
    dfsInOrder(node->left);
    std::cout << node->val << std::endl; // Process node
    dfsInOrder(node->right);
}
```

### Dynamic Programming

```cpp
// 1D DP (e.g., Fibonacci)
std::vector<int> dp(n + 1);
dp[0] = 0;
dp[1] = 1;
for (int i = 2; i <= n; i++) {
    dp[i] = dp[i - 1] + dp[i - 2];
}

// 2D DP
std::vector<std::vector<int>> dp(rows, std::vector<int>(cols));
dp[i][j] = ...;
```

### Additional Useful Headers

```cpp
#include <iostream>      // Input/output
#include <vector>        // Dynamic arrays
#include <string>        // String operations
#include <algorithm>     // Sorting, searching, etc.
#include <unordered_map> // Hash maps
#include <unordered_set> // Hash sets
#include <set>           // Ordered sets (trees)
#include <map>           // Ordered maps (trees)
#include <queue>         // Queue, priority_queue, deque
#include <stack>         // Stack
#include <climits>       // Integer limits
#include <cmath>         // Math functions
#include <numeric>       // Numeric operations (accumulate, etc.)
```